package mypkg.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Board;
import mypkg.model.BoardDao;
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
		
		// 1) bean.getWriter() : 작성자의 아이디 
		// 2) 세션의 loginfo의 id
		// 1)번과 2)번이 다르면 조회수 1증가
		
		/*String imsi1 = bean.getContent();
		//System.out.println(imsi1);
		//System.out.println("=======================================");
		StringTokenizer token = new StringTokenizer(imsi1, "#");
		//int i = 1;
		//while(token.hasMoreTokens()){
		imsi1 = token.nextToken();
		StringTokenizer token2 = new StringTokenizer(imsi1, "#");
		imsi1 = token2.nextToken("&");
		imsi1 += "\">";
		while(token.hasMoreTokens()){
			imsi1 += token.nextToken();
		}
		System.out.println(imsi1);
		bean.setContent(imsi1);*/
		//}
		//&#10; 부터 까지 both;  짜르고 ">를 붙인다.
		
		
		if( bean != null){ //상세 보기로 이동
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
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}

}
