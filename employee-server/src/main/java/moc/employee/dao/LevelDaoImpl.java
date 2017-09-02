package moc.employee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class LevelDaoImpl extends AbstractDaoImpl<LevelModel> implements LevelDao {

	public LevelDaoImpl() {
		super(LevelModel.class);
	}

	@Override
	public List<LevelModel> list() {
		Criteria criteria = createCriteria();
		return criteria.list();
	}

}