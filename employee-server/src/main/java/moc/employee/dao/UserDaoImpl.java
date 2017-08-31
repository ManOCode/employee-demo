package moc.employee.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<UserModel> implements UserDao {

	@Override
	public UserModel authenticate(String username, String password) {
		return null;
	}

}