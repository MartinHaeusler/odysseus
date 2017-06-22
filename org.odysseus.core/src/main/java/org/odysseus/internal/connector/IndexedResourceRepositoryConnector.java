package org.odysseus.internal.connector;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class IndexedResourceRepositoryConnector extends BasicResourceRepositoryConnector {

	// FIXME: On "add to model", this class should also consider child EObject(s) recursively.
	// FIXME: This class should also recognize additions at non-root level (EAdapter?)

	protected Map<EClass, Set<EObject>> eClassToEObject;

	public IndexedResourceRepositoryConnector(final Resource resource, final Supplier<Map<?, ?>> loadOptionsProvider,
			final Supplier<InputStream> inputStreamProvider, final Supplier<Map<?, ?>> saveOptionsProvider,
			final Supplier<OutputStream> outputStreamProvider) {
		super(resource, loadOptionsProvider, inputStreamProvider, saveOptionsProvider, outputStreamProvider);
		resource.eAdapters().add(new ResourceAdapter());
	}

	@Override
	public void addToModel(final EObject eObject) {
		super.addToModel(eObject);
		this.addToIndex(eObject);
	}

	@Override
	public void addToModel(final Iterable<? extends EObject> eObjects) {
		super.addToModel(eObjects);
		eObjects.forEach(eObject -> this.addToIndex(eObject));
	}

	@Override
	public void addToModel(final Iterator<? extends EObject> eObjects) {
		List<EObject> eObjectList = Lists.newArrayList(eObjects);
		super.addToModel(eObjectList.iterator());
		eObjectList.forEach(eObject -> this.addToIndex(eObject));
	}

	@Override
	public long countInstancesOf(final EClass eClass, final boolean includeSubclasses) {
		if (includeSubclasses == false) {
			Set<EObject> set = this.eClassToEObject.get(eClass);
			if (set == null) {
				return 0;
			}
			return set.size();
		} else {
			if (EcorePackage.Literals.EOBJECT.equals(eClass)) {
				long count = 0;
				for (EClass ec : this.eClassToEObject.keySet()) {
					Set<EObject> set = this.eClassToEObject.get(ec);
					if (set != null) {
						count += set.size();
					}
				}
				return count;
			} else {
				long count = 0;
				for (EClass ec : this.eClassToEObject.keySet()) {
					if (eClass.isSuperTypeOf(ec)) {
						Set<EObject> set = this.eClassToEObject.get(ec);
						if (set != null) {
							count += set.size();
						}
					}
				}
				return count;
			}
		}
	}

	@Override
	protected void ensureResourceIsLoaded() {
		super.ensureResourceIsLoaded();
		if (this.eClassToEObject == null) {
			this.eClassToEObject = Maps.newLinkedHashMap();
			// populate index
			Iterator<EObject> allContents = this.resource.getAllContents();
			allContents.forEachRemaining(eObject -> this.addToIndex(eObject));
		}
	}

	@Override
	protected List<EObject> getEObjects(final EClass eClass, final boolean allowSubclasses) {
		if (eClass.equals(EcorePackage.Literals.EOBJECT) && allowSubclasses) {
			// optimization: return everything
			List<EObject> instances = Lists.newArrayList();
			for (EClass ec : this.eClassToEObject.keySet()) {
				instances.addAll(this.eClassToEObject.get(ec));
			}
			return Collections.unmodifiableList(instances);
		}

		if (allowSubclasses) {
			List<EObject> instances = Lists.newArrayList();
			for (EClass ec : this.eClassToEObject.keySet()) {
				if (eClass.isSuperTypeOf(ec)) {
					instances.addAll(this.eClassToEObject.get(ec));
				}
			}
			return Collections.unmodifiableList(instances);
		} else {
			Set<EObject> instances = this.eClassToEObject.get(eClass);
			if (instances == null) {
				return Collections.emptyList();
			} else {
				return Collections.unmodifiableList(Lists.newArrayList(instances));
			}
		}
	}

	// =================================================================================================================
	// HELPER METHODS
	// =================================================================================================================

	protected void addToIndex(final EObject eObject) {
		EClass eClass = eObject.eClass();
		Set<EObject> instances = this.eClassToEObject.get(eClass);
		if (instances == null) {
			instances = Sets.newLinkedHashSet();
			this.eClassToEObject.put(eClass, instances);
		}
		instances.add(eObject);
	}

	protected void removeFromIndex(final EObject eObject) {
		EClass eClass = eObject.eClass();
		Set<EObject> instances = this.eClassToEObject.get(eClass);
		if (instances == null || instances.isEmpty()) {
			return;
		}
		instances.remove(eObject);
	}

	// =================================================================================================================
	// INNER CLASSES
	// =================================================================================================================

	private class ResourceAdapter extends AdapterImpl {

		@Override
		public void notifyChanged(final Notification notification) {
			int eventType = notification.getEventType();
			if (notification.getFeature() instanceof EReference == false) {
				// we are not interested in EAttributes here
				return;
			}
			EReference eReference = (EReference) notification.getFeature();
			if (eReference.isContainment() == false) {
				// we are not interested in non-containment features
				return;
			}

			if (eventType == Notification.ADD || eventType == Notification.ADD_MANY) {
				this.add(notification.getNewValue());
			} else if (eventType == Notification.REMOVE || eventType == Notification.REMOVE_MANY) {
				this.remove(notification.getOldValue());
				this.add(notification.getNewValue());
			}
		}

		private void remove(final Object value) {
			if (value instanceof Collection) {
				Collection<?> collection = (Collection<?>) value;
				for (Object element : collection) {
					if (element instanceof EObject) {
						IndexedResourceRepositoryConnector.this.removeFromIndex((EObject) element);
					}
				}
			} else if (value instanceof EObject) {
				IndexedResourceRepositoryConnector.this.removeFromIndex((EObject) value);
			}
		}

		private void add(final Object value) {
			if (value instanceof Collection) {
				Collection<?> collection = (Collection<?>) value;
				for (Object element : collection) {
					if (element instanceof EObject) {
						IndexedResourceRepositoryConnector.this.addToIndex((EObject) element);
					}
				}
			} else if (value instanceof EObject) {
				IndexedResourceRepositoryConnector.this.addToIndex((EObject) value);
			}
		}

	}
}
