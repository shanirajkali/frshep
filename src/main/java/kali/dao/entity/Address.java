package kali.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Address.getState", query="Select state From Address"),
	@NamedQuery(name="Address.getDistrict", query="Select district From Address A where A.state=?"),
	@NamedQuery(name="Address.getTahsil", query="Select tahsil From Address A where A.district=?"),
	@NamedQuery(name="Address.getLocale",query="Select locale From Address A where A.tahsil=?"),
	@NamedQuery(name="Address.getLocaleByPin",query="Select locale From Address A where A.pin=?"),
	@NamedQuery(name="Address.getByAll", query="From Address A where A.locale=? and A.tahsil=?"),
	@NamedQuery(name="Address.exist",query="select id From Address A where A.pin=? and A.state=? and A.district=? and A.tahsil=? and A.locale=?")
}
)
@Table(name="address")
public class Address {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private int id;
	@Column(name="locale",nullable=false)
	private String locale;
	@Column(name="pin",nullable=false)
	private int pin;
	@Column(name="state",nullable=false)
	private String state;
	@Column(name="tahsil",nullable=false)
	private String tahsil;
	@Column(name="district",nullable=false)
	private String district;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTahsil() {
		return tahsil;
	}
	public void setTahsil(String tahsil) {
		this.tahsil = tahsil;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
}
