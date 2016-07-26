package mypkg.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.BookDao;

import com.oreilly.servlet.MultipartRequest;
public class BookUpdateController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Book bean = new Book();
	
		int bookcode = Integer.parseInt(request.getParameter("bookcode"));
		String name = request.getParameter("name");
		int volume = Integer.parseInt(request.getParameter("volume"));
		String writer = request.getParameter("writer");
		String publisher = request.getParameter("publisher");		
		String pubdate = request.getParameter("pubdate");
		String genre = request.getParameter("genre");
		//String bookstat = request.getParameter("bookstat");
		String bookstory = request.getParameter("bookstory");
		
		bean.setBookcode(bookcode);
		bean.setName(name);
		bean.setVolume(volume);
		bean.setWriter(writer);
		bean.setPublisher(publisher);
		bean.setPubdate(pubdate);
		bean.setGenre(genre);
		bean.setBookstory(bookstory);

		//DAO ��ü�� �����Ѵ�.
		BookDao bkdao = new BookDao();
		int cnt = -99999 ; 
		//Bean ��ü�� �̿��Ͽ� �ش� �Խù��� �߰��Ѵ�.
		cnt = bkdao.UpdateData(bean) ;
		
		//��� ����� �����̷��ǽ�Ų��.
		new BookListController().doProcess(request, response);	
	}
}




