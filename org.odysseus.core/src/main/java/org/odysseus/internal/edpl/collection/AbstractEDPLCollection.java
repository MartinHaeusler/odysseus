package org.odysseus.internal.edpl.collection;

import static com.google.common.base.Preconditions.*;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.odysseus.internal.configuration.FeatureAccessMode;
import org.odysseus.internal.edpl.EDPLProxy;

import com.google.common.collect.Iterators;

public class AbstractEDPLCollection<T extends EObject> implements Collection<T> {

	protected final Collection<T> internalCollection;
	protected final Class<T> elementClass;
	protected final FeatureAccessMode featureAccessMode;

	public AbstractEDPLCollection(final Collection<T> collection, final Class<T> elementClass,
			final FeatureAccessMode accessMode) {
		checkNotNull(collection, "Precondition violation - argument 'collection' must not be NULL!");
		checkNotNull(elementClass, "Precondition violation - argument 'elementClass' must not be NULL!");
		checkNotNull(accessMode, "Precondition violation - argument 'accessMode' must not be NULL!");
		checkArgument(elementClass.isInterface(),
				"Precondition violation - argument 'elementClass' must be an interface!");
		this.internalCollection = collection;
		this.elementClass = elementClass;
		this.featureAccessMode = accessMode;
	}

	@Override
	public int size() {
		return this.internalCollection.size();
	}

	@Override
	public boolean isEmpty() {
		return this.internalCollection.isEmpty();
	}

	@Override
	public boolean contains(final Object o) {
		if (o instanceof EObject) {
			EObject eObject = (EObject) o;
			EObject realEObject = EDPLProxy.unwrap(eObject);
			return this.internalCollection.contains(realEObject);
		} else {
			return this.internalCollection.contains(o);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return Iterators.transform(this.internalCollection.iterator(), e -> {
			return EDPLProxy.create(e, this.elementClass, this.featureAccessMode);
		});
	}

	@Override
	public Object[] toArray() {
		Object[] array = this.internalCollection.toArray();
		this.wrapArray(array);
		return array;
	}

	@Override
	public <E> E[] toArray(final E[] a) {
		E[] array = this.internalCollection.toArray(a);
		this.wrapArray(array);
		return array;
	}

	@Override
	public boolean add(final T e) {
		checkNotNull(e, "Precondition violation - argument 'e' must not be NULL!");
		T element = EDPLProxy.unwrap(e);
		return this.internalCollection.add(element);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean remove(final Object o) {
		checkNotNull(o, "Precondition violation - argument 'o' must not be NULL!");
		if (o instanceof EObject) {
			EObject eObject = (EObject) o;
			T element = (T) EDPLProxy.unwrap(eObject);
			return this.internalCollection.remove(element);
		} else {
			return this.internalCollection.remove(o);
		}
	}

	@Override
	public boolean containsAll(final Collection<?> c) {
		checkNotNull(c, "Precondition violation - argument 'c' must not be NULL!");
		for (Object element : c) {
			if (this.contains(element) == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(final Collection<? extends T> c) {
		checkNotNull(c, "Precondition violation - argument 'c' must not be NULL!");
		boolean changed = false;
		for (T element : c) {
			boolean added = this.add(element);
			changed = added || changed;
		}
		return changed;
	}

	@Override
	public boolean removeAll(final Collection<?> c) {
		checkNotNull(c, "Precondition violation - argument 'c' must not be NULL!");
		boolean changed = false;
		for (Object element : c) {
			boolean removed = this.remove(element);
			changed = removed || changed;
		}
		return changed;
	}

	@Override
	public boolean retainAll(final Collection<?> c) {
		checkNotNull(c, "Precondition violation - argument 'c' must not be NULL!");
		return this.removeIf(element -> c.contains(element) == false);
	}

	@Override
	public void clear() {
		this.internalCollection.clear();
	}

	// =================================================================================================================
	// HELPER METHODS
	// =================================================================================================================

	@SuppressWarnings("unchecked")
	private void wrapArray(final Object[] array) {
		for (int i = 0; i < array.length; i++) {
			EObject eObject = (EObject) array[i];
			array[i] = EDPLProxy.create((T) eObject, this.elementClass, this.featureAccessMode);
		}
	}

}
