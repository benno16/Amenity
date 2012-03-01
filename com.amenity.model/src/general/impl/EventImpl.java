/**
 */
package general.impl;

import general.Event;
import general.EventType;
import general.GeneralPackage;
import general.User;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.EventImpl#getEventId <em>Event Id</em>}</li>
 *   <li>{@link general.impl.EventImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link general.impl.EventImpl#getDate <em>Date</em>}</li>
 *   <li>{@link general.impl.EventImpl#isUserRelevant <em>User Relevant</em>}</li>
 *   <li>{@link general.impl.EventImpl#getUser <em>User</em>}</li>
 *   <li>{@link general.impl.EventImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventImpl extends EObjectImpl implements Event {
	/**
	 * The default value of the '{@link #getEventId() <em>Event Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventId()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventId() <em>Event Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventId()
	 * @generated
	 * @ordered
	 */
	protected String eventId = EVENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isUserRelevant() <em>User Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USER_RELEVANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUserRelevant() <em>User Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserRelevant()
	 * @generated
	 * @ordered
	 */
	protected boolean userRelevant = USER_RELEVANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUser() <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected User user;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EventType TYPE_EDEFAULT = EventType.ERROR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EventType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventId(String newEventId) {
		String oldEventId = eventId;
		eventId = newEventId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.EVENT__EVENT_ID, oldEventId, eventId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.EVENT__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.EVENT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUserRelevant() {
		return userRelevant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserRelevant(boolean newUserRelevant) {
		boolean oldUserRelevant = userRelevant;
		userRelevant = newUserRelevant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.EVENT__USER_RELEVANT, oldUserRelevant, userRelevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser() {
		if (user != null && user.eIsProxy()) {
			InternalEObject oldUser = (InternalEObject)user;
			user = (User)eResolveProxy(oldUser);
			if (user != oldUser) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.EVENT__USER, oldUser, user));
			}
		}
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		User oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.EVENT__USER, oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EventType newType) {
		EventType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.EVENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.EVENT__EVENT_ID:
				return getEventId();
			case GeneralPackage.EVENT__MESSAGE:
				return getMessage();
			case GeneralPackage.EVENT__DATE:
				return getDate();
			case GeneralPackage.EVENT__USER_RELEVANT:
				return isUserRelevant();
			case GeneralPackage.EVENT__USER:
				if (resolve) return getUser();
				return basicGetUser();
			case GeneralPackage.EVENT__TYPE:
				return getType();
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
			case GeneralPackage.EVENT__EVENT_ID:
				setEventId((String)newValue);
				return;
			case GeneralPackage.EVENT__MESSAGE:
				setMessage((String)newValue);
				return;
			case GeneralPackage.EVENT__DATE:
				setDate((Date)newValue);
				return;
			case GeneralPackage.EVENT__USER_RELEVANT:
				setUserRelevant((Boolean)newValue);
				return;
			case GeneralPackage.EVENT__USER:
				setUser((User)newValue);
				return;
			case GeneralPackage.EVENT__TYPE:
				setType((EventType)newValue);
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
			case GeneralPackage.EVENT__EVENT_ID:
				setEventId(EVENT_ID_EDEFAULT);
				return;
			case GeneralPackage.EVENT__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case GeneralPackage.EVENT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case GeneralPackage.EVENT__USER_RELEVANT:
				setUserRelevant(USER_RELEVANT_EDEFAULT);
				return;
			case GeneralPackage.EVENT__USER:
				setUser((User)null);
				return;
			case GeneralPackage.EVENT__TYPE:
				setType(TYPE_EDEFAULT);
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
			case GeneralPackage.EVENT__EVENT_ID:
				return EVENT_ID_EDEFAULT == null ? eventId != null : !EVENT_ID_EDEFAULT.equals(eventId);
			case GeneralPackage.EVENT__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case GeneralPackage.EVENT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case GeneralPackage.EVENT__USER_RELEVANT:
				return userRelevant != USER_RELEVANT_EDEFAULT;
			case GeneralPackage.EVENT__USER:
				return user != null;
			case GeneralPackage.EVENT__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (eventId: ");
		result.append(eventId);
		result.append(", message: ");
		result.append(message);
		result.append(", date: ");
		result.append(date);
		result.append(", userRelevant: ");
		result.append(userRelevant);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //EventImpl
