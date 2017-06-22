/**
 */
package org.odysseus.models.socialnetwork.activity.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.activity.Comment;
import org.odysseus.models.socialnetwork.activity.Post;
import org.odysseus.models.socialnetwork.activity.Reaction;
import org.odysseus.models.socialnetwork.activity.Visibility;
import org.odysseus.models.socialnetwork.media.MediaData;
import org.odysseus.models.socialnetwork.user.Group;
import org.odysseus.models.socialnetwork.user.Person;
import org.odysseus.models.socialnetwork.user.UserPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Post</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl#getIsRepostOf <em>Is Repost Of</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl#getAttachedMedia <em>Attached Media</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl#getMentions <em>Mentions</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl#getInGroup <em>In Group</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl#getComments <em>Comments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PostImpl extends ContributionImpl implements Post {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIsRepostOf() <em>Is Repost Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsRepostOf()
	 * @generated
	 * @ordered
	 */
	protected Post isRepostOf;

	/**
	 * The cached value of the '{@link #getAttachedMedia() <em>Attached Media</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachedMedia()
	 * @generated
	 * @ordered
	 */
	protected EList<MediaData> attachedMedia;

	/**
	 * The cached value of the '{@link #getMentions() <em>Mentions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMentions()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> mentions;

	/**
	 * The cached value of the '{@link #getInGroup() <em>In Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInGroup()
	 * @generated
	 * @ordered
	 */
	protected Group inGroup;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.EVERYONE;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Visibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReactions() <em>Reactions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactions()
	 * @generated
	 * @ordered
	 */
	protected EList<Reaction> reactions;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> comments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityPackage.Literals.POST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.POST__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Post getIsRepostOf() {
		if (isRepostOf != null && isRepostOf.eIsProxy()) {
			InternalEObject oldIsRepostOf = (InternalEObject)isRepostOf;
			isRepostOf = (Post)eResolveProxy(oldIsRepostOf);
			if (isRepostOf != oldIsRepostOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.POST__IS_REPOST_OF, oldIsRepostOf, isRepostOf));
			}
		}
		return isRepostOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Post basicGetIsRepostOf() {
		return isRepostOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRepostOf(Post newIsRepostOf) {
		Post oldIsRepostOf = isRepostOf;
		isRepostOf = newIsRepostOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.POST__IS_REPOST_OF, oldIsRepostOf, isRepostOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MediaData> getAttachedMedia() {
		if (attachedMedia == null) {
			attachedMedia = new EObjectResolvingEList<MediaData>(MediaData.class, this, ActivityPackage.POST__ATTACHED_MEDIA);
		}
		return attachedMedia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getMentions() {
		if (mentions == null) {
			mentions = new EObjectResolvingEList<Person>(Person.class, this, ActivityPackage.POST__MENTIONS);
		}
		return mentions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group getInGroup() {
		if (inGroup != null && inGroup.eIsProxy()) {
			InternalEObject oldInGroup = (InternalEObject)inGroup;
			inGroup = (Group)eResolveProxy(oldInGroup);
			if (inGroup != oldInGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.POST__IN_GROUP, oldInGroup, inGroup));
			}
		}
		return inGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group basicGetInGroup() {
		return inGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInGroup(Group newInGroup, NotificationChain msgs) {
		Group oldInGroup = inGroup;
		inGroup = newInGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActivityPackage.POST__IN_GROUP, oldInGroup, newInGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInGroup(Group newInGroup) {
		if (newInGroup != inGroup) {
			NotificationChain msgs = null;
			if (inGroup != null)
				msgs = ((InternalEObject)inGroup).eInverseRemove(this, UserPackage.GROUP__POSTS, Group.class, msgs);
			if (newInGroup != null)
				msgs = ((InternalEObject)newInGroup).eInverseAdd(this, UserPackage.GROUP__POSTS, Group.class, msgs);
			msgs = basicSetInGroup(newInGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.POST__IN_GROUP, newInGroup, newInGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.POST__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reaction> getReactions() {
		if (reactions == null) {
			reactions = new EObjectResolvingEList<Reaction>(Reaction.class, this, ActivityPackage.POST__REACTIONS);
		}
		return reactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectResolvingEList<Comment>(Comment.class, this, ActivityPackage.POST__COMMENTS);
		}
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivityPackage.POST__IN_GROUP:
				if (inGroup != null)
					msgs = ((InternalEObject)inGroup).eInverseRemove(this, UserPackage.GROUP__POSTS, Group.class, msgs);
				return basicSetInGroup((Group)otherEnd, msgs);
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
			case ActivityPackage.POST__IN_GROUP:
				return basicSetInGroup(null, msgs);
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
			case ActivityPackage.POST__TEXT:
				return getText();
			case ActivityPackage.POST__IS_REPOST_OF:
				if (resolve) return getIsRepostOf();
				return basicGetIsRepostOf();
			case ActivityPackage.POST__ATTACHED_MEDIA:
				return getAttachedMedia();
			case ActivityPackage.POST__MENTIONS:
				return getMentions();
			case ActivityPackage.POST__IN_GROUP:
				if (resolve) return getInGroup();
				return basicGetInGroup();
			case ActivityPackage.POST__VISIBILITY:
				return getVisibility();
			case ActivityPackage.POST__REACTIONS:
				return getReactions();
			case ActivityPackage.POST__COMMENTS:
				return getComments();
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
			case ActivityPackage.POST__TEXT:
				setText((String)newValue);
				return;
			case ActivityPackage.POST__IS_REPOST_OF:
				setIsRepostOf((Post)newValue);
				return;
			case ActivityPackage.POST__ATTACHED_MEDIA:
				getAttachedMedia().clear();
				getAttachedMedia().addAll((Collection<? extends MediaData>)newValue);
				return;
			case ActivityPackage.POST__MENTIONS:
				getMentions().clear();
				getMentions().addAll((Collection<? extends Person>)newValue);
				return;
			case ActivityPackage.POST__IN_GROUP:
				setInGroup((Group)newValue);
				return;
			case ActivityPackage.POST__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
			case ActivityPackage.POST__REACTIONS:
				getReactions().clear();
				getReactions().addAll((Collection<? extends Reaction>)newValue);
				return;
			case ActivityPackage.POST__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
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
			case ActivityPackage.POST__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case ActivityPackage.POST__IS_REPOST_OF:
				setIsRepostOf((Post)null);
				return;
			case ActivityPackage.POST__ATTACHED_MEDIA:
				getAttachedMedia().clear();
				return;
			case ActivityPackage.POST__MENTIONS:
				getMentions().clear();
				return;
			case ActivityPackage.POST__IN_GROUP:
				setInGroup((Group)null);
				return;
			case ActivityPackage.POST__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case ActivityPackage.POST__REACTIONS:
				getReactions().clear();
				return;
			case ActivityPackage.POST__COMMENTS:
				getComments().clear();
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
			case ActivityPackage.POST__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case ActivityPackage.POST__IS_REPOST_OF:
				return isRepostOf != null;
			case ActivityPackage.POST__ATTACHED_MEDIA:
				return attachedMedia != null && !attachedMedia.isEmpty();
			case ActivityPackage.POST__MENTIONS:
				return mentions != null && !mentions.isEmpty();
			case ActivityPackage.POST__IN_GROUP:
				return inGroup != null;
			case ActivityPackage.POST__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case ActivityPackage.POST__REACTIONS:
				return reactions != null && !reactions.isEmpty();
			case ActivityPackage.POST__COMMENTS:
				return comments != null && !comments.isEmpty();
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
		result.append(" (text: ");
		result.append(text);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //PostImpl
