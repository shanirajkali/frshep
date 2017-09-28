package kali.commons.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import kali.dao.entity.UserAccount;

@Component
public class Validators {
public static	String signup(UserAccount ua){
		
		if(ua.getEmail().equals("")){
			return Status.emailAddressError;
		}
		else if(ua.getMobile()<100000){
			return Status.mobileNOError;
		}
		
		else if(ua.getPassword()==null){
			return Status.wrongPassword;
		}
		else if(ua.getDob().compareTo(new Date(-53453453L))<0){
			return Status.wrongDOB;
		}
		return Status.OK;
	}
}
