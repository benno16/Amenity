/**
 */
package general;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see general.GeneralPackage
 * @generated
 */
public interface GeneralFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneralFactory eINSTANCE = general.impl.GeneralFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Source</em>'.
	 * @generated
	 */
	DataSource createDataSource();

	/**
	 * Returns a new object of class '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection</em>'.
	 * @generated
	 */
	Connection createConnection();

	/**
	 * Returns a new object of class '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container</em>'.
	 * @generated
	 */
	Container createContainer();

	/**
	 * Returns a new object of class '<em>Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshot</em>'.
	 * @generated
	 */
	Snapshot createSnapshot();

	/**
	 * Returns a new object of class '<em>Content Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content Object</em>'.
	 * @generated
	 */
	ContentObject createContentObject();

	/**
	 * Returns a new object of class '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File</em>'.
	 * @generated
	 */
	File createFile();

	/**
	 * Returns a new object of class '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder</em>'.
	 * @generated
	 */
	Folder createFolder();

	/**
	 * Returns a new object of class '<em>File Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Type</em>'.
	 * @generated
	 */
	FileType createFileType();

	/**
	 * Returns a new object of class '<em>File Ending</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Ending</em>'.
	 * @generated
	 */
	FileEnding createFileEnding();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>File Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Property</em>'.
	 * @generated
	 */
	FileProperty createFileProperty();

	/**
	 * Returns a new object of class '<em>Documentation File Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation File Property</em>'.
	 * @generated
	 */
	GeneralDocumentationFileProperty createGeneralDocumentationFileProperty();

	/**
	 * Returns a new object of class '<em>Generic Function SRS File Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Function SRS File Property</em>'.
	 * @generated
	 */
	GenericFunctionSRSFileProperty createGenericFunctionSRSFileProperty();

	/**
	 * Returns a new object of class '<em>System Component Level Documentation File Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Component Level Documentation File Property</em>'.
	 * @generated
	 */
	SystemComponentLevelDocumentationFileProperty createSystemComponentLevelDocumentationFileProperty();

	/**
	 * Returns a new object of class '<em>Documentation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation Type</em>'.
	 * @generated
	 */
	GeneralDocumentationType createGeneralDocumentationType();

	/**
	 * Returns a new object of class '<em>Generic Function SRS Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Function SRS Type</em>'.
	 * @generated
	 */
	GenericFunctionSRSType createGenericFunctionSRSType();

	/**
	 * Returns a new object of class '<em>System Component Level Documentation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Component Level Documentation</em>'.
	 * @generated
	 */
	SystemComponentLevelDocumentation createSystemComponentLevelDocumentation();

	/**
	 * Returns a new object of class '<em>User List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User List</em>'.
	 * @generated
	 */
	UserList createUserList();

	/**
	 * Returns a new object of class '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task</em>'.
	 * @generated
	 */
	Task createTask();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GeneralPackage getGeneralPackage();

} //GeneralFactory
