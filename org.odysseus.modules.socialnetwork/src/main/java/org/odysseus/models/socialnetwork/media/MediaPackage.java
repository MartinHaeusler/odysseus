/**
 */
package org.odysseus.models.socialnetwork.media;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.odysseus.models.socialnetwork.media.MediaFactory
 * @model kind="package"
 * @generated
 */
public interface MediaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "media";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.odysseus.socialnetwork.media";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "media";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MediaPackage eINSTANCE = org.odysseus.models.socialnetwork.media.impl.MediaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.media.impl.MediaDataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.media.impl.MediaDataImpl
	 * @see org.odysseus.models.socialnetwork.media.impl.MediaPackageImpl#getMediaData()
	 * @generated
	 */
	int MEDIA_DATA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_DATA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_DATA__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_DATA__CONTENT = 2;

	/**
	 * The feature id for the '<em><b>Upload Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_DATA__UPLOAD_DATE = 3;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_DATA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.media.MediaType <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.media.MediaType
	 * @see org.odysseus.models.socialnetwork.media.impl.MediaPackageImpl#getMediaType()
	 * @generated
	 */
	int MEDIA_TYPE = 1;


	/**
	 * Returns the meta object for class '{@link org.odysseus.models.socialnetwork.media.MediaData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see org.odysseus.models.socialnetwork.media.MediaData
	 * @generated
	 */
	EClass getMediaData();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.media.MediaData#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.odysseus.models.socialnetwork.media.MediaData#getName()
	 * @see #getMediaData()
	 * @generated
	 */
	EAttribute getMediaData_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.media.MediaData#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.odysseus.models.socialnetwork.media.MediaData#getType()
	 * @see #getMediaData()
	 * @generated
	 */
	EAttribute getMediaData_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.media.MediaData#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.odysseus.models.socialnetwork.media.MediaData#getContent()
	 * @see #getMediaData()
	 * @generated
	 */
	EAttribute getMediaData_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.media.MediaData#getUploadDate <em>Upload Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upload Date</em>'.
	 * @see org.odysseus.models.socialnetwork.media.MediaData#getUploadDate()
	 * @see #getMediaData()
	 * @generated
	 */
	EAttribute getMediaData_UploadDate();

	/**
	 * Returns the meta object for enum '{@link org.odysseus.models.socialnetwork.media.MediaType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.odysseus.models.socialnetwork.media.MediaType
	 * @generated
	 */
	EEnum getMediaType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MediaFactory getMediaFactory();

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
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.media.impl.MediaDataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.media.impl.MediaDataImpl
		 * @see org.odysseus.models.socialnetwork.media.impl.MediaPackageImpl#getMediaData()
		 * @generated
		 */
		EClass MEDIA_DATA = eINSTANCE.getMediaData();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_DATA__NAME = eINSTANCE.getMediaData_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_DATA__TYPE = eINSTANCE.getMediaData_Type();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_DATA__CONTENT = eINSTANCE.getMediaData_Content();

		/**
		 * The meta object literal for the '<em><b>Upload Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_DATA__UPLOAD_DATE = eINSTANCE.getMediaData_UploadDate();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.media.MediaType <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.media.MediaType
		 * @see org.odysseus.models.socialnetwork.media.impl.MediaPackageImpl#getMediaType()
		 * @generated
		 */
		EEnum MEDIA_TYPE = eINSTANCE.getMediaType();

	}

} //MediaPackage
