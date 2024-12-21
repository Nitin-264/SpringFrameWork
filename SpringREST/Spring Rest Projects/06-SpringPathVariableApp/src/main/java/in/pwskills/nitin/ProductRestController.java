package in.pwskills.nitin;

import java.util.Enumeration;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/api/product")
public class ProductRestController {

	/*
	 * R.T    : ResponseEntity<String>
	 * METHOD : GET
	 * PATH   : /get -> static path , {pid}/{pname} -> dynamic path
	 * INPUT  : No input
	 * 
	 */
	@GetMapping("/get/{pid}/{pname}")
	public ResponseEntity<String> getPathhVariable(
			         @PathVariable Integer pid,
			         @PathVariable String pname){
		//new ResponseEntity<String>("PID = "+pid + " : "+"PNAME = "+pname,HttpStatus.OK);
		
		String body = "Pid:"+pid+"pname:"+pname;
		
		return ResponseEntity.ok(body);
	}
	
	/*
	 * R.T    : ResponseEntity<String>
	 * METHOD : find
	 * PATH   : /get -> static path 
	 * INPUT  : @RequestParam (pid,pname)
	 * 
	 */
	@GetMapping("/find")
	public ResponseEntity<String> getRequestParm(
			         @RequestParam Integer pid,
			         @RequestParam String pname){
		
		String body = "pid: "+pid+"pname: "+pname;
		return new ResponseEntity<>(body,HttpStatus.OK);
	}
	
	/*
	 * R.T    : ResponseEntity<String>
	 * METHOD : GET
	 * PATH   : /load -> static path 
	 * INPUT  : No Input
	 * 
	 */
	@GetMapping("/load")
	public ResponseEntity<String> getHeadersDetails(
			               @RequestHeader Map<String,String> headers){
		
		headers.forEach((key,value)->{
			System.out.println(String.format("Headers %s = %s",key,value));
		});
		
		return new ResponseEntity<>(String.format("Listed  %d Headers ",headers.size()),HttpStatus.OK);
	}
	
	/*
	 * R.T    : ResponseEntity<String>
	 * METHOD : GET
	 * PATH   : /info -> static path 
	 * INPUT  : No Input
	 * 
	 */
	@GetMapping("/info")
	public ResponseEntity<String> getHeaderInfo(
			HttpServletRequest request){
		
		Enumeration<String> names = request.getHeaderNames();
		String name="";
		String value="";
		String body="";
		while (names.hasMoreElements()) {
			name = (String) names.nextElement();
			value = request.getHeader(name);
			System.out.println(name + ": " + value);
		 	body+=name + ": "+value +"\n";
		}
		
		return new ResponseEntity<>(body,HttpStatus.OK);
	}
}
