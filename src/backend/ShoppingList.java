package backend;

import java.util.ArrayList;

public class ShoppingList {
	
	public ShoppingList(){
		
	}
	Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public ArrayList<Item> getShopping() {
		return shopping;
	}
	public void setShopping(ArrayList<Item> shopping) {
		this.shopping = shopping;
	}
	Store store;
	ArrayList<Item> shopping = new ArrayList<Item>();
	
	public void addItem(Item t) {
		int qnew = t.getQuantity() - 1;
		t.setQuantity(qnew);
		
	}
	
	
}
