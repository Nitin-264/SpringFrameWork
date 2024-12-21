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
		
		EmployeeDTO dto = service.fetchemployeeByNo(3);
		System.out.println(dto);
		System.out.println("*********************************");
		
		List<EmployeeDTO> ldto = service.fetchemployeeByDesg("batsman", "bowler");
		ldto.forEach(System.out::println);
		System.out.println("*********************************");
		
		List<EmployeeDTO> listdto= service.fetchallemployee();
		listdto.forEach(System.out::println);
		System.out.println("*********************************");
		
		
	}


}
