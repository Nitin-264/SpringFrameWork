package in.pwskills.nitin.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NonNull
	private Integer eid;
	@NonNull
	private String ename;
	@NonNull
	private String eaddress;
	
	private Float esalary;

}
