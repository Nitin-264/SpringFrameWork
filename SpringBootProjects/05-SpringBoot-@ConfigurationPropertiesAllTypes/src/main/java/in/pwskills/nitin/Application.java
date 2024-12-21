package in.pwskills.nitin;



import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import in.pwskills.nitin.beans.Company;
import in.pwskills.nitin.beans.Employee;



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
		
       Employee emp = context.getBean(Employee.class);
       System.out.println(emp);

       DataSource datasource = context.getBean(DataSource.class);
       System.out.println(datasource.getClass().getName());
       
		
		((ConfigurableApplicationContext) context).close();
		System.out.println("*********Clsoing the container**********");
		
	}

}
