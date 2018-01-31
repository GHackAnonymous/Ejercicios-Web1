package controlador;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.model.User;
import dominio.news.dao.NewsItemFacade;
import dominio.news.model.NewsItem;

/**
 * Servlet implementation class NewsItem
 */
@WebServlet("/NewsItemEdit")
public class NewsItemEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsItemEdit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// Set charset for request
		response.setCharacterEncoding("UTF-8");// Set charset for response
		String dispatchURL = "/NewsItemView";
		boolean redirect = false;
		NewsItemFacade nif = new NewsItemFacade();
		
		// Get the user from the session
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		//Get action parameter from request and initialize variables
		String action = request.getParameter("action");
		if(action==null){ action="new"; }
		
		//Try to get the user from the request (newsItemId)
		NewsItem requestNewsItem = null;
		String newsItemIdStr = request.getParameter("newsItemId");
		int newsItemId;
		if(newsItemIdStr != null && !newsItemIdStr.equals("")){
			// if there is a user id in the request, load it
			newsItemId = Integer.parseInt(newsItemIdStr);
			requestNewsItem = nif.loadNewsItem(newsItemId);
		}
		
		//if the user is not loged, they have no permission to performs these actions
		if(sessionUser!=null){
		// Perform different actions depending on the request
			switch(action){
			case "delete":
				if(requestNewsItem!=null){
					nif.deleteNewsItem(requestNewsItem.getNewsItemId());
					request.setAttribute("message","newsItemEdit.edit");
				}else{
					request.setAttribute("error","newsItemEdit.noNewsItem");
				}
				break;
			case "edit":
				if(requestNewsItem!=null){
					request.setAttribute("newsItem", requestNewsItem);
					dispatchURL="/pages/newsItemForm.jsp";
				}else{
					request.setAttribute("error","newsItemEdit.noNewsItem");
				}
				break;
			case "new":
				request.setAttribute("newsItem", null);
				dispatchURL="/pages/newsItemForm.jsp";
				break;
			case "save":
				Locale locale;
				NewsItem editNewsItem = new NewsItem();
				String newNewsItemId = request.getParameter("newsItemId");
				if(newNewsItemId!=null && !newNewsItemId.equals(""))
					editNewsItem.setNewsItemId(Integer.parseInt(newNewsItemId));
				editNewsItem.setTitle(request.getParameter("title"));
				editNewsItem.setBody(request.getParameter("body"));
				
				String localeStr = request.getParameter("lang");
				if(localeStr!=null && !localeStr.equals("")){
					localeStr = localeStr.replace("_","-");
					locale = Locale.forLanguageTag(localeStr);
				}else{
					locale = request.getLocale();
				}
				//Object lang = request.getSession().getAttribute("javax.servlet.jsp.jstl.fmt.locale.session");
				editNewsItem.setLang(locale);
				editNewsItem.setAuthor(sessionUser);
				
				
				if(nif.saveNewsItem(editNewsItem)){
					//request.setAttribute("message", "editUser.successful");
					dispatchURL = "NewsItemView?message=editUser.successful";
				}else{
					//request.setAttribute("error", "newUser.failed");
					dispatchURL = "NewsItemView?error=newUser.failed";
				}
				redirect=true;
				
			default:
			}
		}else{
			request.setAttribute("error", "general.noPermission");
			dispatchURL="/index.jsp";
		}
		if(redirect){
			response.sendRedirect(response.encodeRedirectURL(dispatchURL));
		}else{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatchURL);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
