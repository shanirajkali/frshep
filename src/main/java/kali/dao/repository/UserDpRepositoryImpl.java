package kali.dao.repository;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.entity.UserDp;

@Transactional
@Component
public class UserDpRepositoryImpl implements UserDpRepository{

	@Autowired
	SessionFactory session;
	
	public boolean save(UserDp ud) {
		session.getCurrentSession().saveOrUpdate(ud);
		return true;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getAll(int id) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("UserDp.selectAllByUserId");
		query.setLong(0, id);
		return (ArrayList<String>)query.list();
	}

}
