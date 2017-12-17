/**
 */
package org.odysseus.modules.itlandscape.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.odysseus.modules.itlandscape.Application;
import org.odysseus.modules.itlandscape.Cluster;
import org.odysseus.modules.itlandscape.Database;
import org.odysseus.modules.itlandscape.Element;
import org.odysseus.modules.itlandscape.Host;
import org.odysseus.modules.itlandscape.ItlandscapeFactory;
import org.odysseus.modules.itlandscape.ItlandscapePackage;
import org.odysseus.modules.itlandscape.PhysicalMachine;
import org.odysseus.modules.itlandscape.Service;
import org.odysseus.modules.itlandscape.ServiceLevelAgreement;
import org.odysseus.modules.itlandscape.Storage;
import org.odysseus.modules.itlandscape.VirtualHost;
import org.odysseus.modules.itlandscape.VirtualMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ItlandscapePackageImpl extends EPackageImpl implements ItlandscapePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clusterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualHostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum serviceLevelAgreementEEnum = null;

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
	 * @see org.odysseus.modules.itlandscape.ItlandscapePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ItlandscapePackageImpl() {
		super(eNS_URI, ItlandscapeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ItlandscapePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ItlandscapePackage init() {
		if (isInited)
			return (ItlandscapePackage) EPackage.Registry.INSTANCE.getEPackage(ItlandscapePackage.eNS_URI);

		// Obtain or create and register package
		ItlandscapePackageImpl theItlandscapePackage = (ItlandscapePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ItlandscapePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new ItlandscapePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theItlandscapePackage.createPackageContents();

		// Initialize created meta-data
		theItlandscapePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theItlandscapePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ItlandscapePackage.eNS_URI, theItlandscapePackage);
		return theItlandscapePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStorage() {
		return storageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStorage_Capacity() {
		return (EAttribute) storageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhysicalMachine() {
		return physicalMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalMachine_Uses() {
		return (EReference) physicalMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalMachine_CpuCores() {
		return (EAttribute) physicalMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalMachine_ClockRateGhz() {
		return (EAttribute) physicalMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalMachine_RamGB() {
		return (EAttribute) physicalMachineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCluster() {
		return clusterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCluster_HighAvailability() {
		return (EAttribute) clusterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCluster_LoadBalancing() {
		return (EAttribute) clusterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualMachine() {
		return virtualMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualMachine_CpuCores() {
		return (EAttribute) virtualMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualMachine_RamGB() {
		return (EAttribute) virtualMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualMachine_ClockRateGhz() {
		return (EAttribute) virtualMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplication() {
		return applicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_RunsOn() {
		return (EReference) applicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_Accesses() {
		return (EReference) applicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_DependsOn() {
		return (EReference) applicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_DependsOn() {
		return (EReference) serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabase() {
		return databaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDatabase_RunsOn() {
		return (EReference) databaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHost() {
		return hostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHost_Ip() {
		return (EAttribute) hostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHost_OperatingSystem() {
		return (EAttribute) hostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualHost() {
		return virtualHostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualHost_RunsOn() {
		return (EReference) virtualHostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Name() {
		return (EAttribute) elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Description() {
		return (EAttribute) elementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Sla() {
		return (EAttribute) elementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServiceLevelAgreement() {
		return serviceLevelAgreementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItlandscapeFactory getItlandscapeFactory() {
		return (ItlandscapeFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		storageEClass = createEClass(STORAGE);
		createEAttribute(storageEClass, STORAGE__CAPACITY);

		physicalMachineEClass = createEClass(PHYSICAL_MACHINE);
		createEReference(physicalMachineEClass, PHYSICAL_MACHINE__USES);
		createEAttribute(physicalMachineEClass, PHYSICAL_MACHINE__CPU_CORES);
		createEAttribute(physicalMachineEClass, PHYSICAL_MACHINE__CLOCK_RATE_GHZ);
		createEAttribute(physicalMachineEClass, PHYSICAL_MACHINE__RAM_GB);

		clusterEClass = createEClass(CLUSTER);
		createEAttribute(clusterEClass, CLUSTER__HIGH_AVAILABILITY);
		createEAttribute(clusterEClass, CLUSTER__LOAD_BALANCING);

		virtualMachineEClass = createEClass(VIRTUAL_MACHINE);
		createEAttribute(virtualMachineEClass, VIRTUAL_MACHINE__CPU_CORES);
		createEAttribute(virtualMachineEClass, VIRTUAL_MACHINE__RAM_GB);
		createEAttribute(virtualMachineEClass, VIRTUAL_MACHINE__CLOCK_RATE_GHZ);

		applicationEClass = createEClass(APPLICATION);
		createEReference(applicationEClass, APPLICATION__RUNS_ON);
		createEReference(applicationEClass, APPLICATION__ACCESSES);
		createEReference(applicationEClass, APPLICATION__DEPENDS_ON);

		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__DEPENDS_ON);

		databaseEClass = createEClass(DATABASE);
		createEReference(databaseEClass, DATABASE__RUNS_ON);

		hostEClass = createEClass(HOST);
		createEAttribute(hostEClass, HOST__IP);
		createEAttribute(hostEClass, HOST__OPERATING_SYSTEM);

		virtualHostEClass = createEClass(VIRTUAL_HOST);
		createEReference(virtualHostEClass, VIRTUAL_HOST__RUNS_ON);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__NAME);
		createEAttribute(elementEClass, ELEMENT__DESCRIPTION);
		createEAttribute(elementEClass, ELEMENT__SLA);

		// Create enums
		serviceLevelAgreementEEnum = createEEnum(SERVICE_LEVEL_AGREEMENT);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		storageEClass.getESuperTypes().add(this.getElement());
		physicalMachineEClass.getESuperTypes().add(this.getHost());
		clusterEClass.getESuperTypes().add(this.getVirtualHost());
		virtualMachineEClass.getESuperTypes().add(this.getVirtualHost());
		applicationEClass.getESuperTypes().add(this.getElement());
		serviceEClass.getESuperTypes().add(this.getElement());
		databaseEClass.getESuperTypes().add(this.getElement());
		hostEClass.getESuperTypes().add(this.getElement());
		virtualHostEClass.getESuperTypes().add(this.getHost());

		// Initialize classes, features, and operations; add parameters
		initEClass(storageEClass, Storage.class, "Storage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStorage_Capacity(), ecorePackage.getEInt(), "capacity", null, 0, 1, Storage.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(physicalMachineEClass, PhysicalMachine.class, "PhysicalMachine", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPhysicalMachine_Uses(), this.getStorage(), null, "uses", null, 0, -1, PhysicalMachine.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPhysicalMachine_CpuCores(), ecorePackage.getEInt(), "cpuCores", "1", 0, 1,
				PhysicalMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalMachine_ClockRateGhz(), ecorePackage.getEFloat(), "clockRateGhz", null, 0, 1,
				PhysicalMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalMachine_RamGB(), ecorePackage.getEInt(), "ramGB", "0", 0, 1, PhysicalMachine.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clusterEClass, Cluster.class, "Cluster", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCluster_HighAvailability(), ecorePackage.getEBoolean(), "highAvailability", null, 0, 1,
				Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getCluster_LoadBalancing(), ecorePackage.getEBoolean(), "loadBalancing", "false", 0, 1,
				Cluster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(virtualMachineEClass, VirtualMachine.class, "VirtualMachine", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVirtualMachine_CpuCores(), ecorePackage.getEInt(), "cpuCores", "4", 0, 1,
				VirtualMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getVirtualMachine_RamGB(), ecorePackage.getEInt(), "ramGB", "0", 0, 1, VirtualMachine.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVirtualMachine_ClockRateGhz(), ecorePackage.getEFloat(), "clockRateGhz", "0.0", 0, 1,
				VirtualMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplication_RunsOn(), this.getHost(), null, "runsOn", null, 0, -1, Application.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getApplication_Accesses(), this.getDatabase(), null, "accesses", null, 0, -1, Application.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getApplication_DependsOn(), this.getApplication(), null, "dependsOn", null, 0, -1,
				Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_DependsOn(), this.getApplication(), null, "dependsOn", null, 0, -1, Service.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(databaseEClass, Database.class, "Database", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDatabase_RunsOn(), this.getHost(), null, "runsOn", null, 0, -1, Database.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);

		initEClass(hostEClass, Host.class, "Host", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHost_Ip(), ecorePackage.getEString(), "ip", null, 0, 1, Host.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHost_OperatingSystem(), ecorePackage.getEString(), "operatingSystem", null, 0, 1, Host.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualHostEClass, VirtualHost.class, "VirtualHost", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVirtualHost_RunsOn(), this.getHost(), null, "runsOn", null, 0, -1, VirtualHost.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, Element.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, Element.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_Sla(), this.getServiceLevelAgreement(), "sla", null, 0, 1, Element.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(serviceLevelAgreementEEnum, ServiceLevelAgreement.class, "ServiceLevelAgreement");
		addEEnumLiteral(serviceLevelAgreementEEnum, ServiceLevelAgreement.BEST_EFFORT);
		addEEnumLiteral(serviceLevelAgreementEEnum, ServiceLevelAgreement.BRONZE);
		addEEnumLiteral(serviceLevelAgreementEEnum, ServiceLevelAgreement.SILVER);
		addEEnumLiteral(serviceLevelAgreementEEnum, ServiceLevelAgreement.GOLD);

		// Create resource
		createResource(eNS_URI);
	}

} //ItlandscapePackageImpl
