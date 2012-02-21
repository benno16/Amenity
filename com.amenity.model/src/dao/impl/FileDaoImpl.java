/**
 */
package dao.impl;

import general.File;

import java.util.ArrayList;
import java.util.List;

import dao.DaoPackage;
import dao.FileDao;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Transaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FileDaoImpl extends GenericDaoImpl implements FileDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.FILE_DAO;
	}

	@Override
	public boolean massInsert(List list, Class<?> class_) {
		session = getSession();
		Transaction tx = session.beginTransaction();
		try {
			list = (ArrayList<File>) list;
		} catch (Exception e) {
			return false;
		}
		int i = 0;
		for ( File f : (ArrayList<File>) list ) {
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

} //FileDaoImpl
