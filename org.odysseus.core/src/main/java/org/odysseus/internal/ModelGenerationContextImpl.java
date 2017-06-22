package org.odysseus.internal;

import static com.google.common.base.Preconditions.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.odysseus.api.Odysseus;
import org.odysseus.api.RepositoryConnector;
import org.odysseus.internal.edpl.EDPLProxy;
import org.odysseus.spi.ModelGenerationContext;
import org.odysseus.spi.RandomGenerator;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

public class ModelGenerationContextImpl implements ModelGenerationContext {

	protected final Odysseus owningInstance;

	// statistics
	protected int iterationNumber;
	protected long startTime;
	protected int elementsAdded;
	protected int elementsRemoved;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	public ModelGenerationContextImpl(final Odysseus owningInstance) {
		this.owningInstance = owningInstance;
		this.iterationNumber = 0;
		this.startTime = System.currentTimeMillis();
	}

	// =================================================================================================================
	// ACCESS TO SERVICES
	// =================================================================================================================

	@Override
	public RandomGenerator random() {
		return this.owningInstance.randomGeneratorConfig().getGenerator();
	}

	// =================================================================================================================
	// STATISTICS
	// =================================================================================================================

	@Override
	public int getIteration() {
		return this.iterationNumber;
	}

	@Override
	public long getSimulationRuntime() {
		return System.currentTimeMillis() - this.startTime;
	}

	@Override
	public int getElementsAdded() {
		return this.elementsAdded;
	}

	@Override
	public int getElementsRemoved() {
		return this.elementsRemoved;
	}

	// =================================================================================================================
	// QUERY METHODS
	// =================================================================================================================

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EObject> T getAnyInstanceOf(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		EObject eObject = this.connector().getAnyInstanceOf(this.random(), eClass);
		Class<? extends EObject> javaInterface = EDPLProxy.getPrimaryJavaInterfaceForEClass(eClass);
		return (T) EDPLProxy.create(eObject, javaInterface, this.owningInstance.ecoreConfig().getFeatureAccessMode());
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAnyDistinctInstancesOf(final EClass eClass, final int numberOfInstances) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		checkArgument(numberOfInstances > 0,
				"Precondition violation - argument 'numberOfInstances' must be greater than zero!");
		List<EObject> eObjects = this.connector().getAnyDistinctInstancesOf(this.random(), eClass, numberOfInstances);
		return eObjects.stream().map(eObject -> {
			Class<? extends EObject> javaInterface = EDPLProxy.getPrimaryJavaInterfaceForEClass(eObject.eClass());
			return (T) EDPLProxy.create(eObject, javaInterface,
					this.owningInstance.ecoreConfig().getFeatureAccessMode());
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAnyDistinctInstancesOf(final EClass eClass, final int numberOfInstances,
			final boolean allowSubclasses) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		checkArgument(numberOfInstances > 0,
				"Precondition violation - argument 'numberOfInstances' must be greater than zero!");
		List<EObject> eObjects = this.connector().getAnyDistinctInstancesOf(this.random(), eClass, numberOfInstances,
				allowSubclasses);
		return eObjects.stream().map(eObject -> {
			Class<? extends EObject> javaInterface = EDPLProxy.getPrimaryJavaInterfaceForEClass(eObject.eClass());
			return (T) EDPLProxy.create(eObject, javaInterface,
					this.owningInstance.ecoreConfig().getFeatureAccessMode());
		}).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EObject> Iterator<T> getAllInstancesOf(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		Iterator<EObject> iterator = this.connector().getAllInstancesOf(eClass);
		return Iterators.transform(iterator, eObject -> {
			Class<? extends EObject> javaInterface = EDPLProxy.getPrimaryJavaInterfaceForEClass(eObject.eClass());
			return (T) EDPLProxy.create(eObject, javaInterface,
					this.owningInstance.ecoreConfig().getFeatureAccessMode());
		});
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EObject> Iterator<T> getAllInstancesOf(final EClass eClass, final boolean includeSubclasses) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		Iterator<EObject> iterator = this.connector().getAllInstancesOf(eClass, includeSubclasses);
		return Iterators.transform(iterator, eObject -> {
			Class<? extends EObject> javaInterface = EDPLProxy.getPrimaryJavaInterfaceForEClass(eObject.eClass());
			return (T) EDPLProxy.create(eObject, javaInterface,
					this.owningInstance.ecoreConfig().getFeatureAccessMode());
		});
	}

	@Override
	public long countInstancesOf(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		return this.connector().countInstancesOf(eClass);
	}

	@Override
	public long countInstancesOf(final EClass eClass, final boolean includeSubclasses) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		return this.connector().countInstancesOf(eClass, includeSubclasses);
	}

	// =================================================================================================================
	// ADDING METHODS
	// =================================================================================================================

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EObject> T instantiate(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		EObject eObject = this.owningInstance.ecoreConfig().getEObjectFactory().create(eClass);
		Class<? extends EObject> javaInterface = EDPLProxy.getPrimaryJavaInterfaceForEClass(eClass);
		return (T) EDPLProxy.create(eObject, javaInterface, this.owningInstance.ecoreConfig().getFeatureAccessMode());
	}

	@Override
	public <T extends EObject> T instantiateAndAddToModel(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		T eObject = this.instantiate(eClass);
		this.addToModel(eObject);
		return eObject;
	}

	@Override
	public void addToModel(final EObject eObject) {
		checkNotNull(eObject, "Precondition violation - argument 'eObject' must not be NULL!");
		EObject unwrappedEObject = EDPLProxy.unwrap(eObject);
		this.connector().addToModel(unwrappedEObject);
	}

	@Override
	public void addToModel(final Iterator<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		if (eObjects.hasNext() == false) {
			return;
		}
		this.addToModel(eObjects);
	}

	@Override
	public void addToModel(final Iterable<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		if (Iterables.isEmpty(eObjects)) {
			return;
		}
		this.addToModel(eObjects);
	}

	@Override
	public void removeFromModel(final EObject eObject) {
		checkNotNull(eObject, "Precondition violation - argument 'eObject' must not be NULL!");
		EObject unwrappedEObject = EDPLProxy.unwrap(eObject);
		this.connector().removeFromModel(unwrappedEObject);
	}

	@Override
	public void removeFromModel(final Iterator<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		if (eObjects.hasNext() == false) {
			return;
		}
		this.removeFromModel(eObjects);
	}

	@Override
	public void removeFromModel(final Iterable<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		if (Iterables.isEmpty(eObjects)) {
			return;
		}
		this.removeFromModel(eObjects);
	}

	// =================================================================================================================
	// INTERNAL API
	// =================================================================================================================

	public void iterationDone() {
		this.iterationNumber++;
	}

	// =================================================================================================================
	// INTERNAL HELPER METHODS
	// =================================================================================================================

	protected RepositoryConnector connector() {
		return this.owningInstance.repositoryConfig().getConnector();
	}

}
