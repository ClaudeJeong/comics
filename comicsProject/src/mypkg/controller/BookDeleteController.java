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
		
		//�뿩���� ��Ȳ���� ���������� �Ұ����ϴ�.
		int bookcode = Integer.parseInt(request.getParameter("bookcode"));
		//String bookstat = request.getParameter("bookstat");
		

		//DAO ��ü�� �����Ѵ�.
		BookDao bkdao = new BookDao();
		int cnt = -99999 ; 
		//Bean ��ü�� �̿��Ͽ� �ش� �Խù��� �߰��Ѵ�.
		cnt = bkdao.bookDelete(bookcode) ;
		
		//�󼼺���� �����̷��ǽ�Ų��.
		new BookDetailViewController().doProcess(request, response);	
	}
}




