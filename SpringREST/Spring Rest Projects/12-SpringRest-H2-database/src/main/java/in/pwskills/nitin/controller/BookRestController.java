package in.pwskills.nitin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.entity.Book;
import in.pwskills.nitin.repositry.IBookRepo;

@RestController
@RequestMapping("v1/api/book")
public class BookRestController {

	@Autowired
	private IBookRepo repo;
	
	/*
	 * METHOD : POST
	 * PATH   : /save
	 * INPUT  : Book(@RequestBody)
	 * OUTPUt : R.E<String>
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveBook(@RequestBody Book book){
		Book obj =  repo.save(book);
		return ResponseEntity.ok("Book Saved with id::"+obj.getBid());
	}
}
