/**
 */
package general;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Container#getContainerId <em>Container Id</em>}</li>
 *   <li>{@link general.Container#getName <em>Name</em>}</li>
 *   <li>{@link general.Container#getCreated <em>Created</em>}</li>
 *   <li>{@link general.Container#getModified <em>Modified</em>}</li>
 *   <li>{@link general.Container#getAddInfo1 <em>Add Info1</em>}</li>
 *   <li>{@link general.Container#getAddInfo2 <em>Add Info2</em>}</li>
 *   <li>{@link general.Container#getAddInfo3 <em>Add Info3</em>}</li>
 *   <li>{@link general.Container#getOwner <em>Owner</em>}</li>
 *   <li>{@link general.Container#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.Container#getOwnerId <em>Owner Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Container Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Id</em>' attribute.
	 * @see #setContainerId(String)
	 * @see general.GeneralPackage#getContainer_ContainerId()
	 * @model required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getContainerId();

	/**
	 * Sets the value of the '{@link general.Container#getContainerId <em>Container Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Id</em>' attribute.
	 * @see #getContainerId()
	 * @generated
	 */
	void setContainerId(String value);

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
	 * @see general.GeneralPackage#getContainer_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.Container#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see general.GeneralPackage#getContainer_Created()
	 * @model dataType="general.Date" required="true"
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link general.Container#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' attribute.
	 * @see #setModified(Date)
	 * @see general.GeneralPackage#getContainer_Modified()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getModified();

	/**
	 * Sets the value of the '{@link general.Container#getModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #getModified()
	 * @generated
	 */
	void setModified(Date value);

	/**
	 * Returns the value of the '<em><b>Add Info1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info1</em>' attribute.
	 * @see #setAddInfo1(String)
	 * @see general.GeneralPackage#getContainer_AddInfo1()
	 * @model
	 * @generated
	 */
	String getAddInfo1();

	/**
	 * Sets the value of the '{@link general.Container#getAddInfo1 <em>Add Info1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info1</em>' attribute.
	 * @see #getAddInfo1()
	 * @generated
	 */
	void setAddInfo1(String value);

	/**
	 * Returns the value of the '<em><b>Add Info2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info2</em>' attribute.
	 * @see #setAddInfo2(String)
	 * @see general.GeneralPackage#getContainer_AddInfo2()
	 * @model
	 * @generated
	 */
	String getAddInfo2();

	/**
	 * Sets the value of the '{@link general.Container#getAddInfo2 <em>Add Info2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info2</em>' attribute.
	 * @see #getAddInfo2()
	 * @generated
	 */
	void setAddInfo2(String value);

	/**
	 * Returns the value of the '<em><b>Add Info3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info3</em>' attribute.
	 * @see #setAddInfo3(String)
	 * @see general.GeneralPackage#getContainer_AddInfo3()
	 * @model
	 * @generated
	 */
	String getAddInfo3();

	/**
	 * Sets the value of the '{@link general.Container#getAddInfo3 <em>Add Info3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info3</em>' attribute.
	 * @see #getAddInfo3()
	 * @generated
	 */
	void setAddInfo3(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(User)
	 * @see general.GeneralPackage#getContainer_Owner()
	 * @model
	 * @generated
	 */
	User getOwner();

	/**
	 * Sets the value of the '{@link general.Container#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(User value);

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
	 * @see general.GeneralPackage#getContainer_Deleted()
	 * @model
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link general.Container#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted</em>' attribute.
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

	/**
	 * Returns the value of the '<em><b>Owner Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Id</em>' attribute.
	 * @see #setOwnerId(String)
	 * @see general.GeneralPackage#getContainer_OwnerId()
	 * @model
	 * @generated
	 */
	String getOwnerId();

	/**
	 * Sets the value of the '{@link general.Container#getOwnerId <em>Owner Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Id</em>' attribute.
	 * @see #getOwnerId()
	 * @generated
	 */
	void setOwnerId(String value);

} // Container
