package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.BoardDao;

public class BoardDeleteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao bDao = new BoardDao();
		int cnt = -99999;
		cnt = bDao.deleteData(no);
		String message="게시글이 삭제 되었습니다.";
		request.setAttribute("message", message);
		
		new BoardListController().doProcess(request, response);
		
	}

}
