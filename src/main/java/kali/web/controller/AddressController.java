package kali.web.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.dao.entity.Address;
import kali.dao.repository.AddressRepository;
import kali.dao.repository.AddressRepositoryImpl;
import kali.web.rest.validation.AddressRest;

@RestController
@RequestMapping("address")
public class AddressController {
	
	AddressRepository addressRepository=new AddressRepositoryImpl();
	ObjectMapper mapper=new ObjectMapper();
	
	
	RequestString rs=new RequestString();
	
	
	
	@RequestMapping(value="/newAddress")
	public String addAddress(HttpServletRequest request) throws IOException, Exception{
		AddressRest addressRest=mapper.readValue(rs.getRequestBody(request.getInputStream()),AddressRest.class);
		Address address=new Address();
		address.setDistrict(addressRest.getDistrict());
		address.setLocale(addressRest.getLocale());
		address.setPin(addressRest.getPin());
		address.setState(addressRest.getState());
		address.setTahsil(addressRest.getTahsil());
		addressRepository.persist(address);
		return "done";
	}

}
