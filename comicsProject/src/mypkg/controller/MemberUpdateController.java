package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberUpdateController implements SuperController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDao mDao = new MemberDao();
		Member bean = new Member();
		bean.setAddress1(request.getParameter("address1"));
		bean.setAddress2(request.getParameter("address2"));
		bean.setBirth(request.getParameter("birth"));
		bean.setEmail1(request.getParameter("email1"));
		if(request.getParameter("email2").equals("selfwrite") || request.getParameter("email2").equals("all")){
			bean.setEmail2(request.getParameter("email3"));
		}else{
			bean.setEmail2(request.getParameter("email2"));
		}
		bean.setNickname(request.getParameter("nickname"));
		bean.setPassword(request.getParameter("password1"));
		bean.setPhone1(request.getParameter("phone1"));
		bean.setPhone2(request.getParameter("phone2"));
		bean.setPhone3(request.getParameter("phone3"));
		bean.setZipcode(request.getParameter("zipcode"));
		bean.setId(request.getParameter("id1"));
		
		int cnt = -99999;
		cnt = mDao.updateData(bean);
		String message = "정보가 수정되었습니다" + "<br>" + "다시 로그인 해주세요";
		request.setAttribute("message", message);
		HttpSession session = request.getSession();
		session.invalidate();
		String url="main.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
