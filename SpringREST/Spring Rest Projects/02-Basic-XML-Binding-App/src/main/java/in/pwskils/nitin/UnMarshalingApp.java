package in.pwskils.nitin;

import java.io.File;

import in.pwskils.nitin.bean.Person;
import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class UnMarshalingApp {

	public static void main(String[] args) {
		
		//Read XML data and convert to object 
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			
			Unmarshaller unmarshaller=  context.createUnmarshaller();
			
			Person person = (Person) unmarshaller.unmarshal(new File("src/main/resources/person.xml"));
			System.out.println(person);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
