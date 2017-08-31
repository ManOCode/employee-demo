package moc.employee.dao;

public interface UserDao extends AbstractDao<UserModel> {

	public UserModel authenticate(String username, String password);
}