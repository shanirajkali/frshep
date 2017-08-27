package kali.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import kali.commons.model.URL;

@Entity
public class ProfilePicURLs {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String pic_url;
//	@OneToOne
//	@JoinTable(joinColumns=@JoinColumn(name="account_id"))
/*	private Account user_url;
	public Account getUser_url() {
		return user_url;
	}
	public void setUser_url(Account user_url) {
		this.user_url = user_url;
	}*/
	
	@Override
	public String toString(){
		return URL.TO_STRING_NOT_DEFINED;
	}

}
