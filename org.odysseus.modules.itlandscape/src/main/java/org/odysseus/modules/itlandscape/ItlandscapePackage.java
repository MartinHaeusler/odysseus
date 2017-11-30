/**
 */
package org.odysseus.modules.itlandscape;

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
 * @see org.odysseus.modules.itlandscape.ItlandscapeFactory
 * @model kind="package"
 * @generated
 */
public interface ItlandscapePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "itlandscape";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/itlandscape";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "itlandscape";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ItlandscapePackage eINSTANCE = org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.ElementImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__SLA = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.StorageImpl <em>Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.StorageImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getStorage()
	 * @generated
	 */
	int STORAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__DESCRIPTION = ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__SLA = ELEMENT__SLA;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__CAPACITY = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.HostImpl <em>Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.HostImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getHost()
	 * @generated
	 */
	int HOST = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST__DESCRIPTION = ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST__SLA = ELEMENT__SLA;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST__IP = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST__OPERATING_SYSTEM = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOST_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.PhysicalMachineImpl <em>Physical Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.PhysicalMachineImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getPhysicalMachine()
	 * @generated
	 */
	int PHYSICAL_MACHINE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__NAME = HOST__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__DESCRIPTION = HOST__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__SLA = HOST__SLA;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__IP = HOST__IP;

	/**
	 * The feature id for the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__OPERATING_SYSTEM = HOST__OPERATING_SYSTEM;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__USES = HOST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cpu Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__CPU_CORES = HOST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Clock Rate Ghz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__CLOCK_RATE_GHZ = HOST_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ram GB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE__RAM_GB = HOST_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Physical Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE_FEATURE_COUNT = HOST_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Physical Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_MACHINE_OPERATION_COUNT = HOST_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.VirtualHostImpl <em>Virtual Host</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.VirtualHostImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getVirtualHost()
	 * @generated
	 */
	int VIRTUAL_HOST = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_HOST__NAME = HOST__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_HOST__DESCRIPTION = HOST__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_HOST__SLA = HOST__SLA;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_HOST__IP = HOST__IP;

	/**
	 * The feature id for the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_HOST__OPERATING_SYSTEM = HOST__OPERATING_SYSTEM;

	/**
	 * The feature id for the '<em><b>Runs On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_HOST__RUNS_ON = HOST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Virtual Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_HOST_FEATURE_COUNT = HOST_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Virtual Host</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_HOST_OPERATION_COUNT = HOST_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.ClusterImpl <em>Cluster</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.ClusterImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getCluster()
	 * @generated
	 */
	int CLUSTER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__NAME = VIRTUAL_HOST__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__DESCRIPTION = VIRTUAL_HOST__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__SLA = VIRTUAL_HOST__SLA;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__IP = VIRTUAL_HOST__IP;

	/**
	 * The feature id for the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__OPERATING_SYSTEM = VIRTUAL_HOST__OPERATING_SYSTEM;

	/**
	 * The feature id for the '<em><b>Runs On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__RUNS_ON = VIRTUAL_HOST__RUNS_ON;

	/**
	 * The feature id for the '<em><b>High Availability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__HIGH_AVAILABILITY = VIRTUAL_HOST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Load Balancing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__LOAD_BALANCING = VIRTUAL_HOST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cluster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_FEATURE_COUNT = VIRTUAL_HOST_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cluster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_OPERATION_COUNT = VIRTUAL_HOST_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.VirtualMachineImpl <em>Virtual Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.VirtualMachineImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getVirtualMachine()
	 * @generated
	 */
	int VIRTUAL_MACHINE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__NAME = VIRTUAL_HOST__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__DESCRIPTION = VIRTUAL_HOST__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__SLA = VIRTUAL_HOST__SLA;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__IP = VIRTUAL_HOST__IP;

	/**
	 * The feature id for the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__OPERATING_SYSTEM = VIRTUAL_HOST__OPERATING_SYSTEM;

	/**
	 * The feature id for the '<em><b>Runs On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__RUNS_ON = VIRTUAL_HOST__RUNS_ON;

	/**
	 * The feature id for the '<em><b>Cpu Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__CPU_CORES = VIRTUAL_HOST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ram GB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__RAM_GB = VIRTUAL_HOST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Clock Rate Ghz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE__CLOCK_RATE_GHZ = VIRTUAL_HOST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Virtual Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_FEATURE_COUNT = VIRTUAL_HOST_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Virtual Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_OPERATION_COUNT = VIRTUAL_HOST_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.ApplicationImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__DESCRIPTION = ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__SLA = ELEMENT__SLA;

	/**
	 * The feature id for the '<em><b>Runs On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__RUNS_ON = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Accesses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__ACCESSES = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.ServiceImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SLA = ELEMENT__SLA;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DEPENDS_ON = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.impl.DatabaseImpl <em>Database</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.impl.DatabaseImpl
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getDatabase()
	 * @generated
	 */
	int DATABASE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__DESCRIPTION = ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sla</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__SLA = ELEMENT__SLA;

	/**
	 * The feature id for the '<em><b>Runs On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__RUNS_ON = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.modules.itlandscape.ServiceLevelAgreement <em>Service Level Agreement</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.modules.itlandscape.ServiceLevelAgreement
	 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getServiceLevelAgreement()
	 * @generated
	 */
	int SERVICE_LEVEL_AGREEMENT = 10;

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.Storage <em>Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage</em>'.
	 * @see org.odysseus.modules.itlandscape.Storage
	 * @generated
	 */
	EClass getStorage();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.Storage#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see org.odysseus.modules.itlandscape.Storage#getCapacity()
	 * @see #getStorage()
	 * @generated
	 */
	EAttribute getStorage_Capacity();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.PhysicalMachine <em>Physical Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physical Machine</em>'.
	 * @see org.odysseus.modules.itlandscape.PhysicalMachine
	 * @generated
	 */
	EClass getPhysicalMachine();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.modules.itlandscape.PhysicalMachine#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see org.odysseus.modules.itlandscape.PhysicalMachine#getUses()
	 * @see #getPhysicalMachine()
	 * @generated
	 */
	EReference getPhysicalMachine_Uses();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.PhysicalMachine#getCpuCores <em>Cpu Cores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Cores</em>'.
	 * @see org.odysseus.modules.itlandscape.PhysicalMachine#getCpuCores()
	 * @see #getPhysicalMachine()
	 * @generated
	 */
	EAttribute getPhysicalMachine_CpuCores();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.PhysicalMachine#getClockRateGhz <em>Clock Rate Ghz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clock Rate Ghz</em>'.
	 * @see org.odysseus.modules.itlandscape.PhysicalMachine#getClockRateGhz()
	 * @see #getPhysicalMachine()
	 * @generated
	 */
	EAttribute getPhysicalMachine_ClockRateGhz();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.PhysicalMachine#getRamGB <em>Ram GB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ram GB</em>'.
	 * @see org.odysseus.modules.itlandscape.PhysicalMachine#getRamGB()
	 * @see #getPhysicalMachine()
	 * @generated
	 */
	EAttribute getPhysicalMachine_RamGB();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.Cluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cluster</em>'.
	 * @see org.odysseus.modules.itlandscape.Cluster
	 * @generated
	 */
	EClass getCluster();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.Cluster#isHighAvailability <em>High Availability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High Availability</em>'.
	 * @see org.odysseus.modules.itlandscape.Cluster#isHighAvailability()
	 * @see #getCluster()
	 * @generated
	 */
	EAttribute getCluster_HighAvailability();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.Cluster#isLoadBalancing <em>Load Balancing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Balancing</em>'.
	 * @see org.odysseus.modules.itlandscape.Cluster#isLoadBalancing()
	 * @see #getCluster()
	 * @generated
	 */
	EAttribute getCluster_LoadBalancing();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.VirtualMachine <em>Virtual Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Machine</em>'.
	 * @see org.odysseus.modules.itlandscape.VirtualMachine
	 * @generated
	 */
	EClass getVirtualMachine();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.VirtualMachine#getCpuCores <em>Cpu Cores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Cores</em>'.
	 * @see org.odysseus.modules.itlandscape.VirtualMachine#getCpuCores()
	 * @see #getVirtualMachine()
	 * @generated
	 */
	EAttribute getVirtualMachine_CpuCores();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.VirtualMachine#getRamGB <em>Ram GB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ram GB</em>'.
	 * @see org.odysseus.modules.itlandscape.VirtualMachine#getRamGB()
	 * @see #getVirtualMachine()
	 * @generated
	 */
	EAttribute getVirtualMachine_RamGB();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.VirtualMachine#getClockRateGhz <em>Clock Rate Ghz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clock Rate Ghz</em>'.
	 * @see org.odysseus.modules.itlandscape.VirtualMachine#getClockRateGhz()
	 * @see #getVirtualMachine()
	 * @generated
	 */
	EAttribute getVirtualMachine_ClockRateGhz();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see org.odysseus.modules.itlandscape.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.modules.itlandscape.Application#getRunsOn <em>Runs On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Runs On</em>'.
	 * @see org.odysseus.modules.itlandscape.Application#getRunsOn()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_RunsOn();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.modules.itlandscape.Application#getAccesses <em>Accesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Accesses</em>'.
	 * @see org.odysseus.modules.itlandscape.Application#getAccesses()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Accesses();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.odysseus.modules.itlandscape.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.modules.itlandscape.Service#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see org.odysseus.modules.itlandscape.Service#getDependsOn()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_DependsOn();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.Database <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database</em>'.
	 * @see org.odysseus.modules.itlandscape.Database
	 * @generated
	 */
	EClass getDatabase();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.modules.itlandscape.Database#getRunsOn <em>Runs On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Runs On</em>'.
	 * @see org.odysseus.modules.itlandscape.Database#getRunsOn()
	 * @see #getDatabase()
	 * @generated
	 */
	EReference getDatabase_RunsOn();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.Host <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Host</em>'.
	 * @see org.odysseus.modules.itlandscape.Host
	 * @generated
	 */
	EClass getHost();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.Host#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see org.odysseus.modules.itlandscape.Host#getIp()
	 * @see #getHost()
	 * @generated
	 */
	EAttribute getHost_Ip();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.Host#getOperatingSystem <em>Operating System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operating System</em>'.
	 * @see org.odysseus.modules.itlandscape.Host#getOperatingSystem()
	 * @see #getHost()
	 * @generated
	 */
	EAttribute getHost_OperatingSystem();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.VirtualHost <em>Virtual Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Host</em>'.
	 * @see org.odysseus.modules.itlandscape.VirtualHost
	 * @generated
	 */
	EClass getVirtualHost();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.modules.itlandscape.VirtualHost#getRunsOn <em>Runs On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Runs On</em>'.
	 * @see org.odysseus.modules.itlandscape.VirtualHost#getRunsOn()
	 * @see #getVirtualHost()
	 * @generated
	 */
	EReference getVirtualHost_RunsOn();

	/**
	 * Returns the meta object for class '{@link org.odysseus.modules.itlandscape.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.odysseus.modules.itlandscape.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.odysseus.modules.itlandscape.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.Element#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.odysseus.modules.itlandscape.Element#getDescription()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.modules.itlandscape.Element#getSla <em>Sla</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sla</em>'.
	 * @see org.odysseus.modules.itlandscape.Element#getSla()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Sla();

	/**
	 * Returns the meta object for enum '{@link org.odysseus.modules.itlandscape.ServiceLevelAgreement <em>Service Level Agreement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Level Agreement</em>'.
	 * @see org.odysseus.modules.itlandscape.ServiceLevelAgreement
	 * @generated
	 */
	EEnum getServiceLevelAgreement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ItlandscapeFactory getItlandscapeFactory();

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
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.StorageImpl <em>Storage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.StorageImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getStorage()
		 * @generated
		 */
		EClass STORAGE = eINSTANCE.getStorage();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORAGE__CAPACITY = eINSTANCE.getStorage_Capacity();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.PhysicalMachineImpl <em>Physical Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.PhysicalMachineImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getPhysicalMachine()
		 * @generated
		 */
		EClass PHYSICAL_MACHINE = eINSTANCE.getPhysicalMachine();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_MACHINE__USES = eINSTANCE.getPhysicalMachine_Uses();

		/**
		 * The meta object literal for the '<em><b>Cpu Cores</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_MACHINE__CPU_CORES = eINSTANCE.getPhysicalMachine_CpuCores();

		/**
		 * The meta object literal for the '<em><b>Clock Rate Ghz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_MACHINE__CLOCK_RATE_GHZ = eINSTANCE.getPhysicalMachine_ClockRateGhz();

		/**
		 * The meta object literal for the '<em><b>Ram GB</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_MACHINE__RAM_GB = eINSTANCE.getPhysicalMachine_RamGB();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.ClusterImpl <em>Cluster</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.ClusterImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getCluster()
		 * @generated
		 */
		EClass CLUSTER = eINSTANCE.getCluster();

		/**
		 * The meta object literal for the '<em><b>High Availability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLUSTER__HIGH_AVAILABILITY = eINSTANCE.getCluster_HighAvailability();

		/**
		 * The meta object literal for the '<em><b>Load Balancing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLUSTER__LOAD_BALANCING = eINSTANCE.getCluster_LoadBalancing();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.VirtualMachineImpl <em>Virtual Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.VirtualMachineImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getVirtualMachine()
		 * @generated
		 */
		EClass VIRTUAL_MACHINE = eINSTANCE.getVirtualMachine();

		/**
		 * The meta object literal for the '<em><b>Cpu Cores</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_MACHINE__CPU_CORES = eINSTANCE.getVirtualMachine_CpuCores();

		/**
		 * The meta object literal for the '<em><b>Ram GB</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_MACHINE__RAM_GB = eINSTANCE.getVirtualMachine_RamGB();

		/**
		 * The meta object literal for the '<em><b>Clock Rate Ghz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_MACHINE__CLOCK_RATE_GHZ = eINSTANCE.getVirtualMachine_ClockRateGhz();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.ApplicationImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>Runs On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__RUNS_ON = eINSTANCE.getApplication_RunsOn();

		/**
		 * The meta object literal for the '<em><b>Accesses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__ACCESSES = eINSTANCE.getApplication_Accesses();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.ServiceImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__DEPENDS_ON = eINSTANCE.getService_DependsOn();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.DatabaseImpl <em>Database</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.DatabaseImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getDatabase()
		 * @generated
		 */
		EClass DATABASE = eINSTANCE.getDatabase();

		/**
		 * The meta object literal for the '<em><b>Runs On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE__RUNS_ON = eINSTANCE.getDatabase_RunsOn();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.HostImpl <em>Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.HostImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getHost()
		 * @generated
		 */
		EClass HOST = eINSTANCE.getHost();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST__IP = eINSTANCE.getHost_Ip();

		/**
		 * The meta object literal for the '<em><b>Operating System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOST__OPERATING_SYSTEM = eINSTANCE.getHost_OperatingSystem();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.VirtualHostImpl <em>Virtual Host</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.VirtualHostImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getVirtualHost()
		 * @generated
		 */
		EClass VIRTUAL_HOST = eINSTANCE.getVirtualHost();

		/**
		 * The meta object literal for the '<em><b>Runs On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_HOST__RUNS_ON = eINSTANCE.getVirtualHost_RunsOn();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.impl.ElementImpl
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__DESCRIPTION = eINSTANCE.getElement_Description();

		/**
		 * The meta object literal for the '<em><b>Sla</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__SLA = eINSTANCE.getElement_Sla();

		/**
		 * The meta object literal for the '{@link org.odysseus.modules.itlandscape.ServiceLevelAgreement <em>Service Level Agreement</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.modules.itlandscape.ServiceLevelAgreement
		 * @see org.odysseus.modules.itlandscape.impl.ItlandscapePackageImpl#getServiceLevelAgreement()
		 * @generated
		 */
		EEnum SERVICE_LEVEL_AGREEMENT = eINSTANCE.getServiceLevelAgreement();

	}

} //ItlandscapePackage
