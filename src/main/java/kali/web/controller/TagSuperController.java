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
import kali.dao.entity.TagSuper;
import kali.dao.repository.TagSuperRepository;

@RestController
@RequestMapping(URL.tag)
public class TagSuperController {

	@Autowired
	TagSuperRepository tagSuperRepo;

	@Autowired
	RequestString requestString;
	
	ObjectMapper objectMapper=new ObjectMapper();
	
	@RequestMapping(value=URL.tagSuper+URL.create, method=RequestMethod.POST)
	public String doCreate(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSuper tagSuper=objectMapper.readValue( requestBody, TagSuper.class);
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
	
	@RequestMapping(value=URL.tagSuper+URL.getPatternWise, method=RequestMethod.POST)
	public String getAllPatternWise(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSuper tagSuper=objectMapper.readValue( requestBody, TagSuper.class);
			return objectMapper.writeValueAsString(tagSuperRepo.getPatternWise(tagSuper.getTagSuperName()));
		} catch (Exception e1) {
			e1.printStackTrace();
			return Status.parsingError;
		}
		
	}
	
}
