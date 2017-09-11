package kali.web.controller;

import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kali.web.model.Student;

@RestController
public class PathVariableController {
	
	@RequestMapping("/hello/{country}/{name}")
	public String hello(@PathVariable("country") String c,@PathVariable("name") String n){
		return "hello "+n+" you are from "+c+"??";
		
	}
	
	@RequestMapping("/hello/{country}/{state}/{city}/{name}")
	public String mapPathFunc(@PathVariable Map<String,String> pathVars){
		String country=pathVars.get("country");
		String state=pathVars.get("state");
		String city=pathVars.get("city");
		String name=pathVars.get("name");
		
		return country+" "+state+" "+city+" "+name;
	}
	
	@RequestMapping("/hello/kali")
	public String reqParameterFunc(@RequestParam("firstName") String fName,@RequestParam("lastName") String lName){
		return "First Name: "+fName+"Last Name: "+lName;
	}
	
	@RequestMapping("/hello/mymodel")
	public String myModel(@ModelAttribute("student") Student student,BindingResult bl){
		if(bl.hasErrors()){
			
			return "error";
		}
		return student.getFirstName()+" "+student.getLastName();
	}
}
