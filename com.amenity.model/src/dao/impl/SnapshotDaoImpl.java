/**
 */
package dao.impl;

import dao.ConnectionDao;
import dao.DaoFactory;
import dao.DaoPackage;
import dao.SnapshotDao;
import general.Connection;
import general.Container;
import general.Snapshot;

import java.util.ArrayList;
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
	 * 
	 * select * from "snapshot" s 
	inner join "connection" c on s."connection_via_connectionid" = c."connectionid"
	where c."container_partof_containerid" = 'c0eb818d-f530-43e9-b309-8ef1b7c81868'
	 */
	@SuppressWarnings("unchecked")
	public List<Snapshot> getListByContainer(Container container) {
		ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();

		List<Connection> tempConnections = connectionDao.getListByContainer(container);
		
		session = getSession();
		session.beginTransaction();
		/**
		 * TODO: solve this with inner join... not working for some reason
		 */
		
		List<Snapshot> resList = new ArrayList<Snapshot>();
		for ( Connection c : tempConnections ) {
			Query queryRes = session.createQuery("from " + Snapshot.class.getName().toString() + 
					" where via = '" + c.getConnectionId() + "'");
			resList.addAll(queryRes.list());
		}
		
		
		session.close();
		return resList;
	}
	
	@Override
	public Object getById(String id) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + Snapshot.class.getName().toString() + 
				" where snapshotId='" + id + "'");

		@SuppressWarnings("unchecked")
		List<Snapshot> snapshots = queryRes.list();
		session.close();
		
		if ( snapshots == null || snapshots.size() == 0 ) {
			return null;
		}else if ( snapshots.size() == 1) {
			return snapshots.get(0);
		} else {
			System.out.println("multiple entries found");
			return null;
		}
	}

} //SnapshotDaoImpl
