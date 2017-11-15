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

import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.commons.util.Status;
import kali.commons.util.URL;
import kali.dao.entity.TagSub0;
import kali.dao.entity.TagSub1;
import kali.dao.repository.TagSub0Repository;
import kali.dao.repository.TagSub1Repository;
import kali.dao.service.TagSub1Service;

@RestController
@RequestMapping(URL.tag)
public class TagSub1Controller {
	
	@Autowired	TagSub1Repository tagSub1Repository;
	@Autowired TagSub0Repository tagSub0Repository;
	
	@Autowired TagSub1Service tagSub1Service;
	
	@Autowired
	RequestString requestString;
	
	ObjectMapper jackson=new ObjectMapper();

	@RequestMapping(value=URL.tagSub1+URL.create, method=RequestMethod.POST)
	public String doCreate(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub1 tagSub1=jackson.readValue( requestBody, TagSub1.class);
			System.out.println("bfore get super");
			if(tagSub1.getTagSub0Id()!=null){
			TagSub0 tagSub0=tagSub0Repository.getTagSub0(tagSub1.getTagSub0Id().getTagSub0Name());
				if(tagSub0!=null){
					System.out.print("setted");
					tagSub1.setTagSub0Id(tagSub0);}
				else
					return Status.tagRegestrationError;
			}
			else if(tagSub1.getTagSub0Id()==null)
				return Status.tagRegestrationError;
			System.out.println(tagSub1.getTagSub1Name());
			if(!tagSub1Repository.tagExist(tagSub1.getTagSub1Name())){
				if(tagSub1Repository.save(tagSub1))
					return Status.tagSub1Registerd;
				else return Status.tagRegestrationError;
			}
			else {
				return Status.alredyExist;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return Status.tagRegestrationError;
		}
	}
	
	@RequestMapping(value=URL.tagSub1+URL.getPatternWise, method=RequestMethod.POST)
	public String getAllPatternWise(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub1 tagSub1=jackson.readValue( requestBody, TagSub1.class);
			return jackson.writeValueAsString(tagSub1Repository.getPatternWise(tagSub1.getTagSub1Name()));
		} catch (Exception e1) {
			e1.printStackTrace();
		return	Status.parsingError;
		
		}
	}
	
	@PostMapping("/getAllSub1OfSub0")
	public String getAllOfSub0(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, Exception{
		System.out.println("getAllOfSub0");
		String requestBody;
		requestBody = requestString.getRequestBody(request.getInputStream());
		TagSub0 tagSub0=jackson.readValue( requestBody, TagSub0.class);
		return jackson.writeValueAsString(tagSub1Service.getAllSubTag1NameOfSubTag0Id(tagSub0.getTagSub0Name()));
	}
	
}
