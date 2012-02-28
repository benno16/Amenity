/**
 */
package general;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Snapshot#getSnapshotId <em>Snapshot Id</em>}</li>
 *   <li>{@link general.Snapshot#getCreated <em>Created</em>}</li>
 *   <li>{@link general.Snapshot#getName <em>Name</em>}</li>
 *   <li>{@link general.Snapshot#getComment <em>Comment</em>}</li>
 *   <li>{@link general.Snapshot#getPartOf <em>Part Of</em>}</li>
 *   <li>{@link general.Snapshot#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.Snapshot#getStores <em>Stores</em>}</li>
 *   <li>{@link general.Snapshot#getFunctions <em>Functions</em>}</li>
 *   <li>{@link general.Snapshot#getGeneral <em>General</em>}</li>
 *   <li>{@link general.Snapshot#getSystemComponent <em>System Component</em>}</li>
 *   <li>{@link general.Snapshot#getDetailedProperties <em>Detailed Properties</em>}</li>
 *   <li>{@link general.Snapshot#getGeneralProperties <em>General Properties</em>}</li>
 *   <li>{@link general.Snapshot#getVia <em>Via</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getSnapshot()
 * @model annotation="teneo.jpa value='@OnDelete(action = OnDeleteAction.CASCADE)'"
 * @generated
 */
public interface Snapshot extends EObject {
	/**
	 * Returns the value of the '<em><b>Snapshot Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot Id</em>' attribute.
	 * @see #setSnapshotId(String)
	 * @see general.GeneralPackage#getSnapshot_SnapshotId()
	 * @model required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getSnapshotId();

	/**
	 * Sets the value of the '{@link general.Snapshot#getSnapshotId <em>Snapshot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot Id</em>' attribute.
	 * @see #getSnapshotId()
	 * @generated
	 */
	void setSnapshotId(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see general.GeneralPackage#getSnapshot_Created()
	 * @model dataType="general.Date" required="true"
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link general.Snapshot#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

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
	 * @see general.GeneralPackage#getSnapshot_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.Snapshot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see general.GeneralPackage#getSnapshot_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link general.Snapshot#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of</em>' reference.
	 * @see #setPartOf(Container)
	 * @see general.GeneralPackage#getSnapshot_PartOf()
	 * @model required="true"
	 *        annotation="teneo.jpa value='@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})'"
	 * @generated
	 */
	Container getPartOf();

	/**
	 * Sets the value of the '{@link general.Snapshot#getPartOf <em>Part Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Of</em>' reference.
	 * @see #getPartOf()
	 * @generated
	 */
	void setPartOf(Container value);

	/**
	 * Returns the value of the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted</em>' attribute.
	 * @see #setDeleted(boolean)
	 * @see general.GeneralPackage#getSnapshot_Deleted()
	 * @model
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link general.Snapshot#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted</em>' attribute.
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

	/**
	 * Returns the value of the '<em><b>Stores</b></em>' reference list.
	 * The list contents are of type {@link general.ContentObject}.
	 * It is bidirectional and its opposite is '{@link general.ContentObject#getPartOf <em>Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stores</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stores</em>' reference list.
	 * @see general.GeneralPackage#getSnapshot_Stores()
	 * @see general.ContentObject#getPartOf
	 * @model opposite="partOf"
	 * @generated
	 */
	EList<ContentObject> getStores();

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' reference list.
	 * The list contents are of type {@link general.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' reference list.
	 * @see general.GeneralPackage#getSnapshot_Functions()
	 * @model
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference.
	 * @see #setGeneral(GeneralDocumentationFileProperty)
	 * @see general.GeneralPackage#getSnapshot_General()
	 * @model
	 * @generated
	 */
	GeneralDocumentationFileProperty getGeneral();

	/**
	 * Sets the value of the '{@link general.Snapshot#getGeneral <em>General</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General</em>' reference.
	 * @see #getGeneral()
	 * @generated
	 */
	void setGeneral(GeneralDocumentationFileProperty value);

	/**
	 * Returns the value of the '<em><b>System Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Component</em>' reference.
	 * @see #setSystemComponent(SystemComponentLevelDocumentationFileProperty)
	 * @see general.GeneralPackage#getSnapshot_SystemComponent()
	 * @model
	 * @generated
	 */
	SystemComponentLevelDocumentationFileProperty getSystemComponent();

	/**
	 * Sets the value of the '{@link general.Snapshot#getSystemComponent <em>System Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Component</em>' reference.
	 * @see #getSystemComponent()
	 * @generated
	 */
	void setSystemComponent(SystemComponentLevelDocumentationFileProperty value);

	/**
	 * Returns the value of the '<em><b>Detailed Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailed Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailed Properties</em>' containment reference.
	 * @see #setDetailedProperties(SystemComponentLevelDocumentationFileProperty)
	 * @see general.GeneralPackage#getSnapshot_DetailedProperties()
	 * @model containment="true"
	 * @generated
	 */
	SystemComponentLevelDocumentationFileProperty getDetailedProperties();

	/**
	 * Sets the value of the '{@link general.Snapshot#getDetailedProperties <em>Detailed Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detailed Properties</em>' containment reference.
	 * @see #getDetailedProperties()
	 * @generated
	 */
	void setDetailedProperties(SystemComponentLevelDocumentationFileProperty value);

	/**
	 * Returns the value of the '<em><b>General Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Properties</em>' containment reference.
	 * @see #setGeneralProperties(GeneralDocumentationFileProperty)
	 * @see general.GeneralPackage#getSnapshot_GeneralProperties()
	 * @model containment="true"
	 * @generated
	 */
	GeneralDocumentationFileProperty getGeneralProperties();

	/**
	 * Sets the value of the '{@link general.Snapshot#getGeneralProperties <em>General Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Properties</em>' containment reference.
	 * @see #getGeneralProperties()
	 * @generated
	 */
	void setGeneralProperties(GeneralDocumentationFileProperty value);

	/**
	 * Returns the value of the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Via</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Via</em>' reference.
	 * @see #setVia(Connection)
	 * @see general.GeneralPackage#getSnapshot_Via()
	 * @model
	 * @generated
	 */
	Connection getVia();

	/**
	 * Sets the value of the '{@link general.Snapshot#getVia <em>Via</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Via</em>' reference.
	 * @see #getVia()
	 * @generated
	 */
	void setVia(Connection value);

} // Snapshot
