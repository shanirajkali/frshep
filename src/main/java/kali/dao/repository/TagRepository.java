package kali.dao.repository;

import java.util.ArrayList;

public interface TagRepository {
	public ArrayList<String> getAllTagByLikePattern(String like);
}
