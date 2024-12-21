package in.pwskills.nitin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.beans.EmployeeBO;
import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public List<EmployeeDTO> fetchempbydesg(String[] desg) throws Exception {
		// TODO Auto-generated method stub
		
		StringBuilder builder = new StringBuilder("(");;
		for (int i = 0; i < desg.length; i++) {
			//// append based on the index we are processing
			if (i==desg.length-1) {
				// last index we are processing
				builder.append("'"+desg[i]+"')");
			}
			else {
				// still data is there to be processed
				builder.append("'"+desg[i]+"',");
			}
		}
		//Converting string builder to string
		String cond = builder.toString();
		System.out.println("Condition to be sent is :: " + cond);
		
		List<EmployeeDTO> ldto = new ArrayList<EmployeeDTO>();
		List<EmployeeBO> lbo = dao.fetchempbydesg(cond);
		
		lbo.forEach(bo->{
			
			EmployeeDTO dto = new EmployeeDTO();
			// copy from bo to dto
			// [datatype and fieldname same]
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(ldto.size()+1);
			
			//add dto object to list 
			ldto.add(dto);
			});
		
		return ldto;
	}

}
