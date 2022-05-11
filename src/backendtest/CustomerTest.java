package backendtest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Admin;
import backend.Customer;
import backend.Item;

public class CustomerTest {

	@Test
	public void testGetId() {

		Customer c = new Customer(99, "name", "email", "password", "location");
		assertEquals(c.getId(), 99);
	}

	@Test
	public void testSetId() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.setId(909);
		assertEquals(c.getId(), 909);
	}

	@Test
	public void testGetName() {
		Customer c = new Customer(99, "name", "email", "password", "location");

		assertEquals(c.getName(), "name");
	}

	@Test
	public void testSetName() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.setName("newName");
		assertEquals(c.getName(), "newName");
	}

	@Test
	public void testGetEmail() {
		Customer c = new Customer(99, "name", "email", "password", "location");

		assertEquals(c.getEmail(), "email");
	}

	@Test
	public void testSetEmail() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.setEmail("emailNew");
		assertEquals(c.getEmail(), "emailNew");
	}

	@Test
	public void testGetPassword() {
		Customer c = new Customer(99, "name", "email", "password", "location");

		assertEquals(c.getPassword(), "password");
	}

	@Test
	public void testSetPassword() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.setPassword("passNew");
		assertEquals(c.getPassword(), "passNew");
	}
	public void testSetPreferredStore() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.getPreferredStore();
		
		assertTrue(c.getPreferredStore().equals("Store"));
	}

	@Test
	public void testGetLocation() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		

		assertEquals(c.getLocation(), "location");
	}

	@Test
	public void testSetLocation() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.setLocation("locNew");
		assertEquals(c.getLocation(), "locNew");
	}

	@Test
	public void testGetShoppingList() {
		
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.getShoppingList().add(t);
		assertTrue(c.getShoppingList().contains(t));
		
	}

	@Test
	public void testSetShoppingList() {
		ArrayList<Item> result = new ArrayList<Item>();
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		result.add(t);
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.setShoppingList(result);
		assertTrue(c.getShoppingList().equals(result));
		
	}
	
	@Test
	public void testGetStringShoppingList() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.getShoppingList().add(t);
		String[] result = new String[2];
		result[0] = "Name: " + t.getName() + " Price: " + t.getPrice() + " Category  " + t.getCategory() + " Description " + t.getDescription() + "  ";
		assertEquals(c.shoppinglisttoString()[0], result[0]);
	}

	@Test
	public void testSignUp() {
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.signUp();
		assertTrue(Admin.customers.contains(c));
	}

	@Test
	public void testAddtoCart() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		Customer c = new Customer(99, "name", "email", "password", "location");
		c.addtoCart(t);
		assertTrue(c.getShoppingList().contains(t));
	}

}