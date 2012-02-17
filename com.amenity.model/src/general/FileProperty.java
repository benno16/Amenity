/**
 */
package general;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.FileProperty#getFilePropertyId <em>File Property Id</em>}</li>
 *   <li>{@link general.FileProperty#isRequired <em>Required</em>}</li>
 *   <li>{@link general.FileProperty#getUpToDate <em>Up To Date</em>}</li>
 *   <li>{@link general.FileProperty#getReviewed <em>Reviewed</em>}</li>
 *   <li>{@link general.FileProperty#getConfigurationManagement <em>Configuration Management</em>}</li>
 *   <li>{@link general.FileProperty#getRating <em>Rating</em>}</li>
 *   <li>{@link general.FileProperty#getComment <em>Comment</em>}</li>
 *   <li>{@link general.FileProperty#getOf <em>Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getFileProperty()
 * @model
 * @generated
 */
public interface FileProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>File Property Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Property Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Property Id</em>' attribute.
	 * @see #isSetFilePropertyId()
	 * @see #unsetFilePropertyId()
	 * @see #setFilePropertyId(String)
	 * @see general.GeneralPackage#getFileProperty_FilePropertyId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getFilePropertyId();

	/**
	 * Sets the value of the '{@link general.FileProperty#getFilePropertyId <em>File Property Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Property Id</em>' attribute.
	 * @see #isSetFilePropertyId()
	 * @see #unsetFilePropertyId()
	 * @see #getFilePropertyId()
	 * @generated
	 */
	void setFilePropertyId(String value);

	/**
	 * Unsets the value of the '{@link general.FileProperty#getFilePropertyId <em>File Property Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFilePropertyId()
	 * @see #getFilePropertyId()
	 * @see #setFilePropertyId(String)
	 * @generated
	 */
	void unsetFilePropertyId();

	/**
	 * Returns whether the value of the '{@link general.FileProperty#getFilePropertyId <em>File Property Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>File Property Id</em>' attribute is set.
	 * @see #unsetFilePropertyId()
	 * @see #getFilePropertyId()
	 * @see #setFilePropertyId(String)
	 * @generated
	 */
	boolean isSetFilePropertyId();

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see general.GeneralPackage#getFileProperty_Required()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link general.FileProperty#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Up To Date</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link general.QualityCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Up To Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Up To Date</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #setUpToDate(QualityCriteria)
	 * @see general.GeneralPackage#getFileProperty_UpToDate()
	 * @model default="" required="true"
	 * @generated
	 */
	QualityCriteria getUpToDate();

	/**
	 * Sets the value of the '{@link general.FileProperty#getUpToDate <em>Up To Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Up To Date</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #getUpToDate()
	 * @generated
	 */
	void setUpToDate(QualityCriteria value);

	/**
	 * Returns the value of the '<em><b>Reviewed</b></em>' attribute.
	 * The literals are from the enumeration {@link general.QualityCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reviewed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reviewed</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #setReviewed(QualityCriteria)
	 * @see general.GeneralPackage#getFileProperty_Reviewed()
	 * @model required="true"
	 * @generated
	 */
	QualityCriteria getReviewed();

	/**
	 * Sets the value of the '{@link general.FileProperty#getReviewed <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reviewed</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #getReviewed()
	 * @generated
	 */
	void setReviewed(QualityCriteria value);

	/**
	 * Returns the value of the '<em><b>Configuration Management</b></em>' attribute.
	 * The literals are from the enumeration {@link general.QualityCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Management</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Management</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #setConfigurationManagement(QualityCriteria)
	 * @see general.GeneralPackage#getFileProperty_ConfigurationManagement()
	 * @model required="true"
	 * @generated
	 */
	QualityCriteria getConfigurationManagement();

	/**
	 * Sets the value of the '{@link general.FileProperty#getConfigurationManagement <em>Configuration Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Management</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #getConfigurationManagement()
	 * @generated
	 */
	void setConfigurationManagement(QualityCriteria value);

	/**
	 * Returns the value of the '<em><b>Rating</b></em>' attribute.
	 * The literals are from the enumeration {@link general.QualityCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rating</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #setRating(QualityCriteria)
	 * @see general.GeneralPackage#getFileProperty_Rating()
	 * @model required="true"
	 * @generated
	 */
	QualityCriteria getRating();

	/**
	 * Sets the value of the '{@link general.FileProperty#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #getRating()
	 * @generated
	 */
	void setRating(QualityCriteria value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see general.GeneralPackage#getFileProperty_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link general.FileProperty#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Of</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link general.File#getHasProperty <em>Has Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of</em>' reference.
	 * @see #setOf(File)
	 * @see general.GeneralPackage#getFileProperty_Of()
	 * @see general.File#getHasProperty
	 * @model opposite="hasProperty"
	 * @generated
	 */
	File getOf();

	/**
	 * Sets the value of the '{@link general.FileProperty#getOf <em>Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Of</em>' reference.
	 * @see #getOf()
	 * @generated
	 */
	void setOf(File value);

} // FileProperty
