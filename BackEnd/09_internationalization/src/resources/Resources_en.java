package resources;

import java.util.ListResourceBundle;

public class Resources_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"string.hello", "Hello"},
			{"string.welcome", "Welcome"},
			{"language.en", "English"},
			{"language.es", "Spanish"},
			{"language.eu", "Basque"},
	};

}
