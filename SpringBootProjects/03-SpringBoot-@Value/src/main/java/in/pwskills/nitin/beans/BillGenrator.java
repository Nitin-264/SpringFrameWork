package in.pwskills.nitin.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
public class BillGenrator {

	@Value("#{info.idlyprice+ info.dosaprice+ info.vadaprice}")
	private float billAmount;
	@Value("Paradise")
	private String hotelName;
	
	@Autowired
	private Itemsinfo items;
	
	@Override
	public String toString() {
		return "BillGenerator [billAmount=" + billAmount + ", hotelName=" + hotelName + ", items=" + items + "]";
	}
}
