package domain.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import domain.news.model.NewsItem;
import domain.user.dao.DaoUserMySQL;
import domain.user.model.User;

public class DaoNewsItemMySQL implements DaoNewsItem {

	Connection connection = null;
	Statement statement = null;
	String serverName = "localhost";
	String dataBaseName = "eclipse_db_exercise1";
	String url = "jdbc:mysql://";
	String username = "root";
	String password = "";
	String connectionString = null;
	
	public DaoNewsItemMySQL(){
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
	public boolean insertNewsItem(NewsItem newsItem) {

		boolean ret = false;
		String sqlQuery = "INSERT INTO news_item (title,body,lang,authorId) "+
		"VALUES("
		+ "'"+newsItem.getTitle()+"',"
		+ "'"+newsItem.getBody()+"',"
		+ "'"+newsItem.getLang().toLanguageTag()+"',"
		+ newsItem.getAuthor().getUserId()
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
	public NewsItem loadNewsItem(int newsItemId) {
		NewsItem newsItem = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM news_item "
				+ "WHERE newsItemId="+newsItemId;
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				int authorId;
				User author;
				newsItem = new NewsItem();
				
				newsItem.setNewsItemId(rs.getInt("newsItemId"));
				newsItem.setTitle(rs.getString("title"));
				newsItem.setBody(rs.getString("body"));
				
				Timestamp ts = rs.getTimestamp("date");
				Date date = new Date(ts.getTime());
				newsItem.setDate(date);
				
				String langStr = rs.getString("lang");
				Locale lang = Locale.forLanguageTag(langStr);
				newsItem.setLang(lang);
				
				authorId = rs.getInt("authorId");
				author = new DaoUserMySQL().loadUser(authorId);
				newsItem.setAuthor(author);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoNewsItemMysql loadNewsItem");
		}
		disconnect();
		return newsItem;
	}

	@Override
	public ArrayList<NewsItem> loadAllNewsItems() {
		ArrayList<NewsItem> newsItems = new ArrayList<NewsItem>();
		NewsItem newsItem;
		User author;
		int authorId;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM news_item";
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			while(rs.next()){
				newsItem = new NewsItem();
				
				newsItem.setNewsItemId(rs.getInt("newsItemId"));
				newsItem.setTitle(rs.getString("title"));
				newsItem.setBody(rs.getString("body"));
				
				Timestamp ts = rs.getTimestamp("date");
				Date date = new Date(ts.getTime());
				newsItem.setDate(date);
				
				String langStr = rs.getString("lang");
				Locale lang = Locale.forLanguageTag(langStr);
				newsItem.setLang(lang);
				
				authorId = rs.getInt("authorId");
				author = new DaoUserMySQL().loadUser(authorId);
				newsItem.setAuthor(author);
				
				newsItems.add(newsItem);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoNewsItemMysql loadAllNewsItems");
		}
		disconnect();
		return newsItems;
	}

	@Override
	public boolean updateNewsItem(NewsItem newsItem) {
		boolean ret = false;
		String sqlQuery = "UPDATE news_item "+
		"SET "
		+ "title='"+newsItem.getTitle()+"',"
		+ "body='"+newsItem.getBody()+"',"
		+ "lang='"+newsItem.getLang().toLanguageTag()+"',"
		+ "authorId="+newsItem.getAuthor().getUserId()
		+ " WHERE newsItemId="+newsItem.getNewsItemId();
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
	public boolean deleteNewsItem(Integer newsItemId) {

		boolean ret = false;
		String sqlQuery = "DELETE FROM news_item WHERE newsItemId="+newsItemId;
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
