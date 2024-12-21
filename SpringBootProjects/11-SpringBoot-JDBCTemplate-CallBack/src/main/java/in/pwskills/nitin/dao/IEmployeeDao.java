package in.pwskills.nitin.dao;

import java.util.List;

import in.pwskills.nitin.bean.EmployeeBO;

public interface IEmployeeDao {

public EmployeeBO  fetchemployeeByNo(Integer no);
	
	public List<EmployeeBO> fetchemployeeByDesg(String cond1 , String cond2);
	public List<EmployeeBO> fetchallemployee();
}
