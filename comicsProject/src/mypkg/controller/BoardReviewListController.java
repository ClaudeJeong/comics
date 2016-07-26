package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypkg.model.Board;
import mypkg.model.BoardDao;
import mypkg.util.FlowParameters;
import mypkg.util.Paging;

public class BoardReviewListController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDao bDao = new BoardDao();
		
		String mode = request.getParameter("mode"); //���ʽ��۽� ��尡 �ȳѾ�´�.
		if(mode == null || mode.equals("null") || mode.equals("") ){
			mode = "all";
		}
		
		String keyword = request.getParameter("keyword");
		if(keyword == null || keyword.equals("null")){
			keyword = "";
		}
		
		//System.out.println( mode + "/" + keyword );
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");
		
		FlowParameters parameters = new FlowParameters();
		parameters.setKeyword(keyword);
		parameters.setMode(mode);
		parameters.setPageNumber(pageNumber);
		parameters.setPageSize(pageSize);
		//System.out.println(parameters.toString());
		String boardType ="����";
		int totalCount = bDao.selectTotalCount(mode, keyword + "%", boardType); //1008
		//System.out.println("��Ż ī���� : " + totalCount);
		
		String contextPath = request.getContextPath();
		//System.out.println("���佺 : " + contextPath);
		String myurl = contextPath + "/ComicsCtrl?command=boReList";
		//System.out.println("myurl : " + myurl );
		Paging pageInfo = new Paging(
										pageNumber, 
										pageSize, 
										totalCount, 
										myurl, 
										mode, 
										keyword );
		
		List<Board> lists = bDao.SelectDataList(pageInfo.getBeginRow(), pageInfo.getEndRow()
				,mode, keyword + "%", boardType);
		
		request.setAttribute("lists", lists); //ǥ�� �������� �÷���
		
		//����¡ ���� �׸��
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		
		//���� �׸���� �˻� �ʵ��� ���� ���� �����ϱ� ���Ͽ� ����
		request.setAttribute("mode", mode);
		request.setAttribute("keyword", keyword);
		
		//�󼼺���, ����, ����, ��� ���� ��ũ�� ���� �Ķ���� ����Ʈ ���ڿ�
		request.setAttribute("parameters", parameters.toString());
		request.setAttribute("boardtype", boardType);
		//�޼��� �佺
		String message = (String)request.getAttribute("message");
		if(message == null || message.equals("null") || message.equals("") ){
			
		}else{
			request.setAttribute("message", message);
		}
		
		String url="/board/boReList.jsp?" + parameters.toString();
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}


