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
		//Working with single select operation
		System.out.println("Name is::"+service.fetchemployeeByNo(5));
		
		List<EmployeeDTO> ldto = service.fetchemployeeByDesg("bowler","batsman");
		ldto.forEach(System.out::println);
		
		EmployeeDTO dto = new EmployeeDTO("ParveenKumar","bowler", 85000.0f, 69, 4);
		
		int count = service.insertemp(dto);
		if (count == 1) {
			System.out.println("Record inserted succesfully");
		}
		
	}


}
