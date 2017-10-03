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
	@NamedQuery(name="TagSub3.getPatternWise", query="select tagSub3Name from TagSub3 ts where ts.tagSub3Name like ?")
})
@Table(name="tag_sub_3")
public class TagSub3 {
	
	TagSub3(){
		this.createTimestamp=new Date();
	}
	
	@Column(name="tag_sub_3_id")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="tag_sub_3_name")
	private String tagSub3Name;
	
	@OneToOne
	@JoinColumn(name="tag_sub_2_id")
	private TagSub2 tagSub2Id;
	
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




	public String getTagSub3Name() {
		return tagSub3Name;
	}

	public void setTagSub3Name(String tagSub3Name) {
		this.tagSub3Name = tagSub3Name;
	}

	public TagSub2 getTagSub2Id() {
		return tagSub2Id;
	}

	public void setTagSub2Id(TagSub2 tagSub2Id) {
		this.tagSub2Id = tagSub2Id;
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