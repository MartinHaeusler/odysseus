package org.odysseus.spi;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface ModelGenerationContext {

	// =================================================================================================================
	// ACCESS TO SERVICES
	// =================================================================================================================

	public RandomGenerator random();

	// =================================================================================================================
	// STATISTICS
	// =================================================================================================================

	public int getIteration();

	public long getSimulationRuntime();

	public int getElementsAdded();

	public int getElementsRemoved();

	// =================================================================================================================
	// QUERY METHODS
	// =================================================================================================================

	public <T extends EObject> T getAnyInstanceOf(final EClass eClass);

	public <T extends EObject> List<T> getAnyDistinctInstancesOf(final EClass eClass, final int numberOfInstances);

	public <T extends EObject> List<T> getAnyDistinctInstancesOf(EClass eClass, int numberOfInstances,
			boolean allowSubclasses);

	public <T extends EObject> Iterator<T> getAllInstancesOf(final EClass eClass);

	public <T extends EObject> Iterator<T> getAllInstancesOf(EClass eClass, boolean includeSubclasses);

	public long countInstancesOf(final EClass eClass);

	public long countInstancesOf(EClass eClass, boolean includeSubclasses);

	// =================================================================================================================
	// ADDING METHODS
	// =================================================================================================================

	public <T extends EObject> T instantiate(EClass eClass);

	public <T extends EObject> T instantiateAndAddToModel(EClass eClass);

	public void addToModel(final EObject eObject);

	public void addToModel(Iterator<? extends EObject> eObjects);

	public void addToModel(final Iterable<? extends EObject> eObjects);

	public void removeFromModel(final EObject eObject);

	public void removeFromModel(Iterator<? extends EObject> eObjects);

	public void removeFromModel(Iterable<? extends EObject> eObjects);

}
