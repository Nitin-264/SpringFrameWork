package in.pwskills.nitin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.entity.Student;

@Repository
public interface IStudentrepo extends JpaRepository<Student, Integer> {

}
