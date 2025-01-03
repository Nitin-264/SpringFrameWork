package in.pwskills.nitin.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Customer;
import in.pwskills.nitin.dao.ICustomerRepo;

@Component
public class CustomerRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepo crepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Customer customer = new Customer(45, "Nitin", "MI",
				LocalDateTime.of(2005, 07, 27, 5, 30), 
				LocalTime.now(), LocalDate.now());
		crepo.save(customer);
		
        System.out.println("*****Customer object is saved******");
		
		crepo.findAll().forEach(System.out::println);
	}

}
