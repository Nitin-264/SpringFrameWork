package in.pwskills.nitin.service;

import java.util.List;

import in.pwskills.nitin.beans.EmployeeDTO;

public interface IEmployeeService {

	public List<EmployeeDTO> fetchempbydesg(String desg[]) throws Exception;
}
