package kali.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionManagement {

	@RequestMapping(value="/session", method=RequestMethod.GET)
	public String mySess(HttpSession hs){
		//hsr.setAttribute("shani", "kali");
		
		String s=(String)hs.getAttribute("email");
		if(s==null){
			hs.setAttribute("email", "shanirajkali@gmail.com");
			hs.setAttribute("password", "$1KALIhpdlink");
			return "null Session";
		}
		return s;
		
	}
}
