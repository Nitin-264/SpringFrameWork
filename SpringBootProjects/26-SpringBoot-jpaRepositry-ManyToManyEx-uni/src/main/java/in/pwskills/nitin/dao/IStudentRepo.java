package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
