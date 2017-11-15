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
	@NamedQuery(name="TagSub2.getPatternWise", query="select tagSub2Name from TagSub2 ts where ts.tagSub2Name like ?"),
	@NamedQuery(name="TagSub2.getIdByName", query="select id from TagSub2 ts2 where ts2.tagSub2Name=?"),
	@NamedQuery(name="TagSub2.getAllBySubTag1Id", query="select tagSub2Name from TagSub2 ts where ts.tagSub1Id=?")
})
@Table(name="tag_sub_2")
public class TagSub2 {
	
	TagSub2(){
		this.createTimestamp=new Date();
	}
	
	
	@Column(name="tag_sub_2_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="tag_sub_2_name")
	private String tagSub2Name;
	
	
	@OneToOne
	@JoinColumn(name="tag_sub_1_id")
	private TagSub1 tagSub1Id;
	
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



	public String getTagSub2Name() {
		return tagSub2Name;
	}

	public void setTagSub2Name(String tagSub2Name) {
		this.tagSub2Name = tagSub2Name;
	}

	public TagSub1 getTagSub1Id() {
		return tagSub1Id;
	}

	public void setTagSub1Id(TagSub1 tagSub1Id) {
		this.tagSub1Id = tagSub1Id;
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