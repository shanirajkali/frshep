package kali.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name="users.getUid", query="Select uid From users u where u.accesscode=?")
}
)
public class users {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int uid;
	String salt;
	String email;
	String first_name;
	String last_name;
	String accesscode;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAccesscode() {
		return accesscode;
	}
	public void setAccesscode(String accesscode) {
		this.accesscode = accesscode;
	}
	
	
	
}
