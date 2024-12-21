package in.pwskills.nitin.bean;

public class ProductDto {

	private Integer pid;
	private String pname;
	private Integer quantity;
	private Float price;
	public Integer getPid() {
		return pid;
	}
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductBo [pid=" + pid + ", pname=" + pname + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
