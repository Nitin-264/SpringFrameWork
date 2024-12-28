package in.pwskills.nitin.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import in.pwskills.nitin.repositry.Repositry;

public class Service {

	private Repositry repo;
	
	//Constructor injection
	public Service(Repositry repo) {
		this.repo =repo;
	}
	
	//Business logic
	public List<String> getDataByLen(){
		try {
			return repo.getData().
					stream().
					filter(d->d.length() <=5).
					collect(Collectors.toList());
		} catch (SQLException e) {
			// TODO: handle exception
			return Arrays.asList();
		}
	}
}
