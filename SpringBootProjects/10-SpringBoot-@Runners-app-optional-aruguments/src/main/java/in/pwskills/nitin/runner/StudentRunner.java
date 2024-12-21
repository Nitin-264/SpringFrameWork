package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.Employee;
import in.pwskills.nitin.beans.Student;

@Component
@Order(value = 5)
public class StudentRunner implements ApplicationRunner , Ordered{


	@Autowired
	private Employee employee;

	@Autowired
	private Student student;

	static {
		System.out.println("StudentRunner.class file is loading...");
	}

	public StudentRunner() {
		System.out.println("StudentRunner Object is created...");
	}
	
	

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		System.out.println("StudentRunner.getOrder()");
		return 15;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("StudentRunner.run()");
		System.out.println(employee);
		System.out.println(student);
		
		System.out.println("Argument passsed are::");
		System.out.println("Optinal arguments are :: "+ args.getOptionNames());
		System.out.println("Non Optionaal arguments are ::"+ args.getNonOptionArgs());
	}

}
