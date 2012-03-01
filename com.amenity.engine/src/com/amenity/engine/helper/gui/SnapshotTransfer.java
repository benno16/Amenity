package com.amenity.engine.helper.gui;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TransferData;

public class SnapshotTransfer extends ByteArrayTransfer {
	
	private static SnapshotTransfer instance = new SnapshotTransfer();
	
	// globally unique snapshot transfer type
	private static final String TYPE_NAME = "snapshot-transfer-format";
	private static final int TYPEID = registerType(TYPE_NAME);

	/**
	 * TODO: http://www.eclipse.org/articles/Article-Workbench-DND/drag_drop.html
	 * @return
	 */
	// singleton return!
	public static SnapshotTransfer getInstance() {
		return instance;
	}
	
	
	// block instantiation
	private SnapshotTransfer() {}
	
	@Override
	protected int[] getTypeIds() {
		return new int[] { TYPEID };
	}

	@Override
	protected String[] getTypeNames() {
		return new String[] { TYPE_NAME };
	}
	
	public void javaToNative ( Object object, TransferData transferData ) {
		if ( !checkType(object) || !isSupportedType (transferData ) ) {
			DND.error(DND.ERROR_INVALID_DATA);
		}
	}
	
	boolean checkType ( Object object ) {
		if ( object == null || !(object instanceof general.File)
				 || !(object instanceof general.Folder)) 
			return false;
		return true;
	}
}
