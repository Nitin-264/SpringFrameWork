package in.pwskills.nitin.beans;

import org.springframework.stereotype.Component;

@Component("Java")
public class JavaCousermaterial implements ICourseMaterial{

	static {
		System.out.println("JavaCourseMaterial.class file is loading...");
	}

	public JavaCousermaterial() {
		System.out.println("JavaCourseMaterial Object is created...");
	}
	
	
	@Override
	public String CourseContent() {
		// TODO Auto-generated method stub
		return "1. OOPS 2.EXCEPTIONHANDLING 3.COLLECTION";
	}

	@Override
	public Double price() {
		// TODO Auto-generated method stub
		return 4000.0;
	}

}
