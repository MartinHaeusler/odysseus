/**
 */
package org.odysseus.models.socialnetwork.user;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.odysseus.models.socialnetwork.activity.Post;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Group#getName <em>Name</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Group#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Group#getAdmin <em>Admin</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Group#getMembers <em>Members</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Group#getPosts <em>Posts</em>}</li>
 * </ul>
 *
 * @see org.odysseus.models.socialnetwork.user.UserPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends EObject {
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
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getGroup_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Group#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getGroup_CreationDate()
	 * @model
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Group#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Admin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Admin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Admin</em>' reference.
	 * @see #setAdmin(Person)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getGroup_Admin()
	 * @model
	 * @generated
	 */
	Person getAdmin();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Group#getAdmin <em>Admin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Admin</em>' reference.
	 * @see #getAdmin()
	 * @generated
	 */
	void setAdmin(Person value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.user.Person}.
	 * It is bidirectional and its opposite is '{@link org.odysseus.models.socialnetwork.user.Person#getMembershipInGroups <em>Membership In Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getGroup_Members()
	 * @see org.odysseus.models.socialnetwork.user.Person#getMembershipInGroups
	 * @model opposite="membershipInGroups"
	 * @generated
	 */
	EList<Person> getMembers();

	/**
	 * Returns the value of the '<em><b>Posts</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.activity.Post}.
	 * It is bidirectional and its opposite is '{@link org.odysseus.models.socialnetwork.activity.Post#getInGroup <em>In Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Posts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Posts</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getGroup_Posts()
	 * @see org.odysseus.models.socialnetwork.activity.Post#getInGroup
	 * @model opposite="inGroup"
	 * @generated
	 */
	EList<Post> getPosts();

} // Group
