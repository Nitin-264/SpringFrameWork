package in.pwskils.nitin.bean;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import in.pwskills.nitin.serialize.CustomBalanceSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	private String accountNumber;
	private String bankName;
	
	@JsonSerialize(using = CustomBalanceSerialize.class)
	private BigDecimal balance;	
}
