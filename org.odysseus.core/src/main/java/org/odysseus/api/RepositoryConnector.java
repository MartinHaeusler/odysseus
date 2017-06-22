package org.odysseus.api;

import static com.google.common.base.Preconditions.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.odysseus.spi.RandomGenerator;
import org.odysseus.spi.exceptions.NotEnoughElementsException;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

public interface RepositoryConnector {

	// =================================================================================================================
	// QUERY METHODS
	// =================================================================================================================

	public default EObject getAnyInstanceOf(final RandomGenerator random, final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		List<? extends EObject> elements = this.getAnyDistinctInstancesOf(random, eClass, 1);
		if (elements == null || elements.isEmpty()) {
			throw new NotEnoughElementsException("There is no instance of EClass '" + eClass.getName() + "'!");
		} else {
			return Iterables.getOnlyElement(elements);
		}
	}

	public default <T extends EObject> List<T> getAnyDistinctInstancesOf(final RandomGenerator random,
			final EClass eClass, final int numberOfInstances) {
		checkNotNull(random, "Precondition violation - argument 'random' must not be NULL!");
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		checkArgument(numberOfInstances >= 0,
				"Precondition violation - argument 'numberOfInstances' must not be negative!");
		return this.getAnyDistinctInstancesOf(random, eClass, numberOfInstances, true);
	}

	public <T extends EObject> List<T> getAnyDistinctInstancesOf(final RandomGenerator random, EClass eClass,
			int numberOfInstances, boolean allowSubclasses);

	public default <T extends EObject> Iterator<T> getAllInstancesOf(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		return this.getAllInstancesOf(eClass, true);
	}

	public <T extends EObject> Iterator<T> getAllInstancesOf(EClass eClass, boolean includeSubclasses);

	public default long countInstancesOf(final EClass eClass) {
		checkNotNull(eClass, "Precondition violation - argument 'eClass' must not be NULL!");
		return this.countInstancesOf(eClass, true);
	}

	public long countInstancesOf(EClass eClass, boolean includeSubclasses);

	// =================================================================================================================
	// ELEMENT GENERATION METHODS
	// =================================================================================================================

	public default void addToModel(final EObject eObject) {
		checkNotNull(eObject, "Precondition violation - argument 'eObject' must not be NULL!");
		this.addToModel(Iterators.singletonIterator(eObject));
	}

	public void addToModel(Iterator<? extends EObject> eObjects);

	public default void addToModel(final Iterable<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		this.addToModel(eObjects.iterator());
	}

	public default void removeFromModel(final EObject eObject) {
		checkNotNull(eObject, "Precondition violation - argument 'eObject' must not be NULL!");
		this.removeFromModel(Iterators.singletonIterator(eObject));
	}

	public void removeFromModel(Iterator<? extends EObject> eObjects);

	public default void removeFromModel(final Iterable<? extends EObject> eObjects) {
		checkNotNull(eObjects, "Precondition violation - argument 'eObjects' must not be NULL!");
		this.removeFromModel(eObjects.iterator());
	}

	// =================================================================================================================
	// DATA FLOW METHODS
	// =================================================================================================================

	public void start();

	public void flush();

	public void done();

}
