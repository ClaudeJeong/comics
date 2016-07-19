package mypkg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Member;
import mypkg.model.MemberDao;
import mypkg.util.Validator;


public class MemberJoinController implements SuperController {
	
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member bean = new Member();
		bean = new Member();
		bean.setId(request.getParameter("id1"));
		bean.setAddress1(request.getParameter("address1"));
		bean.setAddress2(request.getParameter("address2"));
		bean.setBirth(request.getParameter("birth"));
		bean.setEmail1(request.getParameter("email1"));
		if(request.getParameter("email2").equals("selfwrite")){
			bean.setEmail2("@" + request.getParameter("email3"));
		}else{
			bean.setEmail2(request.getParameter("email2"));
		}
		bean.setGender(request.getParameter("gender"));
		bean.setName(request.getParameter("name"));
		bean.setNickname(request.getParameter("nickname"));
		bean.setPassword(request.getParameter("password1"));
		bean.setZipcode(request.getParameter("zipcode"));
		bean.setPhone1(request.getParameter("phone1"));
		bean.setPhone2(request.getParameter("phone2"));
		bean.setPhone3(request.getParameter("phone3"));
		//System.out.println(bean.toString());
		
		
			MemberDao mDao = new MemberDao();
			String url="main.jsp";
			int cnt = -99999;
			cnt = mDao.InsertData(bean);
		
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}
	


}
