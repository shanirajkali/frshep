package kali.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class career_domains {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column(name="package")
	int pack;
	
	int other_id;
	String domain;
	String sub_domain;
	String domain_image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPack() {
		return pack;
	}
	public void setPack(int pack) {
		this.pack = pack;
	}
	public int getOther_id() {
		return other_id;
	}
	public void setOther_id(int other_id) {
		this.other_id = other_id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSub_domain() {
		return sub_domain;
	}
	public void setSub_domain(String sub_domain) {
		this.sub_domain = sub_domain;
	}
	public String getDomain_image() {
		return domain_image;
	}
	public void setDomain_image(String domain_image) {
		this.domain_image = domain_image;
	}
	
	
	
}
