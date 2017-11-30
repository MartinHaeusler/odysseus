/**
 */
package org.odysseus.modules.itlandscape;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.VirtualMachine#getCpuCores <em>Cpu Cores</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.VirtualMachine#getRamGB <em>Ram GB</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.VirtualMachine#getClockRateGhz <em>Clock Rate Ghz</em>}</li>
 * </ul>
 *
 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getVirtualMachine()
 * @model
 * @generated
 */
public interface VirtualMachine extends VirtualHost {
	/**
	 * Returns the value of the '<em><b>Cpu Cores</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpu Cores</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpu Cores</em>' attribute.
	 * @see #setCpuCores(int)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getVirtualMachine_CpuCores()
	 * @model default="4"
	 * @generated
	 */
	int getCpuCores();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.VirtualMachine#getCpuCores <em>Cpu Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Cores</em>' attribute.
	 * @see #getCpuCores()
	 * @generated
	 */
	void setCpuCores(int value);

	/**
	 * Returns the value of the '<em><b>Ram GB</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ram GB</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ram GB</em>' attribute.
	 * @see #setRamGB(int)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getVirtualMachine_RamGB()
	 * @model default="0"
	 * @generated
	 */
	int getRamGB();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.VirtualMachine#getRamGB <em>Ram GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ram GB</em>' attribute.
	 * @see #getRamGB()
	 * @generated
	 */
	void setRamGB(int value);

	/**
	 * Returns the value of the '<em><b>Clock Rate Ghz</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock Rate Ghz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock Rate Ghz</em>' attribute.
	 * @see #setClockRateGhz(float)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getVirtualMachine_ClockRateGhz()
	 * @model default="0.0"
	 * @generated
	 */
	float getClockRateGhz();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.VirtualMachine#getClockRateGhz <em>Clock Rate Ghz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock Rate Ghz</em>' attribute.
	 * @see #getClockRateGhz()
	 * @generated
	 */
	void setClockRateGhz(float value);

} // VirtualMachine
