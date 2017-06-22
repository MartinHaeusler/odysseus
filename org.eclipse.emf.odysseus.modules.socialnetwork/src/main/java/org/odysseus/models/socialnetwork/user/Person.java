/**
 */
package org.odysseus.models.socialnetwork.user;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.odysseus.models.socialnetwork.media.MediaData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getGender <em>Gender</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getBirthdate <em>Birthdate</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getMemberSince <em>Member Since</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getMarriedTo <em>Married To</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getChildren <em>Children</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getProfilePicture <em>Profile Picture</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getFriends <em>Friends</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getParents <em>Parents</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.Person#getMembershipInGroups <em>Membership In Groups</em>}</li>
 * </ul>
 *
 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Gender</b></em>' attribute.
	 * The default value is <code>"MALE"</code>.
	 * The literals are from the enumeration {@link org.odysseus.models.socialnetwork.user.Gender}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gender</em>' attribute.
	 * @see org.odysseus.models.socialnetwork.user.Gender
	 * @see #setGender(Gender)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_Gender()
	 * @model default="MALE"
	 * @generated
	 */
	Gender getGender();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getGender <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gender</em>' attribute.
	 * @see org.odysseus.models.socialnetwork.user.Gender
	 * @see #getGender()
	 * @generated
	 */
	void setGender(Gender value);

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_FirstName()
	 * @model
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_LastName()
	 * @model
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Birthdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birthdate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birthdate</em>' attribute.
	 * @see #setBirthdate(Date)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_Birthdate()
	 * @model
	 * @generated
	 */
	Date getBirthdate();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getBirthdate <em>Birthdate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birthdate</em>' attribute.
	 * @see #getBirthdate()
	 * @generated
	 */
	void setBirthdate(Date value);

	/**
	 * Returns the value of the '<em><b>Member Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Since</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Since</em>' attribute.
	 * @see #setMemberSince(Date)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_MemberSince()
	 * @model
	 * @generated
	 */
	Date getMemberSince();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getMemberSince <em>Member Since</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Since</em>' attribute.
	 * @see #getMemberSince()
	 * @generated
	 */
	void setMemberSince(Date value);

	/**
	 * Returns the value of the '<em><b>Married To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Married To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Married To</em>' reference.
	 * @see #isSetMarriedTo()
	 * @see #unsetMarriedTo()
	 * @see #setMarriedTo(Person)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_MarriedTo()
	 * @model unsettable="true"
	 * @generated
	 */
	Person getMarriedTo();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getMarriedTo <em>Married To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Married To</em>' reference.
	 * @see #isSetMarriedTo()
	 * @see #unsetMarriedTo()
	 * @see #getMarriedTo()
	 * @generated
	 */
	void setMarriedTo(Person value);

	/**
	 * Unsets the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getMarriedTo <em>Married To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMarriedTo()
	 * @see #getMarriedTo()
	 * @see #setMarriedTo(Person)
	 * @generated
	 */
	void unsetMarriedTo();

	/**
	 * Returns whether the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getMarriedTo <em>Married To</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Married To</em>' reference is set.
	 * @see #unsetMarriedTo()
	 * @see #getMarriedTo()
	 * @see #setMarriedTo(Person)
	 * @generated
	 */
	boolean isSetMarriedTo();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.user.Person}.
	 * It is bidirectional and its opposite is '{@link org.odysseus.models.socialnetwork.user.Person#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_Children()
	 * @see org.odysseus.models.socialnetwork.user.Person#getParents
	 * @model opposite="parents" ordered="false"
	 * @generated
	 */
	EList<Person> getChildren();

	/**
	 * Returns the value of the '<em><b>Profile Picture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Picture</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Picture</em>' reference.
	 * @see #setProfilePicture(MediaData)
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_ProfilePicture()
	 * @model
	 * @generated
	 */
	MediaData getProfilePicture();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.user.Person#getProfilePicture <em>Profile Picture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Picture</em>' reference.
	 * @see #getProfilePicture()
	 * @generated
	 */
	void setProfilePicture(MediaData value);

	/**
	 * Returns the value of the '<em><b>Friends</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.user.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Friends</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_Friends()
	 * @model
	 * @generated
	 */
	EList<Person> getFriends();

	/**
	 * Returns the value of the '<em><b>Parents</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.user.Person}.
	 * It is bidirectional and its opposite is '{@link org.odysseus.models.socialnetwork.user.Person#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_Parents()
	 * @see org.odysseus.models.socialnetwork.user.Person#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	EList<Person> getParents();

	/**
	 * Returns the value of the '<em><b>Membership In Groups</b></em>' reference list.
	 * The list contents are of type {@link org.odysseus.models.socialnetwork.user.Group}.
	 * It is bidirectional and its opposite is '{@link org.odysseus.models.socialnetwork.user.Group#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Membership In Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Membership In Groups</em>' reference list.
	 * @see org.odysseus.models.socialnetwork.user.UserPackage#getPerson_MembershipInGroups()
	 * @see org.odysseus.models.socialnetwork.user.Group#getMembers
	 * @model opposite="members"
	 * @generated
	 */
	EList<Group> getMembershipInGroups();

} // Person
