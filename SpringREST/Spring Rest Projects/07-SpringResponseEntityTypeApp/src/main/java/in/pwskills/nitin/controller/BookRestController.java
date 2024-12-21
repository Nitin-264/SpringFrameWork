package in.pwskills.nitin.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Book;

@RestController
@RequestMapping("v1/api/book")
public class BookRestController {

	/*
	 * R.T    : ResponseEntity<?>
	 * Method : GET
	 * PATH   : /find/{id}
	 * Input  : id (@PathVariable)
	 */
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getBookDetails(
			          @PathVariable  Integer id){
		
		HttpHeaders header ;
		if (id==5) {
			header = new HttpHeaders();
			header.add("found", "yes");
			return new ResponseEntity<>(new Book(45,"Microservices",15000.0),header,HttpStatus.OK);
		}
		else {
			header = new HttpHeaders();
			header.add("found", "no");
			return new ResponseEntity<>("SOORY BOOK NOT FOUND",header,HttpStatus.OK);		}
	}
	
	/*
	 * R.T    : Book
	 * Method : GET
	 * PATH   : /info
	 * Input  : no input
	 */
	@GetMapping("/info")
	public Book getbookinfo() {
		// return new ResponseEntity(Book,HttpStatus.OK);
		return new Book(56,"HIBERNET",5000.0);
	}
}
