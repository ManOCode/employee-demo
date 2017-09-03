package moc.employee.dao;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import moc.employee.resource.AuthDTO;
import moc.employee.resource.AuthResource;
import moc.employee.resource.EmployeeDTO;
import moc.employee.resource.EmployeeResource;
import moc.employee.resource.LevelDTO;
import moc.employee.resource.LevelResource;

@Component
public class JUnitResourceTest {

	public static final String INCORRECT_TOKEN = "incorrect";

	@Autowired
	AuthResource authResource;

	@Autowired
	LevelResource levelResource;

	@Autowired
	EmployeeResource employeeResource;

	private String token;

	public void authResourceTest() {
		/*
		 * Authentication incorrect password check
		 */
		AuthDTO authDTO = new AuthDTO();
		authDTO.setUsername(JUnitDaoTest.USERNAME);
		authDTO.setPassword(INCORRECT_TOKEN);
		JAXBElement<AuthDTO> element = new JAXBElement(new QName("authentication"), AuthDTO.class, authDTO);
		Response response1 = authResource.authorise(element);
		Assert.assertNotNull(response1);
		Assert.assertEquals(401, response1.getStatus());
		/*
		 * Authentication correct password check
		 */
		authDTO.setPassword(JUnitDaoTest.PASSWORD);
		JAXBElement<AuthDTO> element2 = new JAXBElement(new QName("authentication"), AuthDTO.class, authDTO);
		Response response2 = authResource.authorise(element);
		Assert.assertNotNull(response2);
		Assert.assertEquals(200, response2.getStatus());
		Assert.assertNotNull(response2.getEntity());
		authDTO = (AuthDTO) response2.getEntity();
		Assert.assertNull(authDTO.getUsername());
		Assert.assertNull(authDTO.getPassword());
		Assert.assertNotNull(authDTO.getAccessToken());
		token = authDTO.getAccessToken();
	}

	public void levelResourceTest() {
		Response response1 = levelResource.levelList(INCORRECT_TOKEN);
		Assert.assertNotNull(response1);
		Assert.assertEquals(401, response1.getStatus());
		Response response2 = levelResource.levelList(token);
		Assert.assertNotNull(response2);
		Assert.assertEquals(200, response2.getStatus());
		Assert.assertNotNull(response2.getEntity());
		List<LevelDTO> levelDTOs = (List<LevelDTO>) response2.getEntity();
		Assert.assertEquals(JUnitDaoTest.LEVEL_COUNT, levelDTOs.size());
	}

	public void employeeResourceTest() {
		/*
		 * Employee list test
		 */
		Response response1 = employeeResource.employeeList(INCORRECT_TOKEN);
		Assert.assertNotNull(response1);
		Assert.assertEquals(401, response1.getStatus());
		Response response2 = employeeResource.employeeList(token);
		Assert.assertNotNull(response2);
		Assert.assertEquals(200, response2.getStatus());
		Assert.assertNotNull(response2.getEntity());
		List<EmployeeDTO> employeeDTOs = (List<EmployeeDTO>) response2.getEntity();
		Assert.assertEquals(JUnitDaoTest.EMPLOYEE_COUNT, employeeDTOs.size());
		/*
		 * Employee create test (incorrect token)
		 */
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName("JuniorName3");
		employeeDTO.setSurname("JuniorSurname3");
		employeeDTO.setLevel("Junior");
		employeeDTO.setDateOfBirth("1991/06/03");
		employeeDTO.setAge("10");
		JAXBElement<EmployeeDTO> element1 = new JAXBElement(new QName("employee"), EmployeeDTO.class, employeeDTO);
		Response response3 = employeeResource.employeeCreate(INCORRECT_TOKEN, element1);
		Assert.assertNotNull(response3);
		Assert.assertEquals(401, response3.getStatus());
		/*
		 * Employee create test (incorrect age)
		 */
		Response response4 = employeeResource.employeeCreate(token, element1);
		Assert.assertNotNull(response4);
		Assert.assertEquals(400, response4.getStatus());
		/*
		 * Employee create test (correct token and age)
		 */
		employeeDTO.setAge("26");
		JAXBElement<EmployeeDTO> element2 = new JAXBElement(new QName("employee"), EmployeeDTO.class, employeeDTO);
		Response response5 = employeeResource.employeeCreate(token, element2);
		Assert.assertNotNull(response5);
		Assert.assertEquals(200, response5.getStatus());
		Assert.assertNotNull(response5.getEntity());
		EmployeeDTO employee = (EmployeeDTO) response5.getEntity();
		Assert.assertNotNull(employee.getId());
		Assert.assertNotNull(employee.getAge());
		/*
		 * Employee create list count test
		 */
		Response response6 = employeeResource.employeeList(token);
		Assert.assertNotNull(response6);
		Assert.assertEquals(200, response6.getStatus());
		Assert.assertNotNull(response6.getEntity());
		List<EmployeeDTO> employeeDTOs2 = (List<EmployeeDTO>) response6.getEntity();
		Assert.assertEquals(JUnitDaoTest.EMPLOYEE_COUNT + 1, employeeDTOs2.size());
		/*
		 * Employee read test
		 */
		Response response7 = employeeResource.employeeRead(INCORRECT_TOKEN, employee.getId());
		Assert.assertNotNull(response7);
		Assert.assertEquals(401, response7.getStatus());
		Response response8 = employeeResource.employeeRead(token, employee.getId());
		Assert.assertNotNull(response8);
		Assert.assertEquals(200, response8.getStatus());
		Assert.assertNotNull(response8.getEntity());
		EmployeeDTO employee2 = (EmployeeDTO) response8.getEntity();
		Assert.assertNotNull(employee2.getId());
		Assert.assertNotNull(employee2.getAge());
		/*
		 * Employee update test
		 */
		employee.setName("SeniorName2");
		employee.setSurname("SeniorSurname2");
		employee.setLevel("Senior");
		JAXBElement<EmployeeDTO> element3 = new JAXBElement(new QName("employee"), EmployeeDTO.class, employee);
		Response response9 = employeeResource.employeeUpdate(INCORRECT_TOKEN, element3);
		Assert.assertNotNull(response9);
		Assert.assertEquals(401, response9.getStatus());
		Response response10 = employeeResource.employeeUpdate(token, element3);
		Assert.assertNotNull(response10);
		Assert.assertEquals(200, response10.getStatus());
		EmployeeDTO employeeUpdated = (EmployeeDTO) response10.getEntity();
		Assert.assertEquals("SeniorName2", employeeUpdated.getName());
		Assert.assertEquals("SeniorSurname2", employeeUpdated.getSurname());
		Assert.assertEquals("Senior", employeeUpdated.getLevel());
		/*
		 * Employee delete test
		 */
		Response response11 = employeeResource.employeeDelete(INCORRECT_TOKEN, element3);
		Assert.assertNotNull(response11);
		Assert.assertEquals(401, response11.getStatus());
		Response response12 = employeeResource.employeeDelete(token, element3);
		Assert.assertNotNull(response12);
		Assert.assertEquals(200, response12.getStatus());
		EmployeeDTO employeeDeleted = (EmployeeDTO) response12.getEntity();
		Assert.assertNull(employeeDeleted.getId());
		/*
		 * Employee delete list count test
		 */
		Response response13 = employeeResource.employeeList(token);
		Assert.assertNotNull(response13);
		Assert.assertEquals(200, response13.getStatus());
		Assert.assertNotNull(response13.getEntity());
		List<EmployeeDTO> employeeDTOs3 = (List<EmployeeDTO>) response13.getEntity();
		Assert.assertEquals(JUnitDaoTest.EMPLOYEE_COUNT, employeeDTOs3.size());
	}

}