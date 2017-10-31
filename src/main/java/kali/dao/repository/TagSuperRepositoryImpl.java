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

import kali.dao.entity.TagSuper;

@Transactional
@Component
public class TagSuperRepositoryImpl implements TagSuperRepository {

	@Autowired
	SessionFactory session;
	
	public boolean save(TagSuper ts) {
		session.getCurrentSession().save(ts);
		return true;
	}

	public TagSuper get(int id) {
		return (TagSuper) session.getCurrentSession().get(TagSuper.class, id);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TagSuper> getPatternWise(String like) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("TagSuper.getTagSuperNameByLike");
		query.setString(0, "%"+like+"%");
		return (ArrayList<TagSuper>) query.list();
	}

	public boolean tagExist(String tagSuperName) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSuper.class);
		criteria.add(Restrictions.eq("tagSuperName", tagSuperName));
		@SuppressWarnings("unchecked")
		ArrayList<TagSuper> list=(ArrayList<TagSuper>) criteria.list();
		if(list.size()>0)
		return true;
		else return false;
	}

	public TagSuper getTagSuper(String tagSuperName) {
		Session current=session.getCurrentSession();
		Criteria criteria=current.createCriteria(TagSuper.class);
		criteria.add(Restrictions.eq("tagSuperName", tagSuperName));
		@SuppressWarnings("unchecked")
		ArrayList<TagSuper> list=(ArrayList<TagSuper>) criteria.list();
		if(list.size()>0) return list.get(0);
		return null;
	}

}
