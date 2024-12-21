package in.pwskills.nitin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Employee;

@RestController
@RequestMapping("/v1/api/employee")
public class EmployeeRestController {


	/*
	 *  R.T    : ResponseEntity<String>
	 *  PATH   : /save
	 *  INPUT  : Employee @RequestBody
	 *  METHOD : POST  
	 * 
	 */
	@PostMapping("/save")
	public ResponseEntity<String> getEmployee(
			           @RequestBody Employee employee){
		String body = employee.toString();
		//CREATED : resource got created at the producer side, to indicate to the consumer e
		
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
}
