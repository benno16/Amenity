/**
 */
package dao.impl;

import dao.ContentObjectDao;
import dao.DaoPackage;

import general.ContentObject;
import general.File;
import general.Snapshot;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

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

		session = getSession();
		session.beginTransaction();
		String string = "from " + ContentObject.class.getName().toString() + 
				" where partOf = '" + snapshot.getSnapshotId() + "'";
		Query queryRes = session.createQuery(string);
		List<File> resultList = queryRes.list();
//		Criteria criteria = session.createCriteria(ContentObject.class);
//		criteria.add(Restrictions.eq("snapshot", snapshot));
//		List<ContentObject> resultList = criteria.list();
		session.close();
		
		return resultList;
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

} //ContentObjectDaoImpl
