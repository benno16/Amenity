/**
 */
package general;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Ending</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.FileEnding#getFileEndingId <em>File Ending Id</em>}</li>
 *   <li>{@link general.FileEnding#getName <em>Name</em>}</li>
 *   <li>{@link general.FileEnding#getOfType <em>Of Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getFileEnding()
 * @model
 * @generated
 */
public interface FileEnding extends EObject {
	/**
	 * Returns the value of the '<em><b>File Ending Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Ending Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Ending Id</em>' attribute.
	 * @see #isSetFileEndingId()
	 * @see #unsetFileEndingId()
	 * @see #setFileEndingId(String)
	 * @see general.GeneralPackage#getFileEnding_FileEndingId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getFileEndingId();

	/**
	 * Sets the value of the '{@link general.FileEnding#getFileEndingId <em>File Ending Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Ending Id</em>' attribute.
	 * @see #isSetFileEndingId()
	 * @see #unsetFileEndingId()
	 * @see #getFileEndingId()
	 * @generated
	 */
	void setFileEndingId(String value);

	/**
	 * Unsets the value of the '{@link general.FileEnding#getFileEndingId <em>File Ending Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFileEndingId()
	 * @see #getFileEndingId()
	 * @see #setFileEndingId(String)
	 * @generated
	 */
	void unsetFileEndingId();

	/**
	 * Returns whether the value of the '{@link general.FileEnding#getFileEndingId <em>File Ending Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>File Ending Id</em>' attribute is set.
	 * @see #unsetFileEndingId()
	 * @see #getFileEndingId()
	 * @see #setFileEndingId(String)
	 * @generated
	 */
	boolean isSetFileEndingId();

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
	 * @see general.GeneralPackage#getFileEnding_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.FileEnding#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Of Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link general.FileType#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Type</em>' reference.
	 * @see #setOfType(FileType)
	 * @see general.GeneralPackage#getFileEnding_OfType()
	 * @see general.FileType#getUses
	 * @model opposite="uses" required="true"
	 * @generated
	 */
	FileType getOfType();

	/**
	 * Sets the value of the '{@link general.FileEnding#getOfType <em>Of Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Of Type</em>' reference.
	 * @see #getOfType()
	 * @generated
	 */
	void setOfType(FileType value);

} // FileEnding
