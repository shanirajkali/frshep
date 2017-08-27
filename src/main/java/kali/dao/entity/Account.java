package kali.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kali.commons.model.URL;

@Entity
public class Account {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	private String user_name;
	private String user_password;
	private String user_current_profile_pic_url;
	private Date create_date_time;
	private Date update_date_time;
	private String user_email;
	private int user_active;
	
	public Date getCreate_date_time() {
		return create_date_time;
	}
	public void setCreate_date_time(Date create_date_time) {
		this.create_date_time = create_date_time;
	}
	public Date getUpdate_date_time() {
		return update_date_time;
	}
	public void setUpdate_date_time(Date update_date_time) {
		this.update_date_time = update_date_time;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getUser_active() {
		return user_active;
	}
	public void setUser_active(int user_active) {
		this.user_active = user_active;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_profile_pic() {
		return user_current_profile_pic_url;
	}
	public void setUser_profile_pic(String user_profile_pic) {
		this.user_current_profile_pic_url = user_profile_pic;
	}
	
	@Override
	public String toString(){
		return URL.TO_STRING_NOT_DEFINED;
	}
	

}
