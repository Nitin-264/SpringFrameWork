package in.pwskills.nitin.dao;

import java.util.List;

import in.pwskills.nitin.beans.EmployeeBO;

public interface IEmployeeDao {

	public List<EmployeeBO> fetchempbydesg(String cond) throws Exception;
}
