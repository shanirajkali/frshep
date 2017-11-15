package kali.dao.entity;

import java.util.Date;

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
@NamedQueries({
	@NamedQuery(name="TagSub0.getPatternWise", query="select tagSub0Name from TagSub0 ts where ts.tagSub0Name like ?"),
	@NamedQuery(name="TagSub0.getAllSub0", query="select tagSub0Name from TagSub0 ts where ts.tagSuperId=?"),
	@NamedQuery(name="TagSub0.getIdByName",query="select id from TagSub0 ts where ts.tagSub0Name=?")
})
@Table(name="tag_sub_0")
public class TagSub0 {
	
	TagSub0(){
		this.createTimestamp=new Date();
	}
	
	@Column(name="tag_sub_0_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="tag_sub_0_name")
	private String tagSub0Name;
	
	@OneToOne
	@JoinColumn(name="tag_super_id")
	private TagSuper tagSuperId;
	
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


	public String getTagSub0Name() {
		return tagSub0Name;
	}

	public void setTagSub0Name(String tagSub0Name) {
		this.tagSub0Name = tagSub0Name;
	}

	public TagSuper getTagSuperId() {
		return tagSuperId;
	}

	public void setTagSuperId(TagSuper tagSuperId) {
		this.tagSuperId = tagSuperId;
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
