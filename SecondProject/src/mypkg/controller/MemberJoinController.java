package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberJoinController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao mDao = new MemberDao();
		Member bean = new Member();
		bean.setId(request.getParameter("id"));
		bean.setAddress1(request.getParameter("address1"));
		bean.setAddress2(request.getParameter("address2"));
		bean.setBirth(request.getParameter("birth"));
		bean.setEmail1(request.getParameter("email1"));
		bean.setEmail2(request.getParameter("email2"));	
		bean.setGender(request.getParameter("gender"));
		bean.setName(request.getParameter("name"));
		bean.setNickname(request.getParameter("nickname"));
		bean.setPassword(request.getParameter("password"));
		bean.setZipCode(request.getParameter("zipcode"));
		bean.setPhone1(request.getParameter("phone1"));
		bean.setPhone2(request.getParameter("phone2"));
		bean.setPhone3(request.getParameter("phone3"));

		int cnt = mDao.InsertData(bean);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/main.jsp");
	}

}
