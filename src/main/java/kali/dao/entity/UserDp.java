package kali.dao.entity;

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

@Entity
@NamedQueries( {
	@NamedQuery(name = "UserDp.selectAllByUserId", query = "select dpUrl from UserDp ud where ud.userId=?"),
	@NamedQuery(name = "UserDp.deleteAllByUserId", query = "delete from UserDp ud where ud.userId=?")
	}
)
@Table(name="user_dp")
public class UserDp {
	
	@Column(name="dp_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	UserAccount userId;
	
	@Column(name="dp_url",nullable=false)
	private String dpUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserAccount getUserId() {
		return userId;
	}

	public void setUserId(UserAccount userId) {
		this.userId = userId;
	}

	public String getDpUrl() {
		return dpUrl;
	}

	public void setDpUrl(String dpUrl) {
		this.dpUrl = dpUrl;
	}
	
}
