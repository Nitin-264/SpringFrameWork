package in.pwskills.nitin.service;

import java.util.List;

import in.pwskills.nitin.bean.EmployeeDTO;

public interface IEmployeeService {

	public EmployeeDTO  fetchemployeeByNo(Integer no);
	
	public List<EmployeeDTO> fetchemployeeByDesg(String cond1 , String cond2);
	public List<EmployeeDTO> fetchallemployee();
}
