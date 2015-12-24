package com.lostpeople.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lostpeople.dao.api.FindDao;
import com.lostpeople.dao.api.LostDao;
import com.lostpeople.dao.api.VolunteerDao;
import com.lostpeople.forms.FindForm;
import com.lostpeople.forms.LostForm;
import com.lostpeople.service.api.LostService;
import com.lostpeople.util.MatchFace;
import com.lostpeople.util.MatchResult;

@Service
@Transactional
public class LostServiceImpl implements LostService{

	@Autowired
	@Qualifier("lostDaoImpl")
	private LostDao lostDao;
	
	@Autowired
	@Qualifier("findDaoImpl")
	private FindDao findDao;
	
	@Autowired
	@Qualifier("volunteerDaoImpl")
	private VolunteerDao volunteerDao;
	
	@Override
	public String addLostInfo(LostForm temp) {
		return lostDao.addLostInfo(temp);
	}
	@Override
	public MatchResult matchFaceFind(LostForm temp) {
		List<FindForm> findList = findDao.findALl();
		String image1, image2;
	  	try { 
		   if (temp.getPhoto3() != null) {
			   image1 = temp.getPhoto3();
			   for (FindForm t : findList) {
				   image2 = t.getPhoto1();
				   double result = MatchFace.matchFace(image1, image2);
				   System.out.println(result);
				   if (result > 60) {
					   return new MatchResult(t, result);
				   }
			   	}
			    
		   } else if (temp.getPhoto2() != null) {
			   image1 = temp.getPhoto2();
			   for (FindForm t : findList) {
				   image2 = t.getPhoto1();
				   double result = MatchFace.matchFace(image1, image2);
				   System.out.println(result);
				   if (result > 60) {
					   return new MatchResult(t, result);
				   }
			   	}
		   } else if (temp.getPhoto1() != null) {
			   image1 = temp.getPhoto1();
			   for (FindForm t : findList) {
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
	@Override
	public LostForm getLostById(Long id) {
		return lostDao.getLostById(id);
	}
}
