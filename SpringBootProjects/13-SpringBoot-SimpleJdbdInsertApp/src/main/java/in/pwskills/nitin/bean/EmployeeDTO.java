package in.pwskills.nitin.bean;

import java.io.Serializable;

public class EmployeeDTO  implements  Serializable{

	private static final long serialVersionUID = 1L;
	private Integer empNo;
	private String ename;
	private String ejob;
	private Float esalary;
	private Integer eDeptNo;
	private Integer eMngrNo;
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(String ename, String job, Float salary, Integer deptNo, Integer mgrNo) {
		super();
		this.ename = ename;
		this.ejob = job;
		this.esalary = salary;
		this.eDeptNo = deptNo;
		this.eMngrNo = mgrNo;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return ejob;
	}
	public void setJob(String job) {
		this.ejob = job;
	}
	public Float getSalary() {
		return esalary;
	}
	public void setSalary(Float salary) {
		this.esalary = salary;
	}
	public Integer getDeptNo() {
		return eDeptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.eDeptNo = deptNo;
	}
	public Integer getMgrNo() {
		return eMngrNo;
	}
	public void setMgrNo(Integer mgrNo) {
		this.eMngrNo = mgrNo;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empNo=" + empNo + ", ename=" + ename + ", job=" + ejob + ", salary=" + esalary + ", deptNo="
				+ eDeptNo + ", mgrNo=" + eMngrNo + "]";
	}
	
	
}