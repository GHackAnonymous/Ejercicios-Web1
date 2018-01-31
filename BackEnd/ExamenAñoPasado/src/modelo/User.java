package modelo;

public class User implements java.io.Serializable{
	private static final long serialVersionUID = 3834633934831160740L;
	
	private int userId = 0;
	private String username = null;
	private String password = null;
	
	public User(){}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}