package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user.dao.UserFacade;
import domain.user.model.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		
		String action = request.getParameter("action");
		UserFacade uf = new UserFacade();
		
		if(action==null){ action="new"; }
		
		// Perform different actions depending on the request
		switch(action){
		case "save":
			User newUser = new User();
			newUser.setEmail(request.getParameter("email"));
			newUser.setFirstName(request.getParameter("firstName"));
			newUser.setSecondName(request.getParameter("secondName"));
			newUser.setPassword(request.getParameter("password"));
			newUser.setUsername(request.getParameter("username"));
			if(uf.saveUser(newUser)){
				request.setAttribute("message", "newUser.successful");
			}else{
				request.setAttribute("error", "newUser.failed");
			}
			dispatchURL="/index.jsp";
			break;
		case "new":
		default:
			request.setAttribute("user", null);
			dispatchURL="/pages/userForm.jsp";
			
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatchURL);
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
