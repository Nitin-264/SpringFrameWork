package in.pwskills.nitin;

import in.pwskills.nitin.bean.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee emp1 = new Employee();
		emp1.setEid(45);
		emp1.setEname("Rohit");
		emp1.setEaddress("MI");
		emp1.setEsalary(500000.0f);
		
		System.out.println(emp1);
		
		Employee emp2 = new Employee(18, "Virat", "RCB", 40000.0f);
		System.out.println(emp2);
		
		Employee emp3 = new Employee(7, "Dhoni", "CSK");
		System.out.println(emp3);
	}

}
