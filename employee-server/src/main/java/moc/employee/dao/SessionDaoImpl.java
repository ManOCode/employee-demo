package moc.employee.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import moc.employee.util.ModelUtils;

@Repository
public class SessionDaoImpl extends AbstractDaoImpl<SessionModel> implements SessionDao {

	private HashMap<String, SessionModel> sessionStore;

	public SessionDaoImpl() {
		super(SessionModel.class);
		sessionStore = new HashMap<String, SessionModel>();
	}

	@Override
	public void store(SessionModel model) {
		sessionStore.put(model.getToken(), model);
	}

	@Override
	public boolean inStore(String token) {
		return sessionStore.get(token) != null;
	}

	@Override
	public void updateStore(String token, Date activeDate) {
		SessionModel sessionModel = sessionStore.get(token);
		if (ModelUtils.hasValue(sessionModel)) {
			sessionModel.setSessionActive(activeDate);
		}
	}

	@Scheduled(fixedDelay = (1000 * 60 * 5))
	public void clearStore() {
		long currentTime = (new Date()).getTime();
		Set<String> tokens = sessionStore.keySet();
		for (String token : tokens) {
			long activeTime = sessionStore.get(token).getSessionActive().getTime();
			activeTime += (1000 * 60 * 5);
			if (activeTime <= currentTime) {
				removeStore(token);
			}
		}
	}

	@Override
	public void removeStore(String token) {
		sessionStore.get(token).setSessionEnd(new Date());
		update(sessionStore.get(token));
		sessionStore.remove(token);
	}

}