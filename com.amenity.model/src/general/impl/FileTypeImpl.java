/**
 */
package general.impl;

import general.FileEnding;
import general.FileType;
import general.GeneralPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.swt.graphics.Image;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.FileTypeImpl#getFileTypeId <em>File Type Id</em>}</li>
 *   <li>{@link general.impl.FileTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link general.impl.FileTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link general.impl.FileTypeImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link general.impl.FileTypeImpl#getTool <em>Tool</em>}</li>
 *   <li>{@link general.impl.FileTypeImpl#getUses <em>Uses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileTypeImpl extends EObjectImpl implements FileType {
	/**
	 * The default value of the '{@link #getFileTypeId() <em>File Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileTypeId() <em>File Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileTypeId()
	 * @generated
	 * @ordered
	 */
	protected String fileTypeId = FILE_TYPE_ID_EDEFAULT;

	/**
	 * This is true if the File Type Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fileTypeIdESet;

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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final Image ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected Image icon = ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getTool() <em>Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTool()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTool() <em>Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTool()
	 * @generated
	 * @ordered
	 */
	protected String tool = TOOL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<FileEnding> uses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.FILE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileTypeId() {
		return fileTypeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileTypeId(String newFileTypeId) {
		String oldFileTypeId = fileTypeId;
		fileTypeId = newFileTypeId;
		boolean oldFileTypeIdESet = fileTypeIdESet;
		fileTypeIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_TYPE__FILE_TYPE_ID, oldFileTypeId, fileTypeId, !oldFileTypeIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFileTypeId() {
		String oldFileTypeId = fileTypeId;
		boolean oldFileTypeIdESet = fileTypeIdESet;
		fileTypeId = FILE_TYPE_ID_EDEFAULT;
		fileTypeIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.FILE_TYPE__FILE_TYPE_ID, oldFileTypeId, FILE_TYPE_ID_EDEFAULT, oldFileTypeIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFileTypeId() {
		return fileTypeIdESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(Image newIcon) {
		Image oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_TYPE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTool() {
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTool(String newTool) {
		String oldTool = tool;
		tool = newTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_TYPE__TOOL, oldTool, tool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FileEnding> getUses() {
		if (uses == null) {
			uses = new EObjectWithInverseResolvingEList<FileEnding>(FileEnding.class, this, GeneralPackage.FILE_TYPE__USES, GeneralPackage.FILE_ENDING__OF_TYPE);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneralPackage.FILE_TYPE__USES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUses()).basicAdd(otherEnd, msgs);
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
			case GeneralPackage.FILE_TYPE__USES:
				return ((InternalEList<?>)getUses()).basicRemove(otherEnd, msgs);
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
			case GeneralPackage.FILE_TYPE__FILE_TYPE_ID:
				return getFileTypeId();
			case GeneralPackage.FILE_TYPE__NAME:
				return getName();
			case GeneralPackage.FILE_TYPE__DESCRIPTION:
				return getDescription();
			case GeneralPackage.FILE_TYPE__ICON:
				return getIcon();
			case GeneralPackage.FILE_TYPE__TOOL:
				return getTool();
			case GeneralPackage.FILE_TYPE__USES:
				return getUses();
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
			case GeneralPackage.FILE_TYPE__FILE_TYPE_ID:
				setFileTypeId((String)newValue);
				return;
			case GeneralPackage.FILE_TYPE__NAME:
				setName((String)newValue);
				return;
			case GeneralPackage.FILE_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case GeneralPackage.FILE_TYPE__ICON:
				setIcon((Image)newValue);
				return;
			case GeneralPackage.FILE_TYPE__TOOL:
				setTool((String)newValue);
				return;
			case GeneralPackage.FILE_TYPE__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends FileEnding>)newValue);
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
			case GeneralPackage.FILE_TYPE__FILE_TYPE_ID:
				unsetFileTypeId();
				return;
			case GeneralPackage.FILE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneralPackage.FILE_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case GeneralPackage.FILE_TYPE__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case GeneralPackage.FILE_TYPE__TOOL:
				setTool(TOOL_EDEFAULT);
				return;
			case GeneralPackage.FILE_TYPE__USES:
				getUses().clear();
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
			case GeneralPackage.FILE_TYPE__FILE_TYPE_ID:
				return isSetFileTypeId();
			case GeneralPackage.FILE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneralPackage.FILE_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case GeneralPackage.FILE_TYPE__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case GeneralPackage.FILE_TYPE__TOOL:
				return TOOL_EDEFAULT == null ? tool != null : !TOOL_EDEFAULT.equals(tool);
			case GeneralPackage.FILE_TYPE__USES:
				return uses != null && !uses.isEmpty();
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
		result.append(" (fileTypeId: ");
		if (fileTypeIdESet) result.append(fileTypeId); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", icon: ");
		result.append(icon);
		result.append(", tool: ");
		result.append(tool);
		result.append(')');
		return result.toString();
	}

} //FileTypeImpl
