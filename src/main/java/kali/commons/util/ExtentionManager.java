package kali.commons.util;

import org.springframework.stereotype.Component;

@Component
public class ExtentionManager {

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
