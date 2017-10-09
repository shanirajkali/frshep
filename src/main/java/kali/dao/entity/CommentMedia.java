package kali.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment_media")
public class CommentMedia {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="comment_media_id")
	private long id;
	
	@Column(name="comment_media_url",nullable=false)
	private String Url;
	
	@OneToOne
	@JoinColumn(name="comment_id")
	private Comment commentId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public Comment getCommentId() {
		return commentId;
	}

	public void setCommentId(Comment commentId) {
		this.commentId = commentId;
	}

	
}
