package kali.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kali.commons.util.Status;
import kali.commons.util.Validators;
import kali.dao.entity.Address;
import kali.dao.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired AddressRepository ar;
	
	@Transactional
	public String save(Address a) {
		
		System.out.println("address ser");
		if(!Validators.address(a).equals(Status.OK)){
			return Validators.address(a);
		}
		if(ar.exist(a)) return Status.addressErrorAlreadyRetisterd;
		if(ar.save(a)) return Status.addressSuccessfullyRegisterd;
		return Status.addressError;
	}
}
