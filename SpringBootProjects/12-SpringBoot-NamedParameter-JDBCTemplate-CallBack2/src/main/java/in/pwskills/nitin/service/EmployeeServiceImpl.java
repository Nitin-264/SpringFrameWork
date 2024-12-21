package in.pwskills.nitin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.bean.EmployeeBO;
import in.pwskills.nitin.bean.EmployeeDTO;
import in.pwskills.nitin.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public String fetchemployeeByNo(Integer no) {
		
	  return dao.fetchemployeeByNo(no);
		
	}

	@Override
	public List<EmployeeDTO> fetchemployeeByDesg(String cond1, String cond2) {
		// TODO Auto-generated method stub
		List<EmployeeDTO> ldto = new ArrayList<EmployeeDTO>();
		List<EmployeeBO> lbo = dao.fetchemployeeByDesg(cond1, cond2);
		lbo.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			ldto.add(dto);
		});
		return ldto;
	}

	@Override
	public int insertemp(EmployeeDTO dto) {
		// TODO Auto-generated method stub

		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.insertemp(bo);
	}

	

}
