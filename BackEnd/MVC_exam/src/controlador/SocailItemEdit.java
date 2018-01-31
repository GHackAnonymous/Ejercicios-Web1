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
import dominio.social.dao.SocialItemFacade;
import dominio.social.model.SocialItem;

/**
 * Servlet implementation class SocailItemEdit
 */
@WebServlet("/SocailItemEdit")
public class SocailItemEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocailItemEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");// Set charset for request
		response.setCharacterEncoding("UTF-8");// Set charset for response
		String dispatchURL = "/SocailItemView";
		boolean redirect = false;
		SocialItemFacade nif = new SocialItemFacade();
		
		// Get the user from the session
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		//Get action parameter from request and initialize variables
		String action = request.getParameter("action");
		if(action==null){ action="new"; }
		
		//Try to get the user from the request (newsItemId)
		SocialItem requestSocialItem = null;
		String SocialItemIdStr = request.getParameter("socialId");
		int newsItemId;
		if(SocialItemIdStr != null && !SocialItemIdStr.equals("")){
			// if there is a user id in the request, load it
			newsItemId = Integer.parseInt(SocialItemIdStr);
			requestSocialItem = nif.loadSocialItem(newsItemId);
		}
		
		//if the user is not loged, they have no permission to performs these actions
		if(sessionUser!=null){
		// Perform different actions depending on the request
			switch(action){
			case "delete":
				if(requestSocialItem!=null){
					nif.deleteSocialItem(requestSocialItem.getSocialItemId());
					request.setAttribute("message","socialItemEdit.edit");
				}else{
					request.setAttribute("error","socialItemEdit.noNewsItem");
				}
				break;
			case "edit":
				if(requestSocialItem!=null){
					request.setAttribute("socialItem", requestSocialItem);
					dispatchURL="/pages/socialItemForm.jsp";
				}else{
					request.setAttribute("error","socialItemEdit.noSocialItem");
				}
				break;
			case "new":
				request.setAttribute("socialItem", null);
				dispatchURL="/pages/socialItemForm.jsp";
				break;
			case "save":
				SocialItem editSocialItem = new SocialItem();
				String newSocialItemId = request.getParameter("socialItemId");
				if(newSocialItemId!=null && !newSocialItemId.equals(""))
					editSocialItem.setSocialItemId(Integer.parseInt(newSocialItemId));
				editSocialItem.setName(request.getParameter("name"));
				editSocialItem.setLogoUrl(request.getParameter("logo"));
				editSocialItem.setLogoUrl(request.getParameter("logo"));
				editSocialItem.setSocialUrl(request.getParameter("url"));
				
				
				if(nif.saveSocialItem(editSocialItem)){
					//request.setAttribute("message", "editUser.successful");
					dispatchURL = "SocialItemView?message=editUser.successful";
				}else{
					//request.setAttribute("error", "newUser.failed");
					dispatchURL = "SocailItemView?error=newUser.failed";
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
