package kali.dao.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user_account")
public class UserAccount {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	@Column(name="user_email",nullable=false)
	private String email;
	@Column(name="user_mobile",nullable=false)
	private int moblie;
	@Column(name="current_dp")
	private String currentDp;
	@Column(name="user_password",nullable=false)
	private String password;
	@OneToOne
	@JoinColumn(name="address_id")
	private Address Address;
	@Column(name="user_street")
	private String street;
	@Column(name="create_time_stamp")
	private Date createTimeStamp;
	@Column(name="update_time_stamp")
	private Date updateTimeStamp;
	@Temporal(TemporalType.DATE)
	@Column(name="user_dob")
	private Date dob;
	@Column(name="user_active_status")
	private boolean activeStatus;
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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

}
