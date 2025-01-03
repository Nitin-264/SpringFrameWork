package in.pwskills.nitin.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Model;
import in.pwskills.nitin.bean.Product;
import in.pwskills.nitin.dao.IModelRepo;
import in.pwskills.nitin.dao.IProductRepo;


//@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IModelRepo mrepo;
	
	@Autowired
	private IProductRepo prepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Model m1 = new Model(1012, "XYZ-A", "4GB-128GB-RED");
		Model m2 = new Model(1013, "XYZ-B", "6GB-256GB-GREEN");
		Model m3 = new Model(1014, "MN-C", "12GB-512GB-PINK");
		Model m4 = new Model(1011, "MN-D", "2GB-64GB-BLACK");
		
		Product p1 = new Product(10, "ABCD-XYZ", Arrays.asList(m1,m2));
		Product p2 = new Product(11, "ABCD-MN", Arrays.asList(m3,m4));
		
		mrepo.save(m1);
		mrepo.save(m2);
		mrepo.save(m3);
		mrepo.save(m4);
		
		prepo.save(p1);
		prepo.save(p2);	
	}

	
}
