package in.pwskills.nitin.dao;

import org.springframework.data.repository.CrudRepository;

import in.pwskills.nitin.bean.Student;

public interface IStudentDaoImpl extends CrudRepository<Student, Integer> {

}
