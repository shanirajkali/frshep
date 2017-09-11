package kali.dao.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.entity.Address;

@Transactional
@Component
public class AddressRepositoryImpl implements AddressRepository{

	@Autowired
	SessionFactory session;
	public void persist(Address address) {
		session.getCurrentSession().saveOrUpdate(address);
		return;
	}

}
