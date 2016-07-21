package mypkg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java.swing.plaf.windows.resources.windows;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberFindPasswordController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name2");
		MemberDao mDao = new MemberDao();
		List<Member> lists = mDao.selectByName(name);
		String message="";
		if(lists.size() == 0 ){
			
			message="아이디와 이름을 확인해주세요";
			request.setAttribute("message", message);
		}else{
		for (Member bean : lists) {
			if(bean.getId().equals(id) && bean.getName().equals(name)){
				//일치하는 경우
				message="가라";
				request.setAttribute("id", id);
				request.setAttribute("name", name);
				request.setAttribute("gotochange", message);
			}else{
				//일치하지 않는 경우
				message="아이디와 이름을 확인해주세요";
				request.setAttribute("message", message);
				
			}
		}
		}
		String url="/meView/meFindIdPassForm.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
	}

}
