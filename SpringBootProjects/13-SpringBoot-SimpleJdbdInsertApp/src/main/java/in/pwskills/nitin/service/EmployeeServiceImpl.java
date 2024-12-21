package in.pwskills.nitin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.bean.EmployeeBO;
import in.pwskills.nitin.bean.EmployeeDTO;
import in.pwskills.nitin.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public int insertrecord(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.insertrecord(bo)
				;
	}

	
}
