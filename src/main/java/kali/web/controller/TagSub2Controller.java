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
import kali.dao.entity.TagSub1;
import kali.dao.entity.TagSub2;
import kali.dao.repository.TagSub1Repository;
import kali.dao.repository.TagSub2Repository;

@RestController
@RequestMapping(URL.tag)
public class TagSub2Controller {
	
	@Autowired
	TagSub2Repository tagSub2Repository;
	
	@Autowired
	TagSub1Repository tagSub1Repository;
	
	@Autowired
	RequestString requestString;
	
	ObjectMapper objectMapper=new ObjectMapper();

	@RequestMapping(value=URL.tagSub2+URL.create, method=RequestMethod.POST)
	public String doCreate(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub2 tagSub2=objectMapper.readValue( requestBody, TagSub2.class);
			System.out.println("bfore get super");
			if(tagSub2.getTagSub1Id()!=null){
			TagSub1 tagSub1=tagSub1Repository.getTagSub1(tagSub2.getTagSub1Id().getTagSub1Name());
				if(tagSub1!=null)
					tagSub2.setTagSub1Id(tagSub1);
				else
					return Status.tagRegestrationError;
			}
			else if(tagSub2.getTagSub1Id()==null)
				return Status.tagRegestrationError;
			if(!tagSub2Repository.tagExist(tagSub2.getTagSub2Name())){
				if(tagSub2Repository.save(tagSub2))
					return Status.tagSub2Registerd;
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
	
	@RequestMapping(value=URL.tagSub2+URL.getPatternWise, method=RequestMethod.POST)
	public String getAllPatternWise(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String requestBody;
		try {
			requestBody = requestString.getRequestBody(request.getInputStream());
			TagSub2 tagSub2=objectMapper.readValue( requestBody, TagSub2.class);
			return objectMapper.writeValueAsString(tagSub1Repository.getPatternWise(tagSub2.getTagSub2Name()));
		} catch (Exception e1) {
			e1.printStackTrace();
		return	Status.parsingError;
		
		}
		
	}
}
