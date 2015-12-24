package com.lostpeople.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lostpeople.dao.api.LostDao;
import com.lostpeople.dao.api.VolunteerDao;
import com.lostpeople.forms.LostForm;
import com.lostpeople.forms.VolunteerForm;
import com.lostpeople.service.api.VolunteerService;
import com.lostpeople.util.MatchFace;
import com.lostpeople.util.MatchResult;

@Service
@Transactional
public class VolunteerServiceImpl implements VolunteerService{
	
	@Autowired
	@Qualifier("volunteerDaoImpl")
	private VolunteerDao volunteerDao;
	
	@Autowired
	@Qualifier("lostDaoImpl")
	private LostDao lostDao;
	
	@Override
	public String addVolunteerInfo(VolunteerForm temp) {
		return volunteerDao.addVolunteerInfo(temp);
	}
	@Override
	public MatchResult matchFace(VolunteerForm temp) {
		List<LostForm> lostList = lostDao.findRightNow();
		String image1, image2;
		System.out.println("test");
		
	  	try { 
		   if (temp.getPhoto3() != null) {
			   image1 = temp.getPhoto3();
			   for (LostForm t : lostList) {
				   image2 = t.getPhoto1();
				   double result = MatchFace.matchFace(image1, image2);
				   System.out.println(result);
				   if (result > 60) {
					   return new MatchResult(t, result);
				   }
			   	}
			    
		   } else if (temp.getPhoto2() != null) {
			   image1 = temp.getPhoto2();
			   for (LostForm t : lostList) {
				   image2 = t.getPhoto1();
				   double result = MatchFace.matchFace(image1, image2);
				   System.out.println(result);
				   if (result > 60) {
					   return new MatchResult(t, result);
				   }
			   	}
		   } else if (temp.getPhoto1() != null) {
			   image1 = temp.getPhoto1();
			   for (LostForm t : lostList) {
				   image2 = t.getPhoto1();
				   double result = MatchFace.matchFace(image1, image2);
				   System.out.println(result);
				   if (result > 60) {
					   return new MatchResult(t, result);
				   }
			   	}
		   } 
		   return null;
	  	}catch (Exception e) {
			return null;
		}
	}
	

}
