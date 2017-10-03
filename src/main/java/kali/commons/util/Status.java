package kali.commons.util;

import org.springframework.stereotype.Component;

@Component
public class Status {
	
	public static final String parsingError="{\"statue\":\"parsingError\"}";
	
	public static final String OK="{\"statue\":\"OK\"}";
	public static final String alredyExist="{\"statue\":\"Alredy Exist\"}";
	
	
	//registration errors
	public static final String mobileNOError="{\"status\":\"Someting wrong with moblie Number\"}";
	public static final String emailAddressError="{\"status\":\"Something wrong with Email Address\"}";
	public static final String wrongPassword="{\"status\":\"Something wrong with Password\"}";
	public static final String wrongDOB="{\"status\":\"Something wrong with Date Of Birth\"}";
	public static final String wrongEmailID="{\"status\":\"Something wrong with Email\"}";
	public static final String addressError="{\"status\":\"Something wrong with Address\"}";
	public static final String emailAlredyRegisterd="{\"status\":\"Email Address Alredy Registerd\"}";
	public static final String phoneNoAlredyRegisterd="{\"status\":\"Phone Number Arredy Registerd\"}";
	public static final String signupUnsuccessfull="{\"status\":false}";
	public static final String signupSuccessfull="{\"status\":true}";
	public static final String loginSuccessfull="{\"status\":login Successfull}";
	public static final String loginUnSuccessfull="{\"status\":login not Successfull}";
	
	//image errors
	public static final String imageNotSupported="{\"status\":Image Not Supports}";
	public static final String imageUploadingError="{\"status\":Image Uploading Error}";
	public static final String imageUploadingSuccessfull="{\"status\":Image Uploading Successfull}";

	public static String loginError ="{\"status\":Some problem in login}";
	public static String loginFirst ="{\"status\":Please login first}";

	public static String logoutSuccessfull ="{\"status\":Logout Successfull}";
	
	
	//tag
	public static final String superTagRegisterd="{\"status\":\"Super Tag SuccessFully Registerd\"}";
	
	
	
}
