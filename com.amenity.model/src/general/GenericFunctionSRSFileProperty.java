/**
 */
package general;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Function SRS File Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.GenericFunctionSRSFileProperty#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getGenericFunctionSRSFileProperty()
 * @model
 * @generated
 */
public interface GenericFunctionSRSFileProperty extends FileProperty {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference list.
	 * The list contents are of type {@link general.GenericFunctionSRSType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference list.
	 * @see general.GeneralPackage#getGenericFunctionSRSFileProperty_Type()
	 * @model
	 * @generated
	 */
	EList<GenericFunctionSRSType> getType();

} // GenericFunctionSRSFileProperty
