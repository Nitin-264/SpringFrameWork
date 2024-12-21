package in.pwskills.nitin;



import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.pwskills.nitin.controller.Controller;




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
		
       //collecting input from user
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the desgination count");
       int count= scanner.nextInt();
       
       String desg[] = null;
       
       if (count>=1) {
    	   //creating an array of that size
    	   desg = new String[count];
    	  } else {
		System.out.println("Invalid input give some +ve number");
	}
       
    // initialize the array with user input['batsman','bowler']
       for (int i = 0; i < count; i++) {
		System.out.println("Enter the desgination::");
		desg[i] = scanner.next();
	}
       
       
       //Asking the container to give Controller Object
       try {
    	   Controller controller = context.getBean(Controller.class);
    	   controller.showempbyDesg(desg).forEach(System.out::println);
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
       
       // closing the resource
       scanner.close();
       
       
		
		((ConfigurableApplicationContext) context).close();
		System.out.println("*********Clsoing the container**********");
		
	}

}
