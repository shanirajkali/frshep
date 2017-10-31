package kali.dao.entity;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
@NamedQuery(name="UserAccount.phoneNoExist", query="Select mobile From UserAccount UA where UA.mobile=?"),
@NamedQuery(name="UserAccount.emailIDExist", query="Select email From UserAccount UA where UA.email=?"),
@NamedQuery(name="UserAccount.password", query="Select password From UserAccount UA where UA.password=?"),
@NamedQuery(name="UserAccount.selectAll", query="from UserAccount"),
@NamedQuery(name="UserAccount.getDetailsByEmailAndPassword", query="from UserAccount ua where ua.email=? and ua.password=?"),
@NamedQuery(name="UserAccount.selectIdByEmailAndPassword", query="select id from UserAccount ua where ua.email=? and ua.password=?")
}
)
@Table(name="user_account")
public class UserAccount{

	public UserAccount(){
		this.createTimeStamp = new Date();
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private long id;
	@Column(name="user_email",nullable=false, unique=true)
	private String email;
	@Column(name="user_mobile",nullable=false)
	private long mobile;
	@Column(name="user_username", nullable=false, unique=true)
	private String username;
	@Column(name="user_name",nullable=false)
	private String name;
	@Column(name="current_dp")
	private String currentDp;
	@Column(name="user_password",nullable=false)
	private String password;
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
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
	@OneToMany
	@JoinTable(name="relation_user_tag",
				joinColumns=@JoinColumn(name="news_id"),
				inverseJoinColumns=@JoinColumn(name="tag_id"))
	private Collection<TagSuper> tagsFollows;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<TagSuper> getTagsFollows() {
		return tagsFollows;
	}
	public void setTagsFollows(Collection<TagSuper> tagsFollows) {
		this.tagsFollows = tagsFollows;
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
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			this.dob = df.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}