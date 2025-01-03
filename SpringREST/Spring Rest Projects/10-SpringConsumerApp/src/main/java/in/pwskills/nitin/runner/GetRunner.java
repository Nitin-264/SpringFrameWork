package in.pwskills.nitin.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.pwskills.nitin.entity.Book;

@Component
public class GetRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		final String URL1 = "http://localhost:9999/v1/api/Book/showA";
		final String URL2 = "http://localhost:9999/v1/api/Book/showB/{id}/{name}";

		// Creation of rest template class
		RestTemplate template =  new RestTemplate();
		
		//CASE1: send the request to the URL :: getForEntity(URL,ResponseType)
		ResponseEntity<String> response1 = template.getForEntity(URL1, String.class);
		ResponseEntity<String> response2 = template.getForEntity(URL2, String.class,10,"Microservices");
		
		// Reading the response details from the object
				System.out.println(response1.getBody());
				System.out.println(response1.getHeaders());
				System.out.println(response1.getStatusCode().value());

				System.out.println("**********************************************");

				// Reading the response details from the object
				System.out.println(response2.getBody());
				System.out.println(response2.getHeaders());
				System.out.println(response2.getStatusCode().value());
				
				System.out.println("****************************************************");
				
				
				//case2 : send the request to the URL :: getForEntity(URL,ResponseType,Object...)
				final String URL3 = "http://localhost:9999/v1/api/Book/showC/{id}";
				ResponseEntity<Book> response3 = template.getForEntity(URL3, Book.class,25);
				// Reading the response details from the object
				System.out.println(response3.getBody());
				System.out.println(response3.getHeaders());
				System.out.println(response3.getStatusCode().value());
				
				System.out.println("****************************************************");
				
				// CASE3: 	request for PostMethod :: postForEntity(URL,HttpEntity,returnType)
				final String URL4 = "http://localhost:9999/v1/api/Book/showD";
				// 1. setting content type in headers
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				
				// 2. Creating a entity object (body + headers)
				String body = "{\r\n" + "    \"bid\": 23,\r\n" + "    \"bname\": \"SBMS\",\r\n"
							+ "    \"bauth\": \"GaganDeep\",\r\n" + "    \"bcost\": 5000.0\r\n" + "}";

				HttpEntity<String> entity = new HttpEntity<>(body, headers);
				
				ResponseEntity<String> response4 = template.postForEntity(URL4,entity,String.class);
				// Reading the response details from the object
				System.out.println(response4.getBody());
				System.out.println(response4.getHeaders());
				System.out.println(response4.getStatusCode().value());
				
				System.out.println("****************************************************");
				
				//Case4: Sending PUT request using exchange(,,,,)
				final String URL5 = "http://localhost:9999/v1/api/Book/showE";
				
				HttpHeaders headers2 = new HttpHeaders();
				headers2.setContentType(MediaType.APPLICATION_JSON);
				
				String jsonbody = "{\r\n"
						+ "    \"bid\": 25,\r\n"
						+ "    \"bname\": \"SBMS\",\r\n"
						+ "    \"bauth\": \"GaganDeep\",\r\n"
						+ "    \"bcost\": 5000.0\r\n"
						+ "}";
				
				HttpEntity<String> entity2 = new HttpEntity<>(jsonbody,headers2);
				
				ResponseEntity<String> response5 = template.exchange(URL5, HttpMethod.PUT, entity2, String.class);
				// Reading the response details from the object
				System.out.println(response5.getBody());
				System.out.println(response5.getHeaders());
				System.out.println(response5.getStatusCode().value());
				
				System.out.println("****************************************************");
				
				//Case5 : Sending DELETE request using exchange(,,,,,,)
				final String URL6 = "http://localhost:9999/v1/api/Book/showF/{id}";
				
				ResponseEntity<String> response6 = template.exchange(URL6, HttpMethod.DELETE, null,String.class,10);
				// Reading the response details from the object
				System.out.println(response6.getBody());
				System.out.println(response6.getHeaders());
				System.out.println(response6.getStatusCode().value());
				
	}

}
