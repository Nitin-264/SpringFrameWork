package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.Model;

public interface IModelRepo extends JpaRepository<Model, Integer> {

}