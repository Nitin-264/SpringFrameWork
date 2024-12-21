package in.pwskills.nitin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Book;

@RestController
@RequestMapping("/v1/api/Book")
public class Bookcontroller {

	/*
	 * METHOD : GET
	 * PATH   : /showA
	 * R.T    : ResponseEntity<String>
	 * INPUT  : no input
	 */
	@GetMapping("/showA")
	public ResponseEntity<String> showA(){
		return ResponseEntity.ok("WELCOME TO FIRST CALL TYPE - GET");}
	
	/*
	 * METHOD : GET
	 * PATH   : /showB
	 * R.T    : ResponseEntity<String>
	 * INPUT  : {id}/{name}
	 */
	@GetMapping("/showB/{id}/{name}")
	public ResponseEntity<String> showB(@PathVariable Integer id,
			                            @PathVariable String name){

		return ResponseEntity.ok("WELCOME TO FIRST CALL TYPE - GET ==> " +id +"-"+name);
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /showC
	 * R.T    : ResponseEntity<Book>
	 * INPUT  : {id}
	 */
	@GetMapping("/showC/{id}")
	public ResponseEntity<Book> showC(@PathVariable Integer id){
		
		return new ResponseEntity<>(new Book(id, "MicroServices", "NitinManjunath", 2500.0),HttpStatus.OK);
		
	}
	
	/*
	 * METHOD : POST
	 * PATH   : /showD
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */
	@PostMapping("/showD")
	public ResponseEntity<String> showD(
			@RequestBody Book book){
		
		return new ResponseEntity<>("Data given is::"+book,HttpStatus.OK);
	}
	
	/*
	 * METHOD : PUT
	 * PATH   : /showE
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */
	@PutMapping("/showE")
	public ResponseEntity<String> showE(@RequestBody Book book){
		
		return ResponseEntity.ok("Data from put is ::"+book);
	}
	
	/*
	 * METHOD : DELETE
	 * PATH   : /showF
	 * R.T    : ResponseEntity<String>
	 * INPUT  : id(@PathVariable)
	 */
	@DeleteMapping("/showF/{id}")
	public ResponseEntity<String> showF(@PathVariable Integer id){
		
		return ResponseEntity.ok("DELETE MAPPING::"+id);
	}
}
