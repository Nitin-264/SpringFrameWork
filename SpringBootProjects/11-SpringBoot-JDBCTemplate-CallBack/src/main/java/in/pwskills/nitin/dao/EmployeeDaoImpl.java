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
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.bean.EmployeeBO;

@Repository("repository")
public class EmployeeDaoImpl implements IEmployeeDao {

    private static final String GET_EMP_BY_NO = "select * from employees where eno = ?";
    private static final String GET_EMP_BY_DESG = "select * from employees where ejob in (?,?) order by ejob";
    private static final String GET_EMP = "select * from employees";

    @Autowired
    private JdbcTemplate template;

    @Override
    public EmployeeBO fetchemployeeByNo(Integer no) {
        return template.queryForObject(GET_EMP_BY_NO, new RowMapper<EmployeeBO>() {
            @Override
            public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
                EmployeeBO bo = new EmployeeBO();
                bo.setEmpNo(rs.getInt(1));
                bo.setEname(rs.getString(2));
                bo.setJob(rs.getString(3));
                bo.setSalary(rs.getFloat(4));
                bo.setDeptNo(rs.getInt(5));
                bo.setMgrNo(rs.getInt(6));

                System.out.println("Data given by database::" + bo);
                return bo;
            }
        }, no);
    }

    @Override
    public List<EmployeeBO> fetchemployeeByDesg(String cond1, String cond2) {
        return template.query(GET_EMP_BY_DESG, new ResultSetExtractor<List<EmployeeBO>>() {
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
        }, cond1, cond2);
    }

    @Override
    public List<EmployeeBO> fetchallemployee() {
        ArrayList<EmployeeBO> lbo = new ArrayList<>();

        template.query(GET_EMP, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println("EmployeeDaoImpl.fetchallemployee().new RowCallbackHandler() {...}.processRow()");
                EmployeeBO bo = new EmployeeBO();
                bo.setEmpNo(rs.getInt(1));
                bo.setEname(rs.getString(2));
                bo.setJob(rs.getString(3));
                bo.setSalary(rs.getFloat(4));
                bo.setDeptNo(rs.getInt(5));
                bo.setMgrNo(rs.getInt(6));

                lbo.add(bo);
            }
        });

        return lbo;
    }
}
