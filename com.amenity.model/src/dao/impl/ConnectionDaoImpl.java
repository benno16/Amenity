/**
 */
package dao.impl;

import dao.ConnectionDao;
import dao.DaoPackage;

import general.Connection;
import general.Container;
import general.User;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConnectionDaoImpl extends GenericDaoImpl implements ConnectionDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.CONNECTION_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String findMksPassword(User user) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //ConnectionDaoImpl
