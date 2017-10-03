package kali.dao.entity;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({
}
)
@Table(name="news")
public class News {

	News(){
		this.postTimeStamp=new Date();
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="news_id")
	private int id;
	@Column(name="news_heading")
	private String heading;
	@Column(name="news_description")
	@Lob
	private String description;
	@Column(name="news_post_time_stamp",nullable=false)
	private Date postTimeStamp;
	@Column(name="news_update_time_stamp",nullable=false)
	private Date updateTimeStamp;
	@OneToOne
	@JoinColumn(name="user_id")
	private UserAccount userId;
	@Column(name="address_id")
	private int addressId;
	@Column(name="news_original")
	private long original;
	@Column(name="news_view")
	private long view;
	public long getView() {
		return view;
	}

	public void setView(long view) {
		this.view = view;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostTimeStamp() {
		return postTimeStamp;
	}

	public void setPostTimeStamp(Date postTimeStamp) {
		this.postTimeStamp = postTimeStamp;
	}

	public Date getUpdateTimeStamp() {
		return updateTimeStamp;
	}

	public void setUpdateTimeStamp(Date updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}

	public UserAccount getUserId() {
		return userId;
	}

	public void setUserId(UserAccount userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public long getOriginal() {
		return original;
	}

	public void setOriginal(long original) {
		this.original = original;
	}

	public long getGenuine() {
		return genuine;
	}

	public void setGenuine(long genuine) {
		this.genuine = genuine;
	}

	public long getLike() {
		return like;
	}

	public void setLike(long like) {
		this.like = like;
	}

	public long getShare() {
		return share;
	}

	public void setShare(long share) {
		this.share = share;
	}

	public Collection<TagSuper> getTags() {
		return tags;
	}

	public void setTags(Collection<TagSuper> tags) {
		this.tags = tags;
	}

	@Column(name="news_genuine")
	private long genuine;
	@Column(name="news_like")
	private long like;
	@Column(name="news_share")
	private long share;
	
	@OneToMany
	@JoinTable(name="relation_news_tag",
				joinColumns=@JoinColumn(name="news_id"),
				inverseJoinColumns=@JoinColumn(name="tag_id"))
	private Collection<TagSuper> tags;
	
}