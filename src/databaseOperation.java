import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

public class databaseOperation {
	private String usernameForDatabase = "root";
	private String passwordForDatabase = "14759639874123";
	private String databaseName = "mircotech";
	private String host = "localhost";
	private int port = 3306;
	private Connection con = null;
	private Statement statement = null;
	
	public ArrayList<String[]> itemArray = new ArrayList<String[]>();
	
	public databaseOperation() {
		
		String url = "jdbc:mysql://"+host+":"+port+"/"+databaseName;
	
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
System.out.println("Not found driver..");
	}
	
	
		try {
			con = DriverManager.getConnection(url,usernameForDatabase,passwordForDatabase);
			System.out.println("Connection succesfull");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection unsuccesfull");
		}
		
		
		
	}
	
	public ArrayList<String[]> getItems() {
	
		String query = "Select * from items";
		try {
			statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				String model = rs.getString("model");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String price = String.valueOf(rs.getInt("price"));
				String stock = String.valueOf(rs.getInt("stock"));
				String[] item= {model,name,price,stock};
				int stockInt=Integer.valueOf(stock);
				if(stockInt>0) {
					itemArray.add(item);
				}
				
			}
			return itemArray;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemArray;
	}
	
	public boolean insertTable(String query) {
		
		try {
			statement = con.createStatement();
			statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean createTable(String query) {
		
		try {
			statement = con.createStatement();
			statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public ArrayList<String> login(String email,String password) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("false");
		try {	
			statement = con.createStatement();
			ResultSet rs=statement.executeQuery("select * from user");
			
			while(rs.next()) {
				String currentemail;
				String currentpassword;
				String currentname;
				currentemail=rs.getString("email");
				currentname=rs.getString("nameAndSurname");
				currentpassword=rs.getString("password");
				if(email.equals(currentemail)&&password.equals(currentpassword)) {
					array.remove(0);
					array.add("true");
					array.add(currentemail);
					array.add(currentpassword);
					array.add(currentname);
				return array;
				}
			
			}
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			
			
		}
		return array ;
		
		
	}
	
	public ArrayList<String> getAItem(String modelName) {
		
		ArrayList<String> array=new ArrayList<String>();
		try {
			statement = con.createStatement();
			ResultSet rs=statement.executeQuery("select * from items where model='"+modelName+"'");
			while(rs.next()) {
				String model = rs.getString("model");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String price = String.valueOf(rs.getInt("price"));
				String stock = String.valueOf(rs.getInt("stock"));
				array.add(model);
				array.add(name);
				array.add(image);
				array.add(price);
				array.add(stock);
				return array;
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	
	public ArrayList<String[]> getCart(String email){
		ArrayList<String[]>array=new ArrayList<String[]>();
		
		try {
			statement = con.createStatement();
			ResultSet rs=statement.executeQuery("select * from `"+email+"|||cart`");
			while(rs.next()) {
				String model = rs.getString("model");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String[]cart= {model,name,price};
				array.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public Boolean deleteFromTable(String query) {
		
		try {
			statement = con.createStatement();
			statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int getStock(String model) {
		
		try {
			statement = con.createStatement();
			ResultSet rs=statement.executeQuery("select * from `mircotech`.`items`");
			while(rs.next()) {
				String getModel = rs.getNString("model");
				if(getModel.equals(model)) {
					int stock = rs.getInt("stock");
					return stock;
				}
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public Boolean update(String query) {
		try {
			statement = con.createStatement();
			statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
