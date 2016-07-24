package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.model.Board;
import mypkg.model.BoardDao;
import mypkg.model.Member;
import mypkg.model.Reply;
import mypkg.model.ReplyDao;
import mypkg.util.FlowParameters;
import mypkg.util.ReplyPaging;

public class BoardNoticeDetailController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		//System.out.println(parameters);
		
		int no = 0;
		no = Integer.parseInt(request.getParameter("no"));	
		BoardDao bDao = new BoardDao();
		Board bean = bDao.selectDataByPk(no);
		String url = "" ;
		HttpSession session = request.getSession();
		
		
		//��� �����ֱ�
		//Reply rbean = request.getParameter("rbean");
		//int bonum = rbean.getBoNum();
		String rePageNum = request.getParameter("repageNumber");
		String rePageSize = request.getParameter("repageSize");
		ReplyDao rDao = new ReplyDao();
		int totalCount = rDao.selectTotalCount(no);
		//System.out.println(totalCount);
		//����������
		//&pageNumber=3&pageSize=10&mode=all&keyword=&
			
		String contextPath = request.getContextPath();
		String myurl = contextPath + "/ComicsCtrl?command=boNoticeDetail&pageNumber="+pageNumber+"&pageSize="+pageSize;
			   myurl += "&mode="+mode+"&keyword="+keyword+"&";
		ReplyPaging pageInfo = new ReplyPaging(
										rePageNum, 
										rePageSize, 
										totalCount, 
										myurl,
										no);
		List<Reply> lists = rDao.SelectDataList(pageInfo.getBeginRow(), pageInfo.getEndRow(), no);
		request.setAttribute("lists", lists);
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("mode", mode);
		request.setAttribute("keyword", keyword);
		request.setAttribute("parameters", parameters.toString());
		request.setAttribute("bean", bean);
		//�� ����� �̵�
		Member mbean = (Member)session.getAttribute("loginfo");
		if( mbean != null){ 
			if(!mbean.getNickname().equals(bean.getWriter())){
				bDao.UpdateReadhit(no) ; //��ȸ�� ������Ʈ 
				url = "/board/boNoticeView.jsp";
			}else{
				url = "/board/boNoticeView.jsp";
			}
		}else{
			url = "/board/boNoticeView.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
