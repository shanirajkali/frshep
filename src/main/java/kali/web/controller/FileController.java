package kali.web.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import kali.commons.util.ExtentionManager;
import kali.commons.util.Path;

@RestController
@RequestMapping("upload")
public class FileController {
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file,HttpSession session){
		String path=session.getServletContext().getRealPath(Path.dpPath);  
		
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
              
            }catch(Exception e){System.out.println(e);}  
		
		return "firstview";
	}
}
