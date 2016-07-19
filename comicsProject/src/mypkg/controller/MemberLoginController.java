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

		String url = "";
		if (bean.getId() == null) { // id�� ���� ���
			System.out.println("���̵����");
			url = "";
		} else {
			if (bean.getPassword().equals(password)) { // ���̵� �ְ� �н����尡 ��ġ�ϴ� ���
				HttpSession session = request.getSession();
				session.setAttribute("loginfo", bean);
				url = "main.jsp";
				System.out.println("�α��μ���");
			} else { // �н����� ��ġ���� �ʴ� ���
				url = "main.jsp";
				System.out.println("�н����� Ʋ��");
			}
		}

		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
	}

}
