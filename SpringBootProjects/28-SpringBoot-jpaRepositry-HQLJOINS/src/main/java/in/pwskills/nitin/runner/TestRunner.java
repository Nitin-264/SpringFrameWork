package in.pwskills.nitin.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Department;
import in.pwskills.nitin.bean.Employee;
import in.pwskills.nitin.dao.IDepartmentRepo;
import in.pwskills.nitin.dao.IEmployeeRepo;



@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeRepo erepo;
	
	@Autowired
	private IDepartmentRepo drepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Department d1 = new Department(1054, "DEV", "AJAY");
		Department d2 = new Department(1055, "QA", "SAM");
		Department d3 = new Department(1056, "BA", "KUMAR");
		drepo.save(d1);
		drepo.save(d2);
		drepo.save(d3);

		Employee e1 = new Employee(10, "SAM", 500.0, d1);
		Employee e2 = new Employee(11, "RAM", 600.0, d2);
		Employee e3 = new Employee(12, "SYED", 700.0, d1);
		Employee e4 = new Employee(13, "AJAY", 700.0, null);

		erepo.save(e1);
		erepo.save(e2);
		erepo.save(e3);
		erepo.save(e4);

		List<Object[]> objs = erepo.getEnameDeptNames();
		for (Object[] obj : objs) {
			System.out.println(obj[0] + "....." + obj[1]);
		}

		System.out.println("******************");
		objs = erepo.getAllEnamesAndDeptNamesIfExist();
		for (Object[] obj : objs) {
			System.out.println(obj[0] + "....." + obj[1]);
		}

		System.out.println("******************");
		objs = erepo.getAllDeptsAndEnamesIfExist();
		for (Object[] obj : objs) {
			System.out.println(obj[0] + "....." + obj[1]);
		}
		
		System.out.println("******************");
		objs = erepo.getAllEnamesAndDeptNamesIsNull();
		for (Object[] obj : objs) {
			System.out.println(obj[0] + "....." + obj[1]);
		}
		
		System.out.println("******************");
		objs = erepo.getDeptNamesAndEmployeeIsNull();
		for (Object[] obj : objs) {
			System.out.println(obj[0] + "....." + obj[1]);
		}
		
		System.out.println("******************");
		objs = erepo.getEmployeesOfParticularDepartment("DEV");
		for (Object[] obj : objs) {
			System.out.println(obj[0] + "....." + obj[1]);
		}
	}

	
	
}