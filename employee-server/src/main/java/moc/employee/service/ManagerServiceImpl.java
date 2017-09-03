package moc.employee.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import moc.employee.dao.EmployeeDao;
import moc.employee.dao.EmployeeModel;
import moc.employee.dao.LevelDao;
import moc.employee.dao.LevelModel;
import moc.employee.resource.EmployeeDTO;
import moc.employee.resource.LevelDTO;
import moc.employee.util.DateUtils;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	LevelDao levelDao;

	@Override
	public List<EmployeeDTO> employeeList() {
		List<EmployeeModel> modelList = employeeDao.list();
		List<EmployeeDTO> dtoList = new ArrayList<EmployeeDTO>();
		for (EmployeeModel model : modelList) {
			dtoList.add(employeeConvert(model));
		}
		return dtoList;
	}

	@Override
	public List<LevelDTO> levelList() {
		List<LevelModel> modelList = levelDao.list();
		List<LevelDTO> dtoList = new ArrayList<LevelDTO>();
		for (LevelModel model : modelList) {
			LevelDTO dto = new LevelDTO();
			dto.setId(Long.toString(model.getId()));
			dto.setDescription(model.getDescription());
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public EmployeeDTO employeeCreate(EmployeeDTO dto) {
		EmployeeModel model = new EmployeeModel();
		model = employeeMerge(model, dto);
		employeeDao.create(model);
		return employeeConvert(model);
	}

	@Override
	public EmployeeDTO employeeFind(EmployeeDTO dto) {
		EmployeeModel model = employeeRetrieve(dto);
		return employeeConvert(model);
	}

	@Override
	public EmployeeDTO employeeUpdate(EmployeeDTO dto) {
		EmployeeModel model = employeeRetrieve(dto);
		model = employeeMerge(model, dto);
		employeeDao.update(model);
		return employeeConvert(model);
	}

	@Override
	public EmployeeDTO employeeDelete(EmployeeDTO dto) {
		EmployeeModel model = employeeRetrieve(dto);
		dto = employeeConvert(model);
		dto.setId(null);
		employeeDao.delete(model);		
		return dto;
	}

	private EmployeeDTO employeeConvert(EmployeeModel model) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(Long.toString(model.getId()));
		dto.setName(model.getName());
		dto.setSurname(model.getSurname());
		dto.setLevel(model.getLevel().getDescription());
		dto.setDateOfBirth(DateUtils.stringFormat(model.getDateOfBirth()));
		dto.setAge(String.valueOf(DateUtils.dateYears(model.getDateOfBirth())));
		return dto;
	}

	private EmployeeModel employeeMerge(EmployeeModel model, EmployeeDTO dto) {
		model.setName(dto.getName());
		model.setSurname(dto.getSurname());
		List<LevelModel> levelList = levelDao.list();
		for (LevelModel level : levelList) {
			if (dto.getLevel().equals(Long.toString(level.getId())) || dto.getLevel().equals(level.getDescription())) {
				model.setLevel(level);
				break;
			}
		}
		Date dateOfBirth = DateUtils.dateFormat(dto.getDateOfBirth());
		model.setDateOfBirth(dateOfBirth);
		return model;
	}

	private EmployeeModel employeeRetrieve(EmployeeDTO dto) {
		Long employeeId = Long.parseLong(dto.getId());
		return employeeDao.findById(employeeId);
	}

}