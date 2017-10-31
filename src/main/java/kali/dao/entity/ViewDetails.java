package kali.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({})
@Table(name="view_details")
public class ViewDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	public ViewDetails(){
		this.createTimestamp=new Date();
	}
	
	@Id
	@JoinColumn(name="user_id")
	@OneToOne
	private UserAccount user;
	
	@Column(name="create_timestamp")
	private Date createTimestamp;
	
	@Column(name="update_timestamp")
	private Date updateTimestamp;

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
	}

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	
	
}
