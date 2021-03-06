package kali.web.controller;

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
import kali.commons.util.UrlName;
import kali.dao.entity.TagSub2;
import kali.dao.entity.TagSub3;
import kali.dao.repository.TagSub2Repository;
import kali.dao.repository.TagSub3Repository;
import kali.dao.service.TagSub3Service;

@RestController
@RequestMapping(UrlName.tag)
public class TagSub3Controller {
	
	@Autowired
	TagSub3Repository tagSub3Repository;
	
	@Autowired
	TagSub2Repository tagSub2Repository;
	
	@Autowired TagSub3Service tagSub3Service;
	
	@Autowired
	RequestString requestString;
	
	ObjectMapper objectMapper=new ObjectMapper();

	@RequestMapping(value=UrlName.sub3+UrlName.create, method=RequestMethod.POST)
	public String doCreate(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub3 tagSub3=objectMapper.readValue( requestBody, TagSub3.class);
			System.out.println("bfore get super");
			if(tagSub3.getTagSub2Id()!=null){
			TagSub2 tagSub2=tagSub2Repository.getTagSub2(tagSub3.getTagSub2Id().getTagSub2Name());
				if(tagSub2!=null)
					tagSub3.setTagSub2Id(tagSub2);
				else
					return Status.tagRegestrationError;
			}
			else if(tagSub3.getTagSub2Id()==null)
				return Status.tagRegestrationError;
			if(!tagSub3Repository.tagExist(tagSub3.getTagSub3Name())){
				if(tagSub3Repository.save(tagSub3))
					return Status.tagSub3Registerd;
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
	
	@RequestMapping(value=UrlName.sub3+UrlName.getPatternWise, method=RequestMethod.POST)
	public String getAllPatternWise(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub3 tagSub1=objectMapper.readValue( requestBody, TagSub3.class);
			return objectMapper.writeValueAsString(tagSub3Repository.getPatternWise(tagSub1.getTagSub3Name()));
		} catch (Exception e1) {
			e1.printStackTrace();
		return	Status.parsingError;
		
		}
		
	}
	
	@PostMapping(UrlName.sub3+UrlName.getAll)
	public String getAllSub2bySub1Name(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub2 tagSub2=objectMapper.readValue( requestBody, TagSub2.class);
			return objectMapper.writeValueAsString(tagSub3Service.getAllBySub2Name(tagSub2.getTagSub2Name()));
		}catch (Exception e1) {
			e1.printStackTrace();
		return	Status.parsingError;
		}
	}
}
