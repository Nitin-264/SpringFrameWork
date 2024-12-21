package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.User;

public interface IUserRepo extends JpaRepository<User, Integer> {

}
