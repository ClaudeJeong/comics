package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;
import mypkg.util.Paging;

public class MemberListController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = new MemberDao();
		
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");
		int totalCount = 54;
		
		String contextPath = request.getContextPath();
		String myurl = contextPath + "/comics?command=MemberListResult";
		String mode = null;
		String keyword = null;
		
		Paging pageInfo = new Paging(
										pageNumber, 
										pageSize, 
										totalCount, 
										myurl, 
										mode, 
										keyword );
		
		List<Member> lists = mdao.SelectDataList(pageInfo.getBeginRow(), pageInfo.getEndRow());
		request.setAttribute("lists", lists);
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		
		String gotoPage = "/member/MemberListResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotoPage);
		dispatcher.forward(request, response);
	}

}
