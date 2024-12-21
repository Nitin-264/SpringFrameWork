package in.pwskils.nitin;

import java.io.File;
import java.io.IOException;

import in.pwskils.nitin.bean.Address;
import in.pwskils.nitin.bean.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


public class MarshalingApp {
    public static void main(String[] args) {
        
    	Person p1 = new Person();
    	p1.setId(45);
        p1.setName("Rohit");
        p1.setGender("Male");
        p1.setEmail("rohitsharma@gmail.com");
        
        Address address = new Address();
        address.setCityName("Charkhi Dadri");
        address.setStateName("Haryana");
        address.setCountryName("India");
        
        p1.setAddress(address);
        
        try {
			JAXBContext context =  JAXBContext.newInstance(Person.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(p1, new File("src/main/resources/person.xml"));
			System.out.println("*********Marshling Complete**********");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
