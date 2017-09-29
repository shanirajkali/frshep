package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.UserDp;

public interface UserDpRepository {
	public boolean save(UserDp ud);
	public ArrayList<String> getAll(int id);
}
