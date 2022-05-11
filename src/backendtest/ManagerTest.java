package backendtest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Admin;
import backend.Manager;
import backend.Store;

public class ManagerTest {

	@Test
	public void testIsLoggedIn() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.login("Test Email", "Test Password");
		assertEquals(manager.isLoggedIn(), true);
	}

	@Test
	public void testSetLoggedIn() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setLoggedIn(true);
		assertEquals(manager.isLoggedIn(), true);
	}

	@Test
	public void testManagerIntStringStringStringStringStore() {
		fail("Not yet implemented");
	} 

	@Test
	public void testGetID() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		assertEquals(99949, manager.getID());
	}
	@Test
	public void testSetID() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setID(0);
		assertEquals(0, manager.getID());
	}

	@Test
	public void testSetShop() {
		Store store = new Store("M", "9", "11", "A"); 
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setShop(store);
		assertEquals(store, manager.getShop());
	}

	@Test
	public void testGetName() {
		
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		assertEquals(manager.getName(), "Test Manager");
	}

	@Test
	public void testSetName() {
		Store store = new Store("M", "9", "11", "A"); 
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setName("N");
		assertEquals(manager.getName(), "N");
	}

	@Test
	public void testGetLocation() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		assertEquals(manager.getLocation(), "Test location");
	}

	@Test
	public void testSetLocation() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setLocation("N");
		assertEquals(manager.getLocation(), "N");
	}

	@Test
	public void testGetEmail() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		assertEquals(manager.getEmail(), "Test Email");
	}

	@Test
	public void testSetEmail() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setEmail("N");
		assertEquals(manager.getEmail(), "N");
	}

	@Test
	public void testGetPassword() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		assertEquals(manager.getPassword(), "Test Password");
	}

	@Test
	public void testSetPassword() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setPassword("N");
		assertEquals(manager.getPassword(), "N");
	}

	@Test
	public void testGetShop() {
		Store store = new Store("M", "9", "11", "A"); 
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setShop(store);
		assertEquals(manager.getShop(), store);
	}

	@Test
	public void testLogout() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.logout("Test Email", "Test Password");
		assertEquals(manager.isLoggedIn(), false);
	}

	@Test
	public void testLogin() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.login("Test Email", "Test Password");
		assertEquals(manager.isLoggedIn(), true);
	}

	@Test
	public void testChangeHours() {
		Store store = new Store("M", "9", "11", "A"); 
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		manager.setShop(store);
		manager.changeHours("10", "12");
		assertEquals(store.getOpeningHours(), "10");
		assertEquals(store.getClosingHours(), "12");
	}

}
