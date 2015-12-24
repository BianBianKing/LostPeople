package com.lostpeople.service.api;

import com.lostpeople.forms.LostForm;
import com.lostpeople.util.MatchResult;

public interface LostService {
	public String addLostInfo(LostForm temp);
	public MatchResult matchFaceFind(LostForm temp);
	public LostForm getLostById(Long id);
}
