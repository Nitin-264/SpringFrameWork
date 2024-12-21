package in.pwskills.nitin;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import in.pwskills.nitin.beans.Company;



@SpringBootApplication
public class Application {

	static {
		System.out.println("Application.class file loading...");
	}
	
	public Application() {
		System.out.println("Application object got created...");
	}
	
	
	public static void main(String[] args) {
		//Starting the container
		System.out.println("**********Starting the container***********");
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		Company company =context.getBean(Company.class);
		System.out.println(company);
		
		((ConfigurableApplicationContext) context).close();
		System.out.println("*********Clsoing the container**********");
		
	}

}
