package in.pwskills.nitin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.pwskills.nitin.bean.Employee;



@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	/***
	 * 1. METHOD TYPE :: GET
	 * 2. INPUT       :: Model
	 * 3. PATH        :: /user
	 * 4. R.T         :: UserData
	 * 
	 */
	@GetMapping(value = "/user")
	public String saveFormData(Model model) {
		System.out.println("Adding attributes");
		model.addAttribute("user","Nitin");
		model.addAttribute("addr", "bengaluru");

		System.out.println("Attribute added");
		return "UserData";
	}
	

	/***
	 * 1. METHOD TYPE :: GET
	 * 2. INPUT       :: Model
	 * 3. PATH        :: /list
	 * 4. R.T         :: EmployeeData
	 * 
	 */
	@GetMapping("/list")
	public String showEmployeedetails(Model model) {
		
		model.addAttribute("employee",new Employee(45, "Rohit", 35000.0));
		model.addAttribute("list",List.of(new Employee(10,"sachin",3500.0),
						new Employee(7,"dhoni",2800.0),
						new Employee(18,"kohli",3000.0))
				);
		
		return "EmployeeData";
	}
}
