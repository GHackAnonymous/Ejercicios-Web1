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
 * Servlet implementation class UserEdit
 */
@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEdit() {
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
		UserFacade uf = new UserFacade();
		
		// Get the user from the session
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		//Get action parameter from request and initialize variables
		String action = request.getParameter("action");
		if(action==null){ action="view"; }
		
		//Try to get the user from the request (userId)
		User requestUser = null;
		String userIdStr = request.getParameter("userId");
		int userId;
		if(userIdStr != null && !userIdStr.equals("")){
			// if there is a user id in the request, load it
			userId = Integer.parseInt(userIdStr);
			requestUser = uf.loadUser(userId);
		}
		
		//if the user is not loged, they have no permission to performs these actions
		if(sessionUser!=null){
		// Perform different actions depending on the request
			switch(action){
			case "delete":
				if(requestUser!=null){
					uf.deleteUser(requestUser.getUserId());
					request.setAttribute("message","general.edit");
				}else{
					request.setAttribute("error","userEdit.noUser");
				}
				dispatchURL ="/UserInfo";
				break;
			case "edit":
				if(requestUser!=null){
					request.setAttribute("user", requestUser);
					dispatchURL="/pages/userForm.jsp";
				}else{
					request.setAttribute("error","userEdit.noUser");
					dispatchURL ="/UserInfo";
				}
				break;
			case "new":
				request.setAttribute("user", null);
				dispatchURL="/pages/userForm.jsp";
				break;
			case "save":
				User editUser = new User();
				String newUserIdStr = request.getParameter("userId");
				editUser.setUserId(Integer.parseInt(newUserIdStr));
				editUser.setEmail(request.getParameter("email"));
				editUser.setFirstName(request.getParameter("firstName"));
				editUser.setSecondName(request.getParameter("secondName"));
				editUser.setPassword(request.getParameter("password"));
				editUser.setUsername(request.getParameter("username"));
				if(uf.saveUser(editUser)){
					request.setAttribute("message", "editUser.successful");
					//If the edited user is the same as the loged one, update the session user
					if(sessionUser.getUserId() == editUser.getUserId())
						request.getSession().setAttribute("user", editUser);
				}else{
					request.setAttribute("error", "newUser.failed");
				}
				
			default:
				dispatchURL="/UserInfo";
			}
		}else{
			request.setAttribute("error", "general.noPermission");
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
