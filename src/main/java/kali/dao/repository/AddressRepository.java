package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.Address;

public interface AddressRepository {
	public void persist(Address address);
	public boolean exist(Address Address);
	public ArrayList<String> getDistrict(String state);
	public ArrayList<String> getTahsil(String district);
	public ArrayList<String> getLocale(String tahsil);
	public Address getAddressByAll(Address a);
	public boolean save(Address a);
	public ArrayList<String> getState();
}
