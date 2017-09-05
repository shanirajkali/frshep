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
@Table(name="news_media")
public class NewsMedia {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="news_media_id")
	private int mediaId;
	
	@Column(name="news_media_url",nullable=false)
	private String mediaUrl;
	
	@OneToOne
	@JoinColumn(name="news_id")
	private News newsId;

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public News getNewsId() {
		return newsId;
	}

	public void setNewsId(News newsId) {
		this.newsId = newsId;
	}

}
