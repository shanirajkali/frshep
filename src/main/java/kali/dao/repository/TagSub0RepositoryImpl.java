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

import kali.dao.entity.TagSub0;

@Transactional
@Component
public class TagSub0RepositoryImpl implements TagSub0Repository{

	@Autowired
	SessionFactory session;
	
	public boolean save(TagSub0 ts) {
		session.getCurrentSession().save(ts);
		return true;
	}

	public TagSub0 get(int id) {
		return (TagSub0) session.getCurrentSession().get(TagSub0.class, id);		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TagSub0> getPatternWise(String like) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("TagSub0.getPatternWise");
		query.setString(0, "%"+like+"%");
		return (ArrayList<TagSub0>) query.list();
	}

	public boolean tagExist(String tagSub0Name) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSub0.class);
		criteria.add(Restrictions.eq("tagSub0Name", tagSub0Name));
		@SuppressWarnings("unchecked")
		ArrayList<TagSub0> list=(ArrayList<TagSub0>) criteria.list();
		if(list.size()>0)
		return true;
		else return false;

	}

	public TagSub0 getTagSub0(String tagSub0Name) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSub0.class);
		criteria.add(Restrictions.eq("tagSub0Name", tagSub0Name));
		@SuppressWarnings("unchecked")
		ArrayList<TagSub0> list=(ArrayList<TagSub0>) criteria.list();
		if(list.size()>0) return list.get(0);
		return null;
	}

}
