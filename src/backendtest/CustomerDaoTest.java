package backendtest;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.Customer;
import dao.CustomerDao;

public class CustomerDaoTest {

	@Test
	public void testValidate() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		boolean flag = CustomerDao.validate("email", "password");
		assertTrue(flag);
	}

	@Test
	public void testLogin() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		CustomerDao.login("email", "password");
		assertTrue(c.isLoggedIn);
	}

	@Test
	public void testLogout() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		CustomerDao.logout("email", "password");
		assertTrue(!c.isLoggedIn);
	}

}
