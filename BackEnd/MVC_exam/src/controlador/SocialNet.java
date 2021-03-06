package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.social.dao.SocialItemFacade;
import dominio.social.model.SocialItem;

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
		String dispatchURL = "/social.jsp";
		
		//Get parameters from request and initialize variables
		String socialItemIdStr = request.getParameter("socialItemId");
		SocialItem socialItem = null;
		SocialItemFacade nif = new SocialItemFacade();

		if(socialItemIdStr != null && !socialItemIdStr.equals("")){
			int socialItemId = Integer.parseInt(socialItemIdStr);
			socialItem = nif.loadSocialItem(socialItemId);
		}

		if(socialItem != null){
			// Show info about selected user
			request.setAttribute("socialItem", socialItem);
			dispatchURL="/pages/index.jsp";
		}else{
			// Show user list
			ArrayList<SocialItem> socials = nif.loadAllSocialItems();
			request.setAttribute("social", socialItem);
			dispatchURL="/pages/social.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatchURL);
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
