package kali.dao.repository;

import java.util.ArrayList;

import kali.dao.entity.Address;

public interface AddressRepository {
	public void persist(Address address);
	public ArrayList<String> getDistrict(String state);
}
