package domain.advert.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


import domain.advert.dao.DaoAdvertItemMySQL;
import modelo.AdvertModelo;

public class DaoAdvertItemMySQL implements DaoAdvertItem {

	Connection connection = null;
	Statement statement = null;
	String serverName = "localhost";
	String dataBaseName = "mvc_examly";
	String url = "jdbc:mysql://";
	String username = "root";
	String password = "";
	String connectionString = null;
	
	public DaoAdvertItemMySQL(){
		this.connectionString = url + serverName + "/" + dataBaseName;
	}
	
	private void connect() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionString,
					username, password);
			System.out.println("peta?");
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
	public boolean insertAdvertItem(AdvertModelo advertItem) {

		boolean ret = false;
		String sqlQuery = "INSERT INTO advert (Title,src,alt) "+
		"VALUES("
		+ "'"+advertItem.getTitle()+"',"
		+ "'"+advertItem.getSrc()+"',"
		+ "'"+advertItem.getAlt()+"'"
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
	public AdvertModelo loadAdvertItem(int advertItemId) {
		AdvertModelo advertItem = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM advert "
				+ "WHERE id="+advertItemId;
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				//int authorId;
				//User author;
				advertItem = new AdvertModelo();
				
				advertItem.setTitle(rs.getString("title"));
				advertItem.setSrc(rs.getString("src"));
				advertItem.setAlt(rs.getString("alt"));
				
				/*authorId = rs.getInt("authorId");
				author = new DaoUserMySQL().loadUser(authorId);
				newsItem.setAuthor(author);*/
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoNewsItemMysql loadNewsItem");
		}
		disconnect();
		return advertItem;
	}

	@Override
	public ArrayList<AdvertModelo> loadAllAdvertItems() {
		ArrayList<AdvertModelo> advertItems = new ArrayList<AdvertModelo>();
		AdvertModelo advertItem;
		//User author;
		//int authorId;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM advert";
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			while(rs.next()){
				advertItem = new AdvertModelo();
				
				advertItem.setTitle(rs.getString("title"));
				advertItem.setSrc(rs.getString("src"));
				advertItem.setAlt(rs.getString("alt"));

				
				/*authorId = rs.getInt("authorId");
				author = new DaoUserMySQL().loadUser(authorId);
				newsItem.setAuthor(author);*/
				
				advertItems.add(advertItem);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoNewsItemMysql loadAllNewsItems");
		}
		disconnect();
		return advertItems;
	}

	@Override
	public boolean updateAdvertItem(AdvertModelo advertItem) {
		boolean ret = false;
		String sqlQuery = "UPDATE advert "+
		"SET "
		+ "title='"+advertItem.getTitle()+"',"
		+ "src='"+advertItem.getSrc()+"',"
		+ "alt='"+advertItem.getAlt()+"',"
		+ " WHERE id="+advertItem.getId()+"";
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
	public boolean deleteAdvertItem(Integer advertItemId) {

		boolean ret = false;
		String sqlQuery = "DELETE FROM advert WHERE id="+advertItemId;
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
