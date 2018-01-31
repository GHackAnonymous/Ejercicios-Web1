package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.user.dao.UserFacade;
import domain.user.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get parameters from the request
				String action = request.getParameter("action");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				HttpSession session = request.getSession(true);
				
				User user = null;
				System.out.println("Username: "+username);
				System.out.println("Password: "+password);

				switch (action){
				case "login":
					//Test loggin
					UserFacade uf = new UserFacade();
					if(username!=null && password!=null){
						user = uf.loadUser(username, password);
					}
						
					//Save login in session
					if(user != null){
						System.out.println("Username:"+user.getUsername());
						session.setAttribute("user",user);
						request.setAttribute("message", "Successfully loged!");
					}else{
						System.out.println("No user loaded");
						session.setAttribute("user", null);
						request.setAttribute("error", "Wrong username ("+username+") or password ("+password+").");
						request.setAttribute("username", username);
						request.setAttribute("password", password);
					}
					break;
				case "logout":
				default:
					session.setAttribute("user", null);
					request.setAttribute("message", "You loged out.");
				}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
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
