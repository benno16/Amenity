/**
 */
package dao.impl;

import general.User;

import java.util.List;

import dao.ContainerDao;
import dao.DaoPackage;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ContainerDaoImpl extends GenericDaoImpl implements ContainerDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerDaoImpl() {
		super();
	}
	
	@Override
	public List<?> getListByOwner(Class<?> class_, User user) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + class_.getName().toString() + 
				" where owner = '" + user.getUserId() + "'";
		Query queryRes = session.createQuery(string);
		System.out.println("amount of containers: " + queryRes.list().size() );
		return queryRes.list();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.CONTAINER_DAO;
	}

} //ContainerDaoImpl
