package kali.web.rest.validation;

public class AddressRest {

	private String locale;
	private int pin;
	private String state;
	private String tahsil;
	private String district;
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
