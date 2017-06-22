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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.activity.Post;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.GroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.GroupImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.GroupImpl#getAdmin <em>Admin</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.GroupImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.user.impl.GroupImpl#getPosts <em>Posts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupImpl extends MinimalEObjectImpl.Container implements Group {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdmin() <em>Admin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdmin()
	 * @generated
	 * @ordered
	 */
	protected Person admin;

	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> members;

	/**
	 * The cached value of the '{@link #getPosts() <em>Posts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosts()
	 * @generated
	 * @ordered
	 */
	protected EList<Post> posts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UserPackage.Literals.GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.GROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.GROUP__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getAdmin() {
		if (admin != null && admin.eIsProxy()) {
			InternalEObject oldAdmin = (InternalEObject)admin;
			admin = (Person)eResolveProxy(oldAdmin);
			if (admin != oldAdmin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UserPackage.GROUP__ADMIN, oldAdmin, admin));
			}
		}
		return admin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetAdmin() {
		return admin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdmin(Person newAdmin) {
		Person oldAdmin = admin;
		admin = newAdmin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserPackage.GROUP__ADMIN, oldAdmin, admin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getMembers() {
		if (members == null) {
			members = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this, UserPackage.GROUP__MEMBERS, UserPackage.PERSON__MEMBERSHIP_IN_GROUPS);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Post> getPosts() {
		if (posts == null) {
			posts = new EObjectWithInverseResolvingEList<Post>(Post.class, this, UserPackage.GROUP__POSTS, ActivityPackage.POST__IN_GROUP);
		}
		return posts;
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
			case UserPackage.GROUP__MEMBERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMembers()).basicAdd(otherEnd, msgs);
			case UserPackage.GROUP__POSTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPosts()).basicAdd(otherEnd, msgs);
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
			case UserPackage.GROUP__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
			case UserPackage.GROUP__POSTS:
				return ((InternalEList<?>)getPosts()).basicRemove(otherEnd, msgs);
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
			case UserPackage.GROUP__NAME:
				return getName();
			case UserPackage.GROUP__CREATION_DATE:
				return getCreationDate();
			case UserPackage.GROUP__ADMIN:
				if (resolve) return getAdmin();
				return basicGetAdmin();
			case UserPackage.GROUP__MEMBERS:
				return getMembers();
			case UserPackage.GROUP__POSTS:
				return getPosts();
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
			case UserPackage.GROUP__NAME:
				setName((String)newValue);
				return;
			case UserPackage.GROUP__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case UserPackage.GROUP__ADMIN:
				setAdmin((Person)newValue);
				return;
			case UserPackage.GROUP__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends Person>)newValue);
				return;
			case UserPackage.GROUP__POSTS:
				getPosts().clear();
				getPosts().addAll((Collection<? extends Post>)newValue);
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
			case UserPackage.GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UserPackage.GROUP__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case UserPackage.GROUP__ADMIN:
				setAdmin((Person)null);
				return;
			case UserPackage.GROUP__MEMBERS:
				getMembers().clear();
				return;
			case UserPackage.GROUP__POSTS:
				getPosts().clear();
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
			case UserPackage.GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UserPackage.GROUP__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case UserPackage.GROUP__ADMIN:
				return admin != null;
			case UserPackage.GROUP__MEMBERS:
				return members != null && !members.isEmpty();
			case UserPackage.GROUP__POSTS:
				return posts != null && !posts.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(')');
		return result.toString();
	}

} //GroupImpl
