package kali.web.rest.validation;

import java.util.Date;

import kali.dao.entity.Address;

public class AccountRest {

	private String email;
	private int moblie;
	private String currentDp;
	private String password;
	private Address Address;
	private String street;
	private Date createTimeStamp;
	private Date updateTimeStamp;
	private Date dob;
	private boolean activeStatus;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMoblie() {
		return moblie;
	}
	public void setMoblie(int moblie) {
		this.moblie = moblie;
	}
	public String getCurrentDp() {
		return currentDp;
	}
	public void setCurrentDp(String currentDp) {
		this.currentDp = currentDp;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Date getCreateTimeStamp() {
		return createTimeStamp;
	}
	public void setCreateTimeStamp(Date createTimeStamp) {
		this.createTimeStamp = createTimeStamp;
	}
	public Date getUpdateTimeStamp() {
		return updateTimeStamp;
	}
	public void setUpdateTimeStamp(Date updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	
}
