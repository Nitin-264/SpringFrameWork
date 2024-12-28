package in.pwskills.nitin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorResponse {

	private String date;
	private String msg;
	private String status;
	
}