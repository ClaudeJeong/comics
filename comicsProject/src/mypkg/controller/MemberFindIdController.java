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
		//System.out.println("리스트" + lists); 
		String message="";
		if(lists.size() == 0 ){
			message="이름과 이메일을 확인해주세요";
			request.setAttribute("message", message);
		}else{
		for (Member bean : lists) {
			String mail = bean.getEmail1() +"@" + bean.getEmail2();
			if(bean.getName().equals(name) && (bean.getEmail1() +"@" + bean.getEmail2()).equals(email)){
				//일치하는 경우
				String id = bean.getId().substring(0, 2);
				String star = "";
				for (int i = 0; i < bean.getId().length() - 2; i++) {
					star += "*";
				}
				message = "회원님의 아이디는 <font size=5px color='black'>" + id + star + "</font>입니다";
				request.setAttribute("message", message);
			}else{
				//일치하지 않는 경우
				message="이름과 이메일을 확인해주세요";
				request.setAttribute("message", message);
				
			}
		}
		}
		
		String url="/meView/meFindIdPassForm.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
		
	}

}
