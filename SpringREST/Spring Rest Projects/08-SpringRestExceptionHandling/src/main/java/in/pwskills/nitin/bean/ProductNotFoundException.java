package in.pwskills.nitin.bean;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductNotFoundException( String msg){
		
		super(msg);
	}
}
