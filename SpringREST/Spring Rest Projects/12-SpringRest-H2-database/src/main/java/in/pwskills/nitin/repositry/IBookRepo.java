package in.pwskills.nitin.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.entity.Book;

public interface IBookRepo extends JpaRepository<Book, Integer>{

}
