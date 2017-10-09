package kali.dao.entity;

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
@Table(name="comment_reply")
public class CommentReply {

	CommentReply(){
		this.replyTimestamp=new Date();
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reply_id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="comment_reply_comment_id")
	private Comment commentId;
	
	@OneToOne
	@JoinColumn(name="comment_reply_user_id")
	private UserAccount userId;
	
	@Column(name="reply_timestamp",nullable=false)
	private Date replyTimestamp;
	
	@Column(name="reply_update_timestamp")
	private Date replyUpdateTimestamp;
	
	@Column(name="reply")
	private String reply;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Comment getCommentId() {
		return commentId;
	}

	public void setCommentId(Comment commentId) {
		this.commentId = commentId;
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

	@Column(name="reply_like")
	private long like;
	
	@Column(name="reply_fake")
	private long fake;
	
	@Column(name="reply_genuine")
	private long genuine;
	
}
