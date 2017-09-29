package kali.commons.util;

import org.springframework.stereotype.Component;

@Component
public class ExtentionManager {

	public static final String[] imageExtentions={"jpeg","png","jpg","gif","bmp"};
	public static final String[] videoExtentions={"mp4", "flv", "mkv", "3gp"};
	
	public static boolean isImageSupported(String image){
		String[] imageParts=image.split("\\.");
		for(int i=0;i<imageExtentions.length;i++){
			if(imageParts[imageParts.length-1].equals(imageExtentions[i]))
					return true;
		}
		return false;
	}
	
	public static boolean isVideoSupported(String video){
		String[] videoParts=video.split("\\.");
		for(int i=0;i<videoExtentions.length;i++){
			if(videoParts[videoParts.length-1].equals(videoExtentions[i]))
					return true;
		}
		return false;
	}
	
	public static String manageName(String s, int add){
		String[] sParts=s.split("\\.");
		s="";
		for(int i=0;i<sParts.length-1;i++){
			s+=sParts[i];
		}
		s+=add+"."+sParts[sParts.length-1];
		return s;
	}
}
