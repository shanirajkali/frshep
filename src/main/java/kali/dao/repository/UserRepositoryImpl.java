package kali.dao.repository;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kali.dao.entity.UserAccount;

@Transactional
@Component
public class UserRepositoryImpl implements UserRepository {

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

	public UserAccount getDetails(String email, String password) {
		Session current = session.getCurrentSession();
		Query query = current.getNamedQuery("UserAccount.getDetailsByEmailAndPassword");
		query.setString(0, email);
		query.setString(1, password);
		query.setMaxResults(1);
		return (UserAccount)query.uniqueResult();
	}

	public int getIdByEmailAndPassword(String email, String password) {
		Session current = session.getCurrentSession();
		Query query = current.getNamedQuery("UserAccount.selectIdByEmailAndPassword");
		query.setString(0, email);
		query.setString(1, password);
		query.setMaxResults(1);
		return (Integer) query.uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	public String getAllUsers() throws JsonProcessingException {
		Session current =session.getCurrentSession();
		Query query = current.getNamedQuery("UserAccount.selectAll");
		ObjectMapper mapper=new ObjectMapper();
		ArrayList<UserAccount> ua= (ArrayList<UserAccount>) query.list();
		return mapper.writeValueAsString(ua);
	}

	public boolean isCurrentUserLoggedIn(String email, String password) {
		if(getDetails(email,password)==null) 
			return false;
		else return true;
	}

	
}
