package in.pwskills.nitin.service;

import java.util.List;

import in.pwskills.nitin.bean.ProductDto;

public interface IProductService {

	public List<ProductDto> getProductsByName(String prod1,String prod2);
}
