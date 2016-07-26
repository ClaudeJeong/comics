package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.BookDao;
import mypkg.model.Member;
import mypkg.model.MemberDao;

public class BookUpdateFormController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookcode = Integer.parseInt( request.getParameter("bookcode") );
		BookDao bkdao = new BookDao() ;
		Book bean = bkdao.SelectDataByPk(bookcode) ;
		
		request.setAttribute( "bean", bean ); 
		String url = "/book/bkUpdateForm.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
	}

}
