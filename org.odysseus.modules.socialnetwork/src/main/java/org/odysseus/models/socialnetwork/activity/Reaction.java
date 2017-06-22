/**
 */
package org.odysseus.models.socialnetwork.activity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Reaction#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getReaction()
 * @model
 * @generated
 */
public interface Reaction extends Response {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"LIKE"</code>.
	 * The literals are from the enumeration {@link org.odysseus.models.socialnetwork.activity.ReactionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.odysseus.models.socialnetwork.activity.ReactionType
	 * @see #setType(ReactionType)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getReaction_Type()
	 * @model default="LIKE"
	 * @generated
	 */
	ReactionType getType();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Reaction#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.odysseus.models.socialnetwork.activity.ReactionType
	 * @see #getType()
	 * @generated
	 */
	void setType(ReactionType value);

} // Reaction
