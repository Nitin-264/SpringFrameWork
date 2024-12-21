package in.pwskills.nitin.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import in.pwskills.nitin.service.IProductService;


public class ProductRunner implements CommandLineRunner {

	@Autowired
	private IProductService service;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		service.getProductsByName("fosssil", "armani").forEach(System.out::println);
		System.out.println("We got");
	}


}
