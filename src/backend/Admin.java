package backend;

import java.util.ArrayList;

import dao.AdminDao;
import dao.ManagerDao;
import dao.StoreDao;

public class Admin {

	public static ArrayList<Store> stores = AdminDao.getAllStore();
	public static ArrayList<Manager> managers = AdminDao.getAllManager();
	public static ArrayList<Customer> customers = AdminDao.getAllCustomers();

	public static ArrayList<Store> getStores() {
		return stores;
	}

	public static void setStores(ArrayList<Store> stores) {
		Admin.stores = stores;
	}

	public Admin() {
		
		
		
		
	}
	public String[] toStringStoreNames() {
		String[] result = new String[stores.size()];
		for(int i =0; i < stores.size(); i++) {
			result[i] = stores.get(i).getName();
		}
		return result;
	}

	public int addStore(Store s) {
		stores.add(s);
		StoreDao.save(s.getName(), s.getOpeningHours(), s.getClosingHours(), s.getLocation());
		return 1;

	}

	public int removeStore(String s) {
		StoreDao.delete(s);
		for (Store store : stores) {
			if (store.getName().equals(s)) {
				stores.remove(store);
				return 1;
			}
			
		}
		return 1;
	}

	public int addManager(Manager m) {
		int i = ManagerDao.save(m.getID(), m.getName(), m.getPassword(), m.getEmail(), m.getLocation(), m.getShop().getName()); 
				managers.add(m);
				
		
		return i;

	}

	public int removeManager(int ID) {
		ManagerDao.delete(ID);
		
		for (Manager m : this.managers) {
			if (m.getID() == ID) {
				managers.remove(m);
				return 1;
			}
		}
		return 1;
	}

	public boolean storeAdded(Store s) {

		if (stores.contains(s)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Manager getManager(String email) {
		
		for(Manager m: managers) {
			if(m.getEmail().equals(email)) {
				return m;
			}
		}
		return new Manager();
		 
	}
	
	//get store from name
	public static Store getStore(String name) {
		Store result = new Store();
		for(Store m: stores) {
			if(m.getName().equals(name)) {
				result = m;
			}
		}
		return result;
		
	}
	
	public void changeHours(String store, String opening, String closing) {
		StoreDao.changehours(store, opening, closing);
		getStore(store).setOpeningHours(opening);
		getStore(store).setClosingHours(closing);
		
		
	}
	 
	
}
