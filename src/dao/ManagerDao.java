package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import backend.Admin;
import backend.Manager;
import backend.Store;
import database.DBConnection;

public class ManagerDao {
	
	public static ArrayList<Manager> managerList = new ArrayList<Manager>();

	
	public static int save(int id, String name, String password, String email, String location, String shop) {
		
		int status=0;
		try{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into manager(id, name, email, password, location ,shop) values(?,?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4,password);
			ps.setString(5,location);
			ps.setString(6,shop);

			status=ps.executeUpdate();
			
			Store s= Admin.getStore(shop);
			managerList.add(new Manager(id, name, email, password, location, s));
			
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		return status;
		
		
	}
	public static int delete(int id){
		
		int status=0;
		try{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from manager where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			String sid = Integer.toString(id);
			//Admin admin = new Admin();
			//admin.removeManager(id);
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String email,String password){
		boolean status=false;
		
		try{ 
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from manager where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	//public static String()
	
	public static void login(String name, String password) {
		
			
				for(Manager m: managerList) {
					if(m.getName().equals(name) && m.getPassword().equals(password)) {
						m.isLoggedIn=true;
					
				}
		
		}
		}
	
	public static void logout(String name, String password) {
		for(Manager m: managerList) {
			if(m.getName().equals(name) && m.getPassword().equals(password)) {
				m.isLoggedIn=false;
			}
		}
		


		}
			
		

}
