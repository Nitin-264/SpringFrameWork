package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.Employee;
import in.pwskills.nitin.beans.Student;

@Component
@Order(value = 10)
public class EmployeeRunner implements CommandLineRunner {

	static {
		System.out.println("EmployeeRunner.class file is loading...");
	}

	public EmployeeRunner() {
		System.out.println("EmployeeRunner Object is created...");
	}
	
	@Autowired
	private Employee emp;
	
	@Autowired
	private Student std;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("\nEmployeeRunner.run()");
		
		System.out.println(emp);
		System.out.println(std);
		
		System.out.println("\nArugument passed are:");
		for (String data : args) {
			System.out.println(data);
		}
	}

}
