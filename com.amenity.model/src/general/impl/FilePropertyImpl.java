/**
 */
package general.impl;

import general.File;
import general.FileProperty;
import general.GeneralPackage;
import general.QualityCriteria;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.FilePropertyImpl#getFilePropertyId <em>File Property Id</em>}</li>
 *   <li>{@link general.impl.FilePropertyImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link general.impl.FilePropertyImpl#getUpToDate <em>Up To Date</em>}</li>
 *   <li>{@link general.impl.FilePropertyImpl#getReviewed <em>Reviewed</em>}</li>
 *   <li>{@link general.impl.FilePropertyImpl#getConfigurationManagement <em>Configuration Management</em>}</li>
 *   <li>{@link general.impl.FilePropertyImpl#getRating <em>Rating</em>}</li>
 *   <li>{@link general.impl.FilePropertyImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link general.impl.FilePropertyImpl#getOf <em>Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FilePropertyImpl extends EObjectImpl implements FileProperty {
	/**
	 * The default value of the '{@link #getFilePropertyId() <em>File Property Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilePropertyId()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_PROPERTY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilePropertyId() <em>File Property Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilePropertyId()
	 * @generated
	 * @ordered
	 */
	protected String filePropertyId = FILE_PROPERTY_ID_EDEFAULT;

	/**
	 * This is true if the File Property Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean filePropertyIdESet;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpToDate() <em>Up To Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpToDate()
	 * @generated
	 * @ordered
	 */
	protected static final QualityCriteria UP_TO_DATE_EDEFAULT = QualityCriteria.EMPTY;

	/**
	 * The cached value of the '{@link #getUpToDate() <em>Up To Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpToDate()
	 * @generated
	 * @ordered
	 */
	protected QualityCriteria upToDate = UP_TO_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewed()
	 * @generated
	 * @ordered
	 */
	protected static final QualityCriteria REVIEWED_EDEFAULT = QualityCriteria.EMPTY;

	/**
	 * The cached value of the '{@link #getReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewed()
	 * @generated
	 * @ordered
	 */
	protected QualityCriteria reviewed = REVIEWED_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfigurationManagement() <em>Configuration Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationManagement()
	 * @generated
	 * @ordered
	 */
	protected static final QualityCriteria CONFIGURATION_MANAGEMENT_EDEFAULT = QualityCriteria.EMPTY;

	/**
	 * The cached value of the '{@link #getConfigurationManagement() <em>Configuration Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationManagement()
	 * @generated
	 * @ordered
	 */
	protected QualityCriteria configurationManagement = CONFIGURATION_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected static final QualityCriteria RATING_EDEFAULT = QualityCriteria.EMPTY;

	/**
	 * The cached value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected QualityCriteria rating = RATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOf() <em>Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOf()
	 * @generated
	 * @ordered
	 */
	protected File of;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FilePropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.FILE_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilePropertyId() {
		return filePropertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilePropertyId(String newFilePropertyId) {
		String oldFilePropertyId = filePropertyId;
		filePropertyId = newFilePropertyId;
		boolean oldFilePropertyIdESet = filePropertyIdESet;
		filePropertyIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__FILE_PROPERTY_ID, oldFilePropertyId, filePropertyId, !oldFilePropertyIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilePropertyId() {
		String oldFilePropertyId = filePropertyId;
		boolean oldFilePropertyIdESet = filePropertyIdESet;
		filePropertyId = FILE_PROPERTY_ID_EDEFAULT;
		filePropertyIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.FILE_PROPERTY__FILE_PROPERTY_ID, oldFilePropertyId, FILE_PROPERTY_ID_EDEFAULT, oldFilePropertyIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilePropertyId() {
		return filePropertyIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCriteria getUpToDate() {
		return upToDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpToDate(QualityCriteria newUpToDate) {
		QualityCriteria oldUpToDate = upToDate;
		upToDate = newUpToDate == null ? UP_TO_DATE_EDEFAULT : newUpToDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__UP_TO_DATE, oldUpToDate, upToDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCriteria getReviewed() {
		return reviewed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReviewed(QualityCriteria newReviewed) {
		QualityCriteria oldReviewed = reviewed;
		reviewed = newReviewed == null ? REVIEWED_EDEFAULT : newReviewed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__REVIEWED, oldReviewed, reviewed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCriteria getConfigurationManagement() {
		return configurationManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationManagement(QualityCriteria newConfigurationManagement) {
		QualityCriteria oldConfigurationManagement = configurationManagement;
		configurationManagement = newConfigurationManagement == null ? CONFIGURATION_MANAGEMENT_EDEFAULT : newConfigurationManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__CONFIGURATION_MANAGEMENT, oldConfigurationManagement, configurationManagement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCriteria getRating() {
		return rating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRating(QualityCriteria newRating) {
		QualityCriteria oldRating = rating;
		rating = newRating == null ? RATING_EDEFAULT : newRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__RATING, oldRating, rating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File getOf() {
		if (of != null && of.eIsProxy()) {
			InternalEObject oldOf = (InternalEObject)of;
			of = (File)eResolveProxy(oldOf);
			if (of != oldOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.FILE_PROPERTY__OF, oldOf, of));
			}
		}
		return of;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File basicGetOf() {
		return of;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOf(File newOf, NotificationChain msgs) {
		File oldOf = of;
		of = newOf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__OF, oldOf, newOf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOf(File newOf) {
		if (newOf != of) {
			NotificationChain msgs = null;
			if (of != null)
				msgs = ((InternalEObject)of).eInverseRemove(this, GeneralPackage.FILE__HAS_PROPERTY, File.class, msgs);
			if (newOf != null)
				msgs = ((InternalEObject)newOf).eInverseAdd(this, GeneralPackage.FILE__HAS_PROPERTY, File.class, msgs);
			msgs = basicSetOf(newOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_PROPERTY__OF, newOf, newOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneralPackage.FILE_PROPERTY__OF:
				if (of != null)
					msgs = ((InternalEObject)of).eInverseRemove(this, GeneralPackage.FILE__HAS_PROPERTY, File.class, msgs);
				return basicSetOf((File)otherEnd, msgs);
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
			case GeneralPackage.FILE_PROPERTY__OF:
				return basicSetOf(null, msgs);
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
			case GeneralPackage.FILE_PROPERTY__FILE_PROPERTY_ID:
				return getFilePropertyId();
			case GeneralPackage.FILE_PROPERTY__REQUIRED:
				return isRequired();
			case GeneralPackage.FILE_PROPERTY__UP_TO_DATE:
				return getUpToDate();
			case GeneralPackage.FILE_PROPERTY__REVIEWED:
				return getReviewed();
			case GeneralPackage.FILE_PROPERTY__CONFIGURATION_MANAGEMENT:
				return getConfigurationManagement();
			case GeneralPackage.FILE_PROPERTY__RATING:
				return getRating();
			case GeneralPackage.FILE_PROPERTY__COMMENT:
				return getComment();
			case GeneralPackage.FILE_PROPERTY__OF:
				if (resolve) return getOf();
				return basicGetOf();
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
			case GeneralPackage.FILE_PROPERTY__FILE_PROPERTY_ID:
				setFilePropertyId((String)newValue);
				return;
			case GeneralPackage.FILE_PROPERTY__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case GeneralPackage.FILE_PROPERTY__UP_TO_DATE:
				setUpToDate((QualityCriteria)newValue);
				return;
			case GeneralPackage.FILE_PROPERTY__REVIEWED:
				setReviewed((QualityCriteria)newValue);
				return;
			case GeneralPackage.FILE_PROPERTY__CONFIGURATION_MANAGEMENT:
				setConfigurationManagement((QualityCriteria)newValue);
				return;
			case GeneralPackage.FILE_PROPERTY__RATING:
				setRating((QualityCriteria)newValue);
				return;
			case GeneralPackage.FILE_PROPERTY__COMMENT:
				setComment((String)newValue);
				return;
			case GeneralPackage.FILE_PROPERTY__OF:
				setOf((File)newValue);
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
			case GeneralPackage.FILE_PROPERTY__FILE_PROPERTY_ID:
				unsetFilePropertyId();
				return;
			case GeneralPackage.FILE_PROPERTY__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case GeneralPackage.FILE_PROPERTY__UP_TO_DATE:
				setUpToDate(UP_TO_DATE_EDEFAULT);
				return;
			case GeneralPackage.FILE_PROPERTY__REVIEWED:
				setReviewed(REVIEWED_EDEFAULT);
				return;
			case GeneralPackage.FILE_PROPERTY__CONFIGURATION_MANAGEMENT:
				setConfigurationManagement(CONFIGURATION_MANAGEMENT_EDEFAULT);
				return;
			case GeneralPackage.FILE_PROPERTY__RATING:
				setRating(RATING_EDEFAULT);
				return;
			case GeneralPackage.FILE_PROPERTY__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case GeneralPackage.FILE_PROPERTY__OF:
				setOf((File)null);
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
			case GeneralPackage.FILE_PROPERTY__FILE_PROPERTY_ID:
				return isSetFilePropertyId();
			case GeneralPackage.FILE_PROPERTY__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case GeneralPackage.FILE_PROPERTY__UP_TO_DATE:
				return upToDate != UP_TO_DATE_EDEFAULT;
			case GeneralPackage.FILE_PROPERTY__REVIEWED:
				return reviewed != REVIEWED_EDEFAULT;
			case GeneralPackage.FILE_PROPERTY__CONFIGURATION_MANAGEMENT:
				return configurationManagement != CONFIGURATION_MANAGEMENT_EDEFAULT;
			case GeneralPackage.FILE_PROPERTY__RATING:
				return rating != RATING_EDEFAULT;
			case GeneralPackage.FILE_PROPERTY__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case GeneralPackage.FILE_PROPERTY__OF:
				return of != null;
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
		result.append(" (filePropertyId: ");
		if (filePropertyIdESet) result.append(filePropertyId); else result.append("<unset>");
		result.append(", required: ");
		result.append(required);
		result.append(", upToDate: ");
		result.append(upToDate);
		result.append(", reviewed: ");
		result.append(reviewed);
		result.append(", configurationManagement: ");
		result.append(configurationManagement);
		result.append(", rating: ");
		result.append(rating);
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //FilePropertyImpl
