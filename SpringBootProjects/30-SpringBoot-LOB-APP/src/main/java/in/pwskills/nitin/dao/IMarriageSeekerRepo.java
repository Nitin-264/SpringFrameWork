package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.MarriageSeeker;

public interface IMarriageSeekerRepo extends JpaRepository<MarriageSeeker, Long> {

}
