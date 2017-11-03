package kali.dao.repository;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.entity.TagSub0;
import kali.dao.entity.TagSub1;
import kali.dao.entity.TagSub2;
import kali.dao.entity.TagSub3;
import kali.dao.entity.TagSuper;
import kali.dao.entity.final_calculation;

@Transactional
@Component
public class TagRepositoryImpl implements TagRepository{

	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getAllTagByLikePattern(String like) {
		
		Session current=session.getCurrentSession();
		Criteria criteria = current.createCriteria(TagSuper.class);
		criteria.add(Restrictions.like("tagSuperName","%"+like+"%"))
				.setProjection(Projections.property("tagSuperName"));
		
			ArrayList<String> result=(ArrayList<String>) criteria.list();
			
			//fatching tag from TagSub0 table
			criteria=current.createCriteria(TagSub0.class);
			criteria.add((Restrictions.like("tagSub0Name","%"+like+"%")))
					.setProjection(Projections.property("tagSub0Name"));
			result.addAll(criteria.list());
			
			//fatching tag from TagSub1 table
			criteria=current.createCriteria(TagSub1.class);
			criteria.add((Restrictions.like("tagSub1Name","%"+like+"%")))
					.setProjection(Projections.property("tagSub1Name"));
			result.addAll(criteria.list());
			
			//fatching tag from TagSub2 table
			criteria=current.createCriteria(TagSub2.class);
			criteria.add((Restrictions.like("tagSub2Name","%"+like+"%")))
					.setProjection(Projections.property("tagSub2Name"));
			result.addAll(criteria.list());
			
			//fatching tag from TagSub3 table
			criteria=current.createCriteria(TagSub3.class);
			criteria.add((Restrictions.like("tagSub3Name","%"+like+"%")))
					.setProjection(Projections.property("tagSub3Name"));
			result.addAll(criteria.list());
					
			return result;
	}
	
	public String getRecord(String accesscode){
		@SuppressWarnings("unchecked")
		ArrayList<Integer> id=(ArrayList<Integer>)session
		.getCurrentSession().getNamedQuery("users.getUid").setString(0, accesscode).list();
		
		Iterator<Integer> it=id.iterator();
		
		Session current=session.getCurrentSession();
		
		String res="";
		
		while(it.hasNext()){
			@SuppressWarnings("unchecked")
			ArrayList<Integer> match=(ArrayList<Integer>)session
					.getCurrentSession()
					.getNamedQuery("final_calculation.getMatch")
					.setInteger(0, it.next()).setMaxResults(5).list();
			res=res+"  "+match.toString();
	
		}		
		return	id.toString()+"    "+res;
	}

}
