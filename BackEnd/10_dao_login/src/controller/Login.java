package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.users.dao.LoginFacade;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
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
		
		boolean exists = false;
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);

		switch (action){
		case "login":
			//Test loggin
			LoginFacade lf = new LoginFacade();
			if(username!=null && password!=null){
				exists = lf.exists(username, password);
				System.out.println("Exists:"+exists);
			}
				
			//Save login in session
			if(exists){
				session.setAttribute("isLoged",true);
				request.setAttribute("message", "Successfully loged!");
			}else{
				session.setAttribute("isLoged", false);
				request.setAttribute("error", "Wrong username ("+username+") or password ("+password+").");
				request.setAttribute("username", username);
				request.setAttribute("password", password);
			}
			break;
		case "logout":
		default:
			session.setAttribute("isLoged", false);
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
