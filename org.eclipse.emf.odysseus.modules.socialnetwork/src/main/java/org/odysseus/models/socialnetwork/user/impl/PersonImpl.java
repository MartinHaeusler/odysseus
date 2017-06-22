/**
 */
package org.odysseus.models.socialnetwork.user.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.odysseus.models.socialnetwork.media.MediaData;
import org.odysseus.models.socialnetwork.user.Gender;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getGender <em>Gender</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getBirthdate <em>Birthdate</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getMemberSince <em>Member Since</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getMarriedTo <em>Married To</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getProfilePicture <em>Profile Picture</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getFriends <em>Friends</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl#getMembershipInGroups <em>Membership In Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonImpl extends MinimalEObjectImpl.Container implements Person {
	/**
	 * The default value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected static final Gender GENDER_EDEFAULT = Gender.MALE;

	/**
	 * The cached value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected Gender gender = GENDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected String lastName = LAST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBirthdate() <em>Birthdate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthdate()
	 * @generated
	 * @ordered
	 */
	protected static final Date BIRTHDATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthdate() <em>Birthdate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthdate()
	 * @generated
	 * @ordered
	 */
	protected Date birthdate = BIRTHDATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemberSince() <em>Member Since</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberSince()
	 * @generated
	 * @ordered
	 */
	protected static final Date MEMBER_SINCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemberSince() <em>Member Since</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberSince()
	 * @generated
	 * @ordered
	 */
	protected Date memberSince = MEMBER_SINCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMarriedTo() <em>Married To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarriedTo()
	 * @generated
	 * @ordered
	 */
	protected Person marriedTo;

	/**
	 * This is true if the Married To reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean marriedToESet;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> children;

	/**
	 * The cached value of the '{@link #getProfilePicture() <em>Profile Picture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfilePicture()
	 * @generated
	 * @ordered
	 */
	protected MediaData profilePicture;

	/**
	 * The cached value of the '{@link #getFriends() <em>Friends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFriends()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> friends;

	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> parents;

	/**
	 * The cached value of the '{@link #getMembershipInGroups() <em>Membership In Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembershipInGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<Group> membershipInGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UserPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGender(Gender newGender) {
		Gender oldGender = gender;
		gender = newGender == null ? GENDER_EDEFAULT : newGender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.PERSON__GENDER, oldGender, gender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.PERSON__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastName(String newLastName) {
		String oldLastName = lastName;
		lastName = newLastName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.PERSON__LAST_NAME, oldLastName, lastName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBirthdate(Date newBirthdate) {
		Date oldBirthdate = birthdate;
		birthdate = newBirthdate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.PERSON__BIRTHDATE, oldBirthdate, birthdate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getMemberSince() {
		return memberSince;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberSince(Date newMemberSince) {
		Date oldMemberSince = memberSince;
		memberSince = newMemberSince;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.PERSON__MEMBER_SINCE, oldMemberSince, memberSince));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getMarriedTo() {
		if (marriedTo != null && marriedTo.eIsProxy()) {
			InternalEObject oldMarriedTo = (InternalEObject)marriedTo;
			marriedTo = (Person)eResolveProxy(oldMarriedTo);
			if (marriedTo != oldMarriedTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UserPackage.PERSON__MARRIED_TO, oldMarriedTo, marriedTo));
			}
		}
		return marriedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetMarriedTo() {
		return marriedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarriedTo(Person newMarriedTo) {
		Person oldMarriedTo = marriedTo;
		marriedTo = newMarriedTo;
		boolean oldMarriedToESet = marriedToESet;
		marriedToESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.PERSON__MARRIED_TO, oldMarriedTo, marriedTo, !oldMarriedToESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMarriedTo() {
		Person oldMarriedTo = marriedTo;
		boolean oldMarriedToESet = marriedToESet;
		marriedTo = null;
		marriedToESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, UserPackage.PERSON__MARRIED_TO, oldMarriedTo, null, oldMarriedToESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMarriedTo() {
		return marriedToESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this, UserPackage.PERSON__CHILDREN, UserPackage.PERSON__PARENTS);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaData getProfilePicture() {
		if (profilePicture != null && profilePicture.eIsProxy()) {
			InternalEObject oldProfilePicture = (InternalEObject)profilePicture;
			profilePicture = (MediaData)eResolveProxy(oldProfilePicture);
			if (profilePicture != oldProfilePicture) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UserPackage.PERSON__PROFILE_PICTURE, oldProfilePicture, profilePicture));
			}
		}
		return profilePicture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaData basicGetProfilePicture() {
		return profilePicture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfilePicture(MediaData newProfilePicture) {
		MediaData oldProfilePicture = profilePicture;
		profilePicture = newProfilePicture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.PERSON__PROFILE_PICTURE, oldProfilePicture, profilePicture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getFriends() {
		if (friends == null) {
			friends = new EObjectResolvingEList<Person>(Person.class, this, UserPackage.PERSON__FRIENDS);
		}
		return friends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getParents() {
		if (parents == null) {
			parents = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this, UserPackage.PERSON__PARENTS, UserPackage.PERSON__CHILDREN);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Group> getMembershipInGroups() {
		if (membershipInGroups == null) {
			membershipInGroups = new EObjectWithInverseResolvingEList.ManyInverse<Group>(Group.class, this, UserPackage.PERSON__MEMBERSHIP_IN_GROUPS, UserPackage.GROUP__MEMBERS);
		}
		return membershipInGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UserPackage.PERSON__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case UserPackage.PERSON__PARENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParents()).basicAdd(otherEnd, msgs);
			case UserPackage.PERSON__MEMBERSHIP_IN_GROUPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMembershipInGroups()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UserPackage.PERSON__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case UserPackage.PERSON__PARENTS:
				return ((InternalEList<?>)getParents()).basicRemove(otherEnd, msgs);
			case UserPackage.PERSON__MEMBERSHIP_IN_GROUPS:
				return ((InternalEList<?>)getMembershipInGroups()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UserPackage.PERSON__GENDER:
				return getGender();
			case UserPackage.PERSON__FIRST_NAME:
				return getFirstName();
			case UserPackage.PERSON__LAST_NAME:
				return getLastName();
			case UserPackage.PERSON__BIRTHDATE:
				return getBirthdate();
			case UserPackage.PERSON__MEMBER_SINCE:
				return getMemberSince();
			case UserPackage.PERSON__MARRIED_TO:
				if (resolve) return getMarriedTo();
				return basicGetMarriedTo();
			case UserPackage.PERSON__CHILDREN:
				return getChildren();
			case UserPackage.PERSON__PROFILE_PICTURE:
				if (resolve) return getProfilePicture();
				return basicGetProfilePicture();
			case UserPackage.PERSON__FRIENDS:
				return getFriends();
			case UserPackage.PERSON__PARENTS:
				return getParents();
			case UserPackage.PERSON__MEMBERSHIP_IN_GROUPS:
				return getMembershipInGroups();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UserPackage.PERSON__GENDER:
				setGender((Gender)newValue);
				return;
			case UserPackage.PERSON__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case UserPackage.PERSON__LAST_NAME:
				setLastName((String)newValue);
				return;
			case UserPackage.PERSON__BIRTHDATE:
				setBirthdate((Date)newValue);
				return;
			case UserPackage.PERSON__MEMBER_SINCE:
				setMemberSince((Date)newValue);
				return;
			case UserPackage.PERSON__MARRIED_TO:
				setMarriedTo((Person)newValue);
				return;
			case UserPackage.PERSON__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Person>)newValue);
				return;
			case UserPackage.PERSON__PROFILE_PICTURE:
				setProfilePicture((MediaData)newValue);
				return;
			case UserPackage.PERSON__FRIENDS:
				getFriends().clear();
				getFriends().addAll((Collection<? extends Person>)newValue);
				return;
			case UserPackage.PERSON__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends Person>)newValue);
				return;
			case UserPackage.PERSON__MEMBERSHIP_IN_GROUPS:
				getMembershipInGroups().clear();
				getMembershipInGroups().addAll((Collection<? extends Group>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UserPackage.PERSON__GENDER:
				setGender(GENDER_EDEFAULT);
				return;
			case UserPackage.PERSON__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case UserPackage.PERSON__LAST_NAME:
				setLastName(LAST_NAME_EDEFAULT);
				return;
			case UserPackage.PERSON__BIRTHDATE:
				setBirthdate(BIRTHDATE_EDEFAULT);
				return;
			case UserPackage.PERSON__MEMBER_SINCE:
				setMemberSince(MEMBER_SINCE_EDEFAULT);
				return;
			case UserPackage.PERSON__MARRIED_TO:
				unsetMarriedTo();
				return;
			case UserPackage.PERSON__CHILDREN:
				getChildren().clear();
				return;
			case UserPackage.PERSON__PROFILE_PICTURE:
				setProfilePicture((MediaData)null);
				return;
			case UserPackage.PERSON__FRIENDS:
				getFriends().clear();
				return;
			case UserPackage.PERSON__PARENTS:
				getParents().clear();
				return;
			case UserPackage.PERSON__MEMBERSHIP_IN_GROUPS:
				getMembershipInGroups().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UserPackage.PERSON__GENDER:
				return gender != GENDER_EDEFAULT;
			case UserPackage.PERSON__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case UserPackage.PERSON__LAST_NAME:
				return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
			case UserPackage.PERSON__BIRTHDATE:
				return BIRTHDATE_EDEFAULT == null ? birthdate != null : !BIRTHDATE_EDEFAULT.equals(birthdate);
			case UserPackage.PERSON__MEMBER_SINCE:
				return MEMBER_SINCE_EDEFAULT == null ? memberSince != null : !MEMBER_SINCE_EDEFAULT.equals(memberSince);
			case UserPackage.PERSON__MARRIED_TO:
				return isSetMarriedTo();
			case UserPackage.PERSON__CHILDREN:
				return children != null && !children.isEmpty();
			case UserPackage.PERSON__PROFILE_PICTURE:
				return profilePicture != null;
			case UserPackage.PERSON__FRIENDS:
				return friends != null && !friends.isEmpty();
			case UserPackage.PERSON__PARENTS:
				return parents != null && !parents.isEmpty();
			case UserPackage.PERSON__MEMBERSHIP_IN_GROUPS:
				return membershipInGroups != null && !membershipInGroups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (gender: ");
		result.append(gender);
		result.append(", firstName: ");
		result.append(firstName);
		result.append(", lastName: ");
		result.append(lastName);
		result.append(", birthdate: ");
		result.append(birthdate);
		result.append(", memberSince: ");
		result.append(memberSince);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
