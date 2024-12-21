package in.pwskills.nitin.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.dao.IStudentDaoImpl;
import in.pwskills.nitin.exception.StudentRecordNotFoundException;

//@Component
public class StudentRunner implements CommandLineRunner {


@Autowired
private IStudentDaoImpl dao;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println(dao.getClass().getName());
		
		//save operation
		dao.save(new Student(25,"Sarfarraz", "PBKS", 28));
		
		Student s1 = new Student(7, "dhoni", "CSK", 42);
		Student s2 = new Student(10, "messi", "argentina", 38);
		dao.saveAll(List.of(s1, s2)).forEach(System.out::println);
		
		Optional<Student> opt = dao.findById(7);
		if (opt.isPresent()) {
			Student std = opt.get();
			System.out.println(std);
		}
		else {
			System.out.println("Record not found for given id");
		}
		
		Student std = dao.findById(7).orElseThrow(()->new StudentRecordNotFoundException("Record not found"));
		System.out.println(std);
		
		// select * from student
		dao.findAll().forEach(System.out::println);

		// select * from student where sid IN (?,?,?)
		dao.findAllById(List.of(7, 18, 9)).forEach(System.out::println);

		System.out.println("*****************************");
		
		if (dao.existsById(7)) {
			
			dao.findById(7).get();
		}
		
		// select count(*) from student;
		long noOfrecords= dao.count();
		System.out.println("No. of records available ::"+noOfrecords);
		
	}

}
