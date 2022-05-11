package backendtest;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.Admin;
import backend.Manager;
import dao.ManagerDao;

public class ManagerDaoTest {

	@Test
	public void testLogin() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		ManagerDao.login("Test Manager", "Test Manager");
		assertTrue(manager.isLoggedIn = true);
	}

	@Test
	public void testLogout() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		ManagerDao.logout("Test Manager", "Test Manager");
		assertTrue(!manager.isLoggedIn);
	}

}
