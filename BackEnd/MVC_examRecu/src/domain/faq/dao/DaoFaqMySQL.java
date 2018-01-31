package domain.faq.dao;

import java.util.ArrayList;

import domain.faq.model.FaqModelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoFaqMySQL implements DaoFaq {

	Connection connection = null;
	Statement statement = null;
	String serverName = "localhost";
	String dataBaseName = "mvc_exam";
	String url = "jdbc:mysql://";
	String username = "mysqladmin";
	String password = "mysqladmin";
	String connectionString = null;

	public DaoFaqMySQL() {
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
	public FaqModelo loadFaq(String question, String answer) {
		FaqModelo faqModelo = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM faq "
				+ "WHERE question='"+question+"' "
				+ "AND answer='"+answer+"';";
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				faqModelo = new FaqModelo();
				
				faqModelo.setFaqId(rs.getInt("faqId"));
				faqModelo.setQuestion(rs.getString("question"));
				faqModelo.setAnswer(rs.getString("answer"));
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoLoginMysql exists select");
		}
		disconnect();
		return faqModelo;
	}

	@Override
	public FaqModelo loadFaq(int faqId) {

		FaqModelo faqModelo = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM faq "
				+ "WHERE faqId="+faqId;
		System.out.println(sqlQuery);
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			if(rs.next()){
				faqModelo = new FaqModelo();
				
				faqModelo.setFaqId(rs.getInt("faqId"));
				faqModelo.setQuestion(rs.getString("question"));
				faqModelo.setAnswer(rs.getString("answer"));
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoLoginMysql exists select");
		}
		disconnect();
		return faqModelo;
	}

	@Override
	public ArrayList<FaqModelo> loadFaqs() {
		ArrayList<FaqModelo> faqs = new ArrayList<FaqModelo>();
		FaqModelo faqModelo = null;
		connect();
		ResultSet rs = null;
		String sqlQuery = "SELECT * FROM faq";
		System.out.println(sqlQuery);
		
		try{
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
			while(rs.next()){
				faqModelo = new FaqModelo();
				
				faqModelo.setFaqId(rs.getInt("faqId"));
				faqModelo.setQuestion(rs.getString("question"));
				faqModelo.setAnswer(rs.getString("answer"));
				
				faqs.add(faqModelo);
			}
		}catch(SQLException e){
			System.out.println(sqlQuery);
			e.printStackTrace();
			System.out.println("Error DaoUserMySQL loadUsers select");
		}
		disconnect();
		return faqs;
	}

	@Override
	public boolean insertFaq(FaqModelo faqModelo) {
		boolean ret = false;
		String sqlQuery = "INSERT INTO faq (question,answer) "+
		"VALUES("
		+ "'"+faqModelo.getQuestion()+"',"
		+ "'"+faqModelo.getAnswer()+"'"
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
	public boolean updateFaq(FaqModelo faqModelo) {
		boolean ret = false;
		String sqlQuery = "UPDATE faq "+
		"SET "
		+ "question='"+faqModelo.getQuestion()+"',"
		+ "answer='"+faqModelo.getAnswer()+"'"
		+ "WHERE faqId="+faqModelo.getFaqId();
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
	public boolean deleteFaq(int faqId) {

		boolean ret = false;
		String sqlQuery = "DELETE FROM faq WHERE faqId="+faqId;
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
