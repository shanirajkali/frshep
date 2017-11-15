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
	@NamedQuery(name="TagSub1.getPatternWise", query="select tagSub1Name from TagSub1 ts where ts.tagSub1Name like ?"),
	@NamedQuery(name="TagSub1.getSub1", query="select tagSub1Name from TagSub1 ts where ts.tagSub0Id=?"),
	@NamedQuery(name="TagSub1.getIdByName",query="select id from TagSub1 ts where ts.tagSub1Name=?")
})
@Table(name="tag_sub_1")
public class TagSub1 {
	
	TagSub1(){
		this.createTimestamp=new Date();
	}
	
	@Column(name="tag_sub_1_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="tag_sub_1_name")
	private String tagSub1Name;
	
	@OneToOne
	@JoinColumn(name="tag_sub_0_id")
	private TagSub0 tagSub0Id;
	
	@Column(name="tag_create_timestamp")
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


	public String getTagSub1Name() {
		return tagSub1Name;
	}

	public void setTagSub1Name(String tagSub1Name) {
		this.tagSub1Name = tagSub1Name;
	}



	public TagSub0 getTagSub0Id() {
		return tagSub0Id;
	}

	public void setTagSub0Id(TagSub0 tagSub0Id) {
		this.tagSub0Id = tagSub0Id;
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