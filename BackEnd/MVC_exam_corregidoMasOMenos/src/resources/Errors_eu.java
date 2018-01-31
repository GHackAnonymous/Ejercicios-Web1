package resources;

import java.util.ListResourceBundle;

public class Errors_eu extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"login.nouser", "Erabiltzaile hori ez da existitzen. Nahi baduzu izena eman."},
			{"login.uperror", "Erabiltzaile edo pasahitz okerra."},
			{"newUser.failed", "Ezin izan da erabiltzaile berria sortu."},
			{"general.notImplemented", "Oraindik ez da inplementatu"},
			{"general.notLoged", "Saioa hasi eragiketa hori egin nahi baduzu."},
			{"general.noPermission", "Ez duzu eragiketa hori egiteko baimenik."},
			{"userList.mainSection","Arazoren bat egon da erabiltzaileen zerrenda jasotzerakoan."},
			{"user.mainSection","Arazoren bat egon da erabiltzailea jasotzerakoan."},
	};

}
