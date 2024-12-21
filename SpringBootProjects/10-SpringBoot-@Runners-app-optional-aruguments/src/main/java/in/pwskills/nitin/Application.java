package in.pwskills.nitin;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {

	
	
	public static void main(String[] args) {
		//Starting the container
		System.out.println("**********Starting the container***********");
		 SpringApplication.run(Application.class, args);
		System.out.println("*********Clsoing the container**********");
		
	}

}
