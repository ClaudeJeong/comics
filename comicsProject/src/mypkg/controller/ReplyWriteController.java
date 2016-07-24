package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Reply;
import mypkg.model.ReplyDao;

public class ReplyWriteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		int boNum = Integer.parseInt(request.getParameter("no"));
		String content = request.getParameter("reply");
		String writer = request.getParameter("writer");
		
		Reply bean = new Reply();
		bean.setBoNum(boNum);
		bean.setWriter(writer);
		bean.setContent(content);
		//System.out.println(bean.toString());
		ReplyDao rDao = new ReplyDao();
		int	cnt = -99999;
		cnt = rDao.InsertData(bean);
		
		//댓글을 가지고 와서 NoticeDetail컨트롤러로 넘긴다.
		//request.setAttribute("rbean", bean);
		new BoardNoticeDetailController().doProcess(request, response);
		
	}

}
