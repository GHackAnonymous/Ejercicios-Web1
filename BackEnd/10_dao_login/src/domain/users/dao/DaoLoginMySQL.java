package domain.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoLoginMySQL implements DaoLogin {
	Connection connection = null;

	Statement statement = null;

	String serverName = "localhost";

	String dataBaseName = "eclipse_db_exercise1";

	String url = "jdbc:mysql://";

	/*
	 * change this to your mysql username 
	 * "root" is fine for development but not for production
	 */
	String username = "root";

	String password = "mysqlpassword";// Change this to your password

	String connectionString = null;

	public DaoLoginMySQL() {

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
	public boolean exists(String username, String password) {
		boolean exists = false;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM user "
				+ "WHERE username='"+username+"' "
				+ "AND password='"+password+"';";
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				exists = true;
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoLoginMysql exists select");
		}
		disconnect();
		return exists;
	}

}
