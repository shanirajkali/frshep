package kali.dao.repository;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.entity.TagSub3;

@Transactional
@Component
public class TagSub3RepositoryImpl implements TagSub3Repository{

	@Autowired
	SessionFactory session;
	
	public boolean save(TagSub3 ts) {
		session.getCurrentSession().save(ts);
		return true;
	}

	public TagSub3 get(int id) {
		return (TagSub3) session.getCurrentSession().get(TagSub3.class, id);		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TagSub3> getPatternWise(String like) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("TagSuper.getPatternWise");
		query.setString(0, "%"+like+"%");
		return (ArrayList<TagSub3>) query.list();
	}

	public boolean tagExist(String tagSub3Name) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSub3.class);
		criteria.add(Restrictions.eq("tagSub3Name", tagSub3Name));
		@SuppressWarnings("unchecked")
		ArrayList<TagSub3> list=(ArrayList<TagSub3>) criteria.list();
		if(list.size()>0)
		return true;
		else return false;

	}
	
	public TagSub3 getTagSub3(String tagSub3Name) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSub3.class);
		criteria.add(Restrictions.eq("tagSub3Name", tagSub3Name));
		@SuppressWarnings("unchecked")
		ArrayList<TagSub3> list=(ArrayList<TagSub3>) criteria.list();
		if(list.size()>0) return list.get(0);
		return null;
	}

}
