package kali.dao.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="news_id")
	private int id;
	
	@Column(name="news_heading")
	private String heading;
	@Column(name="news_description")
	@Lob
	private String description;
	@Column(name="news_post_time_stamp",nullable=false)
	private Date postTimeStamp;
	@Column(name="news_update_time_stamp",nullable=false)
	private Date updateTimeStamp;
	@OneToOne
	@JoinColumn(name="user_id")
	private UserAccount userId;
	@Column(name="address_id")
	private int addressId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPostTimeStamp() {
		return postTimeStamp;
	}
	public void setPostTimeStamp(Date postTimeStamp) {
		this.postTimeStamp = postTimeStamp;
	}
	public Date getUpdateTimeStamp() {
		return updateTimeStamp;
	}
	public void setUpdateTimeStamp(Date updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}
	public UserAccount getUserId() {
		return userId;
	}
	public void setUserId(UserAccount userId) {
		this.userId = userId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
}