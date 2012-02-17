/**
 */
package general.impl;

import general.GeneralPackage;
import general.SystemComponentLevelDocumentation;
import general.SystemComponentLevelDocumentationFileProperty;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Component Level Documentation File Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.SystemComponentLevelDocumentationFilePropertyImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemComponentLevelDocumentationFilePropertyImpl extends FilePropertyImpl implements SystemComponentLevelDocumentationFileProperty {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemComponentLevelDocumentation> type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemComponentLevelDocumentationFilePropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemComponentLevelDocumentation> getType() {
		if (type == null) {
			type = new EObjectResolvingEList<SystemComponentLevelDocumentation>(SystemComponentLevelDocumentation.class, this, GeneralPackage.SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__TYPE);
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__TYPE:
				return getType();
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
			case GeneralPackage.SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends SystemComponentLevelDocumentation>)newValue);
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
			case GeneralPackage.SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__TYPE:
				getType().clear();
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
			case GeneralPackage.SYSTEM_COMPONENT_LEVEL_DOCUMENTATION_FILE_PROPERTY__TYPE:
				return type != null && !type.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemComponentLevelDocumentationFilePropertyImpl
