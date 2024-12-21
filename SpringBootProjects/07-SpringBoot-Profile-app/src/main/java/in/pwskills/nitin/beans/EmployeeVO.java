package in.pwskills.nitin.beans;

public class EmployeeVO {

	private String srNo;
	private String empNo;
	private String empName;
	private String job;
	private String salary;
	private String deptNo;
	private String mgrNo;
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getMgrNo() {
		return mgrNo;
	}
	public void setMgrNo(String mgrNo) {
		this.mgrNo = mgrNo;
	}
	@Override
	public String toString() {
		return "EmployeeVO [srNo=" + srNo + ", empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", salary="
				+ salary + ", deptNo=" + deptNo + ", mgrNo=" + mgrNo + "]";
	}
	
	
}
