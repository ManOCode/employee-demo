package moc.employee.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import moc.employee.util.DateUtils;

@Component
@Transactional
public class JUnitDaoTest {

	public static final int LEVEL_COUNT = 3;

	public static final int EMPLOYEE_COUNT = 4;

	public static final String USERNAME = "Administrator";

	public static final String PASSWORD = "987654321";

	public static final String TOKEN = "AS6D51SDF6V51SDFTS6D51SDF6V51SDF";

	@Autowired
	LevelDao levelDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	UserDao userDao;

	@Autowired
	SessionDao sessionDao;

	public void populateData() {
		/*
		 * Create Level Data
		 */
		LevelModel level1 = new LevelModel();
		level1.setDescription("Manager");
		levelDao.create(level1);
		LevelModel level2 = new LevelModel();
		level2.setDescription("Senior");
		levelDao.create(level2);
		LevelModel level3 = new LevelModel();
		level3.setDescription("Junior");
		levelDao.create(level3);
		/*
		 * Create Employee Data
		 */
		EmployeeModel employee1 = new EmployeeModel();
		employee1.setLevel(level1);
		employee1.setName("ManagerName1");
		employee1.setSurname("ManagerSurname1");
		employee1.setDateOfBirth(DateUtils.dateFormat("1980/02/14"));
		employeeDao.create(employee1);
		EmployeeModel employee2 = new EmployeeModel();
		employee2.setLevel(level2);
		employee2.setName("SeniorName1");
		employee2.setSurname("SeniorSurname1");
		employee2.setDateOfBirth(DateUtils.dateFormat("1986/01/20"));
		employeeDao.create(employee2);
		EmployeeModel employee3 = new EmployeeModel();
		employee3.setLevel(level3);
		employee3.setName("JuniorName1");
		employee3.setSurname("JuniorSurname1");
		employee3.setDateOfBirth(DateUtils.dateFormat("1989/09/05"));
		employeeDao.create(employee3);
		EmployeeModel employee4 = new EmployeeModel();
		employee4.setLevel(level3);
		employee4.setName("JuniorName2");
		employee4.setSurname("JuniorSurname2");
		employee4.setDateOfBirth(DateUtils.dateFormat("1990/12/25"));
		employeeDao.create(employee4);
		/*
		 * Create User Data
		 */
		UserModel user1 = new UserModel();
		user1.setUsername(USERNAME);
		user1.setPassword(PASSWORD);
		userDao.create(user1);
	}

	public void levelDaoTest() {
		List<LevelModel> levelModels = levelDao.list();
		Assert.assertNotNull(levelModels);
		Assert.assertEquals(LEVEL_COUNT, levelModels.size());
	}

	public void employeeDaoTest() {
		List<EmployeeModel> employeeModels = employeeDao.list();
		Assert.assertNotNull(employeeModels);
		Assert.assertEquals(EMPLOYEE_COUNT, employeeModels.size());
	}

	public void userDaoTest() {
		UserModel userModel = userDao.authenticate(USERNAME, PASSWORD);
		Assert.assertNotNull(userModel);
	}

	public void sessionDaoTest() {
		Date startDate = new Date();
		UserModel userModel = userDao.authenticate(USERNAME, PASSWORD);
		SessionModel sessionModel = new SessionModel();
		sessionModel.setSessionStart(startDate);
		sessionModel.setSessionActive(startDate);
		sessionModel.setUser(userModel);
		sessionModel.setToken(TOKEN);
		sessionDao.create(sessionModel);
		sessionDao.store(sessionModel);
		Assert.assertTrue(sessionDao.inStore(TOKEN));
		sessionDao.updateStore(TOKEN, new Date());
		sessionDao.removeStore(TOKEN);
		Assert.assertFalse(sessionDao.inStore(TOKEN));
	}

}