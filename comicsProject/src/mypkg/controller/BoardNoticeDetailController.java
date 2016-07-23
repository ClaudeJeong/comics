package mypkg.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.model.Board;
import mypkg.model.BoardDao;
import mypkg.model.Member;
import mypkg.util.FlowParameters;

public class BoardNoticeDetailController implements SuperController {

	@SuppressWarnings("unused")
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mode = request.getParameter("mode"); //최초시작시 모드가 안넘어온다.
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
		String no = request.getParameter("no");
		//System.out.println(no);
		BoardDao bDao = new BoardDao();
		Board bean = bDao.selectDataByPk(no);
		String url = "" ;
		HttpSession session = request.getSession();
		Member mbean = (Member)session.getAttribute("loginfo");
		
		
		if( mbean != null){ //상세 보기로 이동
			if(!mbean.getNickname().equals(bean.getWriter())){
				bDao.UpdateReadhit(no) ; //조회수 업데이트 
				request.setAttribute("bean", bean);
				url = "/board/boNoticeView.jsp";
				request.setAttribute("mode", mode);
				request.setAttribute("keyword", keyword);
				request.setAttribute("parameters", parameters.toString());
			}else{
				request.setAttribute("bean", bean);
				url = "/board/boNoticeView.jsp";
				request.setAttribute("mode", mode);
				request.setAttribute("keyword", keyword);
				request.setAttribute("parameters", parameters.toString());
			}
				
		}else{
			request.setAttribute("bean", bean);
			url = "/board/boNoticeView.jsp";
			request.setAttribute("mode", mode);
			request.setAttribute("keyword", keyword);
			request.setAttribute("parameters", parameters.toString());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
