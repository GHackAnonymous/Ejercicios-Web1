package resources;

import java.util.ListResourceBundle;

public class Messages  extends ListResourceBundle {

/*
 * This is the default resource, in this case English
 * If a resource is not found in other classes,
 * or a non supported language is set, 
 * this class will be used.
 */
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"login.successful", "You are now loged!"},
			{"login.successful", "You are now loged out!"},
			{"newUser.successful", "The new user has been registered!"},
			{"editUser.successful", "The user has been modified."},
			{"newNewsItem.successful", "The new News Item has been registered!"},
			{"editNewItem.successful", "The News Item has been modified."},
	};
}
