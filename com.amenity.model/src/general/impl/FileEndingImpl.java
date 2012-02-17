/**
 */
package general.impl;

import general.FileEnding;
import general.FileType;
import general.GeneralPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Ending</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.FileEndingImpl#getFileEndingId <em>File Ending Id</em>}</li>
 *   <li>{@link general.impl.FileEndingImpl#getName <em>Name</em>}</li>
 *   <li>{@link general.impl.FileEndingImpl#getOfType <em>Of Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileEndingImpl extends EObjectImpl implements FileEnding {
	/**
	 * The default value of the '{@link #getFileEndingId() <em>File Ending Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileEndingId()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_ENDING_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileEndingId() <em>File Ending Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileEndingId()
	 * @generated
	 * @ordered
	 */
	protected String fileEndingId = FILE_ENDING_ID_EDEFAULT;

	/**
	 * This is true if the File Ending Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fileEndingIdESet;

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
	 * The cached value of the '{@link #getOfType() <em>Of Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOfType()
	 * @generated
	 * @ordered
	 */
	protected FileType ofType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileEndingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.FILE_ENDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileEndingId() {
		return fileEndingId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileEndingId(String newFileEndingId) {
		String oldFileEndingId = fileEndingId;
		fileEndingId = newFileEndingId;
		boolean oldFileEndingIdESet = fileEndingIdESet;
		fileEndingIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_ENDING__FILE_ENDING_ID, oldFileEndingId, fileEndingId, !oldFileEndingIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFileEndingId() {
		String oldFileEndingId = fileEndingId;
		boolean oldFileEndingIdESet = fileEndingIdESet;
		fileEndingId = FILE_ENDING_ID_EDEFAULT;
		fileEndingIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.FILE_ENDING__FILE_ENDING_ID, oldFileEndingId, FILE_ENDING_ID_EDEFAULT, oldFileEndingIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFileEndingId() {
		return fileEndingIdESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_ENDING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileType getOfType() {
		if (ofType != null && ofType.eIsProxy()) {
			InternalEObject oldOfType = (InternalEObject)ofType;
			ofType = (FileType)eResolveProxy(oldOfType);
			if (ofType != oldOfType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.FILE_ENDING__OF_TYPE, oldOfType, ofType));
			}
		}
		return ofType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileType basicGetOfType() {
		return ofType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOfType(FileType newOfType, NotificationChain msgs) {
		FileType oldOfType = ofType;
		ofType = newOfType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_ENDING__OF_TYPE, oldOfType, newOfType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOfType(FileType newOfType) {
		if (newOfType != ofType) {
			NotificationChain msgs = null;
			if (ofType != null)
				msgs = ((InternalEObject)ofType).eInverseRemove(this, GeneralPackage.FILE_TYPE__USES, FileType.class, msgs);
			if (newOfType != null)
				msgs = ((InternalEObject)newOfType).eInverseAdd(this, GeneralPackage.FILE_TYPE__USES, FileType.class, msgs);
			msgs = basicSetOfType(newOfType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_ENDING__OF_TYPE, newOfType, newOfType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneralPackage.FILE_ENDING__OF_TYPE:
				if (ofType != null)
					msgs = ((InternalEObject)ofType).eInverseRemove(this, GeneralPackage.FILE_TYPE__USES, FileType.class, msgs);
				return basicSetOfType((FileType)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneralPackage.FILE_ENDING__OF_TYPE:
				return basicSetOfType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.FILE_ENDING__FILE_ENDING_ID:
				return getFileEndingId();
			case GeneralPackage.FILE_ENDING__NAME:
				return getName();
			case GeneralPackage.FILE_ENDING__OF_TYPE:
				if (resolve) return getOfType();
				return basicGetOfType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneralPackage.FILE_ENDING__FILE_ENDING_ID:
				setFileEndingId((String)newValue);
				return;
			case GeneralPackage.FILE_ENDING__NAME:
				setName((String)newValue);
				return;
			case GeneralPackage.FILE_ENDING__OF_TYPE:
				setOfType((FileType)newValue);
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
			case GeneralPackage.FILE_ENDING__FILE_ENDING_ID:
				unsetFileEndingId();
				return;
			case GeneralPackage.FILE_ENDING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneralPackage.FILE_ENDING__OF_TYPE:
				setOfType((FileType)null);
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
			case GeneralPackage.FILE_ENDING__FILE_ENDING_ID:
				return isSetFileEndingId();
			case GeneralPackage.FILE_ENDING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneralPackage.FILE_ENDING__OF_TYPE:
				return ofType != null;
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
		result.append(" (fileEndingId: ");
		if (fileEndingIdESet) result.append(fileEndingId); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FileEndingImpl
