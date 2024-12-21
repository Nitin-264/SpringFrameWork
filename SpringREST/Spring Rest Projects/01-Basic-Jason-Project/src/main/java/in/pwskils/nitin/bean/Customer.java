package in.pwskils.nitin.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private Integer id;
	private String firstName;
	private String lastName;
	
	//HAS-A relationship
	private Address address;
	
	@JsonIgnore
	private Boolean active;
	
	private List<String> friendsName;
}
