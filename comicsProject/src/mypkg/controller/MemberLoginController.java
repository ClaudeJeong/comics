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
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDao mDao = new MemberDao();
		Member bean = mDao.selectByPk(id);
		String message = "";
		String url = "";
		if (bean.getId() == null) { // id가 없는 경우
			//System.out.println("아이디없음");
			message = "아이디와 비밀번호를 확인해주세요";
			request.setAttribute("message", message);
			url = "main.jsp";
		} else {
			if (bean.getPassword().equals(password)) { // 아이디 있고 패스워드가 일치하는 경우
				HttpSession session = request.getSession();
				session.setAttribute("loginfo", bean);
				message = bean.getId() + "님 환영합니다^^";
				request.setAttribute("message", message);
				url = "main.jsp";
				//System.out.println("로그인성공");
			} else { // 패스워드 일치하지 않는 경우
				message = "아이디와 비밀번호를 확인해주세요";
				request.setAttribute("message", message);
				url = "main.jsp";
				//System.out.println("패스워드 틀림");
			}
		}

		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
	}

}
