/**
 */
package org.odysseus.models.socialnetwork.activity.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.activity.Post;
import org.odysseus.models.socialnetwork.activity.Response;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.ResponseImpl#getPost <em>Post</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResponseImpl extends ContributionImpl implements Response {
	/**
	 * The cached value of the '{@link #getPost() <em>Post</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPost()
	 * @generated
	 * @ordered
	 */
	protected Post post;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityPackage.Literals.RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Post getPost() {
		if (post != null && post.eIsProxy()) {
			InternalEObject oldPost = (InternalEObject)post;
			post = (Post)eResolveProxy(oldPost);
			if (post != oldPost) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.RESPONSE__POST, oldPost, post));
			}
		}
		return post;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Post basicGetPost() {
		return post;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPost(Post newPost) {
		Post oldPost = post;
		post = newPost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.RESPONSE__POST, oldPost, post));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityPackage.RESPONSE__POST:
				if (resolve) return getPost();
				return basicGetPost();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActivityPackage.RESPONSE__POST:
				setPost((Post)newValue);
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
			case ActivityPackage.RESPONSE__POST:
				setPost((Post)null);
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
			case ActivityPackage.RESPONSE__POST:
				return post != null;
		}
		return super.eIsSet(featureID);
	}

} //ResponseImpl
