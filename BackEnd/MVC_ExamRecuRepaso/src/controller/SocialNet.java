package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import domain.social.dao.SocialItemFacade;
import domain.social.model.SocialItem;
import domain.user.model.User;

/**
 * Servlet implementation class SocialNet
 */
@WebServlet("/SocialNet")
public class SocialNet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialNet() {
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
		String dispatchURL = "/index.jsp";
		boolean redirect = false;
		SocialItemFacade nif = new SocialItemFacade();
		
		// Get the user from the session
		HttpSession session = request.getSession(true);
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		//Get action parameter from request and initialize variables
		String action = request.getParameter("action");
		if(action==null){ action="new"; }
		
		//Try to get the user from the request (newsItemId)
		SocialItem requestSocialItem = null;
		String socialItemIdStr = request.getParameter("socialId");
		int socialItemId;
		if(socialItemIdStr != null && !socialItemIdStr.equals("")){
			// if there is a user id in the request, load it
			socialItemId = Integer.parseInt(socialItemIdStr);
			requestSocialItem = nif.loadSocialItem(socialItemId);
		}
		
		//if the user is not loged, they have no permission to performs these actions
		if(sessionUser!=null){
		// Perform different actions depending on the request
			switch(action){
			case "delete":
				System.out.println("delete");
				if(requestSocialItem!=null){
					nif.deleteNewsItem(requestSocialItem.getSocialId());
					request.setAttribute("message","newsItemEdit.edit");
				}else{
					request.setAttribute("error","newsItemEdit.noNewsItem");
				}
				break;
			case "edit":
				System.out.println("edit");
				if(requestSocialItem!=null){
					request.setAttribute("SocialItem", requestSocialItem);
					dispatchURL="/pages/newsItemForm.jsp";
				}else{
					request.setAttribute("error","newsItemEdit.noNewsItem");
				}
				break;
			case "new":
				request.setAttribute("SocialItem", null);
				dispatchURL="/pages/socialItemForm.jsp";
				break;
			case "ver":
				//Get parameters from request and initialize variables
				System.out.print("entro");
				SocialItem socialItem = null;
				

				if(socialItemIdStr != null && !socialItemIdStr.equals("")){
					socialItemId = Integer.parseInt(socialItemIdStr);
					socialItem = nif.loadSocialItem(socialItemId);
				}

				if(socialItem != null){
					// Show info about selected user
					System.out.print("paso1");
					request.setAttribute("social", socialItem);
					dispatchURL="/index.jsp";
				}else{
					// Show user list
					System.out.print("paso2");
					ArrayList<SocialItem> social = nif.loadAllSocialItems();
					
					for(int i = 0; i< social.size();i++) {
						System.out.print(social.get(i).getSocialId()+" ");
						System.out.print(social.get(i).getName()+" ");
						System.out.print(social.get(i).getLogoUrl()+" ");
						System.out.print(social.get(i).getSocialUrl()+" \n");
					}
					
					request.setAttribute("social", social);
					dispatchURL="/index.jsp";
				}
				break;
			case "save":
				SocialItem editSocialItem = new SocialItem();
				String newSocialItemId = request.getParameter("socialItemId");
				if(newSocialItemId!=null && !newSocialItemId.equals(""))
					editSocialItem.setSocialId(Integer.parseInt(newSocialItemId));
					editSocialItem.setName(request.getParameter("name"));
					editSocialItem.setLogoUrl(request.getParameter("logoUrl"));
					editSocialItem.setSocialUrl(request.getParameter("socialUrl"));
				
				
				
				if(nif.saveSocialItem(editSocialItem)){
					//request.setAttribute("message", "editUser.successful");
					dispatchURL = "SocialNet?action=ver";
				}else{
					//request.setAttribute("error", "newUser.failed");
					dispatchURL = "Socialnet?error=newSocial.failed";
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
