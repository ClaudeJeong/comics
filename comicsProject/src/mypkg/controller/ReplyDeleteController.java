package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.ReplyDao;

public class ReplyDeleteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int reNum = Integer.parseInt(request.getParameter("renum"));
		ReplyDao rDao = new ReplyDao();
		int cnt = -99999;
		cnt = rDao.DeleteData(reNum);
		
		new BoardNoticeDetailController().doProcess(request, response);
	}

}
