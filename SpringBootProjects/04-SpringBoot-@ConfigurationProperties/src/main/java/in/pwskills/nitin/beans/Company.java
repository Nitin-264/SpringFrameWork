package in.pwskills.nitin.beans;

import org.springframework.stereotype.Component;

@Component
public class Company {

	static {
		System.out.println("Company.class file is loading...");
	}

	public Company() {
		System.out.println("Company Object -> Zero param....");
	}
	
	private String title;
	private String location;
	private String course;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Company [title=" + title + ", location=" + location + ", course=" + course + "]";
	}
	
	
	
}
