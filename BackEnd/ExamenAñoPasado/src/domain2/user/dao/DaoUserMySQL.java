package domain2.user.dao;

import java.util.ArrayList;

import modelo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUserMySQL implements DaoUser {

	Connection connection = null;
	Statement statement = null;
	String serverName = "127.0.0.1";
	String dataBaseName = "mvc_examly";
	String url = "jdbc:mysql://";
	String username = "root";
	String password = "";
	String connectionString = null;

	public DaoUserMySQL() {
		this.connectionString = url + serverName + "/" + dataBaseName;
	}
	

	private void connect() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionString,
					username, password);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {

			System.out.println("Connection Driver Error");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Could Not Connect to DB ");
		}
	}

	private void disconnect() {

		try {

			if (statement != null) {

				statement.clearWarnings();
				statement.close();
			}

			if (connection != null) {

				connection.clearWarnings();
				connection.close();
			}
		} catch (SQLException e) {

			System.out.println("Error disconnecting");
		}
	}

	@Override
	public User loadUser(String username, String password) {
		System.out.println("Pasa 3");
		User user = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM user "
				+ "WHERE username='"+username+"' "
				+ "AND password='"+password+"';";
		System.out.println(sqlQuery);
		System.out.println("Pasa 4");
		try{
			System.out.println("Pasa 5");
			System.out.println(connection);
			Statement stm = connection.createStatement();
			System.out.println("Pasa 6");
			rs = stm.executeQuery(sqlQuery);
			System.out.println("Pasa 7");
			if(rs.next()){
				user = new User();
				System.out.println("Pasa 8");
				System.out.println("ID: "+user.getUserId());
				System.out.println("Usename: "+user.getUsername());
				System.out.println("Password: "+user.getPassword());
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			System.out.println("Exception");
			e.printStackTrace();
			System.out.println("Error DaoLoginMysql exists select");
		}
		disconnect();
		return user;
	}

	@Override
	public User loadUser(int userId) {

		User user = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM user "
				+ "WHERE userId="+userId;
		System.out.println(sqlQuery);
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				user = new User();
				
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoLoginMysql exists select");
		}
		disconnect();
		return user;
	}

	@Override
	public ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<User>();
		User user = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM user";
		System.out.println(sqlQuery);
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			while(rs.next()){
				user = new User();
				
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
				users.add(user);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoUserMySQL loadUsers select");
		}
		disconnect();
		return users;
	}

	@Override
	public boolean insertUser(User user) {
		boolean ret = false;
		String sqlQuery = "INSERT INTO user (username,password) "+
		"VALUES("
		+ "'"+user.getUsername()+"',"
		+ "'"+user.getPassword()+"'"
		+ ")";
		System.out.println(sqlQuery);
		
		connect();
		try{
			Statement stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		disconnect();
		return ret;
	}
	
	@Override
	public boolean updateUser(User user) {
		boolean ret = false;
		String sqlQuery = "UPDATE user "+
		"SET "
		+ "username='"+user.getUsername()+"',"
		+ "password='"+user.getPassword()+"'"
		+ "WHERE userId="+user.getUserId();
		System.out.println(sqlQuery);
		connect();
		try{
			Statement stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		disconnect();
		return ret;
		
	}


	@Override
	public boolean deleteUser(int userId) {

		boolean ret = false;
		String sqlQuery = "DELETE FROM user WHERE userId="+userId;
		System.out.println(sqlQuery);
		connect();
		try{
			Statement stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		disconnect();
		return ret;
	}

}
