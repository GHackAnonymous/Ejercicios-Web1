package resources;

import java.util.ListResourceBundle;

public class Resources_es_ES extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"string.hello", "Hola"},
			{"string.welcome", "Bienvenido"},
			{"language.en", "Inglés"},
			{"language.es", "Español"},
			{"language.eu", "Vasco"},
	};

}
