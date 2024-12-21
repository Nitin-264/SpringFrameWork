package in.pwskills.nitin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@SpringBootApplication
public class Application {

	@Autowired
	private static SimpleJdbcCall jdbcCall;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		try {
			System.out.println(jdbcCall);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
