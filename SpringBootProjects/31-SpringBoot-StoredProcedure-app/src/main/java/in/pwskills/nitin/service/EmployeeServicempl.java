package in.pwskills.nitin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class EmployeeServicempl implements IEmployeeService {

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Employee> searchEmpsByDesgs(String desg1, String desg2) {
		
		// TODO Auto-generated method stub
		
		//logic to call stored procedure
		System.out.println(manager.getClass().getName());
		//Creating an object to call storedprocedure
		StoredProcedureQuery query =  manager.createStoredProcedureQuery("GET_EMPDETAILS_BY_DESGS", Employee.class);
		
		//Registering the type of IN parameter
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		
		//Set the parameter value
		query.setParameter(1, desg1);
		query.setParameter(2, desg2);
		
		//run storedprocedure and get the result
		
		@SuppressWarnings("unchecked")
		List<Employee> list = query.getResultList();
		
		return list;
	}

}
