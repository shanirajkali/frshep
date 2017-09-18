package kali.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.dao.entity.Address;
import kali.dao.repository.AddressRepository;
import kali.web.rest.validation.AddressRest;
import kali.web.url.URL;

@RestController
@RequestMapping("address")
public class AddressController {
	
	@Autowired
	AddressRepository addressRepository;
	
	
	ObjectMapper mapper=new ObjectMapper();
	
	@Autowired
	RequestString rs;
	
	
	
	@RequestMapping(value="/newAddress")
	public String addAddress(HttpServletRequest request) throws Exception{
		String requestBody=rs.getRequestBody(request.getInputStream());
		AddressRest addressRest=mapper.readValue(requestBody,AddressRest.class);
		Address address=new Address();
		address.setDistrict(addressRest.getDistrict());
		address.setLocale(addressRest.getLocale());
		address.setPin(addressRest.getPin());
		address.setState(addressRest.getState());
		address.setTahsil(addressRest.getTahsil());
		addressRepository.persist(address);
		return address.getDistrict()+address.getId()+address.getLocale();
	}

	@RequestMapping(value=URL.district)
	public String getDistrict(HttpServletRequest request) throws Exception{
		String requestBody=rs.getRequestBody(request.getInputStream());
		AddressRest addressRest=mapper.readValue(requestBody,AddressRest.class);
		String state=addressRest.getState();
		String districts=mapper.writeValueAsString(addressRepository.getDistrict(state));
		return districts;
	}
	
	@RequestMapping(value=URL.tahsil)
	public String getTahsil(HttpServletRequest request) throws Exception{
		String requestBody=rs.getRequestBody(request.getInputStream());
		AddressRest addressRest=mapper.readValue(requestBody,AddressRest.class);
		String district=addressRest.getDistrict();
		String tahsils=mapper.writeValueAsString(addressRepository.getTahsil(district));
		return tahsils;
	}
	
	@RequestMapping(value=URL.locale)
	public String getLocale(HttpServletRequest request) throws Exception{
		String requestBody=rs.getRequestBody(request.getInputStream());
		AddressRest addressRest=mapper.readValue(requestBody,AddressRest.class);
		String tahsil=addressRest.getTahsil();
		String locales=mapper.writeValueAsString(addressRepository.getLocale(tahsil));
		return locales;
	}
	
}
