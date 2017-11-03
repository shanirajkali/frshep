package kali.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="final_calculation.getMatch", query="select match from final_calculation fc where fc.user_id=? ORDER BY fc.match DESC"),
	}
)
public class final_calculation {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	int user_id;
	String career_id;
	String match;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCareer_id() {
		return career_id;
	}
	public void setCareer_id(String career_id) {
		this.career_id = career_id;
	}
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	
	
}
