package kali.dao.repository;

import java.util.ArrayList;


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
		@SuppressWarnings("unchecked")
		ArrayList<String> stateList=(ArrayList<String>) query.list();
		return stateList;
	}
	
	public ArrayList<String> getTahsil(String district) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("Address.getTahsil");
		query.setString(0, district);
		@SuppressWarnings("unchecked")
		ArrayList<String> stateList=(ArrayList<String>) query.list();
		return stateList;
	}
	
	public ArrayList<String> getLocale(String locale) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("Address.getLocale");
		query.setString(0, locale);
		@SuppressWarnings("unchecked")
		ArrayList<String> stateList=(ArrayList<String>) query.list();
		return stateList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Address> getAddressByAll(Address a) {
		Session current=session.getCurrentSession();
		Query query=current.getNamedQuery("Address.getByAll");
		query.setString(0, a.getLocale());
		query.setString(1, a.getTahsil());
		return (ArrayList<Address>) query.list();
	}
}
