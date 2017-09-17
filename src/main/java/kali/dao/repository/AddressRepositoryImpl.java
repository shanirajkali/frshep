package kali.dao.repository;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
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
	
	public ArrayList<String> getDistrict(String state) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("Address.getDistrict");
		query.setString(0, state);
		ArrayList<String> stateList=(ArrayList<String>) query.list();
		return stateList;
	}
}
