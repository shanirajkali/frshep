package kali.dao.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kali.dao.entity.News;
import kali.dao.entity.NewsMedia;
import kali.dao.entity.TagSub0;
import kali.dao.entity.TagSub1;
import kali.dao.entity.TagSub2;
import kali.dao.entity.TagSub3;
import kali.dao.entity.TagSuper;
import kali.dao.repository.NewsRepository;
import kali.dao.repository.TagSub0Repository;
import kali.dao.repository.TagSub1Repository;
import kali.dao.repository.TagSub2Repository;
import kali.dao.repository.TagSub3Repository;
import kali.dao.repository.TagSuperRepository;
import kali.dao.repository.UserRepository;
import kali.web.rest.validation.NewsRest;

@Component
public class NewsServiceImpl implements NewsService{

	@Autowired NewsRepository newsRepository;
	@Autowired UserRepository uar;
	@Autowired NewsMediaService newsMediaService;
	@Autowired UserService us;
	@Autowired TagSuperRepository tsr;
	@Autowired TagSub0Repository ts0r;
	@Autowired TagSub1Repository ts1r;
	@Autowired TagSub2Repository ts2r;
	@Autowired TagSub3Repository ts3r;
	public boolean save(HttpSession session,NewsRest newsRest) {
		News news=new News();
		System.out.println("end7");
		if( !us.isCurrentUserLoggedIn(session) ) return false; 
		System.out.println("end9");
		String email=(String) session.getAttribute("email");
		String password=(String) session.getAttribute("password");
		if(email==null) return false;
		if(password==null) return false;
		news.setUserId(uar.getDetails(email, password));
		news.setHeading(newsRest.getHeading());
		news.setDescription(newsRest.getDescription());
		news.setLike(0);
		news.setView(0);
		news.setGenuine(0);
		
		System.out.println("end4");
		ArrayList<String> tagList=(ArrayList<String>) newsRest.getTag();
		Iterator<String> tag = tagList.iterator();
		System.out.println("end5");
		if( tag.hasNext() ){
			TagSuper tagSuper=tsr.getTagSuper(tag.next());
			if(tagSuper!=null){
				news.setTagSuperId(tagSuper);
				if(tag.hasNext()){
					TagSub0 tagSub0= ts0r.getTagSub0(tag.next());
					if(tagSub0!=null){
						news.setTagSub0Id(tagSub0);
						if(tag.hasNext()){
							TagSub1 tagSub1= ts1r.getTagSub1(tag.next());
							if(tagSub1!=null){
								news.setTagSub1Id(tagSub1);
								if(tag.hasNext()){
									TagSub2 tagSub2= ts2r.getTagSub2(tag.next());
									if(tagSub2!=null){
										news.setTagSub2Id(tagSub2);
										if(tag.hasNext()){
											TagSub3 tagSub3= ts3r.getTagSub3(tag.next());
											if(tagSub3!=null){
												news.setTagSub3Id(tagSub3);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		ArrayList<NewsMedia> newsMedia=new ArrayList<NewsMedia>();
		System.out.println("end2");
		@SuppressWarnings("unchecked")
		ArrayList<NewsMedia> files=(ArrayList<NewsMedia>) session.getAttribute("files");
		if(files!=null){
			Iterator<NewsMedia> file = files.iterator();
			while(file.hasNext()){
				NewsMedia nm=file.next();
				nm=newsMediaService.saveAndGet(nm);
				newsMedia.add(nm);
			}
			session.removeAttribute("files");
		}
		System.out.println("end1");
		news.setNewsMedia(newsMedia);
		System.out.println("end");
		if( newsRepository.save(news) ){ return true;}
		else{ return false;}
	}

}
