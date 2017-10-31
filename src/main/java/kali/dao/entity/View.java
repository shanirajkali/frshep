package kali.dao.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({})
@Table(name="view")
public class View implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public View(){
		
	}
	
	@Id
	@JoinColumn(name="news_id")
	@OneToOne
	private News newsId;
	
	@OneToMany
	@JoinTable(name="view_viewdetails",
				joinColumns=@JoinColumn(name="news_id"),
				inverseJoinColumns=@JoinColumn(name="view_details"))
	private Collection<ViewDetails> viewDetais;

	public News getNewsId() {
		return newsId;
	}

	public void setNewsId(News newsId) {
		this.newsId = newsId;
	}

	public Collection<ViewDetails> getViewDetais() {
		return viewDetais;
	}

	public void setViewDetais(Collection<ViewDetails> viewDetais) {
		this.viewDetais = viewDetais;
	}

	
	
	
	
}
