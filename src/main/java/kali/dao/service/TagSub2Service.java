package kali.dao.service;

import java.util.ArrayList;

public interface TagSub2Service {
	public long getIdByName(String tagSub2Name);
	public ArrayList<String> getAllBySub1Name(String sub1Name);
	
}
