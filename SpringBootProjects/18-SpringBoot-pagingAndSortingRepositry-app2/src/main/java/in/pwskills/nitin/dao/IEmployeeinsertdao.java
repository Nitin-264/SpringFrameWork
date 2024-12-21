package in.pwskills.nitin.dao;

import org.springframework.data.repository.CrudRepository;

import in.pwskills.nitin.bean.Employee;

public interface IEmployeeinsertdao extends CrudRepository<Employee, Integer> {

}
