package backendtest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Item;
import backend.Store;

public class StoreTest {

	@Test
	public void testStoreStringStringStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddtoSale() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
	}

	@Test
	public void testAddItem() {
		Store store = new Store();
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		store.addItem(t);
		assertTrue(store.items.contains(t));

	}

	@Test
	public void testRemoveItem() {
		Store store = new Store();
		Item t = new Item(84, "name", "category", 100, 10, "description");
		store.addItem(t);
		store.removeItem(84);
		assertTrue(!store.items.contains(t));
	}

	@Test
	public void testGetName() {
		Store store = new Store("M", "9", "11", "A");
		store.setName("N");
		assertEquals(store.getName(), "N");
		
	}

	@Test
	public void testSetName() {
		Store store = new Store("M", "9", "11", "A");
		store.setName("N");
		assertEquals(store.getName(), "N");
	}

	@Test
	public void testGetOpeningHours() {
		Store store = new Store("M", "9", "11", "A");
		assertEquals(store.getOpeningHours(), "9");
	}

	@Test
	public void testSetOpeningHours() {

		Store store = new Store("M", "9", "11", "A");
		store.setOpeningHours("10");
		assertEquals(store.getOpeningHours(), "10");
	}

	@Test
	public void testGetClosingHours() {
		Store store = new Store("M", "9", "11", "A");
		assertEquals(store.getClosingHours(), "11");
	}

	@Test
	public void testSetClosingHours() {
		Store store = new Store("M", "9", "11", "A");
		store.setClosingHours("10");
		assertEquals(store.getClosingHours(), "10");
	}

	@Test
	public void testGetItems() {
		Store store = new Store();
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		store.addItem(t);
		assertTrue(store.getItems().contains(t));
		
	}

	@Test
	public void testSetItems() {
		Store store = new Store("M", "9", "11", "A");
		ArrayList<Item> items = new ArrayList<Item>();
		store.setItems(items);
	}

	@Test
	public void testGetLocation() {
		Store store = new Store("M", "9", "11", "A");
		assertEquals(store.getLocation(), "A");
	}

	@Test
	public void testSetLocation() {
		Store store = new Store("M", "9", "11", "A");
		store.setLocation("Loc");
		assertEquals(store.getLocation(), "Loc");
	}

	@Test
	public void testItemNamesString() {
		Store store = new Store("M", "9", "11", "A");
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		String[] string = new String[3];
		string[0] = "Name: " + t.getName() + " Price: " + t.getPrice() + " Category  " + t.getCategory() + " Description " + t.getDescription() + "  ";
		assertEquals(store.itemlisttoString(store.getItems()), string[0]);
		
	}
	
	@Test
	public void itemSearchbyName() {
		Store store = new Store("M", "9", "11", "A");
		Item t = new Item(994, "name", "category", 100, 10, "description");
		String[] string = new String[3];
		string[0] = "Name: " + t.getName() + " Price: " + t.getPrice() + " Category  " + t.getCategory() + " Description " + t.getDescription() + "  ";
		assertEquals(store.itemlisttoString(store.getItems())[store.items.size()-1], string[0]);
	}
	
	@Test
	public void ItembyName() {
		Store s = new Store();
		s.itemlistName("A");
		
	}
	
	@Test
	public void itemSearchbyCategory() {
		Store store = new Store("M", "9", "11", "A");
		Item t = new Item(994, "name", "category", 100, 10, "description");
		store.addItem(t);
		String[] string = new String[3];
		string[0] = "Name: " + t.getName() + " Price: " + t.getPrice() + " Category  " + t.getCategory() + " Description " + t.getDescription() + "  ";
		assertEquals(Store.itemlistCategory("category").get(Store.itemlistCategory("category").size()-1), t);
	}

	@Test
	public void testItemIdInteger() {
		Store s = new Store();
		s.itemIdInteger();
		assertTrue((int)s.itemIdInteger()[0]== 1);
	}

	@Test
	public void testGetItem() {
		Store s = new Store();
		Item t = new Item(98, "name", "category", 100, 10, "description");
		s.addItem(t);
		s.getItem(98);
		assertEquals(t, s.getItem(98));
		}

}
