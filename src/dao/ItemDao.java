package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.DBConnection;

public class ItemDao {

	public static int save(int id, String name, String category, int price, int quantity, String description) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into item(id, name, category, price, quantity, description) values(?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, category);
			ps.setInt(4, price);
			ps.setInt(5, quantity);
			ps.setString(6, description);

			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from item where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static String[] toStringItemDetailAll() {
		ArrayList<String> items = new ArrayList<String>();
		try {
			ResultSet resultSet = null;
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT name, price, description from item WHERE quantity>0");
			resultSet = ps.executeQuery("SELECT name, price, description from item WHERE quantity>0");

			while (resultSet.next()) {
				String row = "";
				for (int i = 1; i <= 3; i++) {
					row = "Item: " + resultSet.getString(1) + "	|	Price: " + resultSet.getString(2)
							+ "	|	 Description: " + resultSet.getString(3);
				}
				items.add(row);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		String[] result = new String[items.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = (String) items.get(i);
		}

		return result;

	}

	// SEARCH ITEM BY CATEGORY
	public static String[] toStringItemDetailCategory(String category) {
		ArrayList<String> items = new ArrayList<String>();
		try {
			ResultSet resultSet = null;
			Connection con = DBConnection.getConnection();
			String query = "SELECT name, price, description from item where category=" + "\"" + category + "\"";
			PreparedStatement ps = con.prepareStatement(query);
			resultSet = ps.executeQuery(query);

			while (resultSet.next()) {
				String row = "";
				for (int i = 1; i <= 3; i++) {
					row = "Item: " + resultSet.getString(1) + "	|	Price: " + resultSet.getString(2)
							+ "	|	Description: " + resultSet.getString(3);
				}
				items.add(row);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		String[] result = new String[items.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = (String) items.get(i);
		}

		return result;

	}

	// SEARCH ITEM BY NAME
	public static String[] toStringItemDetailName(String name) {
		ArrayList<String> items = new ArrayList<String>();
		try {
			ResultSet resultSet = null;
			Connection con = DBConnection.getConnection();
			String query = "SELECT name, price, description from item where name=" + "\"" + name + "\"";
			PreparedStatement ps = con.prepareStatement(query);
			resultSet = ps.executeQuery(query);

			while (resultSet.next()) {
				String row = "";
				for (int i = 1; i <= 3; i++) {
					row = "Item: " + resultSet.getString(1) + "  |	Price: " + resultSet.getString(2)
							+ "	|	Description: " + resultSet.getString(3);
				}
				items.add(row);
			}
			con.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
		String[] result = new String[items.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = (String) items.get(i);
		}

		return result;

	}

	// ITEM CATEGORIES
	public static ArrayList<String> itemCategories() {
		ArrayList<String> itemcategories = new ArrayList<String>();
		try {
			ResultSet resultSet = null;
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT DISTINCT category FROM item");
			resultSet = ps.executeQuery("SELECT DISTINCT category FROM item");
			while (resultSet.next()) {
				String name = resultSet.getString("category");
				itemcategories.add(name);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return itemcategories;
	}

	public static void changeItemDetails(int id, String name, String category, int price, int quantity,
			String description) {
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE item SET name=?, category=?, price=?, quantity=?, description=? where id=?");

			ps.setString(1, name);
			ps.setString(2, category);
			ps.setInt(3, price);
			ps.setInt(4, quantity);
			ps.setString(5, description);
			ps.setInt(6, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
