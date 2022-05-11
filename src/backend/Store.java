package backend;

import java.util.ArrayList;

import dao.AdminDao;
import dao.ItemDao;
import dao.ManagerDao;
import dao.StoreDao;

public class Store {
	String name;
	String openingHours;
	String closingHours;
	String location;
	

	public static ArrayList<Item> items = StoreDao.getAllItems();
	public static ArrayList<Item> sale;

	public Store() {
		StoreDao.getAllItems();
		sale = new ArrayList<Item>();

	} 

	public Store(String name, String opening, String closing, String location) {
		this.name = name;
		this.openingHours = opening;
		this.closingHours = closing;
		this.location = location;
		

		StoreDao.getAllItems();
		sale = new ArrayList<Item>();

	}
	//GET ITEMS IN ARRAY FORM
	public static String[] itemlisttoString(ArrayList<Item> items) {

		String[] result = new String[items.size()];
		ArrayList<String> resultArray = new ArrayList<String>();
		for (Item t : Store.items) {
	
			String s = "Name: " + t.getName() + " Price: " + t.getPrice() + " Category  " + t.getCategory() + " Description " + t.getDescription() + "  ";
			resultArray.add(s);
		}
		
		for(int i =0; i < items.size(); i++) {
			result[i] = resultArray.get(i);
		} 
		
		return result;
	}
	
	
	//ADD ITEM CATEGORY WISE
	public static ArrayList<Item> itemlistCategory(String category) {

		ArrayList<Item> result = new ArrayList<Item>();
		for (Item t : Store.items) {
			
			if (t.quantity > 0 && t.getCategory().equals(category))  {
				result.add(t);
			}
	}	return result;
	}
	
	//ADD ITEM NAME WISE
		public static ArrayList<Item> itemlistName(String name) {

			ArrayList<Item> result = new ArrayList<Item>();
			for (Item t : Store.items) {
				
				if (t.quantity > 0 && t.getName().equals(name))  {
					result.add(t);
				}
		}	return result;
		}
		
	
	
	
	public static Item getItemfromIndex(int i) {
		Item t = Store.items.get(i);
		return t;
		
	}

	public int addtoSale(Item t) {
		t.setSaleItem(true);
		sale.add(t);
		return 1;
	}

	public int addItem(Item t) {
		items.add(t);
		int i = ItemDao.save(t.getId(), t.getName(), t.getCategory(), t.getPrice(), t.getQuantity(),
				t.getDescription());
		return i;

	}

	public int removeItem(int ID) {
		ItemDao.delete(ID);
		for (Item t : items) {
			if (t.getId() == ID) {
				items.remove(t);
				return 1;
			}
		
		} 
		return 1;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getClosingHours() {
		return closingHours;
	}

	public void setClosingHours(String closingHours) {
		this.closingHours = closingHours;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public Integer[] itemIdInteger() {
		Integer[] s = new Integer[items.size()];
		for (int i = 0; i < items.size(); i++) {
			s[i] = items.get(i).getId();
		}
		return s;

	}

//Method to get an item from id
	public Item getItem(int id) {
		for (Item t : items) {
			if (t.getId() == id) {
				return t;
			}
		}

		return items.get(0);
	}
}
