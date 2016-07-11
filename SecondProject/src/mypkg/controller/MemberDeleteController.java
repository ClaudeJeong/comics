package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.model.MemberDao;

public class MemberDeleteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("logid");
		MemberDao mDao = new MemberDao();

		int cnt = mDao.DeleteData(id);

		session.invalidate();
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/main.jsp");
		
	}

}
