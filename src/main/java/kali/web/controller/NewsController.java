package kali.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.dao.service.NewsService;
import kali.web.rest.validation.NewsRest;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	RequestString rs;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	NewsService newsService;
	
	@RequestMapping(value="/post",method=RequestMethod.POST)
	public String doPost(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		NewsRest newsRest;
		try {
			String requestData=rs.getRequestBody(request.getInputStream());
			newsRest=mapper.readValue(requestData, NewsRest.class);
			if(newsService.save(session,newsRest)){
				return "done";
			}else return "not done";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;	
	}
}
