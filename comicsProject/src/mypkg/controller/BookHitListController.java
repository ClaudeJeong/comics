package mypkg.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.BookDao;
import mypkg.util.FlowParameters;
import mypkg.util.Paging;
public class BookHitListController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookDao bkdao = new BookDao();
	
		String contextPath = request.getContextPath();
		String myurl =  contextPath + "/ComicsCtrl?command=bkHitList";
		
		List<Book> lists = bkdao.SelectHitDataList();
		
		request.setAttribute("lists", lists); //표로 보여지는 컬렉션
		
		String url = "/book/bkHitList.jsp?";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}