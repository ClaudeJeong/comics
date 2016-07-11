package mypkg.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberIdPasswordController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringTokenizer st = null;
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		//System.out.println("id = " + id);
		//System.out.println("email = " + email);
		MemberDao mDao = new MemberDao();
		Member bean = null;
		String url = "";
		try{
		if (id != "" && email != "" || id == "" && email == "") {
			url = "/member/meIdPassword.jsp";
		} else {
			if (id == "") {
				// 아이디 값이 없으면 아이디 찾기
				st = new StringTokenizer(request.getParameter("email"), "@");
				String email1 = st.nextToken();
				String email2 = "@" + st.nextToken();
				bean = mDao.SelectDataByEmail(email1, email2);
				System.out.println("bean1= " + bean);
				
				if(!email.equals(bean.getEmail1() + bean.getEmail2()) || bean == null){
					url = "/member/meIdPassword.jsp";
				}else{
					url = "/member/meIdPassResult.jsp";	
				}
			} else {
				// 나머지는 비밀번호 찾기
				bean = mDao.SelectDataByPk(id);
				System.out.println("bean2=" + bean);
				if(!id.equals(bean.getId()) || bean == null ){
					url = "/member/meIdPassword.jsp";
				}else{
					url = "/member/meIdPassResult.jsp";
				}
			
			}
		}
		} catch(NullPointerException e){
			e.printStackTrace();
			url = "/member/meIdPassword.jsp";
		}
		//가독성 제로ㅠㅠ

		request.setAttribute("bean", bean);
		request.setAttribute("id", id);
		request.setAttribute("email", email);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
