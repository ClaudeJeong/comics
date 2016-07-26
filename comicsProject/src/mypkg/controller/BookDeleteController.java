package mypkg.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.BookDao;

import com.oreilly.servlet.MultipartRequest;
public class BookDeleteController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//대여중인 상황에는 도서삭제가 불가능하다.
		int bookcode = Integer.parseInt(request.getParameter("bookcode"));
		//String bookstat = request.getParameter("bookstat");
		

		//DAO 객체를 생성한다.
		BookDao bkdao = new BookDao();
		int cnt = -99999 ; 
		//Bean 객체를 이용하여 해당 게시물을 추가한다.
		cnt = bkdao.bookDelete(bookcode) ;
		
		//상세보기로 리다이렉션시킨다.
		new BookDetailViewController().doProcess(request, response);	
	}
}




