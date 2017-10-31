package kali.dao.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kali.dao.entity.UserAccount;
import kali.dao.repository.AddressRepository;
import kali.dao.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService{

	@Autowired UserRepository ur;
	@Autowired AddressRepository ar;
	
	public boolean isCurrentUserLoggedIn(HttpSession session) {
		String email=(String) session.getAttribute("email");
		if(email==null) return false;
		String password=(String) session.getAttribute("password");
		if(password==null) return false;
		if(ur.isCurrentUserLoggedIn(email, password)) return true;
		return false;
	}

	public String save(UserAccount ua) {
		if(ua.getAddress()!=null){
			
		}
		return null;
	}

}
