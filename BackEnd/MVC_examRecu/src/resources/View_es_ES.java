package resources;

import java.util.ListResourceBundle;

public class View_es_ES extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
			// Header resources
			{"header.appName", "Aplicación Web de Noticias"},
			{"header.home", "Inicio"},
			{"header.users", "Usuarios"},
			{"header.user", "Usuario"},
			{"header.news", "Noticias"},
			// Languages
			{"language.en", "Inglés"},
			{"language.es", "Castellano"},
			{"language.eu", "Vasco"},
			// User properties
			{"userProp.userId", "ID de usuario"},
			{"userProp.username", "Nombre de usuario"},
			{"userProp.password", "Contraseña"},
			{"userProp.firstName", "Nombre"},
			{"userProp.secondName", "Apellido"},
			{"userProp.email", "Correo electrónico"},
			// News Item properties
			{"newsItemProp.newsItemId", "ID de la Noticia"},
			{"newsItemProp.title", "Título"},
			{"newsItemProp.body", "Cuerpo"},
			{"newsItemProp.author", "Autor"},
			{"newsItemProp.lang", "Idioma"},
			{"newsItemProp.date", "Fecha"},
			// faq Item properties
			{"faq.question", "Pregunta"},
			{"faq.answer", "Resuesta"},
			{"faq.title", "Preguntas frecuentes (FAQ):"},
			{"faq.create", "Crear FAQ:"},
			// News Item form
			{"newsItem.create", "Crear nueva Noticia"},
			{"newsItem.edit", "Crear nueva Noticia"},
			// Actions
			{"action.view", "Ver"},
			{"action.save", "Guardar"},
			{"action.edit", "Editar"},
			{"action.delete", "Eliminar"},
			{"action.login", "Iniciar session"},
			{"action.logout", "Cerrar session"},
			{"action.register", "Registrar"},
			{"action.newNewsItem", "Crear noticia"},
			
			// Others
			{"general.hi","¡Hola"},
	};

}
