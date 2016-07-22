package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberUpdateFormController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDao mdao = new MemberDao() ;
		Member bean = mdao.selectByPk(id) ;
		
		request.setAttribute( "bean", bean ); 
		String url = "/meView/meUpdateForm.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
	}

}
