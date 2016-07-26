package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.MemberDao;
import mypkg.model.RecordDao;
import mypkg.model.Zipcode;

public class RecordBookSearchController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		List<Book> lists = null;
		RecordDao rcdao = new RecordDao();
		
		if(name != null){
			lists = rcdao.selectBookList(name);
		}
		
		request.setAttribute("lists", lists);
		
		String url = "/record/rcBookSearch.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
		
	}

}
