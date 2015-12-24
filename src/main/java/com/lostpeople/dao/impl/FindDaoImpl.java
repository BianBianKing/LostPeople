package com.lostpeople.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lostpeople.dao.api.FindDao;
import com.lostpeople.forms.FindForm;

@Repository("findDaoImpl")
public class FindDaoImpl implements FindDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public String addFindInfo(FindForm temp) {
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
	public List<FindForm> findALl() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from FindForm findForm  order by findForm.lostDate desc");
			List<FindForm> findList=query.list();
			return findList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FindForm getFindById(Long id) {
		Session session=sessionFactory.getCurrentSession();
		FindForm findForm = (FindForm)session.get(FindForm.class,id);
		return findForm;
	}
}
