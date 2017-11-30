/**
 */
package org.odysseus.modules.itlandscape;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.Application#getRunsOn <em>Runs On</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.Application#getAccesses <em>Accesses</em>}</li>
 * </ul>
 *
 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends Element {
	/**
	 * Returns the value of the '<em><b>Runs On</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.modules.itlandscape.Host}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runs On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runs On</em>' reference list.
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getApplication_RunsOn()
	 * @model
	 * @generated
	 */
	EList<Host> getRunsOn();

	/**
	 * Returns the value of the '<em><b>Accesses</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.modules.itlandscape.Database}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accesses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accesses</em>' reference list.
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getApplication_Accesses()
	 * @model
	 * @generated
	 */
	EList<Database> getAccesses();

} // Application
