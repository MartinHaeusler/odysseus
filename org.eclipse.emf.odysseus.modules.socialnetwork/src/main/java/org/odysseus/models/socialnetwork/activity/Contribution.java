/**
 */
package org.odysseus.models.socialnetwork.activity;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.odysseus.models.socialnetwork.user.Person;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Contribution#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Contribution#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getContribution()
 * @model
 * @generated
 */
public interface Contribution extends EObject {
	/**
	 * Returns the value of the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' reference.
	 * @see #setAuthor(Person)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getContribution_Author()
	 * @model
	 * @generated
	 */
	Person getAuthor();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Contribution#getAuthor <em>Author</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' reference.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(Person value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getContribution_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Contribution#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // Contribution
