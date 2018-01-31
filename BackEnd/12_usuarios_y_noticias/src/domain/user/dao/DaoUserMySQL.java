package domain.user.dao;

import domain.user.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoUserMySQL implements DaoUser {

	Connection connection = null;
	Statement statement = null;
	
	private String ip = "127.0.0.1";
	private String usuario = "root";
	private String contraseña = "";
	private String nombreBD = "eclipse_db_exercise1";
	    
	private String driver = "com.mysql.jdbc.Driver";  
	private String urlBD = "jdbc:mysql://"+ip+"/"+nombreBD+"";
	
	

	/*public DaoUserMySQL() {
		this.connectionString = url + serverName + "/" + dataBaseName;
	}
	*/

	private void connect() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(urlBD,
					usuario, contraseña);
			System.out.println("MySQL:conexion");
			statement = (Statement) connection.createStatement();
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
	public boolean insertUser(User user) {
		System.out.println("insertUser not implemented yet.");
		return false;
	}

	@Override
	public User loadUser(String username, String password) {
		User user = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM user "
				+ "WHERE username='"+username+"' "
				+ "AND password='"+password+"';";
		
		try{
			Statement stm = (Statement) connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				user = new User();
				
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setSecondName(rs.getString("second_name"));
				user.setEmail(rs.getString("email"));
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
	public User loadUser(int userId) {
		System.out.println("loadUser not implemented yet.");
		return null;
	}

	@Override
	public ArrayList<User> loadUsers() {
		User user = null;
		ArrayList<User> listaUsuarios = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM user; ";
		
		try{
			Statement stm = (Statement) connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			listaUsuarios = new ArrayList<>();
			while(rs.next()){
				user = new User();
				
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setSecondName(rs.getString("second_name"));
				user.setEmail(rs.getString("email"));
				
				listaUsuarios.add(user);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoLoginMysql exists select");
		}
		disconnect();
		return listaUsuarios;
	}

}
