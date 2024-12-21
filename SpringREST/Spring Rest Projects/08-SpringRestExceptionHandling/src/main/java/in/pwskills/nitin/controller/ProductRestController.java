package in.pwskills.nitin.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.MyErrorResponse;
import in.pwskills.nitin.bean.Product;
import in.pwskills.nitin.bean.ProductNotFoundException;

@RestController
@RequestMapping("/v1/api/product")
public class ProductRestController {

	/*
	 * METHOD :GET
	 * PATH   :/one/{id}
	 * INPUT  : id(@Pathvariable)
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	//CASE 1: Default Exception Handler[BasicErrorController: error(request)]
	
	/*@GetMapping("/one/{id}")
	public ResponseEntity<String> getProductbyId(
			                      @PathVariable Integer id){
		
		if (id==150) {
			return new ResponseEntity<>("Product Exists...",HttpStatus.OK);
		}
		else {
			throw new RuntimeException("Product Not found"+id);
		}
	}*/
	
	//CASE 2: Sending ResponseEntity<String> or ResponseEntity<String>
	
	/*@GetMapping("/one/{id}")
	public ResponseEntity<String> getProductbyId(
			                      @PathVariable Integer id){
		
		if (id==150) {
			return new ResponseEntity<>("Product Exists...",HttpStatus.OK);
		}
		else {
			throw new ProductNotFoundException("Product Not found for given id :"+id);
		}
	}*/
	
	/* CASE-3 : Sending ResponseEntity<Product> or ResponseEntity<MyErrorResponse>
	 * METHOD :GET
	 * PATH   :/one/{id}
	 * INPUT  : id(@Pathvariable)
	 * R.T    : ResponseEntity<Product> | ResponseEntity<MyErrorResponse>
	 * 
	 */
	@GetMapping("/one/{id}")
	public ResponseEntity<Product> getProductbyId(
			                      @PathVariable Integer id){
		
		if (id==150) {
			return new ResponseEntity<>(new Product(10, "Microservices", 52000.0),HttpStatus.OK);
		}
		else {
			throw new ProductNotFoundException("Product Not found for given id ::"+id);
		}
		}
}
