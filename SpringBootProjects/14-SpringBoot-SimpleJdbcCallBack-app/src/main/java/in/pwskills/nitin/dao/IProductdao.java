package in.pwskills.nitin.dao;

import java.util.List;

import in.pwskills.nitin.bean.ProductBo;

public interface IProductdao {
	public List<ProductBo> getProductsByName(String prod1,String prod2);
}
