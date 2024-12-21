package in.pwskills.nitin.beans;

import org.springframework.stereotype.Component;

@Component("dotNet")
public class DotNetCourseMaterial implements ICourseMaterial {

	static {
		System.out.println("DotNetCourseMaterial.class file is loading...");
	}
	
	@Override
	public String CourseContent() {
		// TODO Auto-generated method stub
		return "C#Ooops 2.C#Excpetionhandling 3.C#Collections...";
	}

	@Override
	public Double price() {
		// TODO Auto-generated method stub
		return 2000.0;
	}

}
