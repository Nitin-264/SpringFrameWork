package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.MobileNumber;

public interface IMobileNumberRepo extends JpaRepository<MobileNumber, Long> {

}
