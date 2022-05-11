package backend;

import dao.StoreDao;
import dao.ManagerDao; 

public class Manager {

int ID;
String name;
String email;
String password;
String location;
Store shop;
public boolean isLoggedIn;

public boolean isLoggedIn() {
	return isLoggedIn;
}

public void setLoggedIn(boolean isLoggedIn) {
	this.isLoggedIn = isLoggedIn;
}

public Manager() {
	
}
public Manager(int ID, String name, String email, String password, String location, Store shop) {
	Admin admin = new Admin();
	this.ID= ID;
	this.name= name;
	this.email= email;
	this.password = password;
	this.location= location;
	this.shop = shop;
	this.isLoggedIn = false;
	
}

public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}

public void setShop(Store shop) {
	this.shop = shop;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
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

public Store getShop() {
	return shop;
}

public void logout(String name, String password) {
	if(this.getName().equals(name) && this.getPassword().equals(password) ) {
		this.isLoggedIn = false;
		}
	}

public boolean login(String email, String password) {
	if(ManagerDao.validate(email, password)) {
		this.isLoggedIn = true;
		return true;
		}
	else {
		return false;
	} 
	}


public void changeHours(String opening, String closing) {
	StoreDao.changehours(this.shop.getName(), opening, closing);
	this.getShop().setOpeningHours(opening);
	this.getShop().setOpeningHours(closing);
	
	
}
	

}
