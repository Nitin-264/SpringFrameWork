package in.pwskills.nitin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import in.pwskills.nitin.bean.ProductBo;

public class ProductdaoImpl implements IProductdao {

	@Autowired
	private SimpleJdbcCall call;
	
	@Override
	public List<ProductBo> getProductsByName(String prod1, String prod2) {
		// TODO Auto-generated method stub
		
		call.setProcedureName("GET_PRODUCT_DETAILS_BY_NAME");
		
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("name1", prod1);
		source.addValue("name2",prod2);
		
		call.returningResultSet("result", new RowMapper<ProductBo>() {

			@Override
			public ProductBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println(rowNum);
				ProductBo bo = new ProductBo();
				bo.setPid(rs.getInt(1));
				bo.setPname(rs.getString(2));
				bo.setPrice(rs.getFloat(3));
				bo.setQuantity(rs.getInt(4));
				return bo;
				
			}
		});
		Map<String, Object> output = call.execute(source);
		@SuppressWarnings("unchecked")
		List<ProductBo> listBo = (List<ProductBo>) output.get("result");
		
		System.out.println("Returning results");
		return listBo;
	}

}
