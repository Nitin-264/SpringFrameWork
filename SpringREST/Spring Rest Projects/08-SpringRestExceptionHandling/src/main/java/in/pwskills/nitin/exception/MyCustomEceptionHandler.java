package in.pwskills.nitin.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.pwskills.nitin.bean.MyErrorResponse;
import in.pwskills.nitin.bean.ProductNotFoundException;

@RestControllerAdvice
public class MyCustomEceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("MyCustomExceptionHandler.class file is loading..()");
	}
	
	public MyCustomEceptionHandler() {
		System.out.println("MyCustomExceptionHandler object is created..");
	}
	
	
	
	
	/*@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<String> showcustomMsg(
			                                ProductNotFoundException pnfe){
		
		System.out.println("MyCustomEceptionHandler.showcustomMsg()");
		return new ResponseEntity<>(pnfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<MyErrorResponse> showcustomMsg(
			                                ProductNotFoundException pnfe){
		
		System.out.println("MyCustomEceptionHandler.showcustomMsg()");
		MyErrorResponse body = new MyErrorResponse(
				new Date().toString(), 
				"PRODUCT NOT FOUND", 
				404, 
				pnfe.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
