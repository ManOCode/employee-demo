package moc.employee.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moc.employee.dao.SessionDao;
import moc.employee.dao.SessionModel;
import moc.employee.dao.UserDao;
import moc.employee.dao.UserModel;
import moc.employee.util.ModelUtils;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	UserDao userDao;

	@Autowired
	SessionDao sessionDao;

	@Override
	public String login(String username, String password) {
		UserModel userModel = userDao.authenticate(username, password);
		if (ModelUtils.noValue(userModel)) {
			return null;
		}
		String token = null;
		do {
			token = generateRandomString();
		} while (sessionDao.inStore(token));
		SessionModel sessionModel = new SessionModel();
		sessionModel.setUser(userModel);
		sessionModel.setToken(token);
		Date startDate = new Date();
		sessionModel.setSessionStart(startDate);
		sessionModel.setSessionActive(startDate);
		sessionDao.create(sessionModel);
		sessionDao.store(sessionModel);
		return token;

	}

	public static String generateRandomString() {
		StringBuffer buffer = new StringBuffer();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int charactersLength = characters.length();
		for (int i = 0; i < 32; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}

	@Override
	public boolean hasAccess(String token) {
		if (token == null) {
			return false;
		}
		return true;
	}

}