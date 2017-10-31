package kali.dao.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.entity.News;

@Component
@Transactional
public class NewsRepositoryImpl implements NewsRepository{

	@Autowired
	SessionFactory session;
	
	public boolean save(News news) {
		try{session.getCurrentSession().saveOrUpdate(news);
		}catch(Exception e){
			System.out.println("exception");
			e.printStackTrace();
			return false;}return true;
	}

}
