/**
 */
package dao.impl;

import dao.ContentObjectDao;
import dao.DaoPackage;

import general.ContentObject;
import general.Folder;
import general.Function;
import general.Snapshot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content Object Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ContentObjectDaoImpl extends GenericDaoImpl implements ContentObjectDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentObjectDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.CONTENT_OBJECT_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getListBySnapshot(Snapshot snapshot) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void deleteListBySnapshot(Snapshot snapshot) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}


	@Override
	public Object getById(String id) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + ContentObject.class.getName().toString() + 
				" where objectId='" + id + "'");

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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT 
	 */
	@SuppressWarnings("unchecked")
	public List<ContentObject> getChildren(Object parent, Snapshot snapshot) {
		if ( !(parent instanceof Folder) ) {
			return null;
		}
		Folder folder = (Folder)parent;
		session = getSession();
		
		session.beginTransaction();
		Query queryRes = session.createQuery("from " +
				ContentObject.class.getName().toString() + " where partOf = '" +
				snapshot.getSnapshotId() + "' and rootDir = '"+
				folder.getObjectId() + "' or rootDirectory = '" + folder.getObjectId() + "'");

		List<ContentObject> returnList = queryRes.list();
		session.close();
		
		return returnList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object addFunctionToCo(Object function, Object contentObject) {
		session = getSession();
		session.beginTransaction();
		session.flush();
		Query queryRes = session.createQuery("from " + ContentObject.class.getName().toString() + 
				" where objectId='" + ((ContentObject)contentObject).getObjectId() + "'");
		ContentObject co = (ContentObject)queryRes.list().get(0);
		co.getFunction().add((Function)function);
		session.update(co);
		session.flush();
		session.close();
		return co;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List getObjectsOfFunction(Object function, Snapshot snapshot) {
		session = getSession();
		
		session.beginTransaction();
		
		session.load(function, ((Function)function).getFunctionId());
		
		String string = "from " + ContentObject.class.getName().toString() + 
				" where partOf = '" + snapshot.getSnapshotId() + "'";
		
		Query queryRes = session.createQuery(string);
		
		List<ContentObject> cos = queryRes.list();

		List<ContentObject> returnCos = new ArrayList<ContentObject>();
		// lazy loading requires the session to still be open
		for ( ContentObject co : cos ) {
			if ( co.getFunction().size() > 0 ) {
				if ( co.getFunction().contains(function) ) {
					returnCos.add(co);
				}
			}
		}
		session.flush();
		session.close();
		
		return returnCos;
	}

} //ContentObjectDaoImpl
