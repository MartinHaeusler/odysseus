/**
 */
package org.odysseus.models.socialnetwork.media;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.odysseus.models.socialnetwork.media.MediaData#getName <em>Name</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.media.MediaData#getType <em>Type</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.media.MediaData#getContent <em>Content</em>}</li>
 *   <li>{@link org.odysseus.models.socialnetwork.media.MediaData#getUploadDate <em>Upload Date</em>}</li>
 * </ul>
 *
 * @see org.odysseus.models.socialnetwork.media.MediaPackage#getMediaData()
 * @model
 * @generated
 */
public interface MediaData extends EObject {
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
	 * @see org.odysseus.models.socialnetwork.media.MediaPackage#getMediaData_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.media.MediaData#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"IMAGE"</code>.
	 * The literals are from the enumeration {@link org.odysseus.models.socialnetwork.media.MediaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.odysseus.models.socialnetwork.media.MediaType
	 * @see #setType(MediaType)
	 * @see org.odysseus.models.socialnetwork.media.MediaPackage#getMediaData_Type()
	 * @model default="IMAGE"
	 * @generated
	 */
	MediaType getType();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.media.MediaData#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.odysseus.models.socialnetwork.media.MediaType
	 * @see #getType()
	 * @generated
	 */
	void setType(MediaType value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(byte[])
	 * @see org.odysseus.models.socialnetwork.media.MediaPackage#getMediaData_Content()
	 * @model
	 * @generated
	 */
	byte[] getContent();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.media.MediaData#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(byte[] value);

	/**
	 * Returns the value of the '<em><b>Upload Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upload Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upload Date</em>' attribute.
	 * @see #setUploadDate(Date)
	 * @see org.odysseus.models.socialnetwork.media.MediaPackage#getMediaData_UploadDate()
	 * @model
	 * @generated
	 */
	Date getUploadDate();

	/**
	 * Sets the value of the '{@link org.odysseus.models.socialnetwork.media.MediaData#getUploadDate <em>Upload Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upload Date</em>' attribute.
	 * @see #getUploadDate()
	 * @generated
	 */
	void setUploadDate(Date value);

} // MediaData
