package moc.employee.dao;

import java.util.List;

public interface EmployeeDao extends AbstractDao<EmployeeModel> {

	public List<EmployeeModel> list();

}