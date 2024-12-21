package in.pwskills.nitin.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Role;
import in.pwskills.nitin.bean.User;
import in.pwskills.nitin.dao.IRoleRepo;
import in.pwskills.nitin.dao.IUserRepo;



//@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IRoleRepo rrepo;
	
	@Autowired
	private IUserRepo urepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Role r1 = new Role(503, "ADMIN");
		Role r2 = new Role(504, "GUEST");
		
		rrepo.save(r1);
		rrepo.save(r2);
		
		User u1 = new User(10, "SYED", r1);
		User u2 = new User(11, "SAM",  r2);
		//User u3 = new User(12, "RAM",  r1);
		
		urepo.save(u1);
		urepo.save(u2);	
		//urepo.save(u3);
	}

	
	
}
