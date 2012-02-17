/**
 */
package general.impl;

import general.Container;
import general.ContentObject;
import general.Function;
import general.GeneralDocumentationFileProperty;
import general.GeneralPackage;
import general.Snapshot;
import general.SystemComponentLevelDocumentationFileProperty;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Snapshot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.SnapshotImpl#getSnapshotId <em>Snapshot Id</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getName <em>Name</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getPartOf <em>Part Of</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getStores <em>Stores</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getSystemComponent <em>System Component</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getEReference1 <em>EReference1</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getEReference2 <em>EReference2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SnapshotImpl extends EObjectImpl implements Snapshot {
	/**
	 * The default value of the '{@link #getSnapshotId() <em>Snapshot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotId()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAPSHOT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSnapshotId() <em>Snapshot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotId()
	 * @generated
	 * @ordered
	 */
	protected String snapshotId = SNAPSHOT_ID_EDEFAULT;

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
	 * The cached value of the '{@link #getPartOf() <em>Part Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartOf()
	 * @generated
	 * @ordered
	 */
	protected Container partOf;

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
	 * The cached value of the '{@link #getStores() <em>Stores</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStores()
	 * @generated
	 * @ordered
	 */
	protected EList<ContentObject> stores;

	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected GeneralDocumentationFileProperty general;

	/**
	 * The cached value of the '{@link #getSystemComponent() <em>System Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemComponent()
	 * @generated
	 * @ordered
	 */
	protected SystemComponentLevelDocumentationFileProperty systemComponent;

	/**
	 * The cached value of the '{@link #getEReference0() <em>EReference0</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference0()
	 * @generated
	 * @ordered
	 */
	protected SystemComponentLevelDocumentationFileProperty eReference0;

	/**
	 * The cached value of the '{@link #getEReference1() <em>EReference1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference1()
	 * @generated
	 * @ordered
	 */
	protected Function eReference1;

	/**
	 * The cached value of the '{@link #getEReference2() <em>EReference2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference2()
	 * @generated
	 * @ordered
	 */
	protected GeneralDocumentationFileProperty eReference2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnapshotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.SNAPSHOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSnapshotId() {
		return snapshotId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapshotId(String newSnapshotId) {
		String oldSnapshotId = snapshotId;
		snapshotId = newSnapshotId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__SNAPSHOT_ID, oldSnapshotId, snapshotId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__CREATED, oldCreated, created));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getPartOf() {
		if (partOf != null && partOf.eIsProxy()) {
			InternalEObject oldPartOf = (InternalEObject)partOf;
			partOf = (Container)eResolveProxy(oldPartOf);
			if (partOf != oldPartOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.SNAPSHOT__PART_OF, oldPartOf, partOf));
			}
		}
		return partOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetPartOf() {
		return partOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartOf(Container newPartOf) {
		Container oldPartOf = partOf;
		partOf = newPartOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__PART_OF, oldPartOf, partOf));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__DELETED, oldDeleted, deleted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ContentObject> getStores() {
		if (stores == null) {
			stores = new EObjectWithInverseResolvingEList<ContentObject>(ContentObject.class, this, GeneralPackage.SNAPSHOT__STORES, GeneralPackage.CONTENT_OBJECT__PART_OF);
		}
		return stores;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectResolvingEList<Function>(Function.class, this, GeneralPackage.SNAPSHOT__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralDocumentationFileProperty getGeneral() {
		if (general != null && general.eIsProxy()) {
			InternalEObject oldGeneral = (InternalEObject)general;
			general = (GeneralDocumentationFileProperty)eResolveProxy(oldGeneral);
			if (general != oldGeneral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.SNAPSHOT__GENERAL, oldGeneral, general));
			}
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralDocumentationFileProperty basicGetGeneral() {
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneral(GeneralDocumentationFileProperty newGeneral) {
		GeneralDocumentationFileProperty oldGeneral = general;
		general = newGeneral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__GENERAL, oldGeneral, general));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemComponentLevelDocumentationFileProperty getSystemComponent() {
		if (systemComponent != null && systemComponent.eIsProxy()) {
			InternalEObject oldSystemComponent = (InternalEObject)systemComponent;
			systemComponent = (SystemComponentLevelDocumentationFileProperty)eResolveProxy(oldSystemComponent);
			if (systemComponent != oldSystemComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.SNAPSHOT__SYSTEM_COMPONENT, oldSystemComponent, systemComponent));
			}
		}
		return systemComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemComponentLevelDocumentationFileProperty basicGetSystemComponent() {
		return systemComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemComponent(SystemComponentLevelDocumentationFileProperty newSystemComponent) {
		SystemComponentLevelDocumentationFileProperty oldSystemComponent = systemComponent;
		systemComponent = newSystemComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__SYSTEM_COMPONENT, oldSystemComponent, systemComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemComponentLevelDocumentationFileProperty getEReference0() {
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEReference0(SystemComponentLevelDocumentationFileProperty newEReference0, NotificationChain msgs) {
		SystemComponentLevelDocumentationFileProperty oldEReference0 = eReference0;
		eReference0 = newEReference0;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__EREFERENCE0, oldEReference0, newEReference0);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference0(SystemComponentLevelDocumentationFileProperty newEReference0) {
		if (newEReference0 != eReference0) {
			NotificationChain msgs = null;
			if (eReference0 != null)
				msgs = ((InternalEObject)eReference0).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneralPackage.SNAPSHOT__EREFERENCE0, null, msgs);
			if (newEReference0 != null)
				msgs = ((InternalEObject)newEReference0).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneralPackage.SNAPSHOT__EREFERENCE0, null, msgs);
			msgs = basicSetEReference0(newEReference0, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__EREFERENCE0, newEReference0, newEReference0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getEReference1() {
		return eReference1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEReference1(Function newEReference1, NotificationChain msgs) {
		Function oldEReference1 = eReference1;
		eReference1 = newEReference1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__EREFERENCE1, oldEReference1, newEReference1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference1(Function newEReference1) {
		if (newEReference1 != eReference1) {
			NotificationChain msgs = null;
			if (eReference1 != null)
				msgs = ((InternalEObject)eReference1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneralPackage.SNAPSHOT__EREFERENCE1, null, msgs);
			if (newEReference1 != null)
				msgs = ((InternalEObject)newEReference1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneralPackage.SNAPSHOT__EREFERENCE1, null, msgs);
			msgs = basicSetEReference1(newEReference1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__EREFERENCE1, newEReference1, newEReference1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralDocumentationFileProperty getEReference2() {
		return eReference2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEReference2(GeneralDocumentationFileProperty newEReference2, NotificationChain msgs) {
		GeneralDocumentationFileProperty oldEReference2 = eReference2;
		eReference2 = newEReference2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__EREFERENCE2, oldEReference2, newEReference2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference2(GeneralDocumentationFileProperty newEReference2) {
		if (newEReference2 != eReference2) {
			NotificationChain msgs = null;
			if (eReference2 != null)
				msgs = ((InternalEObject)eReference2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneralPackage.SNAPSHOT__EREFERENCE2, null, msgs);
			if (newEReference2 != null)
				msgs = ((InternalEObject)newEReference2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneralPackage.SNAPSHOT__EREFERENCE2, null, msgs);
			msgs = basicSetEReference2(newEReference2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__EREFERENCE2, newEReference2, newEReference2));
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
			case GeneralPackage.SNAPSHOT__STORES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStores()).basicAdd(otherEnd, msgs);
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
			case GeneralPackage.SNAPSHOT__STORES:
				return ((InternalEList<?>)getStores()).basicRemove(otherEnd, msgs);
			case GeneralPackage.SNAPSHOT__EREFERENCE0:
				return basicSetEReference0(null, msgs);
			case GeneralPackage.SNAPSHOT__EREFERENCE1:
				return basicSetEReference1(null, msgs);
			case GeneralPackage.SNAPSHOT__EREFERENCE2:
				return basicSetEReference2(null, msgs);
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
			case GeneralPackage.SNAPSHOT__SNAPSHOT_ID:
				return getSnapshotId();
			case GeneralPackage.SNAPSHOT__CREATED:
				return getCreated();
			case GeneralPackage.SNAPSHOT__NAME:
				return getName();
			case GeneralPackage.SNAPSHOT__COMMENT:
				return getComment();
			case GeneralPackage.SNAPSHOT__PART_OF:
				if (resolve) return getPartOf();
				return basicGetPartOf();
			case GeneralPackage.SNAPSHOT__DELETED:
				return isDeleted();
			case GeneralPackage.SNAPSHOT__STORES:
				return getStores();
			case GeneralPackage.SNAPSHOT__FUNCTIONS:
				return getFunctions();
			case GeneralPackage.SNAPSHOT__GENERAL:
				if (resolve) return getGeneral();
				return basicGetGeneral();
			case GeneralPackage.SNAPSHOT__SYSTEM_COMPONENT:
				if (resolve) return getSystemComponent();
				return basicGetSystemComponent();
			case GeneralPackage.SNAPSHOT__EREFERENCE0:
				return getEReference0();
			case GeneralPackage.SNAPSHOT__EREFERENCE1:
				return getEReference1();
			case GeneralPackage.SNAPSHOT__EREFERENCE2:
				return getEReference2();
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
			case GeneralPackage.SNAPSHOT__SNAPSHOT_ID:
				setSnapshotId((String)newValue);
				return;
			case GeneralPackage.SNAPSHOT__CREATED:
				setCreated((Date)newValue);
				return;
			case GeneralPackage.SNAPSHOT__NAME:
				setName((String)newValue);
				return;
			case GeneralPackage.SNAPSHOT__COMMENT:
				setComment((String)newValue);
				return;
			case GeneralPackage.SNAPSHOT__PART_OF:
				setPartOf((Container)newValue);
				return;
			case GeneralPackage.SNAPSHOT__DELETED:
				setDeleted((Boolean)newValue);
				return;
			case GeneralPackage.SNAPSHOT__STORES:
				getStores().clear();
				getStores().addAll((Collection<? extends ContentObject>)newValue);
				return;
			case GeneralPackage.SNAPSHOT__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case GeneralPackage.SNAPSHOT__GENERAL:
				setGeneral((GeneralDocumentationFileProperty)newValue);
				return;
			case GeneralPackage.SNAPSHOT__SYSTEM_COMPONENT:
				setSystemComponent((SystemComponentLevelDocumentationFileProperty)newValue);
				return;
			case GeneralPackage.SNAPSHOT__EREFERENCE0:
				setEReference0((SystemComponentLevelDocumentationFileProperty)newValue);
				return;
			case GeneralPackage.SNAPSHOT__EREFERENCE1:
				setEReference1((Function)newValue);
				return;
			case GeneralPackage.SNAPSHOT__EREFERENCE2:
				setEReference2((GeneralDocumentationFileProperty)newValue);
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
			case GeneralPackage.SNAPSHOT__SNAPSHOT_ID:
				setSnapshotId(SNAPSHOT_ID_EDEFAULT);
				return;
			case GeneralPackage.SNAPSHOT__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case GeneralPackage.SNAPSHOT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneralPackage.SNAPSHOT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case GeneralPackage.SNAPSHOT__PART_OF:
				setPartOf((Container)null);
				return;
			case GeneralPackage.SNAPSHOT__DELETED:
				setDeleted(DELETED_EDEFAULT);
				return;
			case GeneralPackage.SNAPSHOT__STORES:
				getStores().clear();
				return;
			case GeneralPackage.SNAPSHOT__FUNCTIONS:
				getFunctions().clear();
				return;
			case GeneralPackage.SNAPSHOT__GENERAL:
				setGeneral((GeneralDocumentationFileProperty)null);
				return;
			case GeneralPackage.SNAPSHOT__SYSTEM_COMPONENT:
				setSystemComponent((SystemComponentLevelDocumentationFileProperty)null);
				return;
			case GeneralPackage.SNAPSHOT__EREFERENCE0:
				setEReference0((SystemComponentLevelDocumentationFileProperty)null);
				return;
			case GeneralPackage.SNAPSHOT__EREFERENCE1:
				setEReference1((Function)null);
				return;
			case GeneralPackage.SNAPSHOT__EREFERENCE2:
				setEReference2((GeneralDocumentationFileProperty)null);
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
			case GeneralPackage.SNAPSHOT__SNAPSHOT_ID:
				return SNAPSHOT_ID_EDEFAULT == null ? snapshotId != null : !SNAPSHOT_ID_EDEFAULT.equals(snapshotId);
			case GeneralPackage.SNAPSHOT__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case GeneralPackage.SNAPSHOT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneralPackage.SNAPSHOT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case GeneralPackage.SNAPSHOT__PART_OF:
				return partOf != null;
			case GeneralPackage.SNAPSHOT__DELETED:
				return deleted != DELETED_EDEFAULT;
			case GeneralPackage.SNAPSHOT__STORES:
				return stores != null && !stores.isEmpty();
			case GeneralPackage.SNAPSHOT__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case GeneralPackage.SNAPSHOT__GENERAL:
				return general != null;
			case GeneralPackage.SNAPSHOT__SYSTEM_COMPONENT:
				return systemComponent != null;
			case GeneralPackage.SNAPSHOT__EREFERENCE0:
				return eReference0 != null;
			case GeneralPackage.SNAPSHOT__EREFERENCE1:
				return eReference1 != null;
			case GeneralPackage.SNAPSHOT__EREFERENCE2:
				return eReference2 != null;
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
		result.append(" (snapshotId: ");
		result.append(snapshotId);
		result.append(", created: ");
		result.append(created);
		result.append(", name: ");
		result.append(name);
		result.append(", comment: ");
		result.append(comment);
		result.append(", deleted: ");
		result.append(deleted);
		result.append(')');
		return result.toString();
	}

} //SnapshotImpl
