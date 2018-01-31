package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.dao.UserFacade;
import domain.user.model.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// Set charset for request
		response.setCharacterEncoding("UTF-8");// Set charset for response
		String dispatchURL = "/index.jsp";
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		//Get parameters from request and initialize variables
		//String action = request.getParameter("action");
		String userIdStr = request.getParameter("userId");
		int userId = 0;
		User user = null;
		UserFacade uf = new UserFacade();

		if(userIdStr != null && !userIdStr.equals("")){
			userId = Integer.parseInt(userIdStr);
			user = uf.loadUser(userId);
		}

		//if the user is not loged, they have no permission to performs these actions
		if(sessionUser!=null){
			if(user != null){
				// Show info about selected user
				request.setAttribute("user", user);
				dispatchURL="/pages/user.jsp";
			}else{
				// Show user list
				ArrayList<User> users = uf.loadUsers();
				request.setAttribute("users", users);
				dispatchURL="/pages/userList.jsp";
			}
		}else{
			request.setAttribute("error", "general.noPermission");
			dispatchURL = "/index.jsp";
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
