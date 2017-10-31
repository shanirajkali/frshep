package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.TagSub2;

public interface TagSub2Repository {

	public boolean save(TagSub2 ts);
	public TagSub2 get(int id);
	public ArrayList<TagSub2> getPatternWise(String like);
	public boolean tagExist(String tagSub2Name);
	public TagSub2 getTagSub2(String tagSub2Name);
}
