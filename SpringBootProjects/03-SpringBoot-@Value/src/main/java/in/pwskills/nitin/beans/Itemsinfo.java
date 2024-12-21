package in.pwskills.nitin.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("info")
@PropertySource("in/pwskills/nitin/cfgs/input.properties")
public class Itemsinfo {

	@Value("${idly.price}")
	public  Float idlyprice;
	@Value("${dosa.price}")
	public Float dosaprice;
	@Value("${vada.price}")
	public Float vadaprice;
	
	@Override
	public String toString() {
		return "Itemsinfo [idlyprice=" + idlyprice + ", dosaprice=" + dosaprice + ", vadaprice=" + vadaprice + "]";
	}
	
	
}
