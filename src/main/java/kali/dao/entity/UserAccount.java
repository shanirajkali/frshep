package kali.dao.entity;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
@NamedQuery(name="UserAccount.phoneNoExist", query="Select mobile From UserAccount UA where UA.mobile=?"),
@NamedQuery(name="UserAccount.emailIDExist", query="Select email From UserAccount UA where UA.email=?"),
@NamedQuery(name="UserAccount.password", query="Select password From UserAccount UA where UA.password=?"),
@NamedQuery(name="UserAccount.selectAll", query="from UserAccount")
}
)
@Table(name="user_account")
public class UserAccount {
	
	public UserAccount(){
		this.createTimeStamp = new Date();
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	@Column(name="user_email",nullable=false)
	private String email;
	@Column(name="user_mobile",nullable=false)
	private long mobile;
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
		this.createTimeStamp = new Date();
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
	public void setDob(String dob) {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			this.dob = df.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
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
