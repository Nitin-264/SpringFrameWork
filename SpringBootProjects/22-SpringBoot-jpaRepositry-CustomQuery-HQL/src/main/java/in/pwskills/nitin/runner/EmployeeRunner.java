package in.pwskills.nitin.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Employee;
import in.pwskills.nitin.dao.IEmployeeRepo;

//@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		repo.saveAll(Arrays.asList(new Employee(101, "AA", 200.0, "DEV"), new Employee(102, "BA", 500.0, "DEV"),
				new Employee(103, "AC", 200.0, "QA"), new Employee(104, "DD", 400.0, "QA"),
				new Employee(105, "EF", 600.0, "DEV")));

		repo.fetchAllEmployees(300.0).forEach(System.out::println);

		repo.fetchNameOfEmployees().forEach(System.out::println);

		List<Object[]> objs = repo.fetchIdAndNameofEmployee(); 
		for (Object[] objects : objs) {
			for (Object row : objects) {
				System.out.print(row + "\t");
			}
			System.out.println();
		}
		
		List<Object[]> objss = repo.fetchBasedonDept("QA");
		for (Object[] objects : objss) {
			for (Object row : objects) {
				System.out.print(row + "\t");
			}
			System.out.println();
		}
		
		System.out.println("Before deletion:: ");
		repo.fetchAllEmployees().forEach(System.out::println);
		
		System.out.println("No of records deleted are :: "+repo.deleteEmployeeById(101));
		
		System.out.println("After deletion:: ");
		repo.fetchAllEmployees().forEach(System.out::println);
		
		System.out.println("Before updation salary is :: ");
		repo.fetchAllEmployees().forEach(System.out::println);

		System.out.println("No of records updated is :: "+repo.updateEmployeeSalaryById(102, 200.0));
		
		System.out.println("After updation salary is :: ");
		repo.fetchAllEmployees().forEach(System.out::println);
		
		
	}

}
