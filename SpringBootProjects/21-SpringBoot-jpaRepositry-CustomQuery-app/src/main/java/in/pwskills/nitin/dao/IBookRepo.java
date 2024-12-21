package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.bean.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBookRepo extends JpaRepository<Book, Integer> {

	//select * from booktab where bauth=?
	List<Book> findByAuthor(String author);
	
	//select * from booktab where bcost>=?
	List<Book> findByBookCostGreaterThanEqual(Double bookCost);
	
	//select * from booktab where bid IN (?,?)
	List<Book> findByBookIdIn(List<Integer> inte);
	
	//select * from booktab where bid between x and y
	List<Book> findByBookIdBetween(Integer bookId1,Integer bookId2);
	
	//select * from booktab where bid <= ? or bType like ?
	List<Book> findByBookIdGreaterThanEqualOrBookTypeLike(Integer bookId,String booklike);
	
	//select * from booktab where bcost != ? and author not like ?
	List<Book> findByBookCostNotAndAuthorNotLike(Double cost,String author);
	
	//SELECT * FROM booktab WHERE bauth IS NULL;
    List<Book> findByAuthorIsNull();
		
	//SELECT * FROM booktab WHERE bauth IS Not NULL;
	List<Book> findByAuthorIsNotNull();
	
	//select * from booktab where bid=?
	Optional<Book>  findByBookId(Integer bookId);
	
}
