package kali.dao.repository;


import com.fasterxml.jackson.core.JsonProcessingException;

import kali.dao.entity.UserAccount;

public interface UserRepository {
	public boolean create(UserAccount ua);
	public boolean login(UserAccount ua);
	public boolean isCurrentUserLoggedIn(String email,String password);
	public boolean phoneNoExits(long phoneNo);
	public boolean emailIDExits(String emailID);
	public boolean password(String password);
	public UserAccount getDetails(String email, String password);
	public int getIdByEmailAndPassword(String email, String password);
	public String getAllUsers() throws JsonProcessingException;
	
}
