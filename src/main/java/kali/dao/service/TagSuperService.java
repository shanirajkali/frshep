package kali.dao.service;

import java.util.ArrayList;

public interface TagSuperService {
	
	public ArrayList<String> getAllSuperTag();
	public long getIdByName(String superTagName);

}
