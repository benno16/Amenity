/**
 */
package general;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Component Level Documentation File Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.SystemComponentLevelDocumentationFileProperty#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getSystemComponentLevelDocumentationFileProperty()
 * @model
 * @generated
 */
public interface SystemComponentLevelDocumentationFileProperty extends FileProperty {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference list.
	 * The list contents are of type {@link general.SystemComponentLevelDocumentation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference list.
	 * @see general.GeneralPackage#getSystemComponentLevelDocumentationFileProperty_Type()
	 * @model
	 * @generated
	 */
	EList<SystemComponentLevelDocumentation> getType();

} // SystemComponentLevelDocumentationFileProperty
