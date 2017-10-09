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
	@Lob
	@Column(name="news_description")
	private String description;
	@Column(name="news_post_time_stamp",nullable=false)
	private Date postTimeStamp;
	@Column(name="news_update_time_stamp",nullable=false)
	private Date updateTimeStamp;
	@Column(name="address_id")
	private int addressId;
	@Column(name="news_original")
	private long original;
	@Column(name="news_view")
	private long view;
	@Column(name="news_genuine")
	private long genuine;
	@Column(name="news_like")
	private long like;
	@Column(name="news_share")
	private long share;
	
	@OneToMany
	@JoinTable(name="news_media_relation",
				joinColumns=@JoinColumn(name="news_id"),
				inverseJoinColumns=@JoinColumn(name="news_media_id"))
	private Collection<NewsMedia> newsMedia;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserAccount userId;
	
	@OneToOne
	@JoinTable(name="tag_super_id")
	private TagSuper tagSuperId;
	
	@OneToOne
	@JoinTable(name="tag_sub0_id")
	private TagSub0 tagSub0Id;
	
	@OneToOne
	@JoinTable(name="tag_sub1_id")
	private TagSub1 tagSub1Id;
	
	@OneToOne
	@JoinTable(name="tag_sub2_id")
	private TagSub2 tagSub2Id;
	
	@OneToOne
	@JoinTable(name="tag_sub3_id")
	private TagSub3 tagSub3Id;

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

	public long getView() {
		return view;
	}

	public void setView(long view) {
		this.view = view;
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

	public Collection<NewsMedia> getNewsMedia() {
		return newsMedia;
	}

	public void setNewsMedia(Collection<NewsMedia> newsMedia) {
		this.newsMedia = newsMedia;
	}

	public UserAccount getUserId() {
		return userId;
	}

	public void setUserId(UserAccount userId) {
		this.userId = userId;
	}

	public TagSuper getTagSuperId() {
		return tagSuperId;
	}

	public void setTagSuperId(TagSuper tagSuperId) {
		this.tagSuperId = tagSuperId;
	}

	public TagSub0 getTagSub0Id() {
		return tagSub0Id;
	}

	public void setTagSub0Id(TagSub0 tagSub0Id) {
		this.tagSub0Id = tagSub0Id;
	}

	public TagSub1 getTagSub1Id() {
		return tagSub1Id;
	}

	public void setTagSub1Id(TagSub1 tagSub1Id) {
		this.tagSub1Id = tagSub1Id;
	}

	public TagSub2 getTagSub2Id() {
		return tagSub2Id;
	}

	public void setTagSub2Id(TagSub2 tagSub2Id) {
		this.tagSub2Id = tagSub2Id;
	}

	public TagSub3 getTagSub3Id() {
		return tagSub3Id;
	}

	public void setTagSub3Id(TagSub3 tagSub3Id) {
		this.tagSub3Id = tagSub3Id;
	}
	
	
}