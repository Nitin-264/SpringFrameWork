package in.pwskills.nitin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.relational.core.sql.Named;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.bean.EmployeeBO;

@Repository("repository")
public class EmployeeDaoImpl implements IEmployeeDao {

    private static final String GET_EMP_BY_NO = "select ename from employees where eno = :eno";
    private static final String GET_EMP_BY_DESG = "select * from employees where ejob in (:desg1,:desg2) order by ejob";
    private static final String INSERT_EMP = "insert into employees('ename','ejob','esalary','eDeptNo','eMngrNo') values(:ename,:ejob,:esalary,:edeptNo,:emgrNo)";

    @Autowired
    private NamedParameterJdbcTemplate  template;

    
    @Override
    public List<EmployeeBO> fetchemployeeByDesg(String cond1, String cond2) {
    	
    	MapSqlParameterSource source = new MapSqlParameterSource();
    	source.addValue("desg1", cond1);
    	source.addValue("desg2", cond2);
    	
        return template.query(GET_EMP_BY_DESG, source, new ResultSetExtractor<List<EmployeeBO>>() {
            @Override
            public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                System.out.println(
                    "EmployeeDaoImpl.fetchemployeeByDesg(...).new ResultSetExtractor() {...}.extractData()");
                ArrayList<EmployeeBO> lbo = new ArrayList<>();
                while (rs.next()) {
                    EmployeeBO bo = new EmployeeBO();
                    bo.setEmpNo(rs.getInt(1));
                    bo.setEname(rs.getString(2));
                    bo.setJob(rs.getString(3));
                    bo.setSalary(rs.getFloat(4));
                    bo.setDeptNo(rs.getInt(5));
                    bo.setMgrNo(rs.getInt(6));

                    lbo.add(bo);
                }
                return lbo;
            }
        });
    }

    

	@Override
	public String fetchemployeeByNo(Integer no) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = Map.of("eno",no);
		
		return template.queryForObject(GET_EMP_BY_NO, map,String.class);
	}



	@Override
	public int insertemp(EmployeeBO bo) {
		// TODO Auto-generated method stub
		
		return template.update(INSERT_EMP, new BeanPropertySqlParameterSource(bo));
	}
}
