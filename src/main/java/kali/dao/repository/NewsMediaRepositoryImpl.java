package kali.dao.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.entity.NewsMedia;

@Repository
public class NewsMediaRepositoryImpl implements NewsMediaRepository {

	@Autowired
	SessionFactory session;
	
	@Transactional
	public boolean save(NewsMedia newsMedia) {
		try{
			session.getCurrentSession().saveOrUpdate(newsMedia);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteById(long id) {
		return false;
	}

	@Transactional
	public boolean deleteByObject(NewsMedia newsMedia) {
		return false;
	}

	@Transactional
	public NewsMedia getByUrl(String url) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("NewsMedia.getByUrl");
		query.setString(0, url);
		query.setMaxResults(1);
		
		return (NewsMedia) query.list().get(0);
	}
}