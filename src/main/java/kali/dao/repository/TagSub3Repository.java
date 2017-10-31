package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.TagSub3;

public interface TagSub3Repository {

	public boolean save(TagSub3 ts);
	public TagSub3 get(int id);
	public ArrayList<TagSub3> getPatternWise(String like);
	public boolean tagExist(String tagSub3Name);
	public TagSub3 getTagSub3(String tagSub3Name);
}
