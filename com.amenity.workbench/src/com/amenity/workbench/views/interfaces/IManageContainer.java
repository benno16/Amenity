package com.amenity.workbench.views.interfaces;

import java.util.List;

import com.amenity.workbench.supporter.classes.ContainerClass;

public interface IManageContainer {
	
	public List<String> getProjects();
	public List<String> getSnapshotsForProject ( String projectID );
	public ContainerClass getContainer ( String containerID );

	
}
