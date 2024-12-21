package in.pwskills.nitin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Book {

	private Integer bid;
	private String bname;
	private String bauth;
	private Double bcost;
}
