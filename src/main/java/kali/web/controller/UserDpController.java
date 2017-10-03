package kali.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

import kali.commons.util.ExtentionManager;
import kali.commons.util.Path;
import kali.commons.util.Status;
import kali.dao.entity.UserAccount;
import kali.dao.entity.UserDp;
import kali.dao.repository.UserAccountRepository;
import kali.dao.repository.UserDpRepository;
import kali.web.url.URL;

@RestController
@RequestMapping(value=URL.picture)
public class UserDpController {
	
	@Autowired
	UserAccountRepository uar;
	@Autowired
	UserDpRepository udr;
	
	ObjectMapper mapper=new ObjectMapper();
	
	@RequestMapping(value=URL.userDp+URL.upload, method=RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file,HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String email=(String)session.getAttribute("email");
		String password=(String)session.getAttribute("password");
		if( email!=null && password!=null)	
		{
			UserAccount ua=uar.getDetails(email, password);
				String fileName=file.getOriginalFilename();
				if( ExtentionManager.isImageSupported(fileName)==false ){
					response.setStatus(415);
					return Status.imageNotSupported;
					}
				String path=session.getServletContext().getRealPath(Path.dpPath);
				int i=0;
				while(true){
					File f=new File(path+fileName);
					if(f.exists()){
	        		fileName=ExtentionManager.manageName(fileName, i);
					}
					else break;
				}
				System.out.println(path+" "+fileName);  
				try{  
					byte barr[]=file.getBytes();  
					BufferedOutputStream bout=new BufferedOutputStream(  
	                     new FileOutputStream(path+"/"+fileName));  
					bout.write(barr);  
					bout.flush();  
					bout.close();  
	              
	            	}catch(Exception e){System.out.println(e);
	            		response.setStatus(501);
	            		return Status.imageUploadingError;
	            	}
				UserDp ud=new UserDp();
				ud.setUserId(ua);
				ud.setDpUrl(Path.dpPath+fileName);
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