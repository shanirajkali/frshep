package kali.web.controller;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kali.commons.util.URL;

@Controller
@RequestMapping("")
public class Views {
	@Autowired
	BasicDataSource bd;
	
	@RequestMapping(value="")
	public String getFirstView() throws SQLException {	
		return "home";
	}
	
	@RequestMapping(value="/addressView")
	public String getAddressView() throws SQLException {	
		return "addressRegistration";
	}
	
	@RequestMapping(value="/loginView")
	public String getLoginView() throws SQLException {	
		return "login";
	}
	
	
	@RequestMapping("/home")
	public String login(){
		return "home";
	}
}
