package kali.commons.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileManager {
	
	public static String newName(String s, int add){
		String[] sParts=s.split("\\.");
		s="";
		for(int i=0;i<sParts.length-1;i++){
			s+=sParts[i];
		}
		s+=add+"."+sParts[sParts.length-1];
		return s;
	}
	
	public static String imageUpload(CommonsMultipartFile file,String path){
		
		String fileName=file.getOriginalFilename();
		System.out.println("in image upload"+fileName);
		if( ExtentionManager.isImageSupported(fileName)==false ){
			System.out.println("in check support");
			return "false";
			}
		int i=0;
		while(true){
			File f=new File(path+fileName);
			System.out.println("in while");
			if(f.exists()){System.out.println("in if exist");
    		fileName=FileManager.newName(fileName, i);
			}
			else break;
		}
		try{  
			System.out.println("try to wroite first");
			file.getInputStream();
			System.out.println("input");
			byte barr[]=file.getBytes();  
			System.out.println(barr);
			BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(path+"/"+fileName));  
			bout.write(barr);  
			bout.flush();  
			bout.close();  
			System.out.println("in try to write");
        	}catch(Exception e){System.out.println("in exception");e.printStackTrace();return "false";}
		return fileName;
	}
	
public static String fileUpload(CommonsMultipartFile file,String path){
		
		String fileName=file.getOriginalFilename();
		int i=0;
		while(true){
			File f=new File(path+fileName);
			if(f.exists()){
    		fileName=FileManager.newName(fileName, i);
			}
			else break;
		}
		try{  
			byte barr[]=file.getBytes();  
			BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(path+"/"+fileName));  
			bout.write(barr);  
			bout.flush();  
			bout.close();  
          
        	}catch(Exception e){e.printStackTrace();return "false";}
		return fileName;
	}

}
