package kali.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kali.commons.util.RequestString;
import kali.commons.util.URL;
import kali.dao.entity.Address;
import kali.dao.repository.AddressRepository;
import kali.dao.service.AddressService;
import kali.web.rest.validation.AddressRest;

@RestController
@RequestMapping(URL.address)
public class AddressController {
	
	@Autowired AddressRepository addressRepository;
	@Autowired ObjectMapper mapper;
	@Autowired RequestString rs;
	@Autowired AddressService addressService;
	
	
	
	@PostMapping(URL.save)
	public String create(HttpServletRequest request) throws Exception{
		String requestBody=rs.getRequestBody(request.getInputStream());
		Address address=mapper.readValue(requestBody,Address.class);
		System.out.println("address controller");
		return addressService.save(address);
	}
	@PostMapping(URL.getSate)
	public String getState(HttpServletRequest request){
		try {
			System.out.println(mapper.writeValueAsString(addressRepository.getState()));
			return "{\"state\":"+mapper.writeValueAsString(addressRepository.getState())+"}";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value=URL.district)
	public String getDistrict(HttpServletRequest request) throws Exception{
		String requestBody=rs.getRequestBody(request.getInputStream());
		AddressRest addressRest=mapper.readValue(requestBody,AddressRest.class);
		String state=addressRest.getState();
		String districts=mapper.writeValueAsString(addressRepository.getDistrict(state));
		System.out.println(districts);
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
		System.out.println("locales  =="+locales);
		return locales;
	}
	
}
