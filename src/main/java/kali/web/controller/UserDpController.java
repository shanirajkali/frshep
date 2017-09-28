package kali.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kali.web.url.URL;

@RestController
@RequestMapping(value=URL.picture)
public class UserDpController {
	
	@RequestMapping(value=URL.userDp+URL.upload, method=RequestMethod.POST)
	public String upload(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		return null;
	}
}
