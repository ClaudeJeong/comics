package mypkg.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.BookDao;
import mypkg.model.JoinRecord;
import mypkg.model.RecordDao;
import mypkg.util.Paging;
public class RecordListController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RecordDao rcdao = new RecordDao();
		
		String mode = request.getParameter("mode");
		if(mode == null || mode.equals("null") || mode.equals("")){
			mode = "all";
		}
		String keyword = request.getParameter("keyword");
		if(keyword == null || keyword.equals("null")){
			keyword = "";
		}
		keyword += "%";
		
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");

		int totalCount = rcdao.SelectTotalCount(mode, keyword);
		System.out.println("ÅäÅ» Ä«¿îÅÍ : " + totalCount);
		
		String contextPath = request.getContextPath();
		String myurl =  contextPath + "/ComicsCtrl?command=rcList";
		
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, myurl, mode, keyword);
		
		List<JoinRecord> lists = rcdao.SelectDataList(pageInfo.getBeginRow(), pageInfo.getEndRow(), mode, keyword);
		
		request.setAttribute("lists", lists);
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		
		String url = "/record/rcList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}