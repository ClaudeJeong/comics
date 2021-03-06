package mypkg.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Book;
import mypkg.model.BookDao;
import mypkg.util.FlowParameters;
import mypkg.util.Paging;
public class BookListController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookDao bkdao = new BookDao();
		
		String mode = request.getParameter("mode");
		if(mode == null || mode.equals("null") || mode.equals("")){
			mode = "all";
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
		
		int totalCount = bkdao.SelectTotalCount(mode, "%" + keyword + "%");
		System.out.println("토탈 카운터 : " + totalCount);
		
		String contextPath = request.getContextPath();
		String myurl =  contextPath + "/ComicsCtrl?command=bkList";
		
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, myurl, mode, keyword);
		
		List<Book> lists = bkdao.SelectDataList(pageInfo.getBeginRow(), pageInfo.getEndRow(), mode, "%" + keyword + "%");
		
		request.setAttribute("lists", lists); //표로 보여지는 컬렉션
		
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		request.setAttribute("mode", mode);
		request.setAttribute("keyword", keyword);
		request.setAttribute("parameters", parameters.toString());
		
		
		String url = "/book/bkList.jsp?" + parameters.toString();
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}