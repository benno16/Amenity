/**
 */
package dao.impl;

import dao.DaoPackage;
import dao.SnapshotDao;
import general.Snapshot;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Snapshot Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SnapshotDaoImpl extends GenericDaoImpl implements SnapshotDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnapshotDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.SNAPSHOT_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public List<Snapshot> getListByContainer(String containerId) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + Snapshot.class.getName().toString() + 
				" where partOf = '" + containerId + "'";
		Query queryRes = session.createQuery(string);
		System.out.println("amount of containers: " + queryRes.list().size() );
		List<Snapshot> resList = queryRes.list();
		session.close();
		return resList;
	}

} //SnapshotDaoImpl
