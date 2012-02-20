/**
 */
package dao;

import general.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getConnectionDao()
 * @model
 * @generated
 */
public interface ConnectionDao extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model userDataType="dao.User"
	 * @generated
	 */
	String findMksPassword(User user);

} // ConnectionDao
