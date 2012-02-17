/**
 */
package general;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.File#getObjectName <em>Object Name</em>}</li>
 *   <li>{@link general.File#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link general.File#getStatus <em>Status</em>}</li>
 *   <li>{@link general.File#getRootDir <em>Root Dir</em>}</li>
 *   <li>{@link general.File#getOfType <em>Of Type</em>}</li>
 *   <li>{@link general.File#getHasProperty <em>Has Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getFile()
 * @model
 * @generated
 */
public interface File extends ContentObject {
	/**
	 * Returns the value of the '<em><b>Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Name</em>' attribute.
	 * @see #setObjectName(String)
	 * @see general.GeneralPackage#getFile_ObjectName()
	 * @model
	 * @generated
	 */
	String getObjectName();

	/**
	 * Sets the value of the '{@link general.File#getObjectName <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Name</em>' attribute.
	 * @see #getObjectName()
	 * @generated
	 */
	void setObjectName(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see general.GeneralPackage#getFile_CreationDate()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '{@link general.File#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(String)
	 * @see general.GeneralPackage#getFile_Status()
	 * @model
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link general.File#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Returns the value of the '<em><b>Root Dir</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link general.Folder#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Dir</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Dir</em>' reference.
	 * @see #setRootDir(Folder)
	 * @see general.GeneralPackage#getFile_RootDir()
	 * @see general.Folder#getChildren
	 * @model opposite="children" required="true"
	 * @generated
	 */
	Folder getRootDir();

	/**
	 * Sets the value of the '{@link general.File#getRootDir <em>Root Dir</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Dir</em>' reference.
	 * @see #getRootDir()
	 * @generated
	 */
	void setRootDir(Folder value);

	/**
	 * Returns the value of the '<em><b>Of Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Type</em>' reference.
	 * @see #setOfType(FileType)
	 * @see general.GeneralPackage#getFile_OfType()
	 * @model required="true"
	 * @generated
	 */
	FileType getOfType();

	/**
	 * Sets the value of the '{@link general.File#getOfType <em>Of Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Of Type</em>' reference.
	 * @see #getOfType()
	 * @generated
	 */
	void setOfType(FileType value);

	/**
	 * Returns the value of the '<em><b>Has Property</b></em>' reference list.
	 * The list contents are of type {@link general.FileProperty}.
	 * It is bidirectional and its opposite is '{@link general.FileProperty#getOf <em>Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Property</em>' reference list.
	 * @see general.GeneralPackage#getFile_HasProperty()
	 * @see general.FileProperty#getOf
	 * @model opposite="of"
	 * @generated
	 */
	EList<FileProperty> getHasProperty();

} // File
