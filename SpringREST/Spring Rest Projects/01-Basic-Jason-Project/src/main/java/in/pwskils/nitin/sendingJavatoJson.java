package in.pwskils.nitin;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskils.nitin.bean.Student;

public class sendingJavatoJson {

	public static void main(String[] args) {
	try {
		
	//Object Mapper class
	ObjectMapper mapper = new ObjectMapper();
	
	//Create a student object
	Student student = new Student(10,"sachin",51);


	String jsonStudent = mapper.writeValueAsString(student);
	System.out.println(jsonStudent);
	
	mapper.writeValue(new File("student.json"), student);
	System.out.println("json data created");
	}
	catch(IOException io) {
		io.printStackTrace();
	}
	
}
}