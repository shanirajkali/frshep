package kali.dao.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import kali.dao.entity.Address;

public class AddressRepositoryImpl implements AddressRepository{

	@Autowired
	SessionFactory session;
	public void persist(Address address) {
		session.getCurrentSession().saveOrUpdate(address);
		
	}

}
