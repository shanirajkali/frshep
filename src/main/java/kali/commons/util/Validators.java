package kali.commons.util;

import org.springframework.stereotype.Component;

import kali.dao.entity.Address;
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
		
		return Status.OK;
	}

public static String address(Address a){
	
	if(a.getState().equals("")||a.getState()==null){
		return Status.addressErrorInState;
	}
	if(a.getDistrict().equals("")||a.getDistrict()==null){
		return Status.addressErrorInDistrict;
	}
	if(a.getTahsil().equals("")||a.getTahsil()==null){
		return Status.addressErrorInTahsil;
	}
	if(a.getLocale().equals("")||a.getLocale()==null){
		return Status.addressErrorInLocale;
	}
	if(a.getPin()==0){
		return Status.addressErrorInPin;
	}
	return Status.OK;
	
}
}
