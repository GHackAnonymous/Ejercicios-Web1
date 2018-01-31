package resources;

import java.util.ListResourceBundle;

public class Messages_eu  extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"login.successful", "Saioa hasi duzu!"},
			{"logout.successful", "Saioa itxi duzu!"},
			{"newUser.successful", "Erabiltzailea erregistratu da!"},
			{"editUser.successful", "Erabiltzailea eguneratu da."},
			{"newNewsItem.successful", "Berria gorde da!"},
			{"editNewItem.successful", "Berria eguneratu da."},
	};
}
