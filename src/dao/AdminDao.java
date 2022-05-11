package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import backend.Admin;
import backend.Customer;
import backend.Manager;
import backend.Store;
import database.DBConnection;

public class AdminDao {

	//THIS CLASS IS TO ADD ALL THE DATA FROM DB
	public AdminDao(){
		
	}
public static ArrayList<Store> getAllStore(){
		//STORE
	Admin.stores = new ArrayList<Store>();
	 
	try{ 
		ResultSet resultSet=null;
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * from store");
	    resultSet = ps.executeQuery("SELECT * from store");
	    while (resultSet.next()) {
	    
	            Store m = new Store(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
	            Admin.stores.add(m);
	            
		
        }
	    
	    con.close();
	}catch(Exception e){System.out.println(e);}
	
	return Admin.stores;
}
	

	//MANAGER
	public static ArrayList<Manager> getAllManager(){
		Admin.managers = new ArrayList<Manager>();
	
	try{
		ResultSet resultSet=null;
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * from manager");
	    resultSet = ps.executeQuery("SELECT * from manager");
	    while (resultSet.next()) {
	 
	    	Store s = Admin.getStore(resultSet.getString(6));
	        Manager m = new Manager(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), s);
	        Admin.managers.add(m);
	        System.out.print(Admin.managers.toArray());
		
        }
	    
	    con.close();
	}catch(Exception e){System.out.println(e);}
	return Admin.managers;
	}
	
	//CUSTOMER
	public static ArrayList<Customer> getAllCustomers(){
		Admin.customers = new ArrayList<Customer>();
	
	try{ 
		ResultSet resultSet=null;
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * from customer");
	    resultSet = ps.executeQuery("SELECT * from customer");
	    while (resultSet.next()) {
	 
	           Customer m = new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
	           Admin.customers.add(m);
		
        }
	    System.out.println(Admin.customers);
	    con.close();
	}catch(Exception e){System.out.println(e);}
	return Admin.customers;
	}

}