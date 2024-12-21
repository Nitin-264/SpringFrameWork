package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.dao.IEmployeePagindSortingdao;

//@Component
public class EmployeeSortingRunner implements CommandLineRunner {

	@Autowired
	private IEmployeePagindSortingdao repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// select * from employee order by esal asc;
		//repo.findAll(Sort.by("empSal")).forEach(System.out::println);
		
		// select * from employee order by esal desc;
		//repo.findAll(Sort.by(Direction.DESC, "empSal")).forEach(System.out::println);
		
		//select * from employee order by esal asc,edept asc;
		//repo.findAll(Sort.by("empSal", "empDept")).forEach(System.out::println);
		
		//select * from employee order by esal des,edept des;
		//repo.findAll(Sort.by(Direction.DESC,"empSal", "empDept")).forEach(System.out::println);
		
		//select * from employee order by esal asc,edept desc;
        repo.findAll(Sort.by(org.springframework.data.domain.Sort.Order.asc("empSal")
        		,org.springframework.data.domain.Sort.Order.desc("empDept"))).forEach(System.out::println);;
	}

}
