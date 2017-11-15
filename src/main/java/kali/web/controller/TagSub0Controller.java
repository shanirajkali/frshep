package kali.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.commons.util.Status;
import kali.commons.util.URL;
import kali.dao.entity.TagSub0;
import kali.dao.entity.TagSuper;
import kali.dao.repository.TagSub0Repository;
import kali.dao.repository.TagSuperRepository;
import kali.dao.service.TagSub0Service;

@RestController
@RequestMapping(URL.tag)
public class TagSub0Controller {
	
	@Autowired TagSub0Repository tagSub0Repository;
	@Autowired TagSuperRepository tagSuperRepository;
	
	@Autowired TagSub0Service tagSub0Service;
	
	@Autowired
	RequestString requestString;
	
	ObjectMapper jackson=new ObjectMapper();

	@RequestMapping(value=URL.tagSub0+URL.create, method=RequestMethod.POST)
	public String doCreate(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub0 tagSub0=jackson.readValue( requestBody, TagSub0.class);
			System.out.println("bfore get super");
			if(tagSub0.getTagSuperId()!=null){
			TagSuper tagSuper=tagSuperRepository.getTagSuper(tagSub0.getTagSuperId().getTagSuperName());
				if(tagSuper!=null)
					tagSub0.setTagSuperId(tagSuper);
				else
					return Status.tagRegestrationError;
			}
		//	System.out.println("after get super");
			else if(tagSub0.getTagSuperId()==null)
				return Status.tagRegestrationError;
			if(!tagSub0Repository.tagExist(tagSub0.getTagSub0Name())){
				tagSub0Repository.save(tagSub0);
				return Status.tagSub0Registerd;
			}
			else {
				return Status.alredyExist;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return "done";
		
	}
	
	@RequestMapping(value=URL.tagSub0+URL.getPatternWise, method=RequestMethod.POST)
	public String getAllPatternWise(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub0 tagSub0=jackson.readValue( requestBody, TagSub0.class);
			return jackson.writeValueAsString(tagSub0Repository.getPatternWise(tagSub0.getTagSub0Name()));
		} catch (Exception e1) {
			e1.printStackTrace();
		return	Status.parsingError;
		
		}
		
	}
	
	@PostMapping("/getAllTagsOfSuper")
	public String getAllTagsOfSuper(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, Exception{
		String requestBody;
		requestBody = requestString.getRequestBody(request.getInputStream());
		TagSuper tagSuper=jackson.readValue( requestBody, TagSuper.class);
		return jackson.writeValueAsString(tagSub0Service.allSub0OfSuper(tagSuper.getTagSuperName()));
	}
}
