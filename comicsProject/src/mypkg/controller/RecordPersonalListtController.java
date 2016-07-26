package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.JoinRecord01;
import mypkg.model.JoinRecord02;
import mypkg.model.Member;
import mypkg.model.MemberDao;
import mypkg.model.Record;
import mypkg.model.RecordDao;
import mypkg.util.FlowParameters;
import mypkg.util.Paging;

public class RecordPersonalListtController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		
		RecordDao rcdao = new RecordDao();
		List<JoinRecord01> lists = rcdao.selectRcByMid(mid);
				
		request.setAttribute("lists", lists);		
	
		String url = "/record/rcPersonalList.jsp" ;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
