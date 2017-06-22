/**
 */
package org.odysseus.models.socialnetwork.media.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.odysseus.models.socialnetwork.activity.ActivityPackage;
import org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl;
import org.odysseus.models.socialnetwork.media.MediaData;
import org.odysseus.models.socialnetwork.media.MediaFactory;
import org.odysseus.models.socialnetwork.media.MediaPackage;
import org.odysseus.models.socialnetwork.media.MediaType;
import org.odysseus.models.socialnetwork.user.UserPackage;
import org.odysseus.models.socialnetwork.user.impl.UserPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MediaPackageImpl extends EPackageImpl implements MediaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mediaTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.odysseus.models.socialnetwork.media.MediaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MediaPackageImpl() {
		super(eNS_URI, MediaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MediaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MediaPackage init() {
		if (isInited) return (MediaPackage)EPackage.Registry.INSTANCE.getEPackage(MediaPackage.eNS_URI);

		// Obtain or create and register package
		MediaPackageImpl theMediaPackage = (MediaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MediaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MediaPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ActivityPackageImpl theActivityPackage = (ActivityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI) instanceof ActivityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI) : ActivityPackage.eINSTANCE);
		UserPackageImpl theUserPackage = (UserPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UserPackage.eNS_URI) instanceof UserPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UserPackage.eNS_URI) : UserPackage.eINSTANCE);

		// Create package meta-data objects
		theMediaPackage.createPackageContents();
		theActivityPackage.createPackageContents();
		theUserPackage.createPackageContents();

		// Initialize created meta-data
		theMediaPackage.initializePackageContents();
		theActivityPackage.initializePackageContents();
		theUserPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMediaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MediaPackage.eNS_URI, theMediaPackage);
		return theMediaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediaData() {
		return mediaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaData_Name() {
		return (EAttribute)mediaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaData_Type() {
		return (EAttribute)mediaDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaData_Content() {
		return (EAttribute)mediaDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaData_UploadDate() {
		return (EAttribute)mediaDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMediaType() {
		return mediaTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaFactory getMediaFactory() {
		return (MediaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mediaDataEClass = createEClass(MEDIA_DATA);
		createEAttribute(mediaDataEClass, MEDIA_DATA__NAME);
		createEAttribute(mediaDataEClass, MEDIA_DATA__TYPE);
		createEAttribute(mediaDataEClass, MEDIA_DATA__CONTENT);
		createEAttribute(mediaDataEClass, MEDIA_DATA__UPLOAD_DATE);

		// Create enums
		mediaTypeEEnum = createEEnum(MEDIA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(mediaDataEClass, MediaData.class, "MediaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediaData_Name(), ecorePackage.getEString(), "name", null, 0, 1, MediaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaData_Type(), this.getMediaType(), "type", "IMAGE", 0, 1, MediaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaData_Content(), ecorePackage.getEByteArray(), "content", null, 0, 1, MediaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaData_UploadDate(), ecorePackage.getEDate(), "uploadDate", null, 0, 1, MediaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(mediaTypeEEnum, MediaType.class, "MediaType");
		addEEnumLiteral(mediaTypeEEnum, MediaType.IMAGE);
		addEEnumLiteral(mediaTypeEEnum, MediaType.VIDEO);
		addEEnumLiteral(mediaTypeEEnum, MediaType.AUDIO);

		// Create resource
		createResource(eNS_URI);
	}

} //MediaPackageImpl
