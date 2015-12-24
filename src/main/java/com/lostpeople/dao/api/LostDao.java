package com.lostpeople.dao.api;

import java.util.List;

import com.lostpeople.forms.LostForm;

public interface LostDao {
	public String addLostInfo(LostForm temp);
	public List<LostForm> findALl();
	public List<LostForm> findRightNow();
	public LostForm getLostById(Long id);
}
