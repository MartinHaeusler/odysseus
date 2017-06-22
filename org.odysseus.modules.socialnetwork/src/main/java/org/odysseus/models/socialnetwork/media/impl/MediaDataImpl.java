/**
 */
package org.odysseus.models.socialnetwork.media.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.odysseus.models.socialnetwork.media.MediaData;
import org.odysseus.models.socialnetwork.media.MediaPackage;
import org.odysseus.models.socialnetwork.media.MediaType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.media.impl.MediaDataImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.media.impl.MediaDataImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.media.impl.MediaDataImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.media.impl.MediaDataImpl#getUploadDate <em>Upload Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MediaDataImpl extends MinimalEObjectImpl.Container implements MediaData {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final MediaType TYPE_EDEFAULT = MediaType.IMAGE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected MediaType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected byte[] content = CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUploadDate() <em>Upload Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUploadDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date UPLOAD_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUploadDate() <em>Upload Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUploadDate()
	 * @generated
	 * @ordered
	 */
	protected Date uploadDate = UPLOAD_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MediaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MediaPackage.Literals.MEDIA_DATA;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediaPackage.MEDIA_DATA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(MediaType newType) {
		MediaType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediaPackage.MEDIA_DATA__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(byte[] newContent) {
		byte[] oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediaPackage.MEDIA_DATA__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUploadDate(Date newUploadDate) {
		Date oldUploadDate = uploadDate;
		uploadDate = newUploadDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediaPackage.MEDIA_DATA__UPLOAD_DATE, oldUploadDate, uploadDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediaPackage.MEDIA_DATA__NAME:
				return getName();
			case MediaPackage.MEDIA_DATA__TYPE:
				return getType();
			case MediaPackage.MEDIA_DATA__CONTENT:
				return getContent();
			case MediaPackage.MEDIA_DATA__UPLOAD_DATE:
				return getUploadDate();
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
			case MediaPackage.MEDIA_DATA__NAME:
				setName((String)newValue);
				return;
			case MediaPackage.MEDIA_DATA__TYPE:
				setType((MediaType)newValue);
				return;
			case MediaPackage.MEDIA_DATA__CONTENT:
				setContent((byte[])newValue);
				return;
			case MediaPackage.MEDIA_DATA__UPLOAD_DATE:
				setUploadDate((Date)newValue);
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
			case MediaPackage.MEDIA_DATA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MediaPackage.MEDIA_DATA__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MediaPackage.MEDIA_DATA__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case MediaPackage.MEDIA_DATA__UPLOAD_DATE:
				setUploadDate(UPLOAD_DATE_EDEFAULT);
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
			case MediaPackage.MEDIA_DATA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MediaPackage.MEDIA_DATA__TYPE:
				return type != TYPE_EDEFAULT;
			case MediaPackage.MEDIA_DATA__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case MediaPackage.MEDIA_DATA__UPLOAD_DATE:
				return UPLOAD_DATE_EDEFAULT == null ? uploadDate != null : !UPLOAD_DATE_EDEFAULT.equals(uploadDate);
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
		result.append(", type: ");
		result.append(type);
		result.append(", content: ");
		result.append(content);
		result.append(", uploadDate: ");
		result.append(uploadDate);
		result.append(')');
		return result.toString();
	}

} //MediaDataImpl
