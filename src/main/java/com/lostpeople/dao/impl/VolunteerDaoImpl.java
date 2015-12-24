package com.lostpeople.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lostpeople.dao.api.VolunteerDao;
import com.lostpeople.forms.LostForm;
import com.lostpeople.forms.VolunteerForm;

@Repository("volunteerDaoImpl")
public class VolunteerDaoImpl implements VolunteerDao{
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public String addVolunteerInfo(VolunteerForm temp) {
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
	public List<VolunteerForm> findALl() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from VolunteerForm volunteerForm  order by volunteerForm.lostDate desc");
			List<VolunteerForm> volunteerList=query.list();
			return volunteerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
