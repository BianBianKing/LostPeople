package com.lostpeople.dao.api;

import java.util.List;

import com.lostpeople.forms.FindForm;

public interface FindDao {
	public String addFindInfo(FindForm temp);
	public List<FindForm> findALl();
	public FindForm getFindById(Long id);
}
