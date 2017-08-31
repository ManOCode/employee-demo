package moc.employee.dao;

import java.util.Date;

public interface SessionDao extends AbstractDao<SessionModel> {

	public void store(SessionModel model);

	public boolean inStore(String token);

	public void updateStore(String token, Date activeDate);

	public void removeStore(String token);

}