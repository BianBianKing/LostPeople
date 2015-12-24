package com.lostpeople.dao.api;

import java.util.List;

import com.lostpeople.forms.VolunteerForm;

public interface VolunteerDao {
	public String addVolunteerInfo(VolunteerForm temp);
	public List<VolunteerForm> findALl();
}
