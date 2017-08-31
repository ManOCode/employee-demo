package moc.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moc.employee.dao.EmployeeDao;
import moc.employee.dao.EmployeeModel;
import moc.employee.resource.EmployeeDTO;
import moc.employee.util.DateUtils;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<EmployeeDTO> employeeList() {
		List<EmployeeModel> modelList = employeeDao.list();
		List<EmployeeDTO> dtoList = new ArrayList<EmployeeDTO>();
		for (EmployeeModel model : modelList) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setId(Long.toString(model.getId()));
			dto.setName(model.getName());
			dto.setSurname(model.getSurname());
			dto.setLevel(model.getLevel().getDescription());
			dto.setDateOfBirth(DateUtils.stringFormat(model.getDateOfBirth()));
			dto.setAge(String.valueOf(DateUtils.dateYears(model.getDateOfBirth())));
			dtoList.add(dto);
		}
		return dtoList;
	}

}