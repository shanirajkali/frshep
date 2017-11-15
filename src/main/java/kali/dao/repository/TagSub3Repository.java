package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.TagSub3;

public interface TagSub3Repository {

	public boolean save(TagSub3 ts);
	public TagSub3 get(int id);
	public long getIdByName(String tagSub3Name);
	public ArrayList<String> getAllBySub2Id(long sub2Id);
	public ArrayList<TagSub3> getPatternWise(String like);
	public ArrayList<String> getAllBySub2Id(int sub2Id);
	public boolean tagExist(String tagSub3Name);
	public TagSub3 getTagSub3(String tagSub3Name);
}
