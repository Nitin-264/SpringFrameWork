package in.pwskills.nitin.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "emp.info")
public class Employee {

	static {
		System.out.println("Employee.class file is loading...");
	}

	public Employee() {
		System.out.println("Employee object is created...");
	}
	
	private Integer eid;
	private String ename;
	private String eaddress;
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + "]";
	}
	
	
}
