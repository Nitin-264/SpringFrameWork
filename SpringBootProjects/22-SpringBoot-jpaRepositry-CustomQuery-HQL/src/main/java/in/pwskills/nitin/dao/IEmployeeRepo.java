package in.pwskills.nitin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.bean.Employee;
import jakarta.transaction.Transactional;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

	//================select operation=============//
	
	@Query("From Employee where empSal>=:esal")
	public List<Employee> fetchAllEmployees(Double esal);
	
	@Query("From Employee")
	public List<Employee> fetchAllEmployees();
	
	@Query("select empName from Employee")
	public List<String> fetchNameOfEmployees();
	
	@Query("select empId , empName from Employee")
	public List<Object[]> fetchIdAndNameofEmployee();
	
	@Query("select empId,empName from Employee where empDept= :dept")
	public List<Object[]> fetchBasedonDept(String dept);
	
	//================non-select operation=============//
	@Query("Delete from Employee where empId=:id")
	@Modifying     //instructing the query is DML
	@Transactional //commit and rollback
	public int deleteEmployeeById(Integer id);
	
	@Query("Update Employee set empSal=empSal+:bonus where empId=:id")
	@Modifying
	@Transactional
	public int updateEmployeeSalaryById(Integer id, Double bonus);

	
}
