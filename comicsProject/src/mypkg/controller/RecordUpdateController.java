package mypkg.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.BookDao;
import mypkg.model.Record;
import mypkg.model.RecordDao;

import com.oreilly.servlet.MultipartRequest;
public class RecordUpdateController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int bcode = Integer.parseInt(request.getParameter("bcode"));
				
		//DAO ��ü�� �����Ѵ�.
		RecordDao rcdao = new RecordDao();
		
		int cnt = -99999 ; 
		cnt = rcdao.UpdateData(bcode) ;
		
		//�����̷��ǽ�Ų��.
		new RecordManageDetailController().doProcess(request, response);	
	}
}




