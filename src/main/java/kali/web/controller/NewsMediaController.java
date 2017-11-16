package kali.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.FileManager;
import kali.commons.util.Path;
import kali.commons.util.Status;
import kali.commons.util.UrlName;
import kali.dao.entity.NewsMedia;
import kali.dao.service.NewsMediaService;
import kali.dao.service.UserService;

@RestController
@RequestMapping(value=UrlName.newsMedia)
public class NewsMediaController {
	
	@Autowired
	UserService us;
	
	@Autowired
	NewsMediaService nms;
	
	@Autowired
	ObjectMapper jackson;
	
	
	@RequestMapping(value=UrlName.upload, method=RequestMethod.POST)
	public String upload(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException{
		if(!us.isCurrentUserLoggedIn(session)) return Status.loginFirst;
		
		NewsMedia nm=new NewsMedia();
		nm.setUrl("rej");
		return jackson.writeValueAsString(nms.saveAndGet(nm));
	}
	
	@RequestMapping(value="/uploadNewsMedia", method=RequestMethod.POST)
	public String uploadNewsMedia(@RequestParam("file") CommonsMultipartFile[] file,HttpSession session) throws JsonProcessingException{
		
		//if(!us.isCurrentUserLoggedIn(session)) return Status.loginFirst;
		int i=0;
		ArrayList<NewsMedia> nm=new ArrayList<NewsMedia>();
		
		while(i < file.length ){
			String actualFile= FileManager.fileUpload(file[i], session.getServletContext().getRealPath(Path.newsMedia) );
			if(actualFile.equals("false")) return Status.fileNotSupported;
			NewsMedia news=new NewsMedia();
			news.setUrl(session.getServletContext().getRealPath(Path.newsMedia)+actualFile);
			nm.add(news);
			i++;
		}
		session.setAttribute("files", nm);
		return Status.fileSuccessfullyUploaded;
	}
}
