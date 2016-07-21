package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberDeleteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//추가 고민사항
			//책 대여중이면 삭제가 안되는 방법
			//아이디만 남기고 나머지 정보가 탈퇴함으로 교체
		HttpSession session = request.getSession();
		Member bean =  (Member)session.getAttribute("loginfo");
		String id = bean.getId();
		MemberDao mDao = new MemberDao();
		int cnt = - 99999;
		cnt = mDao.DeleteDate(id);
		session.invalidate();
		String message = "탈퇴하셨습니다 GoodBye";
		request.setAttribute("message", message);
		String url = "main.jsp";
		//response.sendRedirect( request.getContextPath() + url );
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
		
		
	}

}
