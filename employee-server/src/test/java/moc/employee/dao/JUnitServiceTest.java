package moc.employee.dao;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import moc.employee.resource.EmployeeDTO;
import moc.employee.resource.LevelDTO;
import moc.employee.service.ManagerService;
import moc.employee.service.SessionService;

@Component
public class JUnitServiceTest {

	@Autowired
	SessionService sessionService;

	@Autowired
	ManagerService managerService;

	public void sessionServiceTest() {
		String token = sessionService.login(JUnitDaoTest.USERNAME, JUnitDaoTest.PASSWORD);
		Assert.assertNotNull(token);
		Assert.assertTrue(sessionService.hasAccess(token));
	}

	public void managerServiceTest() {
		/*
		 * Employee list test
		 */
		List<EmployeeDTO> employeeList = managerService.employeeList();
		Assert.assertNotNull(employeeList);
		Assert.assertEquals(JUnitDaoTest.EMPLOYEE_COUNT, employeeList.size());
		/*
		 * Level list test
		 */
		List<LevelDTO> levelList = managerService.levelList();
		Assert.assertNotNull(levelList);
		Assert.assertEquals(JUnitDaoTest.LEVEL_COUNT, levelList.size());
		/*
		 * Employee create test
		 */
		EmployeeDTO employee = new EmployeeDTO();
		employee.setName("JuniorName3");
		employee.setSurname("JuniorSurname3");
		employee.setLevel("Junior");
		employee.setDateOfBirth("1991/06/03");
		employee = managerService.employeeCreate(employee);
		Assert.assertNotNull(employee);
		Assert.assertNotNull(employee.getId());
		Assert.assertNotNull(employee.getAge());
		Assert.assertNotEquals("", employee.getAge());
		Assert.assertEquals("26", employee.getAge());
		List<EmployeeDTO> employeeList2 = managerService.employeeList();
		Assert.assertNotNull(employeeList2);
		Assert.assertEquals(JUnitDaoTest.EMPLOYEE_COUNT + 1, employeeList2.size());
		/*
		 * Employee find test
		 */
		EmployeeDTO employee1 = new EmployeeDTO();
		employee1.setId(employee.getId());
		employee1 = managerService.employeeFind(employee1);
		Assert.assertNotNull(employee1);
		Assert.assertNotNull(employee1.getId());
		Assert.assertEquals(employee.getId(), employee1.getId());
		Assert.assertNotNull(employee1.getName());
		Assert.assertEquals("JuniorName3", employee1.getName());
		Assert.assertNotNull(employee1.getSurname());
		Assert.assertEquals("JuniorSurname3", employee1.getSurname());
		Assert.assertNotNull(employee1.getLevel());
		Assert.assertEquals("Junior", employee1.getLevel());
		Assert.assertNotNull(employee1.getDateOfBirth());
		Assert.assertEquals("1991/06/03", employee1.getDateOfBirth());
		Assert.assertNotNull(employee1.getAge());
		Assert.assertEquals("26", employee1.getAge());
		/*
		 * Employee update test
		 */
		employee1.setName("SeniorName2");
		employee1.setSurname("SeniorSurname2");
		employee1.setLevel("Senior");
		employee1.setDateOfBirth("1990/06/03");
		employee1 = managerService.employeeUpdate(employee1);
		Assert.assertNotNull(employee1);
		Assert.assertNotNull(employee1.getId());
		Assert.assertEquals(employee.getId(), employee1.getId());
		Assert.assertNotNull(employee1.getName());
		Assert.assertEquals("SeniorName2", employee1.getName());
		Assert.assertNotNull(employee1.getSurname());
		Assert.assertEquals("SeniorSurname2", employee1.getSurname());
		Assert.assertNotNull(employee1.getLevel());
		Assert.assertEquals("Senior", employee1.getLevel());
		Assert.assertNotNull(employee1.getDateOfBirth());
		Assert.assertEquals("1990/06/03", employee1.getDateOfBirth());
		Assert.assertNotNull(employee1.getAge());
		Assert.assertEquals("27", employee1.getAge());
		/*
		 * Employee delete test
		 */
		EmployeeDTO employee2 = new EmployeeDTO();
		employee2.setId(employee1.getId());
		employee2 = managerService.employeeDelete(employee2);
		Assert.assertNotNull(employee2);
		Assert.assertNull(employee2.getId());
		Assert.assertNotNull(employee2.getName());
		Assert.assertEquals("SeniorName2", employee2.getName());
		Assert.assertNotNull(employee2.getSurname());
		Assert.assertEquals("SeniorSurname2", employee2.getSurname());
		Assert.assertNotNull(employee2.getLevel());
		Assert.assertEquals("Senior", employee2.getLevel());
		Assert.assertNotNull(employee2.getDateOfBirth());
		Assert.assertEquals("1990/06/03", employee2.getDateOfBirth());
		Assert.assertNotNull(employee2.getAge());
		Assert.assertEquals("27", employee2.getAge());
		List<EmployeeDTO> employeeList3 = managerService.employeeList();
		Assert.assertNotNull(employeeList3);
		Assert.assertEquals(JUnitDaoTest.EMPLOYEE_COUNT, employeeList3.size());
	}

}