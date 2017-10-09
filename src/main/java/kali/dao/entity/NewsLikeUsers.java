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
@Table(name="news_like_users")
public class NewsLikeUsers {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="news_like_users_id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="news_like_users_user_id")
	private UserAccount userAccountId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserAccount getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(UserAccount userAccountId) {
		this.userAccountId = userAccountId;
	}
	
}
