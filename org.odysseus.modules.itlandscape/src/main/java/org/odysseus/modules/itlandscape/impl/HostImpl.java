/**
 */
package org.odysseus.modules.itlandscape.impl;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.modules.itlandscape.Host;
import org.odysseus.modules.itlandscape.ItlandscapePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Host</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.HostImpl#getIp <em>Ip</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.HostImpl#getOperatingSystem <em>Operating System</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class HostImpl extends ElementImpl implements Host {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ItlandscapePackage.Literals.HOST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIp() {
		return (String) eGet(ItlandscapePackage.Literals.HOST__IP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIp(String newIp) {
		eSet(ItlandscapePackage.Literals.HOST__IP, newIp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperatingSystem() {
		return (String) eGet(ItlandscapePackage.Literals.HOST__OPERATING_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatingSystem(String newOperatingSystem) {
		eSet(ItlandscapePackage.Literals.HOST__OPERATING_SYSTEM, newOperatingSystem);
	}

} //HostImpl
