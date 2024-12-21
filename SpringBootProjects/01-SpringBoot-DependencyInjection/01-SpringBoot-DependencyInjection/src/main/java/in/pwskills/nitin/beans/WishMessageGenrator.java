package in.pwskills.nitin.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishMessageGenrator {

	static {
		System.out.println("WishMessageGenrator.class file loading...()");
	}
	
	public WishMessageGenrator() {
		System.out.println("WishMessageGenrator object get created...");
	}
	
	@Autowired
	private LocalDateTime ldt;
	
	//Business logic
	public String getMsg(String user) {
		
		int hour = ldt.getHour();
		String msg ="";
		if (hour<12) {
			msg= "Good Morning ::"+user;
		}
		else if(hour<16) {
			msg="Good AfterNoon::"+user;
		}
		else if(hour<20) {
			msg="Good Evening::"+user;
		}
		else {
			msg="Good Night::"+user;
		}
		
		return msg;
	}
	
}
