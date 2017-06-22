package org.odysseus.internal.edpl.collection;

import static com.google.common.base.Preconditions.*;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;
import org.odysseus.internal.configuration.FeatureAccessMode;
import org.odysseus.internal.edpl.EDPLProxy;

public class EDPLList<T extends EObject> extends AbstractEDPLCollection<T> implements List<T> {

	public EDPLList(final List<T> list, final Class<T> elementClass, final FeatureAccessMode accessMode) {
		super(list, elementClass, accessMode);
	}

	@Override
	public boolean addAll(final int index, final Collection<? extends T> c) {
		boolean changed = false;
		int currentIndex = index;
		for (T element : c) {
			this.add(currentIndex, element);
			currentIndex++;
			changed = true;
		}
		return changed;
	}

	@Override
	public T get(final int index) {
		T element = this.getList().get(index);
		if (element != null) {
			return EDPLProxy.create(element, this.elementClass, this.featureAccessMode);
		} else {
			return null;
		}
	}

	@Override
	public T set(final int index, final T element) {
		T eObject = EDPLProxy.unwrap(element);
		T result = this.getList().set(index, eObject);
		return EDPLProxy.create(result, this.elementClass, this.featureAccessMode);
	}

	@Override
	public void add(final int index, final T element) {
		checkNotNull(element, "Precondition violation - argument 'element' must not be NULL!");
		T eObject = EDPLProxy.unwrap(element);
		this.getList().add(index, eObject);
	}

	@Override
	public T remove(final int index) {
		T removed = this.getList().remove(index);
		if (removed != null) {
			return EDPLProxy.unwrap(removed);
		} else {
			return null;
		}
	}

	@Override
	public int indexOf(final Object o) {
		if (o instanceof EObject) {
			EObject eObject = (EObject) o;
			EObject realEObject = EDPLProxy.unwrap(eObject);
			return this.getList().indexOf(realEObject);
		} else {
			return this.getList().indexOf(o);
		}
	}

	@Override
	public int lastIndexOf(final Object o) {
		if (o instanceof EObject) {
			EObject eObject = (EObject) o;
			EObject realEObject = EDPLProxy.unwrap(eObject);
			return this.getList().indexOf(realEObject);
		} else {
			return this.getList().lastIndexOf(o);
		}
	}

	@Override
	public ListIterator<T> listIterator() {
		ListIterator<T> innerIterator = this.getList().listIterator();
		return new EDPLListIterator(innerIterator);
	}

	@Override
	public ListIterator<T> listIterator(final int index) {
		ListIterator<T> innerIterator = this.getList().listIterator(index);
		return new EDPLListIterator(innerIterator);
	}

	@Override
	public List<T> subList(final int fromIndex, final int toIndex) {
		List<T> subList = this.getList().subList(fromIndex, toIndex);
		return new EDPLList<T>(subList, this.elementClass, this.featureAccessMode);
	}

	// =================================================================================================================
	// INTERNAL HELPER METHODS
	// =================================================================================================================

	protected List<T> getList() {
		return (List<T>) this.internalCollection;
	}

	// =================================================================================================================
	// INNER CLASSES
	// =================================================================================================================

	private class EDPLListIterator implements ListIterator<T> {

		private final ListIterator<T> innerIterator;

		public EDPLListIterator(final ListIterator<T> iterator) {
			checkNotNull(iterator, "Precondition violation - argument 'iterator' must not be NULL!");
			this.innerIterator = iterator;
		}

		@Override
		public boolean hasNext() {
			return this.innerIterator.hasNext();
		}

		@Override
		public T next() {
			T element = this.innerIterator.next();
			return EDPLProxy.create(element, EDPLList.this.elementClass, EDPLList.this.featureAccessMode);
		}

		@Override
		public boolean hasPrevious() {
			return this.innerIterator.hasPrevious();
		}

		@Override
		public T previous() {
			T element = this.innerIterator.previous();
			return EDPLProxy.create(element, EDPLList.this.elementClass, EDPLList.this.featureAccessMode);
		}

		@Override
		public int nextIndex() {
			return this.innerIterator.nextIndex();
		}

		@Override
		public int previousIndex() {
			return this.innerIterator.previousIndex();
		}

		@Override
		public void remove() {
			this.innerIterator.remove();
		}

		@Override
		public void set(final T e) {
			T eObject = EDPLProxy.unwrap(e);
			this.innerIterator.set(eObject);
		}

		@Override
		public void add(final T e) {
			T eObject = EDPLProxy.unwrap(e);
			this.innerIterator.add(eObject);
		}
	}

}
