package mypkg.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.JoinRecord02;
import mypkg.model.RecordDao;
import mypkg.util.FlowParameters;
import mypkg.util.Paging;
public class RecordPersonalHistoryController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RecordDao rcdao = new RecordDao();
		
		String mid = request.getParameter("mid");
		System.out.println("이거 : " + mid);
		
		String mode = request.getParameter("mode");
		if(mode == null || mode.equals("null") || mode.equals("")){
			mode = "all";
		}else if(mode.equals("name")){
			mode = "bk.name";
		}
		String keyword = request.getParameter("keyword");
		if(keyword == null || keyword.equals("null")){
			keyword = "";
		}
		
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");

		FlowParameters parameters = new FlowParameters();
		parameters.setKeyword(keyword);
		parameters.setMode(mode);
		parameters.setPageNumber(pageNumber);
		parameters.setPageSize(pageSize);
		
		int totalCount = rcdao.selectTotalCount("records", mid, mode, "%" + keyword + "%");
		System.out.println("토탈 카운터 : " + totalCount);
		
		String contextPath = request.getContextPath();
		String myurl =  contextPath + "/ComicsCtrl?command=rcPersonalHistory";
		
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, myurl, mid, mode, keyword);
		
		List<JoinRecord02> lists = rcdao.SelectDataHistory(mid, pageInfo.getBeginRow(), pageInfo.getEndRow(), mode, "%" + keyword + "%");
		
		request.setAttribute("lists", lists);
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		request.setAttribute("mode", mode);
		request.setAttribute("keyword", keyword);
		request.setAttribute("parameters", parameters.toString());
		
		
		String url = "/record/rcPersonalHistory.jsp?" + parameters.toString();
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}