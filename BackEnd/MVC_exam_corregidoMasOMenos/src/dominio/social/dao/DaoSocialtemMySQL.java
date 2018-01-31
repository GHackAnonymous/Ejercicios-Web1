package dominio.social.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import domain.user.model.User;
import dominio.social.model.SocialItem;
import dominio.user.dao.DaoUserMySQL;

public class DaoSocialtemMySQL implements DaoSocialItem {

	Connection connection = null;
	Statement statement = null;
	String serverName = "localhost";
	String dataBaseName = "mvc_exam";
	String url = "jdbc:mysql://";
	String username = "root";
	String password = "";
	String connectionString = null;
	
	public DaoSocialtemMySQL(){
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
	public boolean insertSocialItem(SocialItem socialItem) {

		boolean ret = false;
		String sqlQuery = "INSERT INTO social (name,logoUrl,socialUrl) "+
		"VALUES("
		+ "'"+socialItem.getName()+"',"
		+ "'"+socialItem.getLogoUrl()+"',"
		+ "'"+socialItem.getSocialUrl()
		+ "')";
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
	public SocialItem loadSocialItem(int socialItemId) {
		SocialItem socialItem = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM social "
				+ "WHERE socialId="+socialItemId;
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				socialItem = new SocialItem();
				
				socialItem.setSocialItemId(rs.getInt("socialId"));
				socialItem.setName(rs.getString("name"));
				socialItem.setLogoUrl(rs.getString("logoUrl"));
				socialItem.setSocialUrl(rs.getString("socialUrl"));
				
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoNewsItemMysql loadNewsItem");
		}
		disconnect();
		return socialItem;
	}

	@Override
	public ArrayList<SocialItem> loadAllSocialItems() {
		ArrayList<SocialItem> socialItems = new ArrayList<SocialItem>();
		SocialItem socialItem;

		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM social";
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			while(rs.next()){
				socialItem = new SocialItem();
				
				socialItem.setSocialItemId(rs.getInt("socialId"));
				socialItem.setName(rs.getString("name"));
				socialItem.setLogoUrl(rs.getString("logoUrl"));
				socialItem.setSocialUrl(rs.getString("socialUrl"));
				
				socialItems.add(socialItem);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoNewsItemMysql loadAllNewsItems");
		}
		disconnect();
		return socialItems;
	}

	@Override
	public boolean updateSocialItem(SocialItem socialItem) {
		boolean ret = false;
		String sqlQuery = "UPDATE social "+
		"SET "
		+ "name='"+socialItem.getName()+"',"
		+ "logoUrl='"+socialItem.getLogoUrl()+"',"
		+ "socialUrl='"+socialItem.getSocialUrl()+"'"
		+ " WHERE socialId="+socialItem.getSocialItemId();
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
	public boolean deleteSocialItem(Integer socialItemId) {

		boolean ret = false;
		String sqlQuery = "DELETE FROM social WHERE socialId="+socialItemId;
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
