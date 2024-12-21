package in.pwskills.nitin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.StringValueExp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.beans.EmployeeVO;
import in.pwskills.nitin.service.IEmployeeService;

@Component("controller")
public class Controller {

	@Autowired
	private IEmployeeService service;
	
	public List<EmployeeVO> showempbyDesg(String desg[]) throws Exception{
		
		List<EmployeeVO> lvo = new ArrayList<EmployeeVO>();
		List<EmployeeDTO> ldto = service.fetchempbydesg(desg);
		
		ldto.forEach(dto->{
			EmployeeVO vo = new EmployeeVO();
			
			// copy such properties whose datatypes and fieldnames should be  same
			BeanUtils.copyProperties(dto, vo);
			
			// setting the properties whose datatypes are not same
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setEmpNo(String.valueOf(dto.getEmpName()));
			vo.setMgrNo(String.valueOf(dto.getMgrNo()));
			vo.setSalary(String.valueOf(dto.getSalary()));
			vo.setSrNo(String.valueOf(dto.getSrNo()));
			
			//add vo object to list
			lvo.add(vo);
			
		});
		
		return lvo;
	}
}
