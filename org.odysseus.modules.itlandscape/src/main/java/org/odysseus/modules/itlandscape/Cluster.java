/**
 */
package org.odysseus.modules.itlandscape;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.Cluster#isHighAvailability <em>High Availability</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.Cluster#isLoadBalancing <em>Load Balancing</em>}</li>
 * </ul>
 *
 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getCluster()
 * @model
 * @generated
 */
public interface Cluster extends VirtualHost {
	/**
	 * Returns the value of the '<em><b>High Availability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>High Availability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>High Availability</em>' attribute.
	 * @see #setHighAvailability(boolean)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getCluster_HighAvailability()
	 * @model
	 * @generated
	 */
	boolean isHighAvailability();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.Cluster#isHighAvailability <em>High Availability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High Availability</em>' attribute.
	 * @see #isHighAvailability()
	 * @generated
	 */
	void setHighAvailability(boolean value);

	/**
	 * Returns the value of the '<em><b>Load Balancing</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load Balancing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Balancing</em>' attribute.
	 * @see #setLoadBalancing(boolean)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getCluster_LoadBalancing()
	 * @model default="false"
	 * @generated
	 */
	boolean isLoadBalancing();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.Cluster#isLoadBalancing <em>Load Balancing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Balancing</em>' attribute.
	 * @see #isLoadBalancing()
	 * @generated
	 */
	void setLoadBalancing(boolean value);

} // Cluster
