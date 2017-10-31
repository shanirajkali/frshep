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
import kali.commons.util.Status;
import kali.commons.util.URL;
import kali.dao.entity.TagSub0;
import kali.dao.entity.TagSub1;
import kali.dao.repository.TagSub0Repository;
import kali.dao.repository.TagSub1Repository;

@RestController
@RequestMapping(URL.tag)
public class TagSub1Controller {
	
	@Autowired
	TagSub1Repository tagSub1Repository;
	
	@Autowired
	TagSub0Repository tagSub0Repository;
	
	@Autowired
	RequestString requestString;
	
	ObjectMapper objectMapper=new ObjectMapper();

	@RequestMapping(value=URL.tagSub1+URL.create, method=RequestMethod.POST)
	public String doCreate(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub1 tagSub1=objectMapper.readValue( requestBody, TagSub1.class);
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
			TagSub1 tagSub1=objectMapper.readValue( requestBody, TagSub1.class);
			return objectMapper.writeValueAsString(tagSub1Repository.getPatternWise(tagSub1.getTagSub1Name()));
		} catch (Exception e1) {
			e1.printStackTrace();
		return	Status.parsingError;
		
		}
		
	}
}
