package in.pwskils.nitin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String cityName;
	private String stateName;
	private String countryName;
}
