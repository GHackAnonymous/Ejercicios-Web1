package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String password;
	private String username;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		username = request.getParameter("username");
		password = request.getParameter("userpass");
		if(username==null || password==null || username.equals("") || password.equals("")){
			session.setAttribute("error", "Please fill all fields");
			response.sendRedirect(response.encodeRedirectURL("index.jsp"));
		}else if(username.equals(password)){
			session.setAttribute("username", username);
			response.sendRedirect(response.encodeRedirectURL("ok.jsp"));
		}else{
			session.setAttribute("error", "Wrong username or password");
			response.sendRedirect(response.encodeRedirectURL("index.jsp"));
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
