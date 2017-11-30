/**
 */
package org.odysseus.modules.itlandscape.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.odysseus.modules.itlandscape.Application;
import org.odysseus.modules.itlandscape.Database;
import org.odysseus.modules.itlandscape.Host;
import org.odysseus.modules.itlandscape.ItlandscapePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.ApplicationImpl#getRunsOn <em>Runs On</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.impl.ApplicationImpl#getAccesses <em>Accesses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationImpl extends ElementImpl implements Application {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ItlandscapePackage.Literals.APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Host> getRunsOn() {
		return (EList<Host>) eGet(ItlandscapePackage.Literals.APPLICATION__RUNS_ON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Database> getAccesses() {
		return (EList<Database>) eGet(ItlandscapePackage.Literals.APPLICATION__ACCESSES, true);
	}

} //ApplicationImpl
