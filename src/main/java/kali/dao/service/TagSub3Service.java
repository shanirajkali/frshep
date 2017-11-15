package kali.dao.service;

import java.util.ArrayList;

public interface TagSub3Service {
	public long getIdByName(String name);
	public ArrayList<String> getAllBySub2Name(String sub2Name);
}
