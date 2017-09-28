package kali.commons.util;

import org.springframework.stereotype.Component;

@Component
public class Status {
	
	public static final String parsingError="{\"statue\":\"parsingError\"}";
	
	public static final String OK="{\"statue\":\"OK\"}";
	
	
	//registration errors
	public static final String mobileNOError="{\"statue\":\"Someting wrong with moblie Number\"}";
	public static final String emailAddressError="{\"statue\":\"Something wrong with Email Address\"}";
	public static final String wrongPassword="{\"statue\":\"Something wrong with Password\"}";
	public static final String wrongDOB="{\"statue\":\"Something wrong with Date Of Birth\"}";
	public static final String wrongEmailID="{\"statue\":\"Something wrong with Email\"}";
	public static final String addressError="{\"statue\":\"Something wrong with Address\"}";
	public static final String emailAlredyRegisterd="{\"statue\":\"Email Address Alredy Registerd\"}";
	public static final String phoneNoAlredyRegisterd="{\"statue\":\"Phone Number Arredy Registerd\"}";
	public static final String signupUnsuccessfull="{\"signupStatue\":false}";
	public static final String signupSuccessfull="{\"signupStatue\":true}";
	public static final String loginSuccessfull="{\"statue\":login Successfull}";
	public static final String loginUnSuccessfull="{\"statue\":login not Successfull}";
	
	
	
	
}
