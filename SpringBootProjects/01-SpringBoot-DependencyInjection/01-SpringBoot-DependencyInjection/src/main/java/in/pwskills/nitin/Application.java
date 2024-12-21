package in.pwskills.nitin;

import java.io.PrintStream;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import in.pwskills.nitin.beans.WishMessageGenrator;

@SpringBootApplication
public class Application {

	static {
		System.out.println("Application.class file loading...");
	}
	
	public Application() {
		System.out.println("Application object got created...");
	}
	
	@Bean
	public LocalDateTime ldtObj() {
		System.out.println("Bean created with name :: ldt -> Application.ldtObj()");
		return LocalDateTime.now();
	}
	public static void main(String[] args) {
		//Starting the container
		System.out.println("**********Starting the container***********");
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		WishMessageGenrator wsg = context.getBean(WishMessageGenrator.class);
		String status =wsg.getMsg("Nitin");
		
		System.out.println(status);
		
		((ConfigurableApplicationContext) context).close();
		System.out.println("*********Clsoing the container**********");
		
	}

}
