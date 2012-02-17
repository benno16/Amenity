/**
 */
package general.impl;

import general.GeneralPackage;
import general.GenericFunctionSRSFileProperty;
import general.GenericFunctionSRSType;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Function SRS File Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.GenericFunctionSRSFilePropertyImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericFunctionSRSFilePropertyImpl extends FilePropertyImpl implements GenericFunctionSRSFileProperty {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EList<GenericFunctionSRSType> type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericFunctionSRSFilePropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.GENERIC_FUNCTION_SRS_FILE_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenericFunctionSRSType> getType() {
		if (type == null) {
			type = new EObjectResolvingEList<GenericFunctionSRSType>(GenericFunctionSRSType.class, this, GeneralPackage.GENERIC_FUNCTION_SRS_FILE_PROPERTY__TYPE);
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
			case GeneralPackage.GENERIC_FUNCTION_SRS_FILE_PROPERTY__TYPE:
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
			case GeneralPackage.GENERIC_FUNCTION_SRS_FILE_PROPERTY__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends GenericFunctionSRSType>)newValue);
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
			case GeneralPackage.GENERIC_FUNCTION_SRS_FILE_PROPERTY__TYPE:
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
			case GeneralPackage.GENERIC_FUNCTION_SRS_FILE_PROPERTY__TYPE:
				return type != null && !type.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GenericFunctionSRSFilePropertyImpl
