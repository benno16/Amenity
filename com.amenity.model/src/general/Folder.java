/**
 */
package general;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Folder#getChildren <em>Children</em>}</li>
 *   <li>{@link general.Folder#getRootDirectory <em>Root Directory</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getFolder()
 * @model
 * @generated
 */
public interface Folder extends ContentObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link general.File}.
	 * It is bidirectional and its opposite is '{@link general.File#getRootDir <em>Root Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see general.GeneralPackage#getFolder_Children()
	 * @see general.File#getRootDir
	 * @model opposite="rootDir"
	 * @generated
	 */
	EList<File> getChildren();

	/**
	 * Returns the value of the '<em><b>Root Directory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Directory</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Directory</em>' reference.
	 * @see #setRootDirectory(Folder)
	 * @see general.GeneralPackage#getFolder_RootDirectory()
	 * @model
	 * @generated
	 */
	Folder getRootDirectory();

	/**
	 * Sets the value of the '{@link general.Folder#getRootDirectory <em>Root Directory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Directory</em>' reference.
	 * @see #getRootDirectory()
	 * @generated
	 */
	void setRootDirectory(Folder value);

} // Folder
