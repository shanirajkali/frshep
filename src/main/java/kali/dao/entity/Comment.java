package kali.dao.entity;

/**
 * @author shani rajkali
 * @Since 30-9-2017
 */


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {


	Comment(){
		this.replyTimestamp=new Date();
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="comment_id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="comment_news_id")
	private News newsId;
	
	@OneToOne
	@JoinColumn(name="comment_user_id")
	private UserAccount userId;
	
	@Column(name="comment_timestamp",nullable=false)
	private Date replyTimestamp;
	
	@Column(name="comment_update_timestamp")
	private Date replyUpdateTimestamp;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public News getNewsId() {
		return newsId;
	}

	public void setNewsId(News newsId) {
		this.newsId = newsId;
	}

	public UserAccount getUserId() {
		return userId;
	}

	public void setUserId(UserAccount userId) {
		this.userId = userId;
	}

	public Date getReplyTimestamp() {
		return replyTimestamp;
	}

	public void setReplyTimestamp(Date replyTimestamp) {
		this.replyTimestamp = replyTimestamp;
	}

	public Date getReplyUpdateTimestamp() {
		return replyUpdateTimestamp;
	}

	public void setReplyUpdateTimestamp(Date replyUpdateTimestamp) {
		this.replyUpdateTimestamp = replyUpdateTimestamp;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public long getLike() {
		return like;
	}

	public void setLike(long like) {
		this.like = like;
	}

	public long getFake() {
		return fake;
	}

	public void setFake(long fake) {
		this.fake = fake;
	}

	public long getGenuine() {
		return genuine;
	}

	public void setGenuine(long genuine) {
		this.genuine = genuine;
	}

	@Column(name="comment")
	private String reply;
	
	@Column(name="comment_like")
	private long like;
	
	@Column(name="comment_fake")
	private long fake;
	
	@Column(name="comment_genuine")
	private long genuine;
	
}
