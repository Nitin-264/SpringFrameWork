package in.pwskills.nitin.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.beans.EmployeeBO;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String SQL_SELECT_QUERY = "SELECT * FROM employees WHERE ejob IN";
	@Autowired
	private DataSource datasource;
	
	@Override
	public List<EmployeeBO> fetchempbydesg(String cond) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeBO> lbo =null;
		EmployeeBO bo = null;
		
		try(Connection conn = datasource.getConnection()){
			
			//Creating the statement object
			Statement stm = conn.createStatement();
			//Getting result set using execute query
			ResultSet rs = stm.executeQuery(SQL_SELECT_QUERY+cond+"order by ename");
			
		    lbo = new ArrayList<EmployeeBO>();
		    while (rs.next()) {
				bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEmpName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSalary(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgrNo(rs.getInt(6));
				
				lbo.add(bo);
				
			}
	
		}
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return lbo;
	}

}
