/**
 */
package org.odysseus.models.socialnetwork.activity;

import org.eclipse.emf.common.util.EList;
import org.odysseus.models.socialnetwork.media.MediaData;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Post</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Post#getText <em>Text</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Post#getIsRepostOf <em>Is Repost Of</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Post#getAttachedMedia <em>Attached Media</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Post#getMentions <em>Mentions</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Post#getInGroup <em>In Group</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Post#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Post#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.Post#getComments <em>Comments</em>}</li>
 * </ul>
 *
 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost()
 * @model
 * @generated
 */
public interface Post extends Contribution {
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
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Post#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Is Repost Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Repost Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Repost Of</em>' reference.
	 * @see #setIsRepostOf(Post)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost_IsRepostOf()
	 * @model
	 * @generated
	 */
	Post getIsRepostOf();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Post#getIsRepostOf <em>Is Repost Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Repost Of</em>' reference.
	 * @see #getIsRepostOf()
	 * @generated
	 */
	void setIsRepostOf(Post value);

	/**
	 * Returns the value of the '<em><b>Attached Media</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.media.MediaData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attached Media</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attached Media</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost_AttachedMedia()
	 * @model
	 * @generated
	 */
	EList<MediaData> getAttachedMedia();

	/**
	 * Returns the value of the '<em><b>Mentions</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.user.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mentions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mentions</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost_Mentions()
	 * @model
	 * @generated
	 */
	EList<Person> getMentions();

	/**
	 * Returns the value of the '<em><b>In Group</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.odysseus.models.socialnetwork.user.Group#getPosts <em>Posts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Group</em>' reference.
	 * @see #setInGroup(Group)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost_InGroup()
	 * @see org.odysseus.models.socialnetwork.user.Group#getPosts
	 * @model opposite="posts"
	 * @generated
	 */
	Group getInGroup();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Post#getInGroup <em>In Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Group</em>' reference.
	 * @see #getInGroup()
	 * @generated
	 */
	void setInGroup(Group value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"EVERYONE"</code>.
	 * The literals are from the enumeration {@link org.odysseus.models.socialnetwork.activity.Visibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.odysseus.models.socialnetwork.activity.Visibility
	 * @see #setVisibility(Visibility)
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost_Visibility()
	 * @model default="EVERYONE"
	 * @generated
	 */
	Visibility getVisibility();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.activity.Post#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see org.odysseus.models.socialnetwork.activity.Visibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(Visibility value);

	/**
	 * Returns the value of the '<em><b>Reactions</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.activity.Reaction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reactions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reactions</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost_Reactions()
	 * @model
	 * @generated
	 */
	EList<Reaction> getReactions();

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.activity.Comment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.activity.ActivityPackage#getPost_Comments()
	 * @model
	 * @generated
	 */
	EList<Comment> getComments();

} // Post
