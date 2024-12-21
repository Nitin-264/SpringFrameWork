package in.pwskills.nitin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.entity.Student;
import in.pwskills.nitin.exception.StudentNotFoundException;
import in.pwskills.nitin.repo.IStudentrepo;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentrepo repo;
	
	@Override
	public Integer saveStudent(Student s) {
		// TODO Auto-generated method stub
		s = repo.save(s);
		return s.getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub

		//check whether object exists with that id
		if (s.getStdId()==null || !repo.existsById(s.getStdId())) {
			throw new StudentNotFoundException("STUDENT"+s.getStdId()+"DOES NOT EXISTS");
		}
		else {
			// if student exists with the id then update 
			repo.save(s);
		}
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Student getOneStudent(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(
				                  ()-> new StudentNotFoundException("Student Not Found for given id::"+id)      
				                       );
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
