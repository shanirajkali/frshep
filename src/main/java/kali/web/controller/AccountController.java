package kali.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kali.commons.model.URL;

@RestController
@RequestMapping(URL.ACCOUNT)
public class AccountController {
	
	@RequestMapping(value=URL.ACCOUNT,method=RequestMethod.GET)
	public String doCreate(){
		return "freshheap";
	}
	
	@RequestMapping(value="signup",method=RequestMethod.GET)
	public String doLogin(){
		return "MerchantSignup";
	}
}
