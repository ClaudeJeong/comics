package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;
import mypkg.model.Record;
import mypkg.model.RecordDao;
import mypkg.util.Validator;


public class RecordInsertController implements SuperController {
	
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		int bcode =  Integer.parseInt(request.getParameter("bcode"));
		
		
		RecordDao rcdao = new RecordDao();
		
		int cnt = -99999;
		cnt = rcdao.InsertData(mid, bcode);
		
		//리다이렉션시킨다.
		new RecordManageDetailController().doProcess(request, response);
	}
	


}
