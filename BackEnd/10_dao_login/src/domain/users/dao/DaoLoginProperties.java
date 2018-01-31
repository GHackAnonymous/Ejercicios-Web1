package domain.users.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DaoLoginProperties implements DaoLogin{
	private String fileName ="config.properties";
	private Properties prop = null;
	
	public DaoLoginProperties(){
		prop = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try{
			prop.load(classLoader.getResourceAsStream(fileName));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean exists(String username, String password) {
		boolean exists = false;
		String propUsername;
		String propPassword;
		propUsername = prop.getProperty("name");
		propPassword = prop.getProperty("password");
		if(propUsername.equals(username) && propPassword.equals(password)){
			exists = true;
		}
		return exists;
	}

}
