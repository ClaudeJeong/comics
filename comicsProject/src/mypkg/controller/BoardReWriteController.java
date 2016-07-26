package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import mypkg.model.Board;
import mypkg.model.BoardDao;

public class BoardReWriteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi") ;
				
				Board bean = new Board();
				String content = multi.getParameter("content");	
				String writer = multi.getParameter("writer");
				String image = multi.getFilesystemName("image");
				String boardType = multi.getParameter("boardtype");
				String subject = multi.getParameter("subject");
				
				bean.setContent(content);
				bean.setBoardType(boardType);
				bean.setImage(image);
				bean.setSubject(subject);
				bean.setWriter(writer);
				
				//DAO 객체를 생성한다.
				BoardDao bDao = new BoardDao();				
				int cnt = -99999 ; 
				
				//Bean 객체를 이용하여 해당 게시물을 추가한다.
				cnt = bDao.insertData(bean);
				
				//목록 보기로 리다이렉션시킨다.
				new BoardReviewListController().doProcess(request, response);	
			}
	}


