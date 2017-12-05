/**
 */
package org.odysseus.modules.itlandscape.impl;

import org.eclipse.emf.ecore.EClass;

import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.VirtualMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.VirtualMachineImpl#getCpuCores <em>Cpu Cores</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.VirtualMachineImpl#getRamGB <em>Ram GB</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.VirtualMachineImpl#getClockRateGhz <em>Clock Rate Ghz</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VirtualMachineImpl extends VirtualHostImpl implements VirtualMachine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ItlandscapePackage.Literals.VIRTUAL_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCpuCores() {
		return (Integer) eGet(ItlandscapePackage.Literals.VIRTUAL_MACHINE__CPU_CORES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuCores(int newCpuCores) {
		eSet(ItlandscapePackage.Literals.VIRTUAL_MACHINE__CPU_CORES, newCpuCores);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRamGB() {
		return (Integer) eGet(ItlandscapePackage.Literals.VIRTUAL_MACHINE__RAM_GB, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRamGB(int newRamGB) {
		eSet(ItlandscapePackage.Literals.VIRTUAL_MACHINE__RAM_GB, newRamGB);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getClockRateGhz() {
		return (Float) eGet(ItlandscapePackage.Literals.VIRTUAL_MACHINE__CLOCK_RATE_GHZ, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClockRateGhz(float newClockRateGhz) {
		eSet(ItlandscapePackage.Literals.VIRTUAL_MACHINE__CLOCK_RATE_GHZ, newClockRateGhz);
	}

} //VirtualMachineImpl
