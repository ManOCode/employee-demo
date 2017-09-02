package moc.employee.service;

import java.util.List;

import moc.employee.resource.EmployeeDTO;
import moc.employee.resource.LevelDTO;

public interface ManagerService {

	public List<EmployeeDTO> employeeList();

	public List<LevelDTO> levelList();

	public EmployeeDTO employeeCreate(EmployeeDTO dto);

	public EmployeeDTO employee(EmployeeDTO dto);

	public EmployeeDTO employeeUpdate(EmployeeDTO dto);

	public EmployeeDTO employeeDelete(EmployeeDTO dto);
}