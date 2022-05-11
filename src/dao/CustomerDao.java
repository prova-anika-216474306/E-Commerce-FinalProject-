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

public class CustomerDao {

	public static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public static int save(int id, String name, String password, String email, String location) {

		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
			"insert into customer(id, name, email, password, location) values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, location);
			

			status = ps.executeUpdate();
			
			customerList.add(new Customer(id, name, email, password, location));

			con.close();
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}

	public static boolean validate(String email, String password) {
		boolean status = false;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	// public static String()

	public static void login(String name, String password) {

		for (Customer m : customerList) {
			if (m.getName().equals(name) && m.getPassword().equals(password)) {
				m.isLoggedIn = true;

			}

		}
	}

	public static void logout(String name, String password) {
		for (Customer m : customerList) {
			if (m.getName().equals(name) && m.getPassword().equals(password)) {
				m.isLoggedIn = false;
			}
		}

	}

}
