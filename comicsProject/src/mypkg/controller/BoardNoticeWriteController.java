package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Board;
import mypkg.model.BoardDao;

public class BoardNoticeWriteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String writer = request.getParameter("writer");
		String boardtype = request.getParameter("boardtype");
		String content = request.getParameter("content");
		
		Board bean = new Board();
		bean.setBoardType(boardtype);
		bean.setContent(content);
		bean.setPassword(password);
		bean.setSubject(subject);
		bean.setWriter(writer);
		
		BoardDao bDao = new BoardDao();
		int cnt = -99999;
		cnt = bDao.insertData(bean);
		
		new BoardListController().doProcess(request, response);
		
	}

}
