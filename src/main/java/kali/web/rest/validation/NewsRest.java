package kali.web.rest.validation;
import java.util.ArrayList;

public class NewsRest {

	private String heading;
	private String description;
	private ArrayList<String> tag;
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
	public ArrayList<String> getTag() {
		return tag;
	}
	public void setTag(ArrayList<String> tag) {
		this.tag = tag;
	}
	
}