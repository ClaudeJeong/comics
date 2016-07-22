package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberFindIdController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberDao mDao = new MemberDao();
		List<Member> lists = mDao.selectByName(name);
		System.out.println("����Ʈ" + lists); 
		String message="";
		if(lists.size() == 0 ){
			message="�̸��� �̸����� Ȯ�����ּ���";
			request.setAttribute("message", message);
		}else{
		for (Member bean : lists) {
			String mail = bean.getEmail1() +"@" + bean.getEmail2();
			System.out.println(mail.equals(email));
			System.out.println(bean.getName().equals(name));
			if(bean.getName().equals(name) && (bean.getEmail1() +"@" + bean.getEmail2()).equals(email)){
				//��ġ�ϴ� ���
				message = bean.getId();
				request.setAttribute("message", message);
			}else{
				//��ġ���� �ʴ� ���
				message="�̸��� �̸����� Ȯ�����ּ���";
				request.setAttribute("message", message);
				
			}
		}
		}
		
		String url="/meView/meFindIdPassForm.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
		
	}

}
