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

import domain.faq.dao.FaqFacade;
import domain.faq.model.FaqModelo;
import domain.user.dao.UserFacade;
import domain.user.model.User;

/**
 * Servlet implementation class Faq
 */
@WebServlet("/Faq")
public class Faq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Faq() {
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
		
		
		// Get the user from the session
		HttpSession session = request.getSession(true);
		User sessionUser = (User) request.getSession().getAttribute("user");
		
		String action = request.getParameter("action");
		FaqFacade uf = new FaqFacade();
		
		if(action==null){ action="new"; }
		
		//Try to get the user from the request (newsItemId)
		FaqModelo requestfaqModelo = null;
		String faqModelodStr = request.getParameter("faqId");
		int faqModeloId;
		if(faqModelodStr != null && !faqModelodStr.equals("")){
			// if there is a user id in the request, load it
			faqModeloId = Integer.parseInt(faqModelodStr);
			requestfaqModelo = uf.loadFaq(faqModeloId);
		}
		
		
		
		if(action==null){ action="new"; }
		
		// Perform different actions depending on the request
		switch(action){
		case "delete":
			System.out.println("delete");
			System.out.println(requestfaqModelo);
			if(requestfaqModelo!=null){
				System.out.println(requestfaqModelo.getFaqId());
				uf.deleteFaq(requestfaqModelo.getFaqId());
				request.setAttribute("message","newsItemEdit.edit");
			}else{
				request.setAttribute("error","newsItemEdit.noNewsItem");
			}
			break;
		case "edit":
			System.out.println("edit");
			System.out.println(requestfaqModelo);
			if(requestfaqModelo!=null){
				request.setAttribute("faqItem", requestfaqModelo);
				dispatchURL="/pages/faqForm.jsp";
			}else{
				request.setAttribute("error","newsItemEdit.noNewsItem");
			}
			break;
		case "save":
			FaqModelo newFaq = new FaqModelo();
			newFaq.setQuestion(request.getParameter("question"));
			newFaq.setAnswer(request.getParameter("answer"));
			
			/*FaqModelo newFaqAux = (FaqModelo) session.getAttribute("faqItem");
			System.out.println(newFaqAux);
			FaqModelo newFaqAux2 = uf.loadFaq(newFaqAux.getQuestion(), newFaqAux.getAnswer());
			System.out.println(newFaqAux2);*/
			
			/*if(newFaqAux != null){
				if(uf.updateFaq(newFaq)){
					request.setAttribute("message", "newFaq.successful");
				}else{
					request.setAttribute("error", "newFaq.failed");
				}
			}else {
				*/if(uf.saveFaq(newFaq)){
					request.setAttribute("message", "newFaq.successful");
				}else{
					request.setAttribute("error", "newFaq.failed");
				}
			//}
			dispatchURL="/Faq?action=ver";
			break;
		case "ver":
			//Get parameters from request and initialize variables
			
			FaqModelo faqModelo = null;
			

			if(faqModelodStr != null && !faqModelodStr.equals("")){
				faqModeloId = Integer.parseInt(faqModelodStr);
				faqModelo = uf.loadFaq(faqModeloId);
			}

			if(faqModelo != null){
				// Show info about selected user
				System.out.print("paso1");
				request.setAttribute("faq", faqModelo);
				dispatchURL="/index.jsp";
			}else{
				// Show user list
				System.out.print("paso2");
				ArrayList<FaqModelo> faq = uf.loadFaqs();
				
				for(int i = 0; i< faq.size();i++) {
					System.out.print(faq.get(i).getFaqId()+" ");
					System.out.print(faq.get(i).getQuestion()+" ");
					System.out.print(faq.get(i).getAnswer()+" \n");
				}
				
				session.setAttribute("faq", faq);
				dispatchURL="/index.jsp";
			}
			break;
		case "new":
			request.setAttribute("user", null);
			dispatchURL="/pages/faqForm.jsp";
			
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
