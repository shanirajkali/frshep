package kali.dao.service;

import javax.servlet.http.HttpSession;

import kali.dao.entity.UserAccount;



public interface UserService {
	public boolean isCurrentUserLoggedIn(HttpSession session);
	public String save(UserAccount ua);
}
