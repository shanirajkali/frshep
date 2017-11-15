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

import kali.dao.entity.TagSub2;

@Transactional
@Component
public class TagSub2RepositoryImpl implements TagSub2Repository{

	@Autowired
	SessionFactory session;
	
	public boolean save(TagSub2 ts) {
		session.getCurrentSession().save(ts);
		return true;
	}

	public TagSub2 get(int id) {
		return (TagSub2) session.getCurrentSession().get(TagSub2.class, id);		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TagSub2> getPatternWise(String like) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("TagSuper.getPatternWise");
		query.setString(0, "%"+like+"%");
		return (ArrayList<TagSub2>) query.list();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getAllBySub1Id(int sub1Id) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("TagSub2.getAllBySub1Id");
		query.setInteger(0, sub1Id);
		return (ArrayList<String>) query.list();
	}
	
	public boolean tagExist(String tagSub2Name) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSub2.class);
		criteria.add(Restrictions.eq("tagSub2Name", tagSub2Name));
		@SuppressWarnings("unchecked")
		ArrayList<TagSub2> list=(ArrayList<TagSub2>) criteria.list();
		if(list.size()>0)
		return true;
		else return false;

	}
	
	public TagSub2 getTagSub2(String tagSub2Name) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSub2.class);
		criteria.add(Restrictions.eq("tagSub2Name", tagSub2Name));
		@SuppressWarnings("unchecked")
		ArrayList<TagSub2> list=(ArrayList<TagSub2>) criteria.list();
		if(list.size()>0) return list.get(0);
		return null;
	}
}