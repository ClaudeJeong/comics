package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberLoginController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDao mDao = new MemberDao();
		Member bean = mDao.SelectDataByPk(id);
		String url = null;
		String message="";
		if(bean == null){
			url = "member/MemberLogin.jsp";
			message = "아이디나 비번이 틀러요.";
		}else{
			if(password.equals(bean.getPassword())){
				url="main.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("loginfo", bean);
				session.setAttribute("logid", bean.getId());
			}else{
			url = "member/MemberLogin.jsp";
			message = "아이디나 비번이 틀러요.";
			}
		}
		request.setAttribute("errmsg", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
