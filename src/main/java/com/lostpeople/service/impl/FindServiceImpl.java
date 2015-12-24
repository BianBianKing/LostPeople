package com.lostpeople.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lostpeople.dao.api.FindDao;
import com.lostpeople.dao.api.LostDao;
import com.lostpeople.forms.FindForm;
import com.lostpeople.forms.LostForm;
import com.lostpeople.service.api.FindService;
import com.lostpeople.util.MatchFace;
import com.lostpeople.util.MatchResult;


@Service
@Transactional
public class FindServiceImpl implements FindService{

	@Autowired
	@Qualifier("findDaoImpl")
	private FindDao findDao;
	
	@Autowired
	@Qualifier("lostDaoImpl")
	private LostDao lostDao;
	
	@Override
	public String addFindInfo(FindForm temp) {
		return findDao.addFindInfo(temp);
	}
	
	@Override
	public MatchResult matchFace(FindForm temp) {
		List<LostForm> lostList = lostDao.findALl();
		String image1, image2;
	  	try { 
		   if (temp.getPhoto1() != null) {
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

	@Override
	public FindForm getFindById(Long id) {
		return findDao.getFindById(id);
	}

}
