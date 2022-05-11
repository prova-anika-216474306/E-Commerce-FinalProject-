package backendtest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.ItemDao;

public class ItemDaoTest {

	@Test
	public void testSave() {
		int i = ItemDao.save(9984, "name", "category", 100, 10, "description");
		int j= ItemDao.save(9984, "name", "category", 100, 10, "description");
		assertEquals(i, 1);
		assertEquals(j, 0);
	}

	@Test
	public void testDelete() {
		int i = ItemDao.delete(984);
		assertEquals(i, 1);
	}

	@Test
	public void testItemNames() {
		fail("Not yet implemented");
	}

	@Test
	public void testItemCategories() {
		ItemDao.itemCategories();
	}


}
