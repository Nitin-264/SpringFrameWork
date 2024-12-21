package in.pwskills.nitin.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

	static {
		System.out.println("Student.class file is loading...");
	}

	public Student() {
		System.out.println("Student Object is created...");
	}
	
	@Autowired
	@Qualifier("courseName")
	private ICourseMaterial course;
	
	//Business logic 
	public void Prepratation(String examName) {
		System.out.println("***Preparation Started ****");
		
		String content = course.CourseContent();
		Double price = course.price();
		
		System.out.println("prepration is on going using"+content+" material with"+price+"price");
		System.out.println("Preparation completed for  " + examName);
	}
}
