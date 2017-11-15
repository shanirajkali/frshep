package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.TagSuper;

public interface TagSuperRepository {
	public boolean save(TagSuper ts);
	public TagSuper get(int id);
	public long getId(String superTagName);
	public ArrayList<TagSuper> getPatternWise(String like);
	public ArrayList<String> getAll();
	public boolean tagExist(String tagSuperName);
	public TagSuper getTagSuper(String tagSuperName);
}
