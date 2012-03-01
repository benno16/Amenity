package com.amenity.engine.helper.gui;

import org.eclipse.swt.dnd.ByteArrayTransfer;

public class SnapshotTransfer extends ByteArrayTransfer {
	private static SnapshotTransfer instance = new SnapshotTransfer();
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

}
