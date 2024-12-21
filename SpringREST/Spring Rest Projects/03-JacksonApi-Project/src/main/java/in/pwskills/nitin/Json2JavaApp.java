package in.pwskills.nitin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import in.pwskils.nitin.bean.Account;
import in.pwskils.nitin.bean.Order;
import in.pwskils.nitin.bean.Person;

public class Json2JavaApp {

	public static void main(String[] args) throws Exception {
		
		// Use JACKSONAPI and convert java object to JSON
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		Person person = mapper.readValue(new File("src/main/resources/person.json"), Person.class);
		System.out.println(person);
	}
}
