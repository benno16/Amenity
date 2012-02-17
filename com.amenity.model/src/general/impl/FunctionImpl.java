/**
 */
package general.impl;

import general.Function;
import general.GeneralPackage;
import general.GenericFunctionSRSFileProperty;
import general.Snapshot;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.FunctionImpl#getFunctionId <em>Function Id</em>}</li>
 *   <li>{@link general.impl.FunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link general.impl.FunctionImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link general.impl.FunctionImpl#getOverallStatus <em>Overall Status</em>}</li>
 *   <li>{@link general.impl.FunctionImpl#getModified <em>Modified</em>}</li>
 *   <li>{@link general.impl.FunctionImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.impl.FunctionImpl#getResponsibleFiles <em>Responsible Files</em>}</li>
 *   <li>{@link general.impl.FunctionImpl#getHeldBy <em>Held By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends EObjectImpl implements Function {
	/**
	 * The default value of the '{@link #getFunctionId() <em>Function Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionId()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFunctionId() <em>Function Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionId()
	 * @generated
	 * @ordered
	 */
	protected String functionId = FUNCTION_ID_EDEFAULT;

	/**
	 * This is true if the Function Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean functionIdESet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected Date created = CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getOverallStatus() <em>Overall Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverallStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String OVERALL_STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOverallStatus() <em>Overall Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverallStatus()
	 * @generated
	 * @ordered
	 */
	protected String overallStatus = OVERALL_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModified()
	 * @generated
	 * @ordered
	 */
	protected static final Date MODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModified()
	 * @generated
	 * @ordered
	 */
	protected Date modified = MODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleted()
	 * @generated
	 * @ordered
	 */
	protected boolean deleted = DELETED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResponsibleFiles() <em>Responsible Files</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibleFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<GenericFunctionSRSFileProperty> responsibleFiles;

	/**
	 * The cached value of the '{@link #getHeldBy() <em>Held By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeldBy()
	 * @generated
	 * @ordered
	 */
	protected Snapshot heldBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionId() {
		return functionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionId(String newFunctionId) {
		String oldFunctionId = functionId;
		functionId = newFunctionId;
		boolean oldFunctionIdESet = functionIdESet;
		functionIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FUNCTION__FUNCTION_ID, oldFunctionId, functionId, !oldFunctionIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFunctionId() {
		String oldFunctionId = functionId;
		boolean oldFunctionIdESet = functionIdESet;
		functionId = FUNCTION_ID_EDEFAULT;
		functionIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.FUNCTION__FUNCTION_ID, oldFunctionId, FUNCTION_ID_EDEFAULT, oldFunctionIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFunctionId() {
		return functionIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FUNCTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(Date newCreated) {
		Date oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FUNCTION__CREATED, oldCreated, created));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallStatus() {
		return overallStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallStatus(String newOverallStatus) {
		String oldOverallStatus = overallStatus;
		overallStatus = newOverallStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FUNCTION__OVERALL_STATUS, oldOverallStatus, overallStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModified(Date newModified) {
		Date oldModified = modified;
		modified = newModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FUNCTION__MODIFIED, oldModified, modified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeleted(boolean newDeleted) {
		boolean oldDeleted = deleted;
		deleted = newDeleted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FUNCTION__DELETED, oldDeleted, deleted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenericFunctionSRSFileProperty> getResponsibleFiles() {
		if (responsibleFiles == null) {
			responsibleFiles = new EObjectResolvingEList<GenericFunctionSRSFileProperty>(GenericFunctionSRSFileProperty.class, this, GeneralPackage.FUNCTION__RESPONSIBLE_FILES);
		}
		return responsibleFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot getHeldBy() {
		if (heldBy != null && heldBy.eIsProxy()) {
			InternalEObject oldHeldBy = (InternalEObject)heldBy;
			heldBy = (Snapshot)eResolveProxy(oldHeldBy);
			if (heldBy != oldHeldBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.FUNCTION__HELD_BY, oldHeldBy, heldBy));
			}
		}
		return heldBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot basicGetHeldBy() {
		return heldBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeldBy(Snapshot newHeldBy) {
		Snapshot oldHeldBy = heldBy;
		heldBy = newHeldBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FUNCTION__HELD_BY, oldHeldBy, heldBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.FUNCTION__FUNCTION_ID:
				return getFunctionId();
			case GeneralPackage.FUNCTION__NAME:
				return getName();
			case GeneralPackage.FUNCTION__CREATED:
				return getCreated();
			case GeneralPackage.FUNCTION__OVERALL_STATUS:
				return getOverallStatus();
			case GeneralPackage.FUNCTION__MODIFIED:
				return getModified();
			case GeneralPackage.FUNCTION__DELETED:
				return isDeleted();
			case GeneralPackage.FUNCTION__RESPONSIBLE_FILES:
				return getResponsibleFiles();
			case GeneralPackage.FUNCTION__HELD_BY:
				if (resolve) return getHeldBy();
				return basicGetHeldBy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneralPackage.FUNCTION__FUNCTION_ID:
				setFunctionId((String)newValue);
				return;
			case GeneralPackage.FUNCTION__NAME:
				setName((String)newValue);
				return;
			case GeneralPackage.FUNCTION__CREATED:
				setCreated((Date)newValue);
				return;
			case GeneralPackage.FUNCTION__OVERALL_STATUS:
				setOverallStatus((String)newValue);
				return;
			case GeneralPackage.FUNCTION__MODIFIED:
				setModified((Date)newValue);
				return;
			case GeneralPackage.FUNCTION__DELETED:
				setDeleted((Boolean)newValue);
				return;
			case GeneralPackage.FUNCTION__RESPONSIBLE_FILES:
				getResponsibleFiles().clear();
				getResponsibleFiles().addAll((Collection<? extends GenericFunctionSRSFileProperty>)newValue);
				return;
			case GeneralPackage.FUNCTION__HELD_BY:
				setHeldBy((Snapshot)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneralPackage.FUNCTION__FUNCTION_ID:
				unsetFunctionId();
				return;
			case GeneralPackage.FUNCTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneralPackage.FUNCTION__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case GeneralPackage.FUNCTION__OVERALL_STATUS:
				setOverallStatus(OVERALL_STATUS_EDEFAULT);
				return;
			case GeneralPackage.FUNCTION__MODIFIED:
				setModified(MODIFIED_EDEFAULT);
				return;
			case GeneralPackage.FUNCTION__DELETED:
				setDeleted(DELETED_EDEFAULT);
				return;
			case GeneralPackage.FUNCTION__RESPONSIBLE_FILES:
				getResponsibleFiles().clear();
				return;
			case GeneralPackage.FUNCTION__HELD_BY:
				setHeldBy((Snapshot)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneralPackage.FUNCTION__FUNCTION_ID:
				return isSetFunctionId();
			case GeneralPackage.FUNCTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneralPackage.FUNCTION__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case GeneralPackage.FUNCTION__OVERALL_STATUS:
				return OVERALL_STATUS_EDEFAULT == null ? overallStatus != null : !OVERALL_STATUS_EDEFAULT.equals(overallStatus);
			case GeneralPackage.FUNCTION__MODIFIED:
				return MODIFIED_EDEFAULT == null ? modified != null : !MODIFIED_EDEFAULT.equals(modified);
			case GeneralPackage.FUNCTION__DELETED:
				return deleted != DELETED_EDEFAULT;
			case GeneralPackage.FUNCTION__RESPONSIBLE_FILES:
				return responsibleFiles != null && !responsibleFiles.isEmpty();
			case GeneralPackage.FUNCTION__HELD_BY:
				return heldBy != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (functionId: ");
		if (functionIdESet) result.append(functionId); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", created: ");
		result.append(created);
		result.append(", overallStatus: ");
		result.append(overallStatus);
		result.append(", modified: ");
		result.append(modified);
		result.append(", deleted: ");
		result.append(deleted);
		result.append(')');
		return result.toString();
	}

} //FunctionImpl
