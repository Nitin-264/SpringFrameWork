package in.pwskills.nitin.dao;

import java.util.List;

import in.pwskills.nitin.bean.EmployeeBO;

public interface IEmployeeDao {

public String  fetchemployeeByNo(Integer no);
	
	public List<EmployeeBO> fetchemployeeByDesg(String cond1 , String cond2);
	public int insertemp(EmployeeBO bo);
}
