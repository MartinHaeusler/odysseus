/**
 */
package org.odysseus.models.socialnetwork.activity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Comment#getInResponseTo <em>In Response To</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Comment#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getComment()
 * @model
 * @generated
 */
public interface Comment extends Response {
	/**
	 * Returns the value of the '<em><b>In Response To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Response To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Response To</em>' reference.
	 * @see #setInResponseTo(Comment)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getComment_InResponseTo()
	 * @model
	 * @generated
	 */
	Comment getInResponseTo();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Comment#getInResponseTo <em>In Response To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Response To</em>' reference.
	 * @see #getInResponseTo()
	 * @generated
	 */
	void setInResponseTo(Comment value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getComment_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Comment#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // Comment
