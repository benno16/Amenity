package com.amenity.workbench.views.interfaces;

import general.User;

import java.util.Date;
import java.util.List;

public interface IStartupView {
	
	public Date getLastLogin();
	public int	getTimesUsed();
	public List<String> getLastErrors();
	public User getCurrentUser();
	
	public boolean isMKSRunning();
	public boolean isSynergyRunning();
	public boolean isDatabaseRunning();
	
}
