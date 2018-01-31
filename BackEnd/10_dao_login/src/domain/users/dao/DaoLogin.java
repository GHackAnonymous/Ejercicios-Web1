package domain.users.dao;

public interface DaoLogin {
	public boolean exists(String username, String password);
}
