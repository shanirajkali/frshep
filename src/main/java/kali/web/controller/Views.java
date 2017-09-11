package kali.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/view")
public class Views {
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String getFirstView(){
		return "firstview";
	}
	
}
