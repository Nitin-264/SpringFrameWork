package in.pwskills.nitin.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "std.info")
public class Student {

	static {
		System.out.println("Student .class file is loading...");
	}

	public Student() {
		System.out.println("Student  object is created...");
	}
	
	private Integer sid;
	private String sname;
	private String saddress;
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + "]";
	}
	
	
	
}
