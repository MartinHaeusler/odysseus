/**
 */
package org.odysseus.modules.itlandscape.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.odysseus.modules.itlandscape.Application;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.ServiceImpl#getDependsOn <em>Depends On</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceImpl extends ElementImpl implements Service {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ItlandscapePackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Application> getDependsOn() {
		return (EList<Application>) eGet(ItlandscapePackage.Literals.SERVICE__DEPENDS_ON, true);
	}

} //ServiceImpl
