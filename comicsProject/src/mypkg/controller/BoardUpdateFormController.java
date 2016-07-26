package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Board;
import mypkg.model.BoardDao;
import mypkg.util.FlowParameters;

public class BoardUpdateFormController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		FlowParameters parameters = new FlowParameters();
		parameters.setKeyword(request.getParameter("keyword"));
		parameters.setMode(request.getParameter("mode"));
		parameters.setPageNumber(request.getParameter("pageNumber"));
		parameters.setPageSize(request.getParameter("pageSize"));
		BoardDao bDao = new BoardDao();
		Board bean = bDao.selectDataByPk(no);
		
		request.setAttribute("bean", bean);
		request.setAttribute("parameters", parameters);
		String url="/board/boNoticeUpdateForm.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
	}

}
