package resources;

import java.util.ListResourceBundle;

public class View_eu extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			// Header resources
			{"header.appName", "Berrien Web Aplikazioa"},
			{"header.home", "Sarrera"},
			{"header.users", "Erabiltzaile zerrenda"},
			{"header.user", "Erabiltzailea"},
			{"header.news", "Berrien zerrenda"},
			// Languages
			{"language.en", "Ingelesa"},
			{"language.es", "Gaztelera"},
			{"language.eu", "Euskara"},
			// User properties
			{"userProp.userId", "Erabiltzaile IDa"},
			{"userProp.username", "Erabiltzaile izena"},
			{"userProp.password", "Pasahitza"},
			{"userProp.firstName", "Izena"},
			{"userProp.secondName", "Abizena"},
			{"userProp.email", "e-posta"},
			// News Item properties
			{"newsItemProp.newsItemId", "Berriaren IDa"},
			{"newsItemProp.title", "Titulua"},
			{"newsItemProp.body", "Gorputza"},
			{"newsItemProp.author", "Idazlea"},
			{"newsItemProp.lang", "Hizkuntza"},
			{"newsItemProp.date", "Data"},
			// News Item form
			{"newsItem.create", "Berria Sortu"},
			{"newsItem.edit", "Berria Editatu"},
			// Actions
			{"action.view", "Ikusi"},
			{"action.save", "Gorde"},
			{"action.edit", "Editatu"},
			{"action.delete", "Ezabatu"},
			{"action.login", "Saioa Hasi"},
			{"action.logout", "Saioa Itxi"},
			{"action.register", "Erregistratu"},
			{"action.newNewsItem", "Berria sortu"},
			// Others
			{"general.hi","Kaixo"},
	};

}
