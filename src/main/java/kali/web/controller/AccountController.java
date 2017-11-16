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
import kali.commons.util.UrlName;
import kali.dao.entity.UserAccount;
import kali.dao.repository.AddressRepository;
import kali.dao.repository.UserRepository;

@RestController
@RequestMapping(UrlName.account)
public class AccountController {
	
	@Autowired
	RequestString rs;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	UserRepository userRepo;
	
	ObjectMapper mapper=new ObjectMapper();
	
	@RequestMapping(value=UrlName.create,method=RequestMethod.POST)
	public String doCreate(HttpServletRequest request,HttpServletResponse response) throws IOException, Exception{
		
			String requestData=rs.getRequestBody(request.getInputStream());
			System.out.println(requestData);
			System.out.println("in Controller");
			UserAccount ua=new UserAccount();
			try{
			ua=mapper.readValue(requestData, UserAccount.class);}catch(Exception e){
				response.setStatus(404);
				e.printStackTrace();
				System.out.println("Parsing exception");
				return Status.parsingError;
			}
			
			
			if(userRepo.emailIDExits(ua.getEmail()))
				return Status.emailAlredyRegisterd;
			if(userRepo.phoneNoExits(ua.getMobile()))
				return Status.phoneNoAlredyRegisterd;
			if(userRepo.usernameExist(ua.getUsername()))
				return Status.usernameAlredyRegisterd;
			
			ua.setAddress(addressRepo.getAddressByAll(ua.getAddress()));
			
			System.out.println(mapper.writeValueAsString(ua));
			userRepo.create(ua);
			return mapper.writeValueAsString(ua);
			
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value=UrlName.login,method=RequestMethod.POST)
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
			if(!userRepo.emailIDExits(ua.getEmail()))
				return Status.wrongEmailID;
			if(!userRepo.password(ua.getPassword()))
				return Status.wrongPassword;
			session.setAttribute("email", ua.getEmail());
			session.setAttribute("password", ua.getPassword());
			return Status.loginSuccessfull;
		}
		else if(s!=null){
			if( (userRepo.emailIDExits((String)session.getAttribute("email"))) == false 
					|| ( ((String)session.getAttribute("email")).equals(ua.getEmail()) ) == false){
				session.invalidate();
				return Status.wrongEmailID;
				}
			if(!userRepo.password((String)session.getAttribute("password"))){
				session.invalidate();
				return Status.wrongPassword;
			}
			return Status.loginSuccessfull;
		}
		
		return Status.loginSuccessfull;
		
	}
	
	@RequestMapping(value=UrlName.logout)
	public String logout(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setStatus(200);
		session.invalidate();
		return Status.logoutSuccessfull;
	}
	@RequestMapping(value=UrlName.getAll)
	public String getAllUsers(HttpServletResponse response){
		try {
			response.setStatus(404);
			response.setContentType("text/x-json;charset=UTF-8");
			
			return userRepo.getAllUsers();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Status.parsingError;
		}
	}
}