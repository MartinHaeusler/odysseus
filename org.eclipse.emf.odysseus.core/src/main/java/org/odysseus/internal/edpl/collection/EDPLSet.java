package org.odysseus.internal.edpl.collection;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.odysseus.internal.configuration.FeatureAccessMode;

public class EDPLSet<T extends EObject> extends AbstractEDPLCollection<T> implements Set<T> {

	public EDPLSet(final Set<T> collection, final Class<T> elementClass, final FeatureAccessMode accessMode) {
		super(collection, elementClass, accessMode);
	}

}
