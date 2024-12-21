package in.pwskills.nitin.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Role;
import in.pwskills.nitin.bean.User;

@RestController
@RequestMapping("/v1/api/user")
public class UserRestController {


	/*
	 * R.T    : ResponseEntity<User>
	 * INPUT  : No input
	 * METHOD : GET
	 * PATH  : /get 
	 */
	
	@GetMapping("/userDetails")
	public ResponseEntity<User> getMapping(){
		
		User user = new User(10,"sachin","batsman","sachin@123",
				Set.of("saurav", "dravid", "sehwagh","yuvi"),
				Map.of("HDFC", 12345L, "Canara", 23123L, "SBI", 23923L));
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/*
	 * R.T    : ResponseEntity<List<Role>>
	 * INPUT  : No input
	 * METHOD : GET
	 * PATH  : /list 
	 */
	
	@GetMapping("/list")
	public ResponseEntity<List<Role>> getListDetails(){
		List<Role> list = List.of(new Role(1234, "BA"),
				                  new Role(2345,"DEV"), new Role(2123,"QA"));
		return new ResponseEntity<>(list,HttpStatus.OK);
	
	}
	

	/*
	 * R.T    : ResponseEntity<Map<K,V>>
	 * INPUT  : No input
	 * METHOD : GET
	 * PATH   : /map 
	 */
	
	@GetMapping("/map")
	public ResponseEntity<Map<String, Role>> getmapdetails(){
		Map<String, Role> map = Map.of("Role1",new Role(1234,"QA"),
				"role2",new Role(2345,"BA"), 
				"role3",new Role(1223,"DEV")
				);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
