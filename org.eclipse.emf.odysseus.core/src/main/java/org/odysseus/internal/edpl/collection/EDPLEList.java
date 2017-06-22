package org.odysseus.internal.edpl.collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.odysseus.internal.configuration.FeatureAccessMode;
import org.odysseus.internal.edpl.EDPLProxy;

public class EDPLEList<T extends EObject> extends EDPLList<T> implements EList<T> {

	public EDPLEList(final EList<T> list, final Class<T> elementClass, final FeatureAccessMode accessMode) {
		super(list, elementClass, accessMode);
	}

	@Override
	public void move(final int newPosition, final T object) {
		EList<T> eList = this.getEList();
		T eObject = EDPLProxy.unwrap(object);
		eList.move(newPosition, eObject);
	}

	@Override
	public T move(final int newPosition, final int oldPosition) {
		T element = this.getEList().move(newPosition, oldPosition);
		return EDPLProxy.create(element, this.elementClass, this.featureAccessMode);
	}

	protected EList<T> getEList() {
		return (EList<T>) super.getList();
	}
}
