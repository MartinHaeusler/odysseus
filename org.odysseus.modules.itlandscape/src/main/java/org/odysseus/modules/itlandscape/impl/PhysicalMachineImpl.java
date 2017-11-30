/**
 */
package org.odysseus.modules.itlandscape.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.PhysicalMachine;
import org.odysseus.modules.itlandscape.Storage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.PhysicalMachineImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.PhysicalMachineImpl#getCpuCores <em>Cpu Cores</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.PhysicalMachineImpl#getClockRateGhz <em>Clock Rate Ghz</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.PhysicalMachineImpl#getRamGB <em>Ram GB</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhysicalMachineImpl extends HostImpl implements PhysicalMachine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ItlandscapePackage.Literals.PHYSICAL_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Storage> getUses() {
		return (EList<Storage>) eGet(ItlandscapePackage.Literals.PHYSICAL_MACHINE__USES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCpuCores() {
		return (Integer) eGet(ItlandscapePackage.Literals.PHYSICAL_MACHINE__CPU_CORES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuCores(int newCpuCores) {
		eSet(ItlandscapePackage.Literals.PHYSICAL_MACHINE__CPU_CORES, newCpuCores);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getClockRateGhz() {
		return (Float) eGet(ItlandscapePackage.Literals.PHYSICAL_MACHINE__CLOCK_RATE_GHZ, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClockRateGhz(float newClockRateGhz) {
		eSet(ItlandscapePackage.Literals.PHYSICAL_MACHINE__CLOCK_RATE_GHZ, newClockRateGhz);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRamGB() {
		return (Integer) eGet(ItlandscapePackage.Literals.PHYSICAL_MACHINE__RAM_GB, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRamGB(int newRamGB) {
		eSet(ItlandscapePackage.Literals.PHYSICAL_MACHINE__RAM_GB, newRamGB);
	}

} //PhysicalMachineImpl
