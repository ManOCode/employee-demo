package moc.employee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractDaoImpl<EmployeeModel> implements EmployeeDao {

	public EmployeeDaoImpl() {
		super(EmployeeModel.class);
	}

	@Override
	public List<EmployeeModel> list() {
		Criteria criteria = createCriteria();
		return criteria.list();
	}

}