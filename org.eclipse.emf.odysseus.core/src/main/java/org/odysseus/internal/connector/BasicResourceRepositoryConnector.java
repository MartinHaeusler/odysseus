package org.odysseus.internal.connector;

import static com.google.common.base.Preconditions.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.odysseus.api.RepositoryConnector;
import org.odysseus.exceptions.OdysseusException;
import org.odysseus.spi.RandomGenerator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class BasicResourceRepositoryConnector implements RepositoryConnector {

	protected final Resource resource;
	protected final Supplier<Map<?, ?>> loadOptionsProvider;
	protected final Supplier<InputStream> inputStreamProvider;
	protected final Supplier<Map<?, ?>> saveOptionsProvider;
	protected final Supplier<OutputStream> outputStreamProvider;

	public BasicResourceRepositoryConnector(final Resource resource, final Supplier<Map<?, ?>> loadOptionsProvider,
			final Supplier<InputStream> inputStreamProvider, final Supplier<Map<?, ?>> saveOptionsProvider,
			final Supplier<OutputStream> outputStreamProvider) {
		checkNotNull(resource, "Precondition violation - argument 'resource' must not be NULL!");
		this.resource = resource;
		this.loadOptionsProvider = loadOptionsProvider;
		this.inputStreamProvider = inputStreamProvider;
		this.saveOptionsProvider = saveOptionsProvider;
		this.outputStreamProvider = outputStreamProvider;
	}

	// =================================================================================================================
	// PUBLIC API
	// =================================================================================================================

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAnyDistinctInstancesOf(final RandomGenerator random, final EClass eClass,
			final int numberOfInstances, final boolean allowSubclasses) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		checkArgument(numberOfInstances > 0,
				"Precondition violation - argument 'numberOfInstances' must be greater than zero!");
		List<EObject> list = this.getEObjects(eClass, allowSubclasses);
		return (List<T>) random.pick(list, numberOfInstances, true);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EObject> Iterator<T> getAllInstancesOf(final EClass eClass, final boolean includeSubclasses) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		List<EObject> list = this.getEObjects(eClass, includeSubclasses);
		return (Iterator<T>) list.iterator();
	}

	@Override
	public long countInstancesOf(final EClass eClass, final boolean includeSubclasses) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		return this.getEObjects(eClass, includeSubclasses).size();
	}

	@Override
	public void addToModel(final Iterator<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		eObjects.forEachRemaining(eObject -> this.resource.getContents().add(eObject));
	}

	@Override
	public void removeFromModel(final Iterator<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		eObjects.forEachRemaining(eObject -> this.resource.getContents().remove(eObject));
	}

	@Override
	public void flush() {
		this.saveResource();
	}

	@Override
	public void start() {
		this.ensureResourceIsLoaded();
	}

	@Override
	public void done() {
		this.saveResource();
		this.unloadResource();
	}

	// =================================================================================================================
	// INTERNAL HELPER METHODS
	// =================================================================================================================

	protected void saveResource() {
		try {
			Map<?, ?> options;
			if (this.saveOptionsProvider != null) {
				options = this.saveOptionsProvider.get();
			} else {
				options = Maps.newHashMap();
			}
			if (this.outputStreamProvider != null) {
				this.resource.save(this.outputStreamProvider.get(), options);
			} else {
				this.resource.save(options);
			}

		} catch (IOException e) {
			throw new OdysseusException(
					"Failed to save resource '" + this.resource.getURI() + "'. See root cause for details.", e);
		}
	}

	protected void ensureResourceIsLoaded() {
		return;
		// if (this.resource.isLoaded()) {
		// return;
		// }
		// try {
		// Map<?, ?> options;
		// if (this.loadOptionsProvider != null) {
		// options = this.loadOptionsProvider.get();
		// } else {
		// options = Maps.newHashMap();
		// }
		// if (this.inputStreamProvider != null) {
		// this.resource.load(this.inputStreamProvider.get(), options);
		// } else {
		// this.resource.load(options);
		// }
		// } catch (IOException e) {
		// throw new OdysseusException(
		// "Failed to load resource '" + this.resource.getURI() + "'. See root cause for details.", e);
		// }
	}

	protected void unloadResource() {
		this.resource.unload();
	}

	protected List<EObject> getEObjects(final EClass eClass, final boolean allowSubclasses) {
		List<EObject> eObjects = Lists.newArrayList();
		this.resource.getAllContents().forEachRemaining(eObject -> {
			if (allowSubclasses) {
				if (eClass.isInstance(eObject)) {
					eObjects.add(eObject);
				}
			} else {
				if (eClass.equals(eObject.eClass())) {
					eObjects.add(eObject);
				}
			}
		});
		return eObjects;
	}
}
