package kali.dao.repository;

import kali.dao.entity.Address;

public interface AddressRepository {
	public void persist(Address address);
}
