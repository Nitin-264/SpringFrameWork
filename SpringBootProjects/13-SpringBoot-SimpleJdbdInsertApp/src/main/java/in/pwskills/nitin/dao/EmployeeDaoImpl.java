package in.pwskills.nitin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.bean.EmployeeBO;

@Repository("repository")
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private SimpleJdbcInsert sji;
	@Override
	public int insertrecord(EmployeeBO bo) {
		// TODO Auto-generated method stub
		sji.setTableName("employees");
		
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(bo);
		return sji.execute(source);
	}

	
    
}
