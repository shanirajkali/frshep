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

import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.FileManager;
import kali.commons.util.Path;
import kali.commons.util.Status;
import kali.commons.util.URL;
import kali.dao.entity.UserAccount;
import kali.dao.entity.UserDp;
import kali.dao.repository.UserRepository;
import kali.dao.repository.UserDpRepository;

@RestController
@RequestMapping(value=URL.picture)
public class UserDpController {
	
	@Autowired
	UserRepository uar;
	@Autowired
	UserDpRepository udr;
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping(value=URL.userDp+URL.upload, method=RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file,HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String email=(String)session.getAttribute("email");
		String password=(String)session.getAttribute("password");
		if( email!=null && password!=null)	
		{
			UserAccount ua=uar.getDetails(email, password);	
			String path=session.getServletContext().getRealPath(Path.dpMedia);
			String uploadedFileName=FileManager.imageUpload(file, path);
			if(uploadedFileName.equals("false")) return Status.imageUploadingError;
			UserDp ud=new UserDp();
			ud.setUserId(ua);
			ud.setDpUrl(Path.dpMedia+uploadedFileName);
			udr.save(ud);
			response.setStatus(202);
			return Status.imageUploadingSuccessfull;
		}
		response.setStatus(404);
		return Status.loginFirst;
	}
	
	@RequestMapping(value=URL.userDp+URL.getAll, method=RequestMethod.POST)
	public String getAllDp(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String email=(String)session.getAttribute("email");
		String password=(String)session.getAttribute("password");
		if( email!=null && password!=null ){
			ArrayList<String> links=udr.getAll(uar.getIdByEmailAndPassword(email, password));
			try{
				return mapper.writeValueAsString(links);}catch(Exception e){
					e.printStackTrace();
					return 	Status.parsingError;
				}
		}
		return Status.loginError;
		
	}
}