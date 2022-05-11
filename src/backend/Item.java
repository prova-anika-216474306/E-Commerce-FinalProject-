package backend;

import java.util.ArrayList;

import dao.ItemDao;

public class Item {

	int id;
	String name;
	String category;
	int price;
	int quantity;
	String description;
	boolean isSaleItem;
	
	public boolean isSaleItem() {
		return isSaleItem;
	}

	public void setSaleItem(boolean isSaleItem) {
		this.isSaleItem = isSaleItem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Item(int id, String name, String category, int price, int quantity, String description) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.description= description;
		this.isSaleItem = false;
	}

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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void UpdateItem(String name, String category, int price, int quantity, String description) {
		int id = this.getId();
		ItemDao.changeItemDetails(id, name, category, price, quantity, description);
		this.setName(name);
		this.setCategory(category);
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setDescription(description);
	}
	

	
	
}
