package backendtest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import backend.Store;
import dao.StoreDao;

public class StoreDaoTest {

	@Test
	public void testGetAllItems() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Store store = new Store("M", "9", "11", "A");
		int i = StoreDao.save("M", "9", "11", "A");
		assertEquals(i, 1);
		
	}

	@Test
	public void testDelete() {
		Store store = new Store("M", "9", "11", "A");
		int i = StoreDao.delete("M");
		assertEquals(i, 1);
	}

	@Test
	public void testStores() {
		ArrayList<String> stores = StoreDao.stores();
		assertTrue(stores!= null);
		
	}

	@Test
	public void testGetStoreName() {
		Store store = new Store("M", "9", "11", "A");
		String s=  StoreDao.getStoreName("A");
		assertEquals(s, "M");
	}

	@Test
	public void testStorelocations() {
		ArrayList<String> s = StoreDao.storelocations();
		assertTrue(s!= null);
	}



}
