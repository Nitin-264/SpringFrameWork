package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

}
