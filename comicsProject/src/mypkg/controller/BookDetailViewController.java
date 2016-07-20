package mypkg.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.BookDao;

public class BookDetailViewController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int bookcode = Integer.parseInt( request.getParameter("bookcode") ) ;
		BookDao bkdao = new BookDao(); 
		Book bean  = bkdao.SelectDataByPk( bookcode );
		
		String url = "" ; 
		if( bean != null){ //상세 보기로 이동			 
			request.setAttribute("bean", bean);
			url = "/book/bkDetailView.jsp";			
		}else{
			url = "/book/bkList.jsp";
		}		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);				
	}
}