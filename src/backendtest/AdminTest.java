package backendtest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Admin;
import backend.Manager;
import backend.Store;
import junit.framework.Assert;

public class AdminTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before 
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStores() {
		
		Admin admin = new Admin();
		Store s = new Store("Test Store", "9", "5", "Test package");
		Admin.stores.add(s);
		assertEquals(Admin.stores.get(Admin.stores.size()-1).getName(), s.getName());
	}

	@Test 
	public void testSetStores() {
		Admin admin = new Admin();
		admin.setStores(new ArrayList<Store>());
		assertEquals(Admin.stores.size() , 0);
		
		
		
	}

	@Test
	public void testAdmin() { 
		Admin admin = new Admin();
		int i = Admin.stores.size();
		int j = admin.stores.size();
		assertEquals(i, j);
		
		
	}

	@Test
	public void testToStringStoreNames() {
		
		Admin admin = new Admin();
		//get last name
		String store = Admin.stores.get(Admin.stores.size() - 1).getName();
		String[] s= admin.toStringStoreNames();
		String string = s[s.length-1];
		assertEquals(string, store);
		
	}

	@Test 
	public void testAddStore() {
		Admin admin = new Admin();
		Store s = new Store("Test Store", "9", "5", "Test package");
		Admin.stores.add(s);
		assertEquals(Admin.stores.get(Admin.stores.size()-1).getName(), s.getName());
	}

	@Test
	public void testRemoveStore() {
		Admin admin = new Admin();
		int i = Admin.stores.size();
		Store s = new Store("Test Store", "9", "5", "Test package");
		Admin.stores.remove(Admin.stores.size()-1);
		assertEquals(i -1, Admin.stores.size());
	}

	@Test
	public void testAddManager() {
		
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		Admin admin = new Admin();
		admin.addManager(manager);
		String s = Admin.managers.get(Admin.managers.size()-1).getName();
		assertEquals("Test Manager", s);
		
		
	}

	@Test
	public void testRemoveManager() {
		int i = Admin.managers.size();
		Admin admin = new Admin();
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		admin.removeManager(99949);
		
		assertTrue(!Admin.managers.contains(manager));
	}

	@Test
	public void testStoreAdded() {
		Admin admin = new Admin();
		Store s = new Store("Test Store", "9", "5", "Test package");
		Admin.stores.add(s);
		assertTrue(Admin.stores.contains(s));
		
	}

	@Test
	public void testGetManager() {
		Manager manager = new Manager(99949, "Test Manager", "Test Email", "Test Password", "Test location", Admin.stores.get(0));
		Admin.managers.add(manager);
		String s = Admin.managers.get(Admin.managers.size()-1).getEmail();
		Admin admin = new Admin();
		Manager result = admin.getManager("Test Email");
		assertEquals(result, manager);
		 
		
	}

	@Test
	public void testGetStore() {
		Store store = new Store("M", "9", "11", "A"); 
		Admin.stores.add(store);
		String s = Admin.stores.get(Admin.managers.size()-1).getName();
		Admin a = new Admin();
		Store result = a.getStore("M");
		assertEquals(result, store);
	}

	@Test
	public void testChangeHours() {
		Store store = new Store("M", "9", "11", "A"); 
		store.setOpeningHours("1");
		store.setClosingHours("2");	
		assertEquals(store.getOpeningHours(), "1");
		assertEquals(store.getClosingHours(), "2");
		
	}
	@Test
	public void testSetChangeHours() {
		Store store = new Store("M", "9", "11", "A"); 
		Admin.stores.add(store);
		Admin admin = new Admin();
		admin.changeHours("M", "5", "6");
		assertEquals(store.getClosingHours(), "6");
		assertEquals(store.getOpeningHours(), "5");
		
		
	}
	
	public void testAddStoreStoreArgument() {
		Store store = new Store("M", "9", "11", "A"); 
		Admin admin = new Admin();
		admin.addStore(store);
		
		assertTrue(admin.stores.contains(store));
		
	}
	
	public void testRemoveStoreStoreArgument() {
		Store store = new Store("M", "9", "11", "A"); 
		Admin.stores.add(store);
		Admin admin = new Admin();
		admin.removeStore("M");
		assertTrue(!admin.stores.contains(store));
	}
	
	
	
	

}