package in.pwskils.nitin;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskils.nitin.bean.Customer;

public class App {
    public static void main(String[] args) {
        
    	try {

        	//use object mapper class
        	ObjectMapper mapper = new ObjectMapper();
        	
        	// read JSON file and put into java object
        	File file  = new File("/01-Basic-Jason-Project/src/Data/sample.json");
        	
        	if(!file.exists()) {
        		System.out.println("file does not exists");
        	}
        	
        	//converting json to java object
			Customer customer = mapper.readValue(file, Customer.class);
			
	    	System.out.println(customer);
	    	
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
    }
}
