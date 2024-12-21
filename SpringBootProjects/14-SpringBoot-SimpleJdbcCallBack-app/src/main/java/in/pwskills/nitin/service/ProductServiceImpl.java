package in.pwskills.nitin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import in.pwskills.nitin.bean.ProductBo;
import in.pwskills.nitin.bean.ProductDto;
import in.pwskills.nitin.dao.IProductdao;

public class ProductServiceImpl implements IProductService {

	@Autowired
	public IProductdao dao;
	@Override
	public List<ProductDto> getProductsByName(String prod1, String prod2) {
		// TODO Auto-generated method stub
		List<ProductBo> listBo = dao.getProductsByName(prod1, prod2);

		ArrayList<ProductDto> listDto = new ArrayList<>();

		listBo.forEach(bo -> {
			ProductDto dto = new ProductDto();
			BeanUtils.copyProperties(bo, dto);
			listDto.add(dto);
		});

		return listDto;
		
	}

	
}
