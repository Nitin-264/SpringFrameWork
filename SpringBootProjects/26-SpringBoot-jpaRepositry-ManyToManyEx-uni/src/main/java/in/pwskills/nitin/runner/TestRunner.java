package in.pwskills.nitin.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Course;
import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.dao.ICourseRepo;
import in.pwskills.nitin.dao.IStudentRepo;


//@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private ICourseRepo crepo;
	
	@Autowired
	private IStudentRepo srepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Course c1 = new Course(50, "SpringBoot", 500.0);
		Course c2 = new Course(51, "Angular", 600.0);
		
		crepo.save(c1);
		crepo.save(c2);
		
		Student s1 = new Student(10, "AJAY", "aj@gm.com", Arrays.asList(c1,c2));
		Student s2 = new Student(11, "SAM", "sa@gm.com", Arrays.asList(c1,c2));
		
		srepo.save(s1);
		srepo.save(s2);
	}

	
	
}
