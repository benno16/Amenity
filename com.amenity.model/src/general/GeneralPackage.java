/**
 */
package general;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see general.GeneralFactory
 * @model kind="package"
 *        annotation="teneo.jpa value='@GenericGenerator(name = \"system-uuid\", strategy = \"uuid2\")'"
 * @generated
 */
public interface GeneralPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "general";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://general/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "general";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneralPackage eINSTANCE = general.impl.GeneralPackageImpl.init();

	/**
	 * The meta object id for the '{@link general.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.UserImpl
	 * @see general.impl.GeneralPackageImpl#getUser()
	 * @generated
	 */
	int USER = 0;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_ID = 0;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USERNAME = 1;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PASSWORD = 2;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__EMAIL = 3;

	/**
	 * The feature id for the '<em><b>Last Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LAST_USED = 4;

	/**
	 * The feature id for the '<em><b>Times Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__TIMES_USED = 5;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DELETED = 6;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__EVENT = 7;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link general.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.EventImpl
	 * @see general.impl.GeneralPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 1;

	/**
	 * The feature id for the '<em><b>Event Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__EVENT_ID = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DATE = 2;

	/**
	 * The feature id for the '<em><b>User Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__USER_RELEVANT = 3;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__USER = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = 5;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link general.impl.DataSourceImpl <em>Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.DataSourceImpl
	 * @see general.impl.GeneralPackageImpl#getDataSource()
	 * @generated
	 */
	int DATA_SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Data Source Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__DATA_SOURCE_ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__CREATED = 2;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__MODIFIED = 3;

	/**
	 * The feature id for the '<em><b>Add Info1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__ADD_INFO1 = 4;

	/**
	 * The feature id for the '<em><b>Add Info2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__ADD_INFO2 = 5;

	/**
	 * The feature id for the '<em><b>Add Info3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__ADD_INFO3 = 6;

	/**
	 * The feature id for the '<em><b>Setting</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__SETTING = 7;

	/**
	 * The number of structural features of the '<em>Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link general.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.ConnectionImpl
	 * @see general.impl.GeneralPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 3;

	/**
	 * The feature id for the '<em><b>Connection Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__CONNECTION_ID = 0;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__USERNAME = 1;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__PASSWORD = 2;

	/**
	 * The feature id for the '<em><b>Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__CONNECTION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Database</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DATABASE = 4;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__PROJECT = 5;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__RELEASE = 6;

	/**
	 * The feature id for the '<em><b>Add Info1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ADD_INFO1 = 7;

	/**
	 * The feature id for the '<em><b>Add Info2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ADD_INFO2 = 8;

	/**
	 * The feature id for the '<em><b>Add Info3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ADD_INFO3 = 9;

	/**
	 * The feature id for the '<em><b>Add Info4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ADD_INFO4 = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE = 11;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__CREATED = 12;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__MODIFIED = 13;

	/**
	 * The feature id for the '<em><b>Last Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__LAST_USED = 14;

	/**
	 * The feature id for the '<em><b>Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__PART_OF = 15;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DELETED = 16;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__EREFERENCE0 = 17;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 18;

	/**
	 * The meta object id for the '{@link general.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.ContainerImpl
	 * @see general.impl.GeneralPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Container Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CONTAINER_ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CREATED = 2;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__MODIFIED = 3;

	/**
	 * The feature id for the '<em><b>Add Info1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ADD_INFO1 = 4;

	/**
	 * The feature id for the '<em><b>Add Info2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ADD_INFO2 = 5;

	/**
	 * The feature id for the '<em><b>Add Info3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ADD_INFO3 = 6;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__OWNER = 7;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__DELETED = 8;

	/**
	 * The feature id for the '<em><b>Owner Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__OWNER_ID = 9;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link general.impl.SnapshotImpl <em>Snapshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.SnapshotImpl
	 * @see general.impl.GeneralPackageImpl#getSnapshot()
	 * @generated
	 */
	int SNAPSHOT = 5;

	/**
	 * The feature id for the '<em><b>Snapshot Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__SNAPSHOT_ID = 0;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__CREATED = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__PART_OF = 4;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__DELETED = 5;

	/**
	 * The feature id for the '<em><b>Stores</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__STORES = 6;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__FUNCTIONS = 7;

	/**
	 * The feature id for the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__GENERAL = 8;

	/**
	 * The feature id for the '<em><b>System Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__SYSTEM_COMPONENT = 9;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__EREFERENCE0 = 10;

	/**
	 * The feature id for the '<em><b>EReference1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__EREFERENCE1 = 11;

	/**
	 * The feature id for the '<em><b>EReference2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__EREFERENCE2 = 12;

	/**
	 * The number of structural features of the '<em>Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link general.impl.ContentObjectImpl <em>Content Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.ContentObjectImpl
	 * @see general.impl.GeneralPackageImpl#getContentObject()
	 * @generated
	 */
	int CONTENT_OBJECT = 6;

	/**
	 * The feature id for the '<em><b>Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__OBJECT_ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__LEVEL = 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__VERSION = 3;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__RELEASE = 4;

	/**
	 * The feature id for the '<em><b>Modfied Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__MODFIED_DATE = 5;

	/**
	 * The feature id for the '<em><b>Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT__PART_OF = 6;

	/**
	 * The number of structural features of the '<em>Content Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link general.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.FileImpl
	 * @see general.impl.GeneralPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 7;

	/**
	 * The feature id for the '<em><b>Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__OBJECT_ID = CONTENT_OBJECT__OBJECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__NAME = CONTENT_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__LEVEL = CONTENT_OBJECT__LEVEL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__VERSION = CONTENT_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__RELEASE = CONTENT_OBJECT__RELEASE;

	/**
	 * The feature id for the '<em><b>Modfied Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__MODFIED_DATE = CONTENT_OBJECT__MODFIED_DATE;

	/**
	 * The feature id for the '<em><b>Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PART_OF = CONTENT_OBJECT__PART_OF;

	/**
	 * The feature id for the '<em><b>Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__OBJECT_NAME = CONTENT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__CREATION_DATE = CONTENT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__STATUS = CONTENT_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Root Dir</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__ROOT_DIR = CONTENT_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Of Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__OF_TYPE = CONTENT_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Has Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__HAS_PROPERTY = CONTENT_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = CONTENT_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link general.impl.FolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.FolderImpl
	 * @see general.impl.GeneralPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 8;

	/**
	 * The feature id for the '<em><b>Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__OBJECT_ID = CONTENT_OBJECT__OBJECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__NAME = CONTENT_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__LEVEL = CONTENT_OBJECT__LEVEL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__VERSION = CONTENT_OBJECT__VERSION;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__RELEASE = CONTENT_OBJECT__RELEASE;

	/**
	 * The feature id for the '<em><b>Modfied Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__MODFIED_DATE = CONTENT_OBJECT__MODFIED_DATE;

	/**
	 * The feature id for the '<em><b>Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__PART_OF = CONTENT_OBJECT__PART_OF;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__CHILDREN = CONTENT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root Directory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__ROOT_DIRECTORY = CONTENT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = CONTENT_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link general.impl.FileTypeImpl <em>File Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.FileTypeImpl
	 * @see general.impl.GeneralPackageImpl#getFileType()
	 * @generated
	 */
	int FILE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>File Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__FILE_TYPE_ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__ICON = 3;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__TOOL = 4;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE__USES = 5;

	/**
	 * The number of structural features of the '<em>File Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link general.impl.FileEndingImpl <em>File Ending</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.FileEndingImpl
	 * @see general.impl.GeneralPackageImpl#getFileEnding()
	 * @generated
	 */
	int FILE_ENDING = 10;

	/**
	 * The feature id for the '<em><b>File Ending Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ENDING__FILE_ENDING_ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ENDING__NAME = 1;

	/**
	 * The feature id for the '<em><b>Of Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ENDING__OF_TYPE = 2;

	/**
	 * The number of structural features of the '<em>File Ending</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ENDING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link general.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.FunctionImpl
	 * @see general.impl.GeneralPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 11;

	/**
	 * The feature id for the '<em><b>Function Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__FUNCTION_ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__CREATED = 2;

	/**
	 * The feature id for the '<em><b>Overall Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OVERALL_STATUS = 3;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__MODIFIED = 4;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DELETED = 5;

	/**
	 * The feature id for the '<em><b>Responsible Files</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RESPONSIBLE_FILES = 6;

	/**
	 * The feature id for the '<em><b>Held By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__HELD_BY = 7;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link general.impl.FilePropertyImpl <em>File Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.FilePropertyImpl
	 * @see general.impl.GeneralPackageImpl#getFileProperty()
	 * @generated
	 */
	int FILE_PROPERTY = 12;

	/**
	 * The feature id for the '<em><b>File Property Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY__FILE_PROPERTY_ID = 0;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY__REQUIRED = 1;

	/**
	 * The feature id for the '<em><b>Up To Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY__UP_TO_DATE = 2;

	/**
	 * The feature id for the '<em><b>Reviewed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY__REVIEWED = 3;

	/**
	 * The feature id for the '<em><b>Configuration Management</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY__CONFIGURATION_MANAGEMENT = 4;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY__RATING = 5;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY__COMMENT = 6;

	/**
	 * The feature id for the '<em><b>Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY__OF = 7;

	/**
	 * The number of structural features of the '<em>File Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_PROPERTY_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link general.impl.GeneralDocumentationFilePropertyImpl <em>Documentation File Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.GeneralDocumentationFilePropertyImpl
	 * @see general.impl.GeneralPackageImpl#getGeneralDocumentationFileProperty()
	 * @generated
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY = 13;

	/**
	 * The feature id for the '<em><b>File Property Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__FILE_PROPERTY_ID = FILE_PROPERTY__FILE_PROPERTY_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__REQUIRED = FILE_PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>Up To Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__UP_TO_DATE = FILE_PROPERTY__UP_TO_DATE;

	/**
	 * The feature id for the '<em><b>Reviewed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__REVIEWED = FILE_PROPERTY__REVIEWED;

	/**
	 * The feature id for the '<em><b>Configuration Management</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__CONFIGURATION_MANAGEMENT = FILE_PROPERTY__CONFIGURATION_MANAGEMENT;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__RATING = FILE_PROPERTY__RATING;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__COMMENT = FILE_PROPERTY__COMMENT;

	/**
	 * The feature id for the '<em><b>Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__OF = FILE_PROPERTY__OF;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY__TYPE = FILE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Documentation File Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_FILE_PROPERTY_FEATURE_COUNT = FILE_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link general.impl.GenericFunctionSRSFilePropertyImpl <em>Generic Function SRS File Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.GenericFunctionSRSFilePropertyImpl
	 * @see general.impl.GeneralPackageImpl#getGenericFunctionSRSFileProperty()
	 * @generated
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY = 14;

	/**
	 * The feature id for the '<em><b>File Property Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__FILE_PROPERTY_ID = FILE_PROPERTY__FILE_PROPERTY_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__REQUIRED = FILE_PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>Up To Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__UP_TO_DATE = FILE_PROPERTY__UP_TO_DATE;

	/**
	 * The feature id for the '<em><b>Reviewed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__REVIEWED = FILE_PROPERTY__REVIEWED;

	/**
	 * The feature id for the '<em><b>Configuration Management</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__CONFIGURATION_MANAGEMENT = FILE_PROPERTY__CONFIGURATION_MANAGEMENT;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__RATING = FILE_PROPERTY__RATING;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__COMMENT = FILE_PROPERTY__COMMENT;

	/**
	 * The feature id for the '<em><b>Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__OF = FILE_PROPERTY__OF;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY__TYPE = FILE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Generic Function SRS File Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_FILE_PROPERTY_FEATURE_COUNT = FILE_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link general.impl.SystemComponentLevelDocumentationFilePropertyImpl <em>System Component Level Documentation File Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.SystemComponentLevelDocumentationFilePropertyImpl
	 * @see general.impl.GeneralPackageImpl#getSystemComponentLevelDocumentationFileProperty()
	 * @generated
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY = 15;

	/**
	 * The feature id for the '<em><b>File Property Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__FILE_PROPERTY_ID = FILE_PROPERTY__FILE_PROPERTY_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__REQUIRED = FILE_PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>Up To Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__UP_TO_DATE = FILE_PROPERTY__UP_TO_DATE;

	/**
	 * The feature id for the '<em><b>Reviewed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__REVIEWED = FILE_PROPERTY__REVIEWED;

	/**
	 * The feature id for the '<em><b>Configuration Management</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__CONFIGURATION_MANAGEMENT = FILE_PROPERTY__CONFIGURATION_MANAGEMENT;

	/**
	 * The feature id for the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__RATING = FILE_PROPERTY__RATING;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__COMMENT = FILE_PROPERTY__COMMENT;

	/**
	 * The feature id for the '<em><b>Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__OF = FILE_PROPERTY__OF;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__TYPE = FILE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System Component Level Documentation File Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY_FEATURE_COUNT = FILE_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link general.impl.GeneralDocumentationTypeImpl <em>Documentation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.GeneralDocumentationTypeImpl
	 * @see general.impl.GeneralPackageImpl#getGeneralDocumentationType()
	 * @generated
	 */
	int GENERAL_DOCUMENTATION_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Documentation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOCUMENTATION_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link general.impl.GenericFunctionSRSTypeImpl <em>Generic Function SRS Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.GenericFunctionSRSTypeImpl
	 * @see general.impl.GeneralPackageImpl#getGenericFunctionSRSType()
	 * @generated
	 */
	int GENERIC_FUNCTION_SRS_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Generic Function SRS Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_FUNCTION_SRS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link general.impl.SystemComponentLevelDocumentationImpl <em>System Component Level Documentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.SystemComponentLevelDocumentationImpl
	 * @see general.impl.GeneralPackageImpl#getSystemComponentLevelDocumentation()
	 * @generated
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>System Component Level Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link general.impl.UserListImpl <em>User List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.UserListImpl
	 * @see general.impl.GeneralPackageImpl#getUserList()
	 * @generated
	 */
	int USER_LIST = 19;

	/**
	 * The feature id for the '<em><b>Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LIST__USERS = 0;

	/**
	 * The number of structural features of the '<em>User List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_LIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link general.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.TaskImpl
	 * @see general.impl.GeneralPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 20;

	/**
	 * The feature id for the '<em><b>Task Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__TASK_ID = 0;

	/**
	 * The feature id for the '<em><b>Finished</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__FINISHED = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__CREATED = 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__OWNER = 4;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link general.EventType <em>Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.EventType
	 * @see general.impl.GeneralPackageImpl#getEventType()
	 * @generated
	 */
	int EVENT_TYPE = 21;

	/**
	 * The meta object id for the '{@link general.ConnectionType <em>Connection Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.ConnectionType
	 * @see general.impl.GeneralPackageImpl#getConnectionType()
	 * @generated
	 */
	int CONNECTION_TYPE = 22;

	/**
	 * The meta object id for the '{@link general.QualityCriteria <em>Quality Criteria</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.QualityCriteria
	 * @see general.impl.GeneralPackageImpl#getQualityCriteria()
	 * @generated
	 */
	int QUALITY_CRITERIA = 23;

	/**
	 * The meta object id for the '<em>Date</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Date
	 * @see general.impl.GeneralPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 24;

	/**
	 * The meta object id for the '<em>Image</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.Image
	 * @see general.impl.GeneralPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 25;


	/**
	 * Returns the meta object for class '{@link general.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see general.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see general.User#getUserId()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UserId();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see general.User#getUsername()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Username();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see general.User#getPassword()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Password();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see general.User#getEmail()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Email();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getLastUsed <em>Last Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Used</em>'.
	 * @see general.User#getLastUsed()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_LastUsed();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getTimesUsed <em>Times Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Times Used</em>'.
	 * @see general.User#getTimesUsed()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_TimesUsed();

	/**
	 * Returns the meta object for the attribute '{@link general.User#isDeleted <em>Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted</em>'.
	 * @see general.User#isDeleted()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Deleted();

	/**
	 * Returns the meta object for the reference list '{@link general.User#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event</em>'.
	 * @see general.User#getEvent()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Event();

	/**
	 * Returns the meta object for class '{@link general.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see general.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link general.Event#getEventId <em>Event Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Id</em>'.
	 * @see general.Event#getEventId()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_EventId();

	/**
	 * Returns the meta object for the attribute '{@link general.Event#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see general.Event#getMessage()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Message();

	/**
	 * Returns the meta object for the attribute '{@link general.Event#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see general.Event#getDate()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Date();

	/**
	 * Returns the meta object for the attribute '{@link general.Event#isUserRelevant <em>User Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Relevant</em>'.
	 * @see general.Event#isUserRelevant()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_UserRelevant();

	/**
	 * Returns the meta object for the reference '{@link general.Event#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see general.Event#getUser()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_User();

	/**
	 * Returns the meta object for the attribute '{@link general.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see general.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Type();

	/**
	 * Returns the meta object for class '{@link general.DataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source</em>'.
	 * @see general.DataSource
	 * @generated
	 */
	EClass getDataSource();

	/**
	 * Returns the meta object for the attribute '{@link general.DataSource#getDataSourceId <em>Data Source Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Source Id</em>'.
	 * @see general.DataSource#getDataSourceId()
	 * @see #getDataSource()
	 * @generated
	 */
	EAttribute getDataSource_DataSourceId();

	/**
	 * Returns the meta object for the attribute '{@link general.DataSource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.DataSource#getName()
	 * @see #getDataSource()
	 * @generated
	 */
	EAttribute getDataSource_Name();

	/**
	 * Returns the meta object for the attribute '{@link general.DataSource#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see general.DataSource#getCreated()
	 * @see #getDataSource()
	 * @generated
	 */
	EAttribute getDataSource_Created();

	/**
	 * Returns the meta object for the attribute '{@link general.DataSource#getModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see general.DataSource#getModified()
	 * @see #getDataSource()
	 * @generated
	 */
	EAttribute getDataSource_Modified();

	/**
	 * Returns the meta object for the attribute '{@link general.DataSource#getAddInfo1 <em>Add Info1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info1</em>'.
	 * @see general.DataSource#getAddInfo1()
	 * @see #getDataSource()
	 * @generated
	 */
	EAttribute getDataSource_AddInfo1();

	/**
	 * Returns the meta object for the attribute '{@link general.DataSource#getAddInfo2 <em>Add Info2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info2</em>'.
	 * @see general.DataSource#getAddInfo2()
	 * @see #getDataSource()
	 * @generated
	 */
	EAttribute getDataSource_AddInfo2();

	/**
	 * Returns the meta object for the attribute '{@link general.DataSource#getAddInfo3 <em>Add Info3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info3</em>'.
	 * @see general.DataSource#getAddInfo3()
	 * @see #getDataSource()
	 * @generated
	 */
	EAttribute getDataSource_AddInfo3();

	/**
	 * Returns the meta object for the reference list '{@link general.DataSource#getSetting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Setting</em>'.
	 * @see general.DataSource#getSetting()
	 * @see #getDataSource()
	 * @generated
	 */
	EReference getDataSource_Setting();

	/**
	 * Returns the meta object for class '{@link general.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see general.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getConnectionId <em>Connection Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Id</em>'.
	 * @see general.Connection#getConnectionId()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ConnectionId();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see general.Connection#getUsername()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Username();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see general.Connection#getPassword()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Password();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Type</em>'.
	 * @see general.Connection#getConnectionType()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ConnectionType();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getDatabase <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Database</em>'.
	 * @see general.Connection#getDatabase()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Database();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project</em>'.
	 * @see general.Connection#getProject()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Project();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see general.Connection#getRelease()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Release();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getAddInfo1 <em>Add Info1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info1</em>'.
	 * @see general.Connection#getAddInfo1()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_AddInfo1();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getAddInfo2 <em>Add Info2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info2</em>'.
	 * @see general.Connection#getAddInfo2()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_AddInfo2();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getAddInfo3 <em>Add Info3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info3</em>'.
	 * @see general.Connection#getAddInfo3()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_AddInfo3();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getAddInfo4 <em>Add Info4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info4</em>'.
	 * @see general.Connection#getAddInfo4()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_AddInfo4();

	/**
	 * Returns the meta object for the reference '{@link general.Connection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see general.Connection#getSource()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Source();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see general.Connection#getCreated()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Created();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see general.Connection#getModified()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Modified();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#getLastUsed <em>Last Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Used</em>'.
	 * @see general.Connection#getLastUsed()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_LastUsed();

	/**
	 * Returns the meta object for the reference '{@link general.Connection#getPartOf <em>Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Part Of</em>'.
	 * @see general.Connection#getPartOf()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_PartOf();

	/**
	 * Returns the meta object for the attribute '{@link general.Connection#isDeleted <em>Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted</em>'.
	 * @see general.Connection#isDeleted()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Deleted();

	/**
	 * Returns the meta object for the containment reference '{@link general.Connection#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EReference0</em>'.
	 * @see general.Connection#getEReference0()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_EReference0();

	/**
	 * Returns the meta object for class '{@link general.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see general.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#getContainerId <em>Container Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Id</em>'.
	 * @see general.Container#getContainerId()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_ContainerId();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.Container#getName()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_Name();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see general.Container#getCreated()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_Created();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#getModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see general.Container#getModified()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_Modified();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#getAddInfo1 <em>Add Info1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info1</em>'.
	 * @see general.Container#getAddInfo1()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_AddInfo1();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#getAddInfo2 <em>Add Info2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info2</em>'.
	 * @see general.Container#getAddInfo2()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_AddInfo2();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#getAddInfo3 <em>Add Info3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add Info3</em>'.
	 * @see general.Container#getAddInfo3()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_AddInfo3();

	/**
	 * Returns the meta object for the reference '{@link general.Container#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see general.Container#getOwner()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Owner();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#isDeleted <em>Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted</em>'.
	 * @see general.Container#isDeleted()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_Deleted();

	/**
	 * Returns the meta object for the attribute '{@link general.Container#getOwnerId <em>Owner Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner Id</em>'.
	 * @see general.Container#getOwnerId()
	 * @see #getContainer()
	 * @generated
	 */
	EAttribute getContainer_OwnerId();

	/**
	 * Returns the meta object for class '{@link general.Snapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot</em>'.
	 * @see general.Snapshot
	 * @generated
	 */
	EClass getSnapshot();

	/**
	 * Returns the meta object for the attribute '{@link general.Snapshot#getSnapshotId <em>Snapshot Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snapshot Id</em>'.
	 * @see general.Snapshot#getSnapshotId()
	 * @see #getSnapshot()
	 * @generated
	 */
	EAttribute getSnapshot_SnapshotId();

	/**
	 * Returns the meta object for the attribute '{@link general.Snapshot#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see general.Snapshot#getCreated()
	 * @see #getSnapshot()
	 * @generated
	 */
	EAttribute getSnapshot_Created();

	/**
	 * Returns the meta object for the attribute '{@link general.Snapshot#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.Snapshot#getName()
	 * @see #getSnapshot()
	 * @generated
	 */
	EAttribute getSnapshot_Name();

	/**
	 * Returns the meta object for the attribute '{@link general.Snapshot#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see general.Snapshot#getComment()
	 * @see #getSnapshot()
	 * @generated
	 */
	EAttribute getSnapshot_Comment();

	/**
	 * Returns the meta object for the reference '{@link general.Snapshot#getPartOf <em>Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Part Of</em>'.
	 * @see general.Snapshot#getPartOf()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_PartOf();

	/**
	 * Returns the meta object for the attribute '{@link general.Snapshot#isDeleted <em>Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted</em>'.
	 * @see general.Snapshot#isDeleted()
	 * @see #getSnapshot()
	 * @generated
	 */
	EAttribute getSnapshot_Deleted();

	/**
	 * Returns the meta object for the reference list '{@link general.Snapshot#getStores <em>Stores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stores</em>'.
	 * @see general.Snapshot#getStores()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_Stores();

	/**
	 * Returns the meta object for the reference list '{@link general.Snapshot#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Functions</em>'.
	 * @see general.Snapshot#getFunctions()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_Functions();

	/**
	 * Returns the meta object for the reference '{@link general.Snapshot#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>General</em>'.
	 * @see general.Snapshot#getGeneral()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_General();

	/**
	 * Returns the meta object for the reference '{@link general.Snapshot#getSystemComponent <em>System Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Component</em>'.
	 * @see general.Snapshot#getSystemComponent()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_SystemComponent();

	/**
	 * Returns the meta object for the containment reference '{@link general.Snapshot#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EReference0</em>'.
	 * @see general.Snapshot#getEReference0()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_EReference0();

	/**
	 * Returns the meta object for the containment reference '{@link general.Snapshot#getEReference1 <em>EReference1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EReference1</em>'.
	 * @see general.Snapshot#getEReference1()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_EReference1();

	/**
	 * Returns the meta object for the containment reference '{@link general.Snapshot#getEReference2 <em>EReference2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EReference2</em>'.
	 * @see general.Snapshot#getEReference2()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_EReference2();

	/**
	 * Returns the meta object for class '{@link general.ContentObject <em>Content Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Object</em>'.
	 * @see general.ContentObject
	 * @generated
	 */
	EClass getContentObject();

	/**
	 * Returns the meta object for the attribute '{@link general.ContentObject#getObjectId <em>Object Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Id</em>'.
	 * @see general.ContentObject#getObjectId()
	 * @see #getContentObject()
	 * @generated
	 */
	EAttribute getContentObject_ObjectId();

	/**
	 * Returns the meta object for the attribute '{@link general.ContentObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.ContentObject#getName()
	 * @see #getContentObject()
	 * @generated
	 */
	EAttribute getContentObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link general.ContentObject#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see general.ContentObject#getLevel()
	 * @see #getContentObject()
	 * @generated
	 */
	EAttribute getContentObject_Level();

	/**
	 * Returns the meta object for the attribute '{@link general.ContentObject#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see general.ContentObject#getVersion()
	 * @see #getContentObject()
	 * @generated
	 */
	EAttribute getContentObject_Version();

	/**
	 * Returns the meta object for the attribute '{@link general.ContentObject#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see general.ContentObject#getRelease()
	 * @see #getContentObject()
	 * @generated
	 */
	EAttribute getContentObject_Release();

	/**
	 * Returns the meta object for the attribute '{@link general.ContentObject#getModfiedDate <em>Modfied Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modfied Date</em>'.
	 * @see general.ContentObject#getModfiedDate()
	 * @see #getContentObject()
	 * @generated
	 */
	EAttribute getContentObject_ModfiedDate();

	/**
	 * Returns the meta object for the reference '{@link general.ContentObject#getPartOf <em>Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Part Of</em>'.
	 * @see general.ContentObject#getPartOf()
	 * @see #getContentObject()
	 * @generated
	 */
	EReference getContentObject_PartOf();

	/**
	 * Returns the meta object for class '{@link general.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see general.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the attribute '{@link general.File#getObjectName <em>Object Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Name</em>'.
	 * @see general.File#getObjectName()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_ObjectName();

	/**
	 * Returns the meta object for the attribute '{@link general.File#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see general.File#getCreationDate()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_CreationDate();

	/**
	 * Returns the meta object for the attribute '{@link general.File#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see general.File#getStatus()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Status();

	/**
	 * Returns the meta object for the reference '{@link general.File#getRootDir <em>Root Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root Dir</em>'.
	 * @see general.File#getRootDir()
	 * @see #getFile()
	 * @generated
	 */
	EReference getFile_RootDir();

	/**
	 * Returns the meta object for the reference '{@link general.File#getOfType <em>Of Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Of Type</em>'.
	 * @see general.File#getOfType()
	 * @see #getFile()
	 * @generated
	 */
	EReference getFile_OfType();

	/**
	 * Returns the meta object for the reference list '{@link general.File#getHasProperty <em>Has Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has Property</em>'.
	 * @see general.File#getHasProperty()
	 * @see #getFile()
	 * @generated
	 */
	EReference getFile_HasProperty();

	/**
	 * Returns the meta object for class '{@link general.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see general.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for the reference list '{@link general.Folder#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see general.Folder#getChildren()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_Children();

	/**
	 * Returns the meta object for the reference '{@link general.Folder#getRootDirectory <em>Root Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root Directory</em>'.
	 * @see general.Folder#getRootDirectory()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_RootDirectory();

	/**
	 * Returns the meta object for class '{@link general.FileType <em>File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Type</em>'.
	 * @see general.FileType
	 * @generated
	 */
	EClass getFileType();

	/**
	 * Returns the meta object for the attribute '{@link general.FileType#getFileTypeId <em>File Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Type Id</em>'.
	 * @see general.FileType#getFileTypeId()
	 * @see #getFileType()
	 * @generated
	 */
	EAttribute getFileType_FileTypeId();

	/**
	 * Returns the meta object for the attribute '{@link general.FileType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.FileType#getName()
	 * @see #getFileType()
	 * @generated
	 */
	EAttribute getFileType_Name();

	/**
	 * Returns the meta object for the attribute '{@link general.FileType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see general.FileType#getDescription()
	 * @see #getFileType()
	 * @generated
	 */
	EAttribute getFileType_Description();

	/**
	 * Returns the meta object for the attribute '{@link general.FileType#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see general.FileType#getIcon()
	 * @see #getFileType()
	 * @generated
	 */
	EAttribute getFileType_Icon();

	/**
	 * Returns the meta object for the attribute '{@link general.FileType#getTool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tool</em>'.
	 * @see general.FileType#getTool()
	 * @see #getFileType()
	 * @generated
	 */
	EAttribute getFileType_Tool();

	/**
	 * Returns the meta object for the reference list '{@link general.FileType#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see general.FileType#getUses()
	 * @see #getFileType()
	 * @generated
	 */
	EReference getFileType_Uses();

	/**
	 * Returns the meta object for class '{@link general.FileEnding <em>File Ending</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Ending</em>'.
	 * @see general.FileEnding
	 * @generated
	 */
	EClass getFileEnding();

	/**
	 * Returns the meta object for the attribute '{@link general.FileEnding#getFileEndingId <em>File Ending Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Ending Id</em>'.
	 * @see general.FileEnding#getFileEndingId()
	 * @see #getFileEnding()
	 * @generated
	 */
	EAttribute getFileEnding_FileEndingId();

	/**
	 * Returns the meta object for the attribute '{@link general.FileEnding#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.FileEnding#getName()
	 * @see #getFileEnding()
	 * @generated
	 */
	EAttribute getFileEnding_Name();

	/**
	 * Returns the meta object for the reference '{@link general.FileEnding#getOfType <em>Of Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Of Type</em>'.
	 * @see general.FileEnding#getOfType()
	 * @see #getFileEnding()
	 * @generated
	 */
	EReference getFileEnding_OfType();

	/**
	 * Returns the meta object for class '{@link general.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see general.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the attribute '{@link general.Function#getFunctionId <em>Function Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Id</em>'.
	 * @see general.Function#getFunctionId()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_FunctionId();

	/**
	 * Returns the meta object for the attribute '{@link general.Function#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.Function#getName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Name();

	/**
	 * Returns the meta object for the attribute '{@link general.Function#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see general.Function#getCreated()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Created();

	/**
	 * Returns the meta object for the attribute '{@link general.Function#getOverallStatus <em>Overall Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overall Status</em>'.
	 * @see general.Function#getOverallStatus()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_OverallStatus();

	/**
	 * Returns the meta object for the attribute '{@link general.Function#getModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see general.Function#getModified()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Modified();

	/**
	 * Returns the meta object for the attribute '{@link general.Function#isDeleted <em>Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted</em>'.
	 * @see general.Function#isDeleted()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Deleted();

	/**
	 * Returns the meta object for the reference list '{@link general.Function#getResponsibleFiles <em>Responsible Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Responsible Files</em>'.
	 * @see general.Function#getResponsibleFiles()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_ResponsibleFiles();

	/**
	 * Returns the meta object for the reference '{@link general.Function#getHeldBy <em>Held By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Held By</em>'.
	 * @see general.Function#getHeldBy()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_HeldBy();

	/**
	 * Returns the meta object for class '{@link general.FileProperty <em>File Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Property</em>'.
	 * @see general.FileProperty
	 * @generated
	 */
	EClass getFileProperty();

	/**
	 * Returns the meta object for the attribute '{@link general.FileProperty#getFilePropertyId <em>File Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Property Id</em>'.
	 * @see general.FileProperty#getFilePropertyId()
	 * @see #getFileProperty()
	 * @generated
	 */
	EAttribute getFileProperty_FilePropertyId();

	/**
	 * Returns the meta object for the attribute '{@link general.FileProperty#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see general.FileProperty#isRequired()
	 * @see #getFileProperty()
	 * @generated
	 */
	EAttribute getFileProperty_Required();

	/**
	 * Returns the meta object for the attribute '{@link general.FileProperty#getUpToDate <em>Up To Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Up To Date</em>'.
	 * @see general.FileProperty#getUpToDate()
	 * @see #getFileProperty()
	 * @generated
	 */
	EAttribute getFileProperty_UpToDate();

	/**
	 * Returns the meta object for the attribute '{@link general.FileProperty#getReviewed <em>Reviewed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reviewed</em>'.
	 * @see general.FileProperty#getReviewed()
	 * @see #getFileProperty()
	 * @generated
	 */
	EAttribute getFileProperty_Reviewed();

	/**
	 * Returns the meta object for the attribute '{@link general.FileProperty#getConfigurationManagement <em>Configuration Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration Management</em>'.
	 * @see general.FileProperty#getConfigurationManagement()
	 * @see #getFileProperty()
	 * @generated
	 */
	EAttribute getFileProperty_ConfigurationManagement();

	/**
	 * Returns the meta object for the attribute '{@link general.FileProperty#getRating <em>Rating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rating</em>'.
	 * @see general.FileProperty#getRating()
	 * @see #getFileProperty()
	 * @generated
	 */
	EAttribute getFileProperty_Rating();

	/**
	 * Returns the meta object for the attribute '{@link general.FileProperty#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see general.FileProperty#getComment()
	 * @see #getFileProperty()
	 * @generated
	 */
	EAttribute getFileProperty_Comment();

	/**
	 * Returns the meta object for the reference '{@link general.FileProperty#getOf <em>Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Of</em>'.
	 * @see general.FileProperty#getOf()
	 * @see #getFileProperty()
	 * @generated
	 */
	EReference getFileProperty_Of();

	/**
	 * Returns the meta object for class '{@link general.GeneralDocumentationFileProperty <em>Documentation File Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation File Property</em>'.
	 * @see general.GeneralDocumentationFileProperty
	 * @generated
	 */
	EClass getGeneralDocumentationFileProperty();

	/**
	 * Returns the meta object for the reference list '{@link general.GeneralDocumentationFileProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Type</em>'.
	 * @see general.GeneralDocumentationFileProperty#getType()
	 * @see #getGeneralDocumentationFileProperty()
	 * @generated
	 */
	EReference getGeneralDocumentationFileProperty_Type();

	/**
	 * Returns the meta object for class '{@link general.GenericFunctionSRSFileProperty <em>Generic Function SRS File Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Function SRS File Property</em>'.
	 * @see general.GenericFunctionSRSFileProperty
	 * @generated
	 */
	EClass getGenericFunctionSRSFileProperty();

	/**
	 * Returns the meta object for the reference list '{@link general.GenericFunctionSRSFileProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Type</em>'.
	 * @see general.GenericFunctionSRSFileProperty#getType()
	 * @see #getGenericFunctionSRSFileProperty()
	 * @generated
	 */
	EReference getGenericFunctionSRSFileProperty_Type();

	/**
	 * Returns the meta object for class '{@link general.SystemComponentLevelDocumentationFileProperty <em>System Component Level Documentation File Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Component Level Documentation File Property</em>'.
	 * @see general.SystemComponentLevelDocumentationFileProperty
	 * @generated
	 */
	EClass getSystemComponentLevelDocumentationFileProperty();

	/**
	 * Returns the meta object for the reference list '{@link general.SystemComponentLevelDocumentationFileProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Type</em>'.
	 * @see general.SystemComponentLevelDocumentationFileProperty#getType()
	 * @see #getSystemComponentLevelDocumentationFileProperty()
	 * @generated
	 */
	EReference getSystemComponentLevelDocumentationFileProperty_Type();

	/**
	 * Returns the meta object for class '{@link general.GeneralDocumentationType <em>Documentation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation Type</em>'.
	 * @see general.GeneralDocumentationType
	 * @generated
	 */
	EClass getGeneralDocumentationType();

	/**
	 * Returns the meta object for the attribute '{@link general.GeneralDocumentationType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.GeneralDocumentationType#getName()
	 * @see #getGeneralDocumentationType()
	 * @generated
	 */
	EAttribute getGeneralDocumentationType_Name();

	/**
	 * Returns the meta object for class '{@link general.GenericFunctionSRSType <em>Generic Function SRS Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Function SRS Type</em>'.
	 * @see general.GenericFunctionSRSType
	 * @generated
	 */
	EClass getGenericFunctionSRSType();

	/**
	 * Returns the meta object for the attribute '{@link general.GenericFunctionSRSType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.GenericFunctionSRSType#getName()
	 * @see #getGenericFunctionSRSType()
	 * @generated
	 */
	EAttribute getGenericFunctionSRSType_Name();

	/**
	 * Returns the meta object for class '{@link general.SystemComponentLevelDocumentation <em>System Component Level Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Component Level Documentation</em>'.
	 * @see general.SystemComponentLevelDocumentation
	 * @generated
	 */
	EClass getSystemComponentLevelDocumentation();

	/**
	 * Returns the meta object for the attribute '{@link general.SystemComponentLevelDocumentation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see general.SystemComponentLevelDocumentation#getName()
	 * @see #getSystemComponentLevelDocumentation()
	 * @generated
	 */
	EAttribute getSystemComponentLevelDocumentation_Name();

	/**
	 * Returns the meta object for class '{@link general.UserList <em>User List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User List</em>'.
	 * @see general.UserList
	 * @generated
	 */
	EClass getUserList();

	/**
	 * Returns the meta object for the attribute '{@link general.UserList#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Users</em>'.
	 * @see general.UserList#getUsers()
	 * @see #getUserList()
	 * @generated
	 */
	EAttribute getUserList_Users();

	/**
	 * Returns the meta object for class '{@link general.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see general.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the attribute '{@link general.Task#getTaskId <em>Task Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Id</em>'.
	 * @see general.Task#getTaskId()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_TaskId();

	/**
	 * Returns the meta object for the attribute '{@link general.Task#isFinished <em>Finished</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Finished</em>'.
	 * @see general.Task#isFinished()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Finished();

	/**
	 * Returns the meta object for the attribute '{@link general.Task#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see general.Task#getDescription()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Description();

	/**
	 * Returns the meta object for the attribute '{@link general.Task#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see general.Task#getCreated()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Created();

	/**
	 * Returns the meta object for the reference '{@link general.Task#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see general.Task#getOwner()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Owner();

	/**
	 * Returns the meta object for enum '{@link general.EventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Type</em>'.
	 * @see general.EventType
	 * @generated
	 */
	EEnum getEventType();

	/**
	 * Returns the meta object for enum '{@link general.ConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection Type</em>'.
	 * @see general.ConnectionType
	 * @generated
	 */
	EEnum getConnectionType();

	/**
	 * Returns the meta object for enum '{@link general.QualityCriteria <em>Quality Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Quality Criteria</em>'.
	 * @see general.QualityCriteria
	 * @generated
	 */
	EEnum getQualityCriteria();

	/**
	 * Returns the meta object for data type '{@link java.util.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Date</em>'.
	 * @see java.util.Date
	 * @model instanceClass="java.util.Date"
	 * @generated
	 */
	EDataType getDate();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image</em>'.
	 * @see org.eclipse.swt.graphics.Image
	 * @model instanceClass="org.eclipse.swt.graphics.Image"
	 * @generated
	 */
	EDataType getImage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneralFactory getGeneralFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link general.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.UserImpl
		 * @see general.impl.GeneralPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USER_ID = eINSTANCE.getUser_UserId();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USERNAME = eINSTANCE.getUser_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PASSWORD = eINSTANCE.getUser_Password();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__EMAIL = eINSTANCE.getUser_Email();

		/**
		 * The meta object literal for the '<em><b>Last Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__LAST_USED = eINSTANCE.getUser_LastUsed();

		/**
		 * The meta object literal for the '<em><b>Times Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__TIMES_USED = eINSTANCE.getUser_TimesUsed();

		/**
		 * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__DELETED = eINSTANCE.getUser_Deleted();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__EVENT = eINSTANCE.getUser_Event();

		/**
		 * The meta object literal for the '{@link general.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.EventImpl
		 * @see general.impl.GeneralPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Event Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__EVENT_ID = eINSTANCE.getEvent_EventId();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__MESSAGE = eINSTANCE.getEvent_Message();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__DATE = eINSTANCE.getEvent_Date();

		/**
		 * The meta object literal for the '<em><b>User Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__USER_RELEVANT = eINSTANCE.getEvent_UserRelevant();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__USER = eINSTANCE.getEvent_User();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '{@link general.impl.DataSourceImpl <em>Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.DataSourceImpl
		 * @see general.impl.GeneralPackageImpl#getDataSource()
		 * @generated
		 */
		EClass DATA_SOURCE = eINSTANCE.getDataSource();

		/**
		 * The meta object literal for the '<em><b>Data Source Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE__DATA_SOURCE_ID = eINSTANCE.getDataSource_DataSourceId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE__NAME = eINSTANCE.getDataSource_Name();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE__CREATED = eINSTANCE.getDataSource_Created();

		/**
		 * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE__MODIFIED = eINSTANCE.getDataSource_Modified();

		/**
		 * The meta object literal for the '<em><b>Add Info1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE__ADD_INFO1 = eINSTANCE.getDataSource_AddInfo1();

		/**
		 * The meta object literal for the '<em><b>Add Info2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE__ADD_INFO2 = eINSTANCE.getDataSource_AddInfo2();

		/**
		 * The meta object literal for the '<em><b>Add Info3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE__ADD_INFO3 = eINSTANCE.getDataSource_AddInfo3();

		/**
		 * The meta object literal for the '<em><b>Setting</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE__SETTING = eINSTANCE.getDataSource_Setting();

		/**
		 * The meta object literal for the '{@link general.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.ConnectionImpl
		 * @see general.impl.GeneralPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Connection Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__CONNECTION_ID = eINSTANCE.getConnection_ConnectionId();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__USERNAME = eINSTANCE.getConnection_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__PASSWORD = eINSTANCE.getConnection_Password();

		/**
		 * The meta object literal for the '<em><b>Connection Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__CONNECTION_TYPE = eINSTANCE.getConnection_ConnectionType();

		/**
		 * The meta object literal for the '<em><b>Database</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DATABASE = eINSTANCE.getConnection_Database();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__PROJECT = eINSTANCE.getConnection_Project();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__RELEASE = eINSTANCE.getConnection_Release();

		/**
		 * The meta object literal for the '<em><b>Add Info1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ADD_INFO1 = eINSTANCE.getConnection_AddInfo1();

		/**
		 * The meta object literal for the '<em><b>Add Info2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ADD_INFO2 = eINSTANCE.getConnection_AddInfo2();

		/**
		 * The meta object literal for the '<em><b>Add Info3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ADD_INFO3 = eINSTANCE.getConnection_AddInfo3();

		/**
		 * The meta object literal for the '<em><b>Add Info4</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ADD_INFO4 = eINSTANCE.getConnection_AddInfo4();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__SOURCE = eINSTANCE.getConnection_Source();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__CREATED = eINSTANCE.getConnection_Created();

		/**
		 * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__MODIFIED = eINSTANCE.getConnection_Modified();

		/**
		 * The meta object literal for the '<em><b>Last Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__LAST_USED = eINSTANCE.getConnection_LastUsed();

		/**
		 * The meta object literal for the '<em><b>Part Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__PART_OF = eINSTANCE.getConnection_PartOf();

		/**
		 * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DELETED = eINSTANCE.getConnection_Deleted();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__EREFERENCE0 = eINSTANCE.getConnection_EReference0();

		/**
		 * The meta object literal for the '{@link general.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.ContainerImpl
		 * @see general.impl.GeneralPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Container Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__CONTAINER_ID = eINSTANCE.getContainer_ContainerId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__NAME = eINSTANCE.getContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__CREATED = eINSTANCE.getContainer_Created();

		/**
		 * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__MODIFIED = eINSTANCE.getContainer_Modified();

		/**
		 * The meta object literal for the '<em><b>Add Info1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__ADD_INFO1 = eINSTANCE.getContainer_AddInfo1();

		/**
		 * The meta object literal for the '<em><b>Add Info2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__ADD_INFO2 = eINSTANCE.getContainer_AddInfo2();

		/**
		 * The meta object literal for the '<em><b>Add Info3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__ADD_INFO3 = eINSTANCE.getContainer_AddInfo3();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__OWNER = eINSTANCE.getContainer_Owner();

		/**
		 * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__DELETED = eINSTANCE.getContainer_Deleted();

		/**
		 * The meta object literal for the '<em><b>Owner Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER__OWNER_ID = eINSTANCE.getContainer_OwnerId();

		/**
		 * The meta object literal for the '{@link general.impl.SnapshotImpl <em>Snapshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.SnapshotImpl
		 * @see general.impl.GeneralPackageImpl#getSnapshot()
		 * @generated
		 */
		EClass SNAPSHOT = eINSTANCE.getSnapshot();

		/**
		 * The meta object literal for the '<em><b>Snapshot Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT__SNAPSHOT_ID = eINSTANCE.getSnapshot_SnapshotId();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT__CREATED = eINSTANCE.getSnapshot_Created();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT__NAME = eINSTANCE.getSnapshot_Name();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT__COMMENT = eINSTANCE.getSnapshot_Comment();

		/**
		 * The meta object literal for the '<em><b>Part Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__PART_OF = eINSTANCE.getSnapshot_PartOf();

		/**
		 * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT__DELETED = eINSTANCE.getSnapshot_Deleted();

		/**
		 * The meta object literal for the '<em><b>Stores</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__STORES = eINSTANCE.getSnapshot_Stores();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__FUNCTIONS = eINSTANCE.getSnapshot_Functions();

		/**
		 * The meta object literal for the '<em><b>General</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__GENERAL = eINSTANCE.getSnapshot_General();

		/**
		 * The meta object literal for the '<em><b>System Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__SYSTEM_COMPONENT = eINSTANCE.getSnapshot_SystemComponent();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__EREFERENCE0 = eINSTANCE.getSnapshot_EReference0();

		/**
		 * The meta object literal for the '<em><b>EReference1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__EREFERENCE1 = eINSTANCE.getSnapshot_EReference1();

		/**
		 * The meta object literal for the '<em><b>EReference2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__EREFERENCE2 = eINSTANCE.getSnapshot_EReference2();

		/**
		 * The meta object literal for the '{@link general.impl.ContentObjectImpl <em>Content Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.ContentObjectImpl
		 * @see general.impl.GeneralPackageImpl#getContentObject()
		 * @generated
		 */
		EClass CONTENT_OBJECT = eINSTANCE.getContentObject();

		/**
		 * The meta object literal for the '<em><b>Object Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_OBJECT__OBJECT_ID = eINSTANCE.getContentObject_ObjectId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_OBJECT__NAME = eINSTANCE.getContentObject_Name();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_OBJECT__LEVEL = eINSTANCE.getContentObject_Level();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_OBJECT__VERSION = eINSTANCE.getContentObject_Version();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_OBJECT__RELEASE = eINSTANCE.getContentObject_Release();

		/**
		 * The meta object literal for the '<em><b>Modfied Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_OBJECT__MODFIED_DATE = eINSTANCE.getContentObject_ModfiedDate();

		/**
		 * The meta object literal for the '<em><b>Part Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT_OBJECT__PART_OF = eINSTANCE.getContentObject_PartOf();

		/**
		 * The meta object literal for the '{@link general.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.FileImpl
		 * @see general.impl.GeneralPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Object Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__OBJECT_NAME = eINSTANCE.getFile_ObjectName();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__CREATION_DATE = eINSTANCE.getFile_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__STATUS = eINSTANCE.getFile_Status();

		/**
		 * The meta object literal for the '<em><b>Root Dir</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE__ROOT_DIR = eINSTANCE.getFile_RootDir();

		/**
		 * The meta object literal for the '<em><b>Of Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE__OF_TYPE = eINSTANCE.getFile_OfType();

		/**
		 * The meta object literal for the '<em><b>Has Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE__HAS_PROPERTY = eINSTANCE.getFile_HasProperty();

		/**
		 * The meta object literal for the '{@link general.impl.FolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.FolderImpl
		 * @see general.impl.GeneralPackageImpl#getFolder()
		 * @generated
		 */
		EClass FOLDER = eINSTANCE.getFolder();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOLDER__CHILDREN = eINSTANCE.getFolder_Children();

		/**
		 * The meta object literal for the '<em><b>Root Directory</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOLDER__ROOT_DIRECTORY = eINSTANCE.getFolder_RootDirectory();

		/**
		 * The meta object literal for the '{@link general.impl.FileTypeImpl <em>File Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.FileTypeImpl
		 * @see general.impl.GeneralPackageImpl#getFileType()
		 * @generated
		 */
		EClass FILE_TYPE = eINSTANCE.getFileType();

		/**
		 * The meta object literal for the '<em><b>File Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TYPE__FILE_TYPE_ID = eINSTANCE.getFileType_FileTypeId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TYPE__NAME = eINSTANCE.getFileType_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TYPE__DESCRIPTION = eINSTANCE.getFileType_Description();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TYPE__ICON = eINSTANCE.getFileType_Icon();

		/**
		 * The meta object literal for the '<em><b>Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TYPE__TOOL = eINSTANCE.getFileType_Tool();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_TYPE__USES = eINSTANCE.getFileType_Uses();

		/**
		 * The meta object literal for the '{@link general.impl.FileEndingImpl <em>File Ending</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.FileEndingImpl
		 * @see general.impl.GeneralPackageImpl#getFileEnding()
		 * @generated
		 */
		EClass FILE_ENDING = eINSTANCE.getFileEnding();

		/**
		 * The meta object literal for the '<em><b>File Ending Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ENDING__FILE_ENDING_ID = eINSTANCE.getFileEnding_FileEndingId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ENDING__NAME = eINSTANCE.getFileEnding_Name();

		/**
		 * The meta object literal for the '<em><b>Of Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_ENDING__OF_TYPE = eINSTANCE.getFileEnding_OfType();

		/**
		 * The meta object literal for the '{@link general.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.FunctionImpl
		 * @see general.impl.GeneralPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Function Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__FUNCTION_ID = eINSTANCE.getFunction_FunctionId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__CREATED = eINSTANCE.getFunction_Created();

		/**
		 * The meta object literal for the '<em><b>Overall Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__OVERALL_STATUS = eINSTANCE.getFunction_OverallStatus();

		/**
		 * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__MODIFIED = eINSTANCE.getFunction_Modified();

		/**
		 * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__DELETED = eINSTANCE.getFunction_Deleted();

		/**
		 * The meta object literal for the '<em><b>Responsible Files</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__RESPONSIBLE_FILES = eINSTANCE.getFunction_ResponsibleFiles();

		/**
		 * The meta object literal for the '<em><b>Held By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__HELD_BY = eINSTANCE.getFunction_HeldBy();

		/**
		 * The meta object literal for the '{@link general.impl.FilePropertyImpl <em>File Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.FilePropertyImpl
		 * @see general.impl.GeneralPackageImpl#getFileProperty()
		 * @generated
		 */
		EClass FILE_PROPERTY = eINSTANCE.getFileProperty();

		/**
		 * The meta object literal for the '<em><b>File Property Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PROPERTY__FILE_PROPERTY_ID = eINSTANCE.getFileProperty_FilePropertyId();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PROPERTY__REQUIRED = eINSTANCE.getFileProperty_Required();

		/**
		 * The meta object literal for the '<em><b>Up To Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PROPERTY__UP_TO_DATE = eINSTANCE.getFileProperty_UpToDate();

		/**
		 * The meta object literal for the '<em><b>Reviewed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PROPERTY__REVIEWED = eINSTANCE.getFileProperty_Reviewed();

		/**
		 * The meta object literal for the '<em><b>Configuration Management</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PROPERTY__CONFIGURATION_MANAGEMENT = eINSTANCE.getFileProperty_ConfigurationManagement();

		/**
		 * The meta object literal for the '<em><b>Rating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PROPERTY__RATING = eINSTANCE.getFileProperty_Rating();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_PROPERTY__COMMENT = eINSTANCE.getFileProperty_Comment();

		/**
		 * The meta object literal for the '<em><b>Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_PROPERTY__OF = eINSTANCE.getFileProperty_Of();

		/**
		 * The meta object literal for the '{@link general.impl.GeneralDocumentationFilePropertyImpl <em>Documentation File Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.GeneralDocumentationFilePropertyImpl
		 * @see general.impl.GeneralPackageImpl#getGeneralDocumentationFileProperty()
		 * @generated
		 */
		EClass GENERAL_DOCUMENTATION_FILE_PROPERTY = eINSTANCE.getGeneralDocumentationFileProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERAL_DOCUMENTATION_FILE_PROPERTY__TYPE = eINSTANCE.getGeneralDocumentationFileProperty_Type();

		/**
		 * The meta object literal for the '{@link general.impl.GenericFunctionSRSFilePropertyImpl <em>Generic Function SRS File Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.GenericFunctionSRSFilePropertyImpl
		 * @see general.impl.GeneralPackageImpl#getGenericFunctionSRSFileProperty()
		 * @generated
		 */
		EClass GENERIC_FUNCTION_SRS_FILE_PROPERTY = eINSTANCE.getGenericFunctionSRSFileProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_FUNCTION_SRS_FILE_PROPERTY__TYPE = eINSTANCE.getGenericFunctionSRSFileProperty_Type();

		/**
		 * The meta object literal for the '{@link general.impl.SystemComponentLevelDocumentationFilePropertyImpl <em>System Component Level Documentation File Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.SystemComponentLevelDocumentationFilePropertyImpl
		 * @see general.impl.GeneralPackageImpl#getSystemComponentLevelDocumentationFileProperty()
		 * @generated
		 */
		EClass SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY = eINSTANCE.getSystemComponentLevelDocumentationFileProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__TYPE = eINSTANCE.getSystemComponentLevelDocumentationFileProperty_Type();

		/**
		 * The meta object literal for the '{@link general.impl.GeneralDocumentationTypeImpl <em>Documentation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.GeneralDocumentationTypeImpl
		 * @see general.impl.GeneralPackageImpl#getGeneralDocumentationType()
		 * @generated
		 */
		EClass GENERAL_DOCUMENTATION_TYPE = eINSTANCE.getGeneralDocumentationType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERAL_DOCUMENTATION_TYPE__NAME = eINSTANCE.getGeneralDocumentationType_Name();

		/**
		 * The meta object literal for the '{@link general.impl.GenericFunctionSRSTypeImpl <em>Generic Function SRS Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.GenericFunctionSRSTypeImpl
		 * @see general.impl.GeneralPackageImpl#getGenericFunctionSRSType()
		 * @generated
		 */
		EClass GENERIC_FUNCTION_SRS_TYPE = eINSTANCE.getGenericFunctionSRSType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_FUNCTION_SRS_TYPE__NAME = eINSTANCE.getGenericFunctionSRSType_Name();

		/**
		 * The meta object literal for the '{@link general.impl.SystemComponentLevelDocumentationImpl <em>System Component Level Documentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.SystemComponentLevelDocumentationImpl
		 * @see general.impl.GeneralPackageImpl#getSystemComponentLevelDocumentation()
		 * @generated
		 */
		EClass SYSTEM_COMPONENT_LEVEL_DOCUMENTATION = eINSTANCE.getSystemComponentLevelDocumentation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_COMPONENT_LEVEL_DOCUMENTATION__NAME = eINSTANCE.getSystemComponentLevelDocumentation_Name();

		/**
		 * The meta object literal for the '{@link general.impl.UserListImpl <em>User List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.UserListImpl
		 * @see general.impl.GeneralPackageImpl#getUserList()
		 * @generated
		 */
		EClass USER_LIST = eINSTANCE.getUserList();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_LIST__USERS = eINSTANCE.getUserList_Users();

		/**
		 * The meta object literal for the '{@link general.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.TaskImpl
		 * @see general.impl.GeneralPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Task Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__TASK_ID = eINSTANCE.getTask_TaskId();

		/**
		 * The meta object literal for the '<em><b>Finished</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__FINISHED = eINSTANCE.getTask_Finished();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__DESCRIPTION = eINSTANCE.getTask_Description();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__CREATED = eINSTANCE.getTask_Created();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__OWNER = eINSTANCE.getTask_Owner();

		/**
		 * The meta object literal for the '{@link general.EventType <em>Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.EventType
		 * @see general.impl.GeneralPackageImpl#getEventType()
		 * @generated
		 */
		EEnum EVENT_TYPE = eINSTANCE.getEventType();

		/**
		 * The meta object literal for the '{@link general.ConnectionType <em>Connection Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.ConnectionType
		 * @see general.impl.GeneralPackageImpl#getConnectionType()
		 * @generated
		 */
		EEnum CONNECTION_TYPE = eINSTANCE.getConnectionType();

		/**
		 * The meta object literal for the '{@link general.QualityCriteria <em>Quality Criteria</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.QualityCriteria
		 * @see general.impl.GeneralPackageImpl#getQualityCriteria()
		 * @generated
		 */
		EEnum QUALITY_CRITERIA = eINSTANCE.getQualityCriteria();

		/**
		 * The meta object literal for the '<em>Date</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Date
		 * @see general.impl.GeneralPackageImpl#getDate()
		 * @generated
		 */
		EDataType DATE = eINSTANCE.getDate();

		/**
		 * The meta object literal for the '<em>Image</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.Image
		 * @see general.impl.GeneralPackageImpl#getImage()
		 * @generated
		 */
		EDataType IMAGE = eINSTANCE.getImage();

	}

} //GeneralPackage
