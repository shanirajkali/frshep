package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.TagSub0;

public interface TagSub0Repository {
	public boolean save(TagSub0 ts);
	public TagSub0 get(int id);
	public long getIdByName(String sub0Name);
	public ArrayList<TagSub0> getPatternWise(String like);
	public ArrayList<String> getAllSub0BySuperTagId(long SuperId);
	public boolean tagExist(String tagSub0Name);
	public TagSub0 getTagSub0(String tagSub0Name);
}