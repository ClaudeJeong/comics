package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;
import mypkg.util.FlowParameters;
import mypkg.util.Paging;

public class MemberListController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDao mDao = new MemberDao(); 
		String mode = request.getParameter("mode"); //���ʽ��۽� ��尡 �ȳѾ�´�.
		//System.out.println(mode);
		if(mode == null || mode.equals("null") || mode.equals("") ){
			mode = "all";
			//System.out.println(mode);
		}
		
		String keyword = request.getParameter("keyword");
		//System.out.println(keyword);
		if(keyword == null || keyword.equals("null")){
			keyword = "";
			//System.out.println(mode);
		}
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");
		
		FlowParameters parameters = new FlowParameters();
		parameters.setKeyword(keyword);
		parameters.setMode(mode);
		parameters.setPageNumber(pageNumber);
		parameters.setPageSize(pageSize);
		
		int totalCount = mDao.selectTotalCount(mode, keyword + "%");
		
		String contextPath = request.getContextPath();
		String myurl = contextPath + "/ComicsCtrl?command=meList";
		
		Paging pageInfo = new Paging(
										pageNumber, 
										pageSize, 
										totalCount, 
										myurl, 
										mode, 
										keyword );
		
		List<Member> lists = mDao.SelectDataList(pageInfo.getBeginRow(), pageInfo.getEndRow()
				,mode, keyword + "%");
		
		request.setAttribute("lists", lists); //ǥ�� �������� �÷���
		
		//����¡ ���� �׸��
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		
		//���� �׸���� �˻� �ʵ��� ���� ���� �����ϱ� ���Ͽ� ����
		request.setAttribute("mode", mode);
		request.setAttribute("keyword", keyword);
		
		//�󼼺���, ����, ����, ��� ���� ��ũ�� ���� �Ķ���� ����Ʈ ���ڿ�
		request.setAttribute("parameters", parameters.toString());
		
		String url="/meView/meList.jsp?" + parameters.toString(); 
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
	}

}
