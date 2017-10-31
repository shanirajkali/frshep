package kali.web.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kali.commons.util.ExtentionManager;
import kali.commons.util.Path;
import kali.commons.util.Status;
import kali.dao.service.UserService;

@RestController
@RequestMapping("/upload")
public class FileController {	
	

	@Autowired
	UserService us;
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file,HttpSession session){
		String path=session.getServletContext().getRealPath(Path.dpMedia);
        String filename=file.getOriginalFilename();  
        String[] names=filename.split("\\.");
        System.out.println(names[names.length-1]);
        int i=0;
        while(true){
        	File f=new File(path+filename);    	
        	if(f.exists()){
        		filename=ExtentionManager.manageName(filename, i);
        	}
        	else break;
        }
        System.out.println(path+" "+filename);
        try{  
            byte barr[]=file.getBytes();  
            BufferedOutputStream bout=new BufferedOutputStream(  
                     new FileOutputStream(path+"/"+filename));  
            bout.write(barr);  
            bout.flush();  
            bout.close();  
            }catch(Exception e){System.out.println(e);
            	}  
		return "firstview";
	}
	
	@RequestMapping(value="/mediaToSession", method=RequestMethod.POST)
	public String uploadFileToSession(@RequestParam("file") CommonsMultipartFile[] file,HttpSession session){
		
		//if(!us.isCurrentUserLoggedIn(session)) return Status.loginFirst;
		
		System.out.println(file[0].getOriginalFilename());
		System.out.println(file[1].getOriginalFilename());
		
	/*	if( !ExtentionManager.isFileSupported(file.getOriginalFilename()) ) return Status.fileNotSupported;
		@SuppressWarnings("unchecked")
		ArrayList<CommonsMultipartFile> al=(ArrayList<CommonsMultipartFile>) session.getAttribute("files");
		if(al==null){
			al=new ArrayList<CommonsMultipartFile>();
			al.add(file);
			session.setAttribute("files", al);
			return Status.fileSuccessfullyUploaded;
		}
		al.add(file);
		session.removeAttribute("files");
		session.setAttribute("files", al);
		*/
		return Status.fileSuccessfullyUploaded;
	}
	
}