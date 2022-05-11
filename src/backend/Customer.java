package backend;

import java.util.ArrayList;
import java.util.Random;

import dao.CustomerDao;
import dao.ManagerDao;

public class Customer {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Item> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ArrayList<Item> shoppingList) {
		this.shoppingList = shoppingList;
	}
	int id;
	String name;
	String email;
	String password;
	String location;
	String preferredStore;
	
	public String getPreferredStore() {
		return preferredStore;
	}

	public void setPreferredStore(String preferredStore) {
		this.preferredStore = preferredStore;
	}
	ArrayList<Item> shoppingList;
	public boolean isLoggedIn;
	
	public Customer(int id, String name, String email, String password, String location) {
		this.id = id;
		this.name= name;
		this.email = email;
		this.password = password;
		this.location= location;
		this.preferredStore = "No Store Selected yet";
		this.shoppingList = new ArrayList<Item>();
		
	}
	
	public int signUp() { 
		int id = this.getId();
		String name = this.getName();
		String email  = this.getEmail();
		String password = this.getPassword();
		String location = this.getLocation(); 
		
		int i = CustomerDao.save(id, name, password, email, location);
		Admin.customers.add(this);
		return i;
	}
	
	public void addtoCart(Item t) {
		this.shoppingList.add(t);
		
		if(t.getQuantity()> 0) {
			t.setQuantity(t.getQuantity() - 1);
		}
		else {
			t.setQuantity(0);
		}
		
				
	} 
	
	//CART TO STRING
	public String[] shoppinglisttoString() {

		String[] result = new String[this.shoppingList.size()];
		ArrayList<String> resultArray = new ArrayList<String>();
		
		for (Item t : this.getShoppingList()) {
	
			String s = "Name: " + t.getName() + " Price: " + t.getPrice() + " Category  " + t.getCategory() + " Description " + t.getDescription() + "  ";
			resultArray.add(s);
		}
		
		for(int i =0; i < resultArray.size(); i++) {
			result[i] = resultArray.get(i);
		}
		
		return result;
	}
	 
	
 
	
}
