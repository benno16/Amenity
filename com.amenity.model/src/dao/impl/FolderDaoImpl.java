/**
 */
package dao.impl;

import general.Folder;

import general.Snapshot;
import java.util.ArrayList;
import java.util.List;

import dao.DaoPackage;
import dao.FolderDao;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Folder Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FolderDaoImpl extends GenericDaoImpl implements FolderDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FolderDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.FOLDER_DAO;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Folder getRootFolderBySnapshot(Snapshot snapshot) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + Folder.class.getName().toString() + 
				" where partOf = '" + snapshot.getSnapshotId() + "'" +
				" order by level ";
		Query queryRes = session.createQuery(string);
		List<?> resultList = queryRes.list();
		session.close();
		if ( resultList.size() > 0 )
			return (Folder)resultList.get(0);
		return null;
	}

	@Override
	public boolean massInsert(List list, Class<?> class_) {
		session = getSession();
		Transaction tx = session.beginTransaction();
		try {
			list = (ArrayList<Folder>) list;
		} catch (Exception e) {
			return false;
		}
		int i = 0;
		for ( Folder f : (ArrayList<Folder>) list ) {
			session.save(f);
			if ( i % 1000 == 0 ) {
				session.flush();
				session.clear();
			}
			i++;
		}
		System.out.println("-amount of inserted objects: " + i );
		try {
			tx.commit();
			session.close();
			return true;
		} catch ( Exception e ) {
			tx.rollback();
			session.close();
			return false;
		}
	}

} //FolderDaoImpl
