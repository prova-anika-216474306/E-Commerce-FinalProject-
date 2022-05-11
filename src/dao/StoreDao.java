package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import backend.Admin;
import backend.Item;
import backend.Store;
import database.DBConnection;

public class StoreDao {

	public static ArrayList<Item> getAllItems() {
		Store.items = new ArrayList<Item>();

		try {
			ResultSet resultSet = null;
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * from item");
			resultSet = ps.executeQuery("SELECT * from item");
			while (resultSet.next()) {
				Item t = new Item(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6));
				Store.items.add(t);

			}

			con.close(); 
		} catch (Exception e) {
			System.out.println(e);
		}

		return Store.items;
	}

	public static int save(String name, String opening, String closing, String location) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into store(name, opening, closing, location) values(?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, opening);
			ps.setString(3, closing);
			ps.setString(4, location);

			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int delete(String name) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from store where name=?");
			ps.setString(1, name);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static ArrayList<String> stores() {
		ArrayList<String> stores = new ArrayList<String>();
		try {
			ResultSet resultSet = null;
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT name from store");
			resultSet = ps.executeQuery("SELECT name from store");
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				stores.add(name);
			} 
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return stores;
	}

	public static String getStoreName(String location) {
		boolean status = false;
		String store = "";
		try {

			Connection con = DBConnection.getConnection();
			String query = "SELECT * from store where location=" + "\"" + location + "\"";

			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			store = rs.getString("name");
			con.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return store;
	}

	// Get array of store locations
	public static ArrayList<String> storelocations() {
		ArrayList<String> locations = new ArrayList<String>();

		try {
			ResultSet resultSet = null;
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT location from store");
			resultSet = ps.executeQuery("SELECT location from store");
			while (resultSet.next()) {
				String location = resultSet.getString("location");
				locations.add(location);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return locations;
	}

	public static void changehours(String name, String opening, String closing) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE store SET opening=?, closing=? where name=?");

			ps.setString(1, opening);
			ps.setString(2, closing);
			ps.setString(3, name);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
