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
	public static final String emailAlredyRegisterd="{\"status\":\"Email Address Alredy Registerd\"}";
	public static final String phoneNoAlredyRegisterd="{\"status\":\"Phone Number Arredy Registerd\"}";
	public static final String usernameAlredyRegisterd="{\"status\":\"username Arredy Registerd\"}";
	public static final String signupUnsuccessfull="{\"status\":false}";
	public static final String signupSuccessfull="{\"status\":true}";
	public static final String loginSuccessfull="{\"status\":login Successfull}";
	public static final String loginUnSuccessfull="{\"status\":login not Successfull}";
	
	//media errors
	public static final String imageNotSupported="{\"status\":Image Not Supports}";
	public static final String imageUploadingError="{\"status\":Image Uploading Error}";
	public static final String imageUploadingSuccessfull="{\"status\":Image Uploading Successfull}";
	public static String mediaNotSupported="{\"status\":Media Not Supports}";
	public static String fileNotSupported="{\"status\":File Not Supports}";
	public static String fileSuccessfullyUploaded="{\"status\":File Successfully Uploaded}";
	
	public static String loginError ="{\"status\":Some problem in login}";
	public static String loginFirst ="{\"status\":Please login first}";

	public static String logoutSuccessfull ="{\"status\":Logout Successfull}";
	
	//tag
	public static final String superTagRegisterd="{\"status\":\"Super Tag SuccessFully Registerd\"}";
	public static String tagRegestrationError="{\"status\":\"tag registration error\"}";
	public static String tagSub0Registerd="{\"status\":\"tag sub 0 registerd\"}";
	public static String tagSub1Registerd="{\"status\":\"tag sub 1 registerd\"}";
	public static String tagSub2Registerd="{\"status\":\"tag sub 2 registerd\"}";
	public static String tagSub3Registerd="{\"status\":\"tag sub 3 registerd\"}";

	//address
	public static String addressError="{\"success\":0,\"massege\":\"Something wrong whith your 'Address'\"}";
	public static String addressErrorAlreadyRetisterd="{\"success\":0,\"massege\":\"Address already registerd\"}";
	public static String addressErrorNotRegisterdRegisterFirst="{\"success\":0,\"massege\":\"Address Not Register Please Register First\"}";
	public static String addressErrorInState="{\"success\":0,\"massege\":\"Something wrong with 'State'\"}";
	public static String addressErrorInDistrict="{\"success\":0,\"massege\":\"Something wrong with 'District'\"}";
	public static String addressErrorInTahsil="{\"success\":0,\"massege\":\"Something wrong with 'Tahsil'\"}";
	public static String addressErrorInLocale="{\"success\":0,\"massege\":\"Something wrong with 'Locale'\"}";
	public static String addressErrorInPin="{\"success\":0,\"massege\":\"Something wrong with 'PIN'\"}";
	public static String addressSuccessfullyRegisterd="{\"success\":1,\"massege\":\"Address Successfully Registerd\"}";
	

	

	
	
	
	
}
