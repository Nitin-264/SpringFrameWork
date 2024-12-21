package in.pwskills.nitin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelcomeController {

	static {
		System.out.println("WelcomeController.class file loading...");
	}
	
	public WelcomeController() {
		// TODO Auto-generated constructor stub
		System.out.println("WelcomeController object created....");
	}
	/**
	 * 1. REQUEST TYPE :: GET/POST
	 * 2. PATH         :: URL
	 * 3. MODEL   	   :: Sending the data from Controller to View
	 * 4. R.T          :: ViewName(with no technology details)
	 * 
	 */
	//@RequestMapping(value = "/",method = RequestMethod.GET)
	
	//@RequestMapping
	@GetMapping(value = "/")
	public String Welcomemsg(Model modle) {
		
		System.out.println("Implementation class is ::"+modle.getClass().getName());
		
		System.out.println("WelcomeController.Welcomemsg()");
		//ADDING DATA TWO MODEL WHICH IS USED IN VIEW
		modle.addAttribute("BRAND","PWSKILLS");
		System.out.println("Attribute added");
		return "welcomepage";
	}
}
