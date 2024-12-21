package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.Employee;
import in.pwskills.nitin.beans.Student;

@Component
@Order(value = 10)
public class EmployeeRunner implements ApplicationRunner {

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
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
        System.out.println("\nEmployeeRunner.run()");
		
		System.out.println(emp);
		System.out.println(std);
		
		System.out.println("\nArugument passed are:");
		System.out.println("Optinl arguments are:: "+args.getOptionNames());
		System.out.println("Optinl arguments are:: "+args.getNonOptionArgs());
	}

}
