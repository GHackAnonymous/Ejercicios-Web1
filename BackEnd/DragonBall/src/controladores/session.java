package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class session
 */
@WebServlet("/session")
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String MyUser = "Eder";
		String MyPass = "1234";
		
		HttpSession session = request.getSession();
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		System.out.println(user);
		System.out.println(pass);
		System.out.println(session.getAttribute(user));
		
		
		if(session.getAttribute(user) != null && session.getAttribute(user).equals(MyUser)){  
	        //logout
			session.invalidate();
			session = null;
			
			session.setAttribute("error", "tienes que logearte");
			response.sendRedirect(response.encodeRedirectURL("index.jsp"));
	    } else if(session.getAttribute(user) == null){
	    	//login
	    	System.out.println("Pasa por sesion == null");
	    	if(user != null && pass != null){
	    		System.out.println("user != null y pass != null");
				if(user.equalsIgnoreCase(MyUser) && pass.equalsIgnoreCase(MyPass)){
					session.setAttribute("username", user);
					response.sendRedirect(response.encodeRedirectURL("ok.jsp"));	
				}else if(!user.equalsIgnoreCase(MyUser) && !pass.equalsIgnoreCase(MyPass)){
					session.setAttribute("error", "Wrong username or password");
					response.sendRedirect(response.encodeRedirectURL("index.jsp"));
				}
			}else if(user == null && pass == null){
				session.setAttribute("error", "tienes que logearte");
				response.sendRedirect(response.encodeRedirectURL("index.jsp"));
			}
	    }
	}

}
