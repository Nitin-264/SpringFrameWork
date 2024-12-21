package in.pwskills.nitin.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import in.pwskills.nitin.service.EmployeeServicempl;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeServicempl service;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		service.searchEmpsByDesgs("QA", "DEV").forEach(System.out::println);
	}

}
