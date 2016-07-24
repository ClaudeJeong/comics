package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Board;
import mypkg.model.BoardDao;
import mypkg.util.FlowParameters;

public class BoardNoticeUpdateController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		FlowParameters parameters = new FlowParameters();
		parameters.setKeyword(request.getParameter("keyword"));
		parameters.setMode(request.getParameter("mode"));
		parameters.setPageNumber(request.getParameter("pageNumber"));
		parameters.setPageSize(request.getParameter("pageSize"));
		
		Board bean = new Board();
		
		bean.setContent(content);
		bean.setSubject(subject);
		bean.setNo(no);
		
		BoardDao bDao = new BoardDao();
		int cnt = -99999;
		cnt = bDao.UpdateData(bean);
		
		String message = "게시물이 수정되었습니다";
		request.setAttribute("message", message);
		request.setAttribute("parameters", parameters);
		new BoardListController().doProcess(request, response);
		
	}

}
