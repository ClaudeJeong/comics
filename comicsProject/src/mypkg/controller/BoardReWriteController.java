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
				
				//DAO ��ü�� �����Ѵ�.
				BoardDao bDao = new BoardDao();				
				int cnt = -99999 ; 
				
				//Bean ��ü�� �̿��Ͽ� �ش� �Խù��� �߰��Ѵ�.
				cnt = bDao.insertData(bean);
				
				//��� ����� �����̷��ǽ�Ų��.
				new BoardReviewListController().doProcess(request, response);	
			}
	}


