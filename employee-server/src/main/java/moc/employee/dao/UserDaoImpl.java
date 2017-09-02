package moc.employee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<UserModel> implements UserDao {

	public UserDaoImpl() {
		super(UserModel.class);
	}

	@Override
	public UserModel authenticate(String username, String password) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		List<UserModel> models = criteria.list();
		if (models != null && !models.isEmpty()) {
			return models.get(0);
		}
		return null;
	}

}