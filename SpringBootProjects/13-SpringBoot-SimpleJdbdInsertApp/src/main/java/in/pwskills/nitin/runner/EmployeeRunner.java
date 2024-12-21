package in.pwskills.nitin.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import in.pwskills.nitin.bean.EmployeeDTO;
import in.pwskills.nitin.service.IEmployeeService;

public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService service;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		EmployeeDTO dto = new EmployeeDTO("Sarfaraz", "batsman", 26000.0f, 58, 12);
		int count = service.insertrecord(dto);
		if (count ==1) {
			System.out.println("Record inserted succesfully");
		}
		
	}


}
