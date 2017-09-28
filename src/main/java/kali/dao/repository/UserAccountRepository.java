package kali.dao.repository;

import kali.dao.entity.UserAccount;

public interface UserAccountRepository {
	public boolean create(UserAccount ua);
	public boolean login(UserAccount ua);
	public boolean phoneNoExits(long phoneNo);
	public boolean emailIDExits(String emailID);
	public boolean password(String password);
	
}
