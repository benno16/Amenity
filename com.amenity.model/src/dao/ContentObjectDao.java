/**
 */
package dao;

import general.Snapshot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Object Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getContentObjectDao()
 * @model
 * @generated
 */
public interface ContentObjectDao extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	List getListBySnapshot(Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	void deleteListBySnapshot(Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	List getChildren(Object parent, Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object addFunctionToCo(Object function, Object contentObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	List getObjectsOfFunction(Object function, Snapshot snapshot);

} // ContentObjectDao
