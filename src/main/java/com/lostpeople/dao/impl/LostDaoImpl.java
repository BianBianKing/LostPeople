package com.lostpeople.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lostpeople.dao.api.LostDao;
import com.lostpeople.forms.FindForm;
import com.lostpeople.forms.LostForm;

@Repository("lostDaoImpl")
public class LostDaoImpl implements LostDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public String addLostInfo(LostForm temp) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(temp);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "faile";
		}
	}

	@Override
	public List<LostForm> findALl() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from LostForm lostForm  order by lostForm.lostDate desc");
			List<LostForm> lostList=query.list();
			return lostList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LostForm> findRightNow() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from LostForm lostForm  where lostForm.type =:type order by lostForm.lostDate desc").setParameter("type", "0");
			List<LostForm> lostList=query.list();
			return lostList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public LostForm getLostById(Long id) {
		Session session=sessionFactory.getCurrentSession();
		LostForm lostForm = (LostForm)session.get(LostForm.class,id);
		return lostForm;
	}
}