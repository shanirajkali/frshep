package kali.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.commons.util.URL;
import kali.dao.repository.TagRepository;

@RestController
@RequestMapping(URL.tag)
public class TagController {

	@Autowired
	TagRepository tagRepo;
	
	@Autowired
	RequestString requestString;
	
	ObjectMapper objectMapper=new ObjectMapper();
	
	@RequestMapping(value=URL.getAllPatternWise, method=RequestMethod.POST)
	public String getAllPatternWise(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, Exception{
		
		String  requestBody = requestString.getRequestBody(request.getInputStream());
		
		return	objectMapper.writeValueAsString(tagRepo.getAllTagByLikePattern(requestBody));
		
	}
}
