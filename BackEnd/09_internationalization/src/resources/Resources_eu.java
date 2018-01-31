package resources;

import java.util.ListResourceBundle;

public class Resources_eu extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"string.hello", "Kaixo"},
			{"string.welcome", "Ongietorri"},
			{"language.en", "Ingelesa"},
			{"language.es", "Gaztelera"},
			{"language.eu", "Euskara"},
	};

}
