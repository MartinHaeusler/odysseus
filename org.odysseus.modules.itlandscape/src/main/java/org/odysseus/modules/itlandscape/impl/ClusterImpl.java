/**
 */
package org.odysseus.modules.itlandscape.impl;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.modules.itlandscape.Cluster;
import org.odysseus.modules.itlandscape.ItlandscapePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.ClusterImpl#isHighAvailability <em>High Availability</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.ClusterImpl#isLoadBalancing <em>Load Balancing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClusterImpl extends VirtualHostImpl implements Cluster {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClusterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ItlandscapePackage.Literals.CLUSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHighAvailability() {
		return (Boolean) eGet(ItlandscapePackage.Literals.CLUSTER__HIGH_AVAILABILITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighAvailability(boolean newHighAvailability) {
		eSet(ItlandscapePackage.Literals.CLUSTER__HIGH_AVAILABILITY, newHighAvailability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoadBalancing() {
		return (Boolean) eGet(ItlandscapePackage.Literals.CLUSTER__LOAD_BALANCING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadBalancing(boolean newLoadBalancing) {
		eSet(ItlandscapePackage.Literals.CLUSTER__LOAD_BALANCING, newLoadBalancing);
	}

} //ClusterImpl
