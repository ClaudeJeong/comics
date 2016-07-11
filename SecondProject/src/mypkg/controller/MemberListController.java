package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberListController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = new MemberDao();
		List<Member> lists = mdao.SelectDataList();
		request.setAttribute("lists", lists);
		
		String gotoPage = "/member/MemberListResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotoPage);
		dispatcher.forward(request, response);
	}

}
