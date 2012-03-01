/**
 */
package dao.impl;

import dao.ContentObjectDao;
import dao.DaoPackage;

import general.ContentObject;
import general.Folder;
import general.Snapshot;

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT 
	 */
	@SuppressWarnings("unchecked")
	public List<?> getChildren(Object parent, Snapshot snapshot) {
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

} //ContentObjectDaoImpl
