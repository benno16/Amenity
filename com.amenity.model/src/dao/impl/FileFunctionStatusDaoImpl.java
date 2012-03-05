/**
 */
package dao.impl;

import dao.DaoFactory;
import dao.DaoPackage;
import dao.FileFunctionStatusDao;
import dao.FunctionDao;

import general.FileFunctionStatus;
import general.Function;
import general.Snapshot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Function Status Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FileFunctionStatusDaoImpl extends GenericDaoImpl implements FileFunctionStatusDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileFunctionStatusDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.FILE_FUNCTION_STATUS_DAO;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public List<FileFunctionStatus> getFileFunctionStatusBySnapshot(Snapshot snapshot1) {
		// Lets fetch the functions
		FunctionDao functionDao = DaoFactory.eINSTANCE.createFunctionDao();
		List<Function> functions = functionDao.getFunctionsBySnapshot(snapshot1);
		// now lets fetch its file-function assoziations
		List<FileFunctionStatus> fileFunctionStatus = new ArrayList<FileFunctionStatus>();
		functionDao = null;
		if ( functions != null ) {
			session = getSession();
			session.beginTransaction();
			
			for (Function f : functions ) {
	 			Query queryRes = session.createQuery("from " + 
					FileFunctionStatus.class.getName().toString() +
					" where ofFunction = '" + f.getFunctionId() + "'");
	 			fileFunctionStatus.addAll(queryRes.list());
			}
			session.close();
		}
		
		return fileFunctionStatus;
	}

} //FileFunctionStatusDaoImpl
