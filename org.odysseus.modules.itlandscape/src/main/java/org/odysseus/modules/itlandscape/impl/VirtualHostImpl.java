/**
 */
package org.odysseus.modules.itlandscape.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.modules.itlandscape.Host;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.VirtualHost;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Host</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.VirtualHostImpl#getRunsOn <em>Runs On</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VirtualHostImpl extends HostImpl implements VirtualHost {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualHostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ItlandscapePackage.Literals.VIRTUAL_HOST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Host> getRunsOn() {
		return (EList<Host>) eGet(ItlandscapePackage.Literals.VIRTUAL_HOST__RUNS_ON, true);
	}

} //VirtualHostImpl
