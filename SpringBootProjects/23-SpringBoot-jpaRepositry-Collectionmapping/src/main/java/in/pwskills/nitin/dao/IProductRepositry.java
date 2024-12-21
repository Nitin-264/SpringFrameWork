package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.Product;

public interface IProductRepositry extends JpaRepository<Product, Integer> {

}
