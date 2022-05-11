package backendtest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.Item;

public class ItemTest {

	@Test
	public void testIsSaleItem() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.setSaleItem(true);
		assertTrue(t.isSaleItem());
	}

	@Test
	public void testGetDescription() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		assertEquals(t.getDescription(), "description");
	}

	@Test
	public void testSetDescription() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.setDescription("new desc");
		assertEquals(t.getDescription(), "new desc");
	}

	@Test
	public void testGetId() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.setId(444);
		assertEquals(t.getId(), 444);
	}

	@Test
	public void testSetId() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.setId(444);
		assertEquals(t.getId(), 444);

	}

	@Test
	public void testGetName() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		assertEquals(t.getName(), "name");
	}

	@Test
	public void testSetName() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.setName("new name");
		assertEquals(t.getName(), "new name");
	}

	@Test
	public void testGetCategory() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		assertEquals(t.getCategory(), "category");
	}

	@Test
	public void testSetCategory() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.setCategory("new cat");
		assertEquals(t.getCategory(), "new cat");
	}

	@Test
	public void testGetPrice() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		assertEquals(t.getPrice(), 100);
	}

	@Test
	public void testSetPrice() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.setPrice(55);
		assertEquals(t.getPrice(), 55);
	}

	@Test
	public void testGetQuantity() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		int q = t.getQuantity();
		assertEquals(q, 10);
	}

	@Test
	public void testSetQuantity() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.setQuantity(900);
		assertEquals(t.getQuantity(), 900);
	}

	@Test
	public void testUpdateItem() {
		Item t = new Item(9984, "name", "category", 100, 10, "description");
		t.UpdateItem("New name", "new category", 0, 0, "new desription");
		
	}

}
