package com.lostpeople.service.api;

import com.lostpeople.forms.VolunteerForm;
import com.lostpeople.util.MatchResult;

public interface VolunteerService {
	public String addVolunteerInfo(VolunteerForm temp);
	public MatchResult matchFace(VolunteerForm temp);
}
