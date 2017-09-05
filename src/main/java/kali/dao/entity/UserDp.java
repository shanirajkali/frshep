package kali.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_dp")
public class UserDp {
	
	@Column(name="dp_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name="user_iid")
	UserAccount userrrId;
	
	@Column(name="dp_url",nullable=false)
	private String dpUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public UserAccount getUserrrId() {
		return userrrId;
	}

	public void setUserrrId(UserAccount userrrId) {
		this.userrrId = userrrId;
	}

	public String getDpUrl() {
		return dpUrl;
	}

	public void setDpUrl(String dpUrl) {
		this.dpUrl = dpUrl;
	}
	
}
