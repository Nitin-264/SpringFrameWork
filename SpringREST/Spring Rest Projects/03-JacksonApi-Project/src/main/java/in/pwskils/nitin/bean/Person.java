package in.pwskils.nitin.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import in.pwskills.nitin.Deserialize.CustomdateDateDeserialize;
import in.pwskills.nitin.serialize.CustomDateSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("person")
@JsonPropertyOrder(value= {"list" ,"account"})
public class Person {

	@JsonProperty("first_name")
	private String firstname;
	private String lastname;
	
	@JsonIgnore
	private String emailid;
	
	@JsonSerialize(using= CustomDateSerialize.class)
	@JsonDeserialize(using = CustomdateDateDeserialize.class)
	private Date date;
	
	private List<Order> list;
	
	private Account account;
}
