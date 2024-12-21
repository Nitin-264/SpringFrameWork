package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.Course;

public interface ICourseRepo extends JpaRepository<Course, Integer> {

}
