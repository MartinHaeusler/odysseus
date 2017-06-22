/**
 */
package org.odysseus.models.socialnetwork.user;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.odysseus.models.socialnetwork.user.UserFactory
 * @model kind="package"
 * @generated
 */
public interface UserPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "user";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.odysseus.socialnetwork.user";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "user";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UserPackage eINSTANCE = org.odysseus.models.socialnetwork.user.impl.UserPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.user.impl.PersonImpl
	 * @see org.odysseus.models.socialnetwork.user.impl.UserPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 0;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__GENDER = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LAST_NAME = 2;

	/**
	 * The feature id for the '<em><b>Birthdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__BIRTHDATE = 3;

	/**
	 * The feature id for the '<em><b>Member Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__MEMBER_SINCE = 4;

	/**
	 * The feature id for the '<em><b>Married To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__MARRIED_TO = 5;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__CHILDREN = 6;

	/**
	 * The feature id for the '<em><b>Profile Picture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PROFILE_PICTURE = 7;

	/**
	 * The feature id for the '<em><b>Friends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FRIENDS = 8;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PARENTS = 9;

	/**
	 * The feature id for the '<em><b>Membership In Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__MEMBERSHIP_IN_GROUPS = 10;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.user.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.user.impl.GroupImpl
	 * @see org.odysseus.models.socialnetwork.user.impl.UserPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__CREATION_DATE = 1;

	/**
	 * The feature id for the '<em><b>Admin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ADMIN = 2;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__MEMBERS = 3;

	/**
	 * The feature id for the '<em><b>Posts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__POSTS = 4;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.user.Gender <em>Gender</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.user.Gender
	 * @see org.odysseus.models.socialnetwork.user.impl.UserPackageImpl#getGender()
	 * @generated
	 */
	int GENDER = 2;


	/**
	 * Returns the meta object for class '{@link org.odysseus.models.socialnetwork.user.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.user.Person#getGender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gender</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getGender()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Gender();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.user.Person#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getFirstName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.user.Person#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getLastName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_LastName();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.user.Person#getBirthdate <em>Birthdate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Birthdate</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getBirthdate()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Birthdate();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.user.Person#getMemberSince <em>Member Since</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Since</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getMemberSince()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_MemberSince();

	/**
	 * Returns the meta object for the reference '{@link org.odysseus.models.socialnetwork.user.Person#getMarriedTo <em>Married To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Married To</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getMarriedTo()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_MarriedTo();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.user.Person#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getChildren()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Children();

	/**
	 * Returns the meta object for the reference '{@link org.odysseus.models.socialnetwork.user.Person#getProfilePicture <em>Profile Picture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Profile Picture</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getProfilePicture()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_ProfilePicture();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.user.Person#getFriends <em>Friends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Friends</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getFriends()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Friends();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.user.Person#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parents</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getParents()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Parents();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.user.Person#getMembershipInGroups <em>Membership In Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Membership In Groups</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Person#getMembershipInGroups()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_MembershipInGroups();

	/**
	 * Returns the meta object for class '{@link org.odysseus.models.socialnetwork.user.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.user.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.user.Group#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Group#getCreationDate()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_CreationDate();

	/**
	 * Returns the meta object for the reference '{@link org.odysseus.models.socialnetwork.user.Group#getAdmin <em>Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Admin</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Group#getAdmin()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Admin();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.user.Group#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Group#getMembers()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Members();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.user.Group#getPosts <em>Posts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Posts</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Group#getPosts()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Posts();

	/**
	 * Returns the meta object for enum '{@link org.odysseus.models.socialnetwork.user.Gender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gender</em>'.
	 * @see org.odysseus.models.socialnetwork.user.Gender
	 * @generated
	 */
	EEnum getGender();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UserFactory getUserFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.user.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.user.impl.PersonImpl
		 * @see org.odysseus.models.socialnetwork.user.impl.UserPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Gender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__GENDER = eINSTANCE.getPerson_Gender();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRST_NAME = eINSTANCE.getPerson_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LAST_NAME = eINSTANCE.getPerson_LastName();

		/**
		 * The meta object literal for the '<em><b>Birthdate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__BIRTHDATE = eINSTANCE.getPerson_Birthdate();

		/**
		 * The meta object literal for the '<em><b>Member Since</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__MEMBER_SINCE = eINSTANCE.getPerson_MemberSince();

		/**
		 * The meta object literal for the '<em><b>Married To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__MARRIED_TO = eINSTANCE.getPerson_MarriedTo();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__CHILDREN = eINSTANCE.getPerson_Children();

		/**
		 * The meta object literal for the '<em><b>Profile Picture</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__PROFILE_PICTURE = eINSTANCE.getPerson_ProfilePicture();

		/**
		 * The meta object literal for the '<em><b>Friends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__FRIENDS = eINSTANCE.getPerson_Friends();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__PARENTS = eINSTANCE.getPerson_Parents();

		/**
		 * The meta object literal for the '<em><b>Membership In Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__MEMBERSHIP_IN_GROUPS = eINSTANCE.getPerson_MembershipInGroups();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.user.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.user.impl.GroupImpl
		 * @see org.odysseus.models.socialnetwork.user.impl.UserPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__CREATION_DATE = eINSTANCE.getGroup_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Admin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__ADMIN = eINSTANCE.getGroup_Admin();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__MEMBERS = eINSTANCE.getGroup_Members();

		/**
		 * The meta object literal for the '<em><b>Posts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__POSTS = eINSTANCE.getGroup_Posts();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.user.Gender <em>Gender</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.user.Gender
		 * @see org.odysseus.models.socialnetwork.user.impl.UserPackageImpl#getGender()
		 * @generated
		 */
		EEnum GENDER = eINSTANCE.getGender();

	}

} //UserPackage
