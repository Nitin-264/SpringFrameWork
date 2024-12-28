package in.pwskills.nitin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.entity.Student;
import in.pwskills.nitin.exception.StudentNotFoundException;
import in.pwskills.nitin.service.IStudentService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("v1/api/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;
	
	/*
	 * METHOD : POST
	 * PATH   : /create
	 * INPUT  : Student object (@RequestBody)
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	@Operation(summary = "SAVE THE STUDENT OBJECT")
	@PostMapping("/create")
	public ResponseEntity<String> saveStudent(@RequestBody Student std){
		
	   Integer id =	service.saveStudent(std);
	   
	   return new ResponseEntity<>("Student saved with id::"+id,HttpStatus.OK);
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /all
	 * INPUT  : no input
	 * R.T    : ResponseEntity<List<Student>>
	 * 
	 */
	@Operation(summary = "GIVE THE LIST OF ALL STUDENT OBJECTS")
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getallStd(){
		List<Student> body = service.getAllStudents();
		return ResponseEntity.ok(body);
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /find/{id}
	 * INPUT  : id ->  @PathVariable
	 * R.T    : ResponseEntity<Student>
	 * 
	 */
	@Operation(summary = "FIND THE STUDENT WITH ID")
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> findstd(@PathVariable Integer id){
		
		ResponseEntity<Student> response;
		try {
			Student std = service.getOneStudent(id);
			response = ResponseEntity.ok(std);
		}
		catch(StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	/*
	 * METHOD : DELETE
	 * PATH   : /remove/{id}
	 * INPUT  : id -> @PathVariable
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	@Operation(summary = "DELETE THE STUDENT OBJECT")
	@GetMapping("/remove/{id}")
	public ResponseEntity<String> deleteStd(@PathVariable Integer id){
		
		ResponseEntity<String> response = null;
		try {
			service.deleteStudent(id);
			response = ResponseEntity.ok("Student removed with id ::"+id);
		}
		catch(StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	/*
	 * METHOD : PUT
	 * PATH   : /modify
	 * INPUT  : Student -> @RequestBody
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	@Operation(summary = "UPDATE THE STUDENT")
	@PutMapping("/modify")
	public ResponseEntity<String> modifyStd(@RequestBody Student std){
		
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(std);
			response = ResponseEntity.ok("Student updated with id ::"+std.getStdId());
		}
		catch(StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	
}