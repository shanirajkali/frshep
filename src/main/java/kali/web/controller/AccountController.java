package kali.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.commons.util.Status;
import kali.commons.util.URL;
import kali.commons.util.Validators;
import kali.dao.entity.UserAccount;
import kali.dao.repository.AddressRepository;
import kali.dao.repository.UserRepository;

@RestController
@RequestMapping(URL.account)
public class AccountController {
	
	@Autowired
	RequestString rs;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UserRepository userAccountRepository;
	
	ObjectMapper mapper=new ObjectMapper();
	
	@RequestMapping(value=URL.create,method=RequestMethod.POST)
	public String doCreate(HttpServletRequest request,HttpServletResponse response) throws IOException, Exception{
		
			String requestData=rs.getRequestBody(request.getInputStream());
			System.out.println("in Controller");
			UserAccount ua=new UserAccount();
			try{
			ua=mapper.readValue(requestData, UserAccount.class);}catch(Exception e){
				response.setStatus(404);
				e.printStackTrace();
				System.out.println("Parsing exception");
				return Status.parsingError;
			}
			
			
			if(userAccountRepository.emailIDExits(ua.getEmail()))
				return Status.emailAlredyRegisterd;
			if(userAccountRepository.phoneNoExits(ua.getMobile()))
				return Status.phoneNoAlredyRegisterd;
			//ua.setAddress(addressRepository.getAddressByAll(ua.getAddress()).get(0));
			userAccountRepository.create(ua);
			return mapper.writeValueAsString(ua);
			
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value=URL.login,method=RequestMethod.POST)
	public String login(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException, Exception{
		String s=(String)session.getAttribute("email");
		String requestData=rs.getRequestBody(request.getInputStream());
		
		UserAccount ua=new UserAccount();
		try{
		ua=mapper.readValue(requestData, UserAccount.class);}catch(Exception e){
			response.setStatus(404);
			e.printStackTrace();
			return Status.parsingError;
		}
		if(s==null){
			System.out.println("null");
			if(!userAccountRepository.emailIDExits(ua.getEmail()))
				return Status.wrongEmailID;
			if(!userAccountRepository.password(ua.getPassword()))
				return Status.wrongPassword;
			session.setAttribute("email", ua.getEmail());
			session.setAttribute("password", ua.getPassword());
			return Status.loginSuccessfull;
		}
		else if(s!=null){
			if( (userAccountRepository.emailIDExits((String)session.getAttribute("email"))) == false 
					|| ( ((String)session.getAttribute("email")).equals(ua.getEmail()) ) == false){
				session.invalidate();
				return Status.wrongEmailID;
				}
			if(!userAccountRepository.password((String)session.getAttribute("password"))){
				session.invalidate();
				return Status.wrongPassword;
			}
			return Status.loginSuccessfull;
		}
		
		return Status.loginSuccessfull;
		
	}
	
	@RequestMapping(value=URL.logout)
	public String logout(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setStatus(200);
		session.invalidate();
		return Status.logoutSuccessfull;
	}
	@RequestMapping(value=URL.getAll)
	public String getAllUsers(HttpServletResponse response){
		try {
			response.setStatus(404);
			response.setContentType("text/x-json;charset=UTF-8");
			
			return userAccountRepository.getAllUsers();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Status.parsingError;
		}
	}
}