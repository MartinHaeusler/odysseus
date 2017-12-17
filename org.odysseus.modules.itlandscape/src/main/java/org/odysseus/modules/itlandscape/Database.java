/**
 */
package org.odysseus.modules.itlandscape;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.Database#getRunsOn <em>Runs On</em>}</li>
 * </ul>
 *
 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getDatabase()
 * @model
 * @generated
 */
public interface Database extends Element {
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
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getDatabase_RunsOn()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Host> getRunsOn();

} // Database
