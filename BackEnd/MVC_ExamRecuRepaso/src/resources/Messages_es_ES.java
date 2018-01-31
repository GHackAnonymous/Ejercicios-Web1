package resources;

import java.util.ListResourceBundle;

public class Messages_es_ES  extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			{"login.successful", "¡Ya has iniciado la sesión!"},
			{"logout.successful", "¡Ya has cerrado la sesión!"},
			{"newUser.successful", "¡El usuario ha sido registrado!"},
			{"editUser.successful", "El usuario ha sido modificado."},
			{"newNewsItem.successful", "¡La noticia ha sido guardada!"},
			{"editNewItem.successful", "La noticia ha sido modificada."},
	};
}
