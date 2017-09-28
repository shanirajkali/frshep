package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.Address;

public interface AddressRepository {
	public void persist(Address address);
	public ArrayList<String> getDistrict(String state);
	public ArrayList<String> getTahsil(String district);
	public ArrayList<String> getLocale(String tahsil);
	public ArrayList<Address> getAddressByAll(Address a);
}
