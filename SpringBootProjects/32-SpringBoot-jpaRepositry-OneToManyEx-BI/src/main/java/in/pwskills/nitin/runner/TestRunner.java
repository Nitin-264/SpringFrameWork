package in.pwskills.nitin.runner;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.MobileNumber;
import in.pwskills.nitin.bean.Person;
import in.pwskills.nitin.dao.IMobileNumberRepo;
import in.pwskills.nitin.dao.IPersonRepo;


@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IPersonRepo prepo;

	@Autowired
	private IMobileNumberRepo mrepo;

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		int id = 10;

		// child objs
		MobileNumber ph1 = new MobileNumber(100L, 9999999L, "airtel", "office");
		MobileNumber ph2 = new MobileNumber(101L, 8888888L, "vodafone", "residence");

		// parent obj
		Person person1 = new Person(id, "rajesh", "hyd");
		
		//parent to child 
		ph1.setPerson(person1);
		ph2.setPerson(person1);
		
		Set<MobileNumber> set = Set.of(ph1, ph2);
		
		//child to parent
		person1.setMobile(set);
		
		//saving parent object
		prepo.save(person1);
		
		
		// Creating a child object
				MobileNumber ph3 = new MobileNumber(102L, 76576757L, "jio", "office");
				MobileNumber ph4 = new MobileNumber(103L, 66576155L, "vodafone", "office");

				// parent obj
				Person per = new Person(11, "karan", "hyd");

				// add parent to childs
				ph3.setPerson(per);
				ph4.setPerson(per);

				// childs to parent
				per.setMobile(Set.of(ph3, ph4));

				// saving using child objects
				mrepo.save(ph3);
				mrepo.save(ph4);
				
				//retrieved from parent
				Optional<Person> optional = prepo.findById(id);
				if (optional.isPresent()) {
					Person person = optional.get();
					System.out.println(person);
					
					//load all child objects
					Set<MobileNumber> mobile = person.getMobile();
					mobile.forEach(System.out::println);
				} else {
					System.out.println("Record not found for the id :: " + id);
				}
				
				
				//retrieved from child
				mrepo.findAll().forEach(mobile->{
					System.out.println(mobile);
					Person person = mobile.getPerson();
					System.out.println(person);
				});
			
}
}