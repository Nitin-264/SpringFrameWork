package in.pwskills.nitin.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pwskills.nitin.bean.Employee;

public interface IEmployeePagindSortingdao extends PagingAndSortingRepository<Employee, Integer> {

}
