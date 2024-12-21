package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

}
