package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.TagSub1;

public interface TagSub1Repository {
	public boolean save(TagSub1 ts);
	public TagSub1 get(int id);
	public ArrayList<TagSub1> getPatternWise(String like);
	public long getIdByName(String sub1Name);
	public ArrayList<String> getAllBySub0Id(long sub0Id);
	public boolean tagExist(String tagSub1Name);
	public TagSub1 getTagSub1(String tagSub1Name);
}
