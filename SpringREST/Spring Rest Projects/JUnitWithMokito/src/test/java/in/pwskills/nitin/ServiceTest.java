package in.pwskills.nitin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import in.pwskills.nitin.repositry.Repositry;
import in.pwskills.nitin.service.Service;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@Mock
	Repositry repo;
	
	@InjectMocks
	Service service;
	
	@Test
	public void getDataByLenTest() {
		//Give mocking implementation when the code is not ready
		try {
			when(repo.getData()).
			thenReturn(Arrays.asList("sachin","Rohit","virat","yuvi","dhoni"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//Test your code
		int expectedlenght =4;
        List<String> actual = service.getDataByLen();
		
		//checking the comparison is made on the actual object
		assertNotNull(actual);
		int actuallenght = service.getDataByLen().size();
		
		assertEquals(expectedlenght, actuallenght);
	}
	
	@Test
	public void getDataThrowException() {
		
		try {
			when(repo.getData()).thenThrow(new SQLException("SQLEXCEPTION OCCRED"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		List<String> actual =  service.getDataByLen();
		//assertNotNull(actual);
		assertEquals(0,actual.size());

	}
	
}
