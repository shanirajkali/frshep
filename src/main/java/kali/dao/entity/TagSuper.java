package kali.dao.entity;


import java.util.Date;

import javax.persistence.Column;

/**
 * @author shani rajkali
 * @since 30-9-2017
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name="TagSuper.getPatternWise", query="select tagSuperName from TagSuper ts where ts.tagSuperName like ?"),
@NamedQuery(name="TagSuper.getAll", query="select tagSuperName from TagSuper"),
@NamedQuery(name="TagSuper.getId", query="select id from TagSuper ts where ts.tagSuperName=?")
})
@Table(name="tag_super")
public class TagSuper {
	
	TagSuper(){
		this.createTimestamp=new Date();
	}

	@Column(name="tag_super_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="tag_super_name")
	private String tagSuperName;
	
	@Column(name="tag_creat_timestamp")
	private Date createTimestamp;
	
	@Column(name="tag_update_timestamp")
	private Date updateTimestamp;
	
	@Column(name="tag_view")
	private long view;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTagSuperName() {
		return tagSuperName;
	}

	public void setTagSuperName(String tagSuperName) {
		this.tagSuperName = tagSuperName;
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

	public long getView() {
		return view;
	}

	public void setView(long view) {
		this.view = view;
	}

	
}
