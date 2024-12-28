package in.pwskills.nitin;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//Creating the server and container environment
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)

//mocking the annotations(@RequestBody,@ResponseBody) needed  during Testing
@AutoConfigureMockMvc

//Loading the data from properties file(src/main/resources)
@TestPropertySource("classpath:application.properties")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationTests {

	@Autowired
	public MockMvc mockMvc;
	
	
	@Test
	@DisplayName("Student created")
	@Order(1)
	public void testcreatStudent() throws Exception {
		
		String body = "{\"stdName\" :\"Dhoni\",\"stdGen\"  : \"Male\",\"stdCourse\": \"H2DBMS\",\"stdAddr\"  : \"CSK\"}";
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]	
	    MockHttpServletRequestBuilder request =	MockMvcRequestBuilders.post("http://localhost:9999/v1/api/student/create").
		                                         contentType(MediaType.APPLICATION_JSON).content(body);
		 // 2. Send the request and get the response
		MvcResult result=  mockMvc.perform(request).andReturn();  
	    
	    // 3. Retrieve the data from request object to peform testing
	   MockHttpServletResponse response = result.getResponse();
	 
	    // 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		boolean isTrue = response.getContentAsString().contains("saved");
		if (!isTrue) {
			fail("Student not created");
		}
		                                         
	}
	
	@Test
	@DisplayName("Getting Student object")
	@Order(2)
	public void testgetStudent() throws Exception {
		String URL = "http://localhost:9999/v1/api/student/find/{id}";
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]	
	    MockHttpServletRequestBuilder request =	MockMvcRequestBuilders.get(URL,1);
		 // 2. Send the request and get the response
		MvcResult result=  mockMvc.perform(request).andReturn();  
	    
	    // 3. Retrieve the data from request object to peform testing
	   MockHttpServletResponse response = result.getResponse();
	 
	    // 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		String output = response.getContentAsString();
		System.out.println(output);
		assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
		
		                                         
	}
	
	@Test
	@DisplayName("Getting All Student object")
	@Order(3)
	public void testgetAllStudent() throws Exception {
		String URL = "http://localhost:9999/v1/api/student/all";
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]	
	    MockHttpServletRequestBuilder request =	MockMvcRequestBuilders.get(URL);
		 // 2. Send the request and get the response
		MvcResult result=  mockMvc.perform(request).andReturn();  
	    
	    // 3. Retrieve the data from request object to peform testing
	   MockHttpServletResponse response = result.getResponse();
	 
	    // 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		String output = response.getContentAsString();
		System.out.println(output);
		assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
		                                         
	}
	
	@Test
	@DisplayName("Deleting Student object")
	@Order(5)
	public void testDeleteStudent() throws Exception {
		String URL = "http://localhost:9999/v1/api/student/remove/{id}";
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]	
	    MockHttpServletRequestBuilder request =	MockMvcRequestBuilders.get(URL,1);
		 // 2. Send the request and get the response
		MvcResult result=  mockMvc.perform(request).andReturn();  
	    
	    // 3. Retrieve the data from request object to peform testing
	   MockHttpServletResponse response = result.getResponse();
	 
	    // 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		boolean isTrue = response.getContentAsString().contains("removed");
		if (!isTrue) {
			fail("Student Not removed");
		}                                      
	}

	@Test
	@DisplayName("Updating Student object")
	@Order(4)
	public void testUpdateStudent() throws Exception {
		String URL = "http://localhost:9999/v1/api/student/modify";
		
		String body ="{\"stdId\":\"1\",\"stdName\" :\"Dhoni\",\"stdGen\"  : \"Male\",\"stdCourse\": \"H2DBMS\",\"stdAddr\"  : \"CSK\"}";
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]	
	    MockHttpServletRequestBuilder request =	MockMvcRequestBuilders.put(URL).
	    		                                contentType(MediaType.APPLICATION_JSON).content(body);
		 // 2. Send the request and get the response
		MvcResult result=  mockMvc.perform(request).andReturn();  
	    
	    // 3. Retrieve the data from request object to peform testing
	   MockHttpServletResponse response = result.getResponse();
	 
	    // 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		String output = response.getContentAsString();
		System.out.println(output);
		                                         
	}
}
