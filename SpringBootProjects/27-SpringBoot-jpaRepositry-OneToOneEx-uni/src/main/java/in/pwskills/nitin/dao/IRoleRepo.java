package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.Role;

public interface IRoleRepo extends JpaRepository<Role, Integer> {

}
