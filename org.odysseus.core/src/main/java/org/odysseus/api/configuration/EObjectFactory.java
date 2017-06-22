package org.odysseus.api.configuration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

@FunctionalInterface
public interface EObjectFactory {

	public EObject create(EClass eClass);

}