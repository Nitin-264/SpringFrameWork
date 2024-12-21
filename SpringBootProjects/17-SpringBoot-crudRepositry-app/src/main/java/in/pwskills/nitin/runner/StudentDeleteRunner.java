package in.pwskills.nitin.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.dao.IStudentDaoImpl;
import in.pwskills.nitin.exception.StudentRecordNotFoundException;

//@Component
public class StudentDeleteRunner implements CommandLineRunner {

	@Autowired
	private IStudentDaoImpl dao;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//dao.deleteById(25);
		
		/*Student student = new Student();
		student.setSid(10);
		student.setSname("messi");
		student.setSage(38);
		student.setSaddress("argentina");
		dao.delete(student);*/
		
		/*dao.delete(dao.findById(7).orElseThrow(()->new StudentRecordNotFoundException(String.format(
				"Record for %s object not avaialable for the given id %d", Student.class.getName(),7))));
		*/
		dao.deleteAllById(List.of(26, 63));
	}

}
