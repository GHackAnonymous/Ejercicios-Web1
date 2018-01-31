package domain.users.dao;

public class LoginFacade {
	DaoLogin login = null;
	
	public LoginFacade(){
		//login = new DaoLoginProperties();
		login = new DaoLoginMySQL();
	}
	public boolean exists(String username, String password){
		return login.exists(username,password);
	}
}
