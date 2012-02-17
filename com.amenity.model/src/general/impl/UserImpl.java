/**
 */
package general.impl;

import general.Event;
import general.GeneralPackage;
import general.User;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.UserImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link general.impl.UserImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link general.impl.UserImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link general.impl.UserImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link general.impl.UserImpl#getLastUsed <em>Last Used</em>}</li>
 *   <li>{@link general.impl.UserImpl#getTimesUsed <em>Times Used</em>}</li>
 *   <li>{@link general.impl.UserImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.impl.UserImpl#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends EObjectImpl implements User {
	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

	/**
	 * This is true if the User Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean userIdESet;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastUsed() <em>Last Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsed()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_USED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastUsed() <em>Last Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsed()
	 * @generated
	 * @ordered
	 */
	protected Date lastUsed = LAST_USED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimesUsed() <em>Times Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimesUsed()
	 * @generated
	 * @ordered
	 */
	protected static final int TIMES_USED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimesUsed() <em>Times Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimesUsed()
	 * @generated
	 * @ordered
	 */
	protected int timesUsed = TIMES_USED_EDEFAULT;

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
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> event;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		boolean oldUserIdESet = userIdESet;
		userIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.USER__USER_ID, oldUserId, userId, !oldUserIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserId() {
		String oldUserId = userId;
		boolean oldUserIdESet = userIdESet;
		userId = USER_ID_EDEFAULT;
		userIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.USER__USER_ID, oldUserId, USER_ID_EDEFAULT, oldUserIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserId() {
		return userIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.USER__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.USER__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.USER__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastUsed() {
		return lastUsed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUsed(Date newLastUsed) {
		Date oldLastUsed = lastUsed;
		lastUsed = newLastUsed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.USER__LAST_USED, oldLastUsed, lastUsed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimesUsed() {
		return timesUsed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimesUsed(int newTimesUsed) {
		int oldTimesUsed = timesUsed;
		timesUsed = newTimesUsed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.USER__TIMES_USED, oldTimesUsed, timesUsed));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.USER__DELETED, oldDeleted, deleted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvent() {
		if (event == null) {
			event = new EObjectWithInverseResolvingEList<Event>(Event.class, this, GeneralPackage.USER__EVENT, GeneralPackage.EVENT__USER);
		}
		return event;
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
			case GeneralPackage.USER__EVENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEvent()).basicAdd(otherEnd, msgs);
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
			case GeneralPackage.USER__EVENT:
				return ((InternalEList<?>)getEvent()).basicRemove(otherEnd, msgs);
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
			case GeneralPackage.USER__USER_ID:
				return getUserId();
			case GeneralPackage.USER__USERNAME:
				return getUsername();
			case GeneralPackage.USER__PASSWORD:
				return getPassword();
			case GeneralPackage.USER__EMAIL:
				return getEmail();
			case GeneralPackage.USER__LAST_USED:
				return getLastUsed();
			case GeneralPackage.USER__TIMES_USED:
				return getTimesUsed();
			case GeneralPackage.USER__DELETED:
				return isDeleted();
			case GeneralPackage.USER__EVENT:
				return getEvent();
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
			case GeneralPackage.USER__USER_ID:
				setUserId((String)newValue);
				return;
			case GeneralPackage.USER__USERNAME:
				setUsername((String)newValue);
				return;
			case GeneralPackage.USER__PASSWORD:
				setPassword((String)newValue);
				return;
			case GeneralPackage.USER__EMAIL:
				setEmail((String)newValue);
				return;
			case GeneralPackage.USER__LAST_USED:
				setLastUsed((Date)newValue);
				return;
			case GeneralPackage.USER__TIMES_USED:
				setTimesUsed((Integer)newValue);
				return;
			case GeneralPackage.USER__DELETED:
				setDeleted((Boolean)newValue);
				return;
			case GeneralPackage.USER__EVENT:
				getEvent().clear();
				getEvent().addAll((Collection<? extends Event>)newValue);
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
			case GeneralPackage.USER__USER_ID:
				unsetUserId();
				return;
			case GeneralPackage.USER__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case GeneralPackage.USER__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case GeneralPackage.USER__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case GeneralPackage.USER__LAST_USED:
				setLastUsed(LAST_USED_EDEFAULT);
				return;
			case GeneralPackage.USER__TIMES_USED:
				setTimesUsed(TIMES_USED_EDEFAULT);
				return;
			case GeneralPackage.USER__DELETED:
				setDeleted(DELETED_EDEFAULT);
				return;
			case GeneralPackage.USER__EVENT:
				getEvent().clear();
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
			case GeneralPackage.USER__USER_ID:
				return isSetUserId();
			case GeneralPackage.USER__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case GeneralPackage.USER__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case GeneralPackage.USER__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case GeneralPackage.USER__LAST_USED:
				return LAST_USED_EDEFAULT == null ? lastUsed != null : !LAST_USED_EDEFAULT.equals(lastUsed);
			case GeneralPackage.USER__TIMES_USED:
				return timesUsed != TIMES_USED_EDEFAULT;
			case GeneralPackage.USER__DELETED:
				return deleted != DELETED_EDEFAULT;
			case GeneralPackage.USER__EVENT:
				return event != null && !event.isEmpty();
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
		result.append(" (userId: ");
		if (userIdESet) result.append(userId); else result.append("<unset>");
		result.append(", username: ");
		result.append(username);
		result.append(", password: ");
		result.append(password);
		result.append(", email: ");
		result.append(email);
		result.append(", lastUsed: ");
		result.append(lastUsed);
		result.append(", timesUsed: ");
		result.append(timesUsed);
		result.append(", deleted: ");
		result.append(deleted);
		result.append(')');
		return result.toString();
	}

} //UserImpl
