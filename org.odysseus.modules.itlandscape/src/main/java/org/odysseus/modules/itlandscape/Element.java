/**
 */
package org.odysseus.modules.itlandscape;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.modules.itlandscape.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.Element#getDescription <em>Description</em>}</li>
 *   <li>{@link org.odysseus.modules.itlandscape.Element#getSla <em>Sla</em>}</li>
 * </ul>
 *
 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getElement_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.Element#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Sla</b></em>' attribute.
	 * The literals are from the enumeration {@link org.odysseus.modules.itlandscape.ServiceLevelAgreement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sla</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sla</em>' attribute.
	 * @see org.odysseus.modules.itlandscape.ServiceLevelAgreement
	 * @see #setSla(ServiceLevelAgreement)
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#getElement_Sla()
	 * @model
	 * @generated
	 */
	ServiceLevelAgreement getSla();

	/**
	 * Sets the value of the '{@link org.odysseus.modules.itlandscape.Element#getSla <em>Sla</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sla</em>' attribute.
	 * @see org.odysseus.modules.itlandscape.ServiceLevelAgreement
	 * @see #getSla()
	 * @generated
	 */
	void setSla(ServiceLevelAgreement value);

} // Element
