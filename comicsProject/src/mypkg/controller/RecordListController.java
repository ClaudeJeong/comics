package mypkg.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.JoinRecord02;
import mypkg.model.RecordDao;
import mypkg.util.Paging;
public class RecordListController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("하하");
		RecordDao rcdao = new RecordDao();
		
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

		int totalCount = rcdao.selectTotalCount("records", mode, "%" + keyword + "%");
		System.out.println("토탈 카운터 : " + totalCount);
		
		String contextPath = request.getContextPath();
		String myurl =  contextPath + "/ComicsCtrl?command=rcList";
		
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, myurl, mode, keyword);
		
		List<JoinRecord02> lists = rcdao.SelectDataList(pageInfo.getBeginRow(), pageInfo.getEndRow(), mode, "%" + keyword + "%");
		
		request.setAttribute("lists", lists);
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		
		String url = "/record/rcList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}