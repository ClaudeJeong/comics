package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.MemberDao;

public class MemberChangePassController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		MemberDao mDao = new MemberDao();
		int cnt = - 99999;
		cnt = mDao.changePassword(password, id, name);
		String message = "비밀번호가 변경되었습니다";
		request.setAttribute("message", message);
		String url = "/meView/meFindIdPassForm.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
	}

}
