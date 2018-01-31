package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.advert.dao.AdvertItemFacade;
import modelo.AdvertModelo;

/**
 * Servlet implementation class advertController
 */
@WebServlet("/advertController")
public class advertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdvertModelo aM = new AdvertModelo();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		AdvertItemFacade aif = new AdvertItemFacade();
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession(true);
		String dispatchURL = "/pages/advertList.jsp";
		
		if(action != null){
			switch (action){
				case "insert":
					if(request.getParameter("title") != null) {
						aM.setTitle(request.getParameter("title"));
						aM.setSrc(request.getParameter("src"));
						aM.setAlt(request.getParameter("alt"));
						
						
						
						if(aif.saveAdvertModelo(aM)){
							request.setAttribute("message", "newUser.successful");
						}else{
							request.setAttribute("error", "newUser.failed");
						}
					}
				break;
				case "edit":
					System.out.println("PASA?");
					String asideTitleStr = request.getParameter("asideTitle");
					System.out.println(asideTitleStr);
					int titleId;
					AdvertModelo requestAM = null;
					if(asideTitleStr != null && !asideTitleStr.equals("")){
						System.out.println("PASA2?");
						titleId = Integer.parseInt(asideTitleStr);
						requestAM = aif.loadAdvertModelo(titleId);
					}
					
					if(requestAM!=null){
						System.out.println("PASA3?");
						request.setAttribute("user", requestAM);
						dispatchURL ="/pages/advertModi.jsp";
					}
					dispatchURL ="/pages/advertModi.jsp";
				break;
				case "delete":
				break;
				case "save":
					AdvertModelo editAdvert = new AdvertModelo();
					String asideTitleStr2 = request.getParameter("id");
					editAdvert.setId(Integer.parseInt(asideTitleStr2));
					editAdvert.setTitle(request.getParameter("title"));
					editAdvert.setSrc(request.getParameter("src"));
					editAdvert.setAlt(request.getParameter("alt"));
					if(aif.saveAdvertModelo(editAdvert)){
						request.setAttribute("message", "edit.successful");
					}else{
						request.setAttribute("error", "edit.failed");
					}
				break;
				default:
					
					
			}
			
		}

		ArrayList<AdvertModelo> lista = aif.loadAllAdvertModelos();
		
		request.setAttribute("advertLista", lista);
		
		System.out.println(dispatchURL);
		
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
