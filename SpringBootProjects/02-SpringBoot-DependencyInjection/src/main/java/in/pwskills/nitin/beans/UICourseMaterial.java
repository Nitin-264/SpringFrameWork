package in.pwskills.nitin.beans;

import org.springframework.stereotype.Component;

@Component("UI")
public class UICourseMaterial implements ICourseMaterial {

	static {
		System.out.println("UICourseMaterial.class file is loading...");
	}

	public UICourseMaterial() {
		System.out.println("UICourseMaterial Object is created...");
	}
	
	@Override
	public String CourseContent() {
		// TODO Auto-generated method stub
		return "1.HTML  2.CSS  3.JS";
	}

	@Override
	public Double price() {
		// TODO Auto-generated method stub
		return 3500.0;
	}

}
