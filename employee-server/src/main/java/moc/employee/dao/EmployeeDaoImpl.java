package moc.employee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractDaoImpl<EmployeeModel> implements EmployeeDao {

	@Override
	public List<EmployeeModel> list() {
		return null;
	}

}