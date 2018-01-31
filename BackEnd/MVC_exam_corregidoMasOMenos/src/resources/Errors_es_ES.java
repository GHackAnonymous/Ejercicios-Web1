package resources;

import java.util.ListResourceBundle;

public class Errors_es_ES  extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"login.nouser", "Ese usuario no existe. Si quieres, puedes registrarte."},
			{"login.uperror", "Usuario o contraseña incorrecta."},
			{"newUser.failed", "No se ha podido registrar el nuevo usuario."},
			{"general.notImplemented", "Todavía no está implementado."},
			{"general.notLoged", "Tienes que tener la session iniciada para esta acción."},
			{"general.noPermission", "No tienes privilegios para esa acción."},
			{"userList.mainSection","Ha habido un problema cargando la lista de usuarios."},
			{"user.mainSection","Ha habido un problema cargando el usuario."},
	};
}
