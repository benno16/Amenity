/**
 */
package dao;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getSnapshotDao()
 * @model
 * @generated
 */
public interface SnapshotDao extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false"
	 * @generated
	 */
	List getListByContainer(String containerId);

} // SnapshotDao
