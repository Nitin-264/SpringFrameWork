package in.pwskills.nitin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.pwskills.nitin.bean.User;


@Controller
@RequestMapping(value = "/user")
public class UserController {

	static {
		System.out.println("UserController.class file loading...");
	}
	
	public UserController() {
		// TODO Auto-generated constructor stub
		System.out.println("UserController object created....");
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
	@GetMapping(value = "/info")
	public String Usermsg(Model modle) {
		
		System.out.println("Implementation class is ::"+modle.getClass().getName());
		
		System.out.println("UserController.Usermsg()");
		//ADDING DATA TWO MODEL WHICH IS USED IN VIEW
		
		modle.addAttribute("NAME", "Sachin");
		modle.addAttribute("IPLTEAM","MI");
		System.out.println("Attribute added");
		return "UserHome";
	}
	
	/**
	 * 1. METHOD TYPE  :: GET 
	 * 2. PATH         :: /user/obj
	 * 3. ViewName     :: UserData
	 * @param  : Model
	 * @return : String
	 */
	
	@GetMapping("/data")
	//sending from controller to view
	public String showuserobject(Model model) {
		
		User user =new User(45, "Rohit", "CAPTAIN");
		model.addAttribute("obj",user);
		
		List<User> objects = List.of(
				new User(18, "kohli", "batsman"), 
				new User(45,"rohith","batsman"), 
				new User(21,"bumrah","bowler")
			);
		
		model.addAttribute("objlist",objects);
		
		return "UserData";
	}
	
}
