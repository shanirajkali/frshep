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

import kali.dao.entity.TagSub1;

@Transactional
@Component
public class TagSub1RepositoryImpl implements TagSub1Repository{

	@Autowired
	SessionFactory session;
	
	public boolean save(TagSub1 ts) {
		session.getCurrentSession().save(ts);
		return true;
	}

	public TagSub1 get(int id) {
		return (TagSub1) session.getCurrentSession().get(TagSub1.class, id);		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TagSub1> getPatternWise(String like) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("TagSuper.getPatternWise");
		query.setString(0, "%"+like+"%");
		return (ArrayList<TagSub1>) query.list();
	}

	public boolean tagExist(String tagSub1Name) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSub1.class);
		criteria.add(Restrictions.eq("tagSub1Name", tagSub1Name));
		@SuppressWarnings("unchecked")
		ArrayList<TagSub1> list=(ArrayList<TagSub1>) criteria.list();
		if(list.size()>0)
		return true;
		else return false;

	}
	
	public TagSub1 getTagSub1(String tagSub1Name) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSub1.class);
		criteria.add(Restrictions.eq("tagSub1Name", tagSub1Name));
		@SuppressWarnings("unchecked")
		ArrayList<TagSub1> list=(ArrayList<TagSub1>) criteria.list();
		if(list.size()>0) return list.get(0);
		return null;
	}

}
