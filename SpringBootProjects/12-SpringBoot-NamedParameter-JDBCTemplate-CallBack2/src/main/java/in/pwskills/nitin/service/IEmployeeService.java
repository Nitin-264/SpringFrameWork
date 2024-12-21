package in.pwskills.nitin.service;

import java.util.List;

import in.pwskills.nitin.bean.EmployeeDTO;

public interface IEmployeeService {

	public String   fetchemployeeByNo(Integer no);
	
	public List<EmployeeDTO> fetchemployeeByDesg(String cond1 , String cond2);
	public int insertemp(EmployeeDTO dto);
}
