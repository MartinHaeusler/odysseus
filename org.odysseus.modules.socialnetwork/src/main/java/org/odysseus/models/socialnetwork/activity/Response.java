/**
 */
package org.odysseus.models.socialnetwork.activity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Response#getPost <em>Post</em>}</li>
 * </ul>
 *
 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getResponse()
 * @model
 * @generated
 */
public interface Response extends Contribution {
	/**
	 * Returns the value of the '<em><b>Post</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post</em>' reference.
	 * @see #setPost(Post)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getResponse_Post()
	 * @model
	 * @generated
	 */
	Post getPost();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Response#getPost <em>Post</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post</em>' reference.
	 * @see #getPost()
	 * @generated
	 */
	void setPost(Post value);

} // Response
