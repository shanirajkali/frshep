package kali.dao.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.entity.UserAccount;

@Transactional
@Component
public class UserAccountRepositoryImpl implements UserAccountRepository {

	@Autowired
	SessionFactory session;
	
	public boolean create(UserAccount ua) {
		session.getCurrentSession().saveOrUpdate(ua);
		return true;
	}

	public boolean login(UserAccount ua) {
		
		return false;
	}

	public boolean phoneNoExits(long phoneNo) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("UserAccount.phoneNoExist");
		query.setLong(0, phoneNo);
		if(query.list().isEmpty()){
			return false;
		}
		return true;
	}

	public boolean emailIDExits(String emailID) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("UserAccount.emailIDExist");
		query.setString(0, emailID);
		if(query.list().isEmpty()){
			return false;
		}
		return true;
	}

	public boolean password(String password) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("UserAccount.password");
		query.setString(0, password);
		if(query.list().isEmpty()){
			return false;
		}
		return true;
		
	}
}
