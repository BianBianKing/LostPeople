package com.lostpeople.service.api;

import com.lostpeople.forms.FindForm;
import com.lostpeople.util.MatchResult;

public interface FindService {
	public String addFindInfo(FindForm temp);
	public MatchResult matchFace(FindForm temp);
	public FindForm getFindById(Long id);
}
