package resources;

import java.util.ListResourceBundle;

/*
 * This is the default resource, in this case English
 * If a resource is not found in other classes,
 * or a non supported language is set, 
 * this class will be used.
 */
public class Errors  extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"login.nouser", "The user does not exist. Sign up if you want."},
			{"login.uperror", "Wrong username or password."},
			{"newUser.failed", "Unable to register new user."},
			{"general.notImplemented", "This is not implemented yet"},
			{"general.notLoged", "You must be loged to do this action."},
			{"general.noPermission", "You are not allowed to do this action."},
			{"userList.mainSection","There has been a problem loading the User List."},
			{"user.mainSection","There has been a problem loading the User."},
	};
}
