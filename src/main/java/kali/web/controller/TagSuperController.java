package kali.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.commons.util.Status;
import kali.commons.util.UrlName;
import kali.dao.entity.TagSuper;
import kali.dao.repository.TagSuperRepository;
import kali.dao.service.TagSuperService;

@RestController
@RequestMapping(UrlName.tag)
public class TagSuperController {

	@Autowired TagSuperRepository tagSuperRepo;
	@Autowired TagSuperService tagSuperService;

	@Autowired RequestString requestString;
	
	ObjectMapper jackson=new ObjectMapper();
	
	@RequestMapping(value=UrlName.super_+UrlName.create, method=RequestMethod.POST)
	public String doCreate(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSuper tagSuper=jackson.readValue( requestBody, TagSuper.class);
			if(!tagSuperRepo.tagExist(tagSuper.getTagSuperName())){
				tagSuperRepo.save(tagSuper);
				return Status.superTagRegisterd;
			}
			else {
				return Status.alredyExist;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return Status.parsingError;
		} 	
	}
	
	@RequestMapping(value=UrlName.super_+UrlName.getPatternWise, method=RequestMethod.POST)
	public String getAllPatternWise(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSuper tagSuper=jackson.readValue( requestBody, TagSuper.class);
			return jackson.writeValueAsString(tagSuperRepo.getPatternWise(tagSuper.getTagSuperName()));
		}catch (Exception e1) {
			e1.printStackTrace();
			return Status.parsingError;
		}
	}
	
	@RequestMapping(value="superTagId")
	public long getId(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, Exception{
		String requestBody;
		requestBody = requestString.getRequestBody(request.getInputStream());
		TagSuper tagSuper=jackson.readValue( requestBody, TagSuper.class);
		return tagSuperRepo.getId(tagSuper.getTagSuperName());
	}
	
	@RequestMapping(value=UrlName.super_+UrlName.getAll)
	public String getAllSuper() throws JsonProcessingException{
		return jackson.writeValueAsString(tagSuperRepo.getAll());
	}
}