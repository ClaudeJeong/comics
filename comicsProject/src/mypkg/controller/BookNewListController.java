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
public class BookNewListController implements SuperController{
	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookDao bkdao = new BookDao();
		
		String month = "'2016/07/01' and '2016/07/31'";
		
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");

		FlowParameters parameters = new FlowParameters();
		parameters.setPageNumber(pageNumber);
		parameters.setPageSize(pageSize);
		
		int totalCount = bkdao.SelectTotalCount(month);
		System.out.println("토탈 카운터 : " + totalCount);
		
		String contextPath = request.getContextPath();
		String myurl =  contextPath + "/ComicsCtrl?command=bkNewList";
		
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, myurl);
		
		List<Book> lists = bkdao.SelectNewDataList(pageInfo.getBeginRow(), pageInfo.getEndRow(), month);
		
		request.setAttribute("lists", lists); //표로 보여지는 컬렉션
		
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		request.setAttribute("parameters", parameters.toString());
		
		
		String url = "/book/bkNewList.jsp?" + parameters.toString();
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}