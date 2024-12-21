package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
