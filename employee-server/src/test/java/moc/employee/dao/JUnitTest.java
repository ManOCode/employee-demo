package moc.employee.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JUnitTest {

	AnnotationConfigApplicationContext context = null;
	JUnitDaoTest daoTest = null;
	JUnitServiceTest serviceTest = null;
	JUnitResourceTest resourceTest = null;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(JUnitSpringApplication.class);
		daoTest = context.getBean(JUnitDaoTest.class);
		serviceTest = context.getBean(JUnitServiceTest.class);
		resourceTest = context.getBean(JUnitResourceTest.class);
	}

	@Test
	public void test() {
		/*
		 * Dao Tests
		 */
		daoTest.populateData();
		daoTest.levelDaoTest();
		daoTest.employeeDaoTest();
		daoTest.userDaoTest();
		daoTest.sessionDaoTest();
		/*
		 * Service Tests
		 */
		serviceTest.sessionServiceTest();
		serviceTest.managerServiceTest();
		/*
		 * Resource Tests
		 */
		resourceTest.authResourceTest();
		resourceTest.levelResourceTest();
		resourceTest.employeeResourceTest();
	}

	@After
	public void dispose() {

	}
}