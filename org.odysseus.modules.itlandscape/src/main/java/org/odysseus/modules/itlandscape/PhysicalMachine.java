/**
 */
package org.odysseus.modules.itlandscape;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.PhysicalMachine#getUses <em>Uses</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.PhysicalMachine#getCpuCores <em>Cpu Cores</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.PhysicalMachine#getClockRateGhz <em>Clock Rate Ghz</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.PhysicalMachine#getRamGB <em>Ram GB</em>}</li>
 * </ul>
 *
 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getPhysicalMachine()
 * @model
 * @generated
 */
public interface PhysicalMachine extends Host {
	/**
	 * Returns the value of the '<em><b>Uses</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.modules.itlandscape.Storage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' reference list.
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getPhysicalMachine_Uses()
	 * @model
	 * @generated
	 */
	EList<Storage> getUses();

	/**
	 * Returns the value of the '<em><b>Cpu Cores</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpu Cores</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpu Cores</em>' attribute.
	 * @see #setCpuCores(int)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getPhysicalMachine_CpuCores()
	 * @model default="1"
	 * @generated
	 */
	int getCpuCores();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.PhysicalMachine#getCpuCores <em>Cpu Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Cores</em>' attribute.
	 * @see #getCpuCores()
	 * @generated
	 */
	void setCpuCores(int value);

	/**
	 * Returns the value of the '<em><b>Clock Rate Ghz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock Rate Ghz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock Rate Ghz</em>' attribute.
	 * @see #setClockRateGhz(float)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getPhysicalMachine_ClockRateGhz()
	 * @model
	 * @generated
	 */
	float getClockRateGhz();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.PhysicalMachine#getClockRateGhz <em>Clock Rate Ghz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock Rate Ghz</em>' attribute.
	 * @see #getClockRateGhz()
	 * @generated
	 */
	void setClockRateGhz(float value);

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
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getPhysicalMachine_RamGB()
	 * @model default="0"
	 * @generated
	 */
	int getRamGB();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.PhysicalMachine#getRamGB <em>Ram GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ram GB</em>' attribute.
	 * @see #getRamGB()
	 * @generated
	 */
	void setRamGB(int value);

} // PhysicalMachine
