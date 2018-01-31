package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.news.dao.NewsItemFacade;
import domain.news.model.NewsItem;

/**
 * Servlet implementation class NewsItem
 */
@WebServlet("/NewsItemView")
public class NewsItemView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsItemView() {
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
		
		//Get parameters from request and initialize variables
		String newsItemIdStr = request.getParameter("newsItemId");
		NewsItem newsItem = null;
		NewsItemFacade nif = new NewsItemFacade();

		if(newsItemIdStr != null && !newsItemIdStr.equals("")){
			int newsItemId = Integer.parseInt(newsItemIdStr);
			newsItem = nif.loadNewsItem(newsItemId);
		}

		if(newsItem != null){
			// Show info about selected user
			request.setAttribute("newsItem", newsItem);
			dispatchURL="/pages/newsItemView.jsp";
		}else{
			// Show user list
			ArrayList<NewsItem> news = nif.loadAllNewsItems();
			request.setAttribute("news", news);
			dispatchURL="/pages/newsItemList.jsp";
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
