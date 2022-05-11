package backendtest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Customer;
import backend.ShoppingList;
import backend.Store;
import backend.Item;

public class ShoppingListTest {



	@Test
	public void testGetCustomer() {
		ShoppingList sl = new ShoppingList();
		Customer c = new Customer(99, "name", "email", "password", "location");
		sl.setCustomer(c);
		assertEquals(sl.getCustomer(), c);
	}

	@Test
	public void testGetStore() {
		Store store = new Store("M", "9", "11", "A");
		ShoppingList sl = new ShoppingList();
		sl.setStore(store);
		assertEquals(store, sl.getStore());
		
	}

	@Test
	public void testGetShopping() {
		ArrayList<Item> items =new ArrayList<Item>();
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		items.add(t);
		ShoppingList sl = new ShoppingList();
		sl.setShopping(items);
		assertEquals(sl.getShopping(), items);
		
		
	}

	@Test
	public void testAddItem() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		ShoppingList sl = new ShoppingList();
		sl.addItem(t);
		assertTrue(sl.getShopping().contains(t));
	}

}
