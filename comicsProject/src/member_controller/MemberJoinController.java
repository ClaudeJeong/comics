package member_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common_controller.SuperController;
import model.Member;
import model.MemberDao;
import util.Validator;


public class MemberJoinController implements SuperController, Validator {
	private HttpServletRequest request ;
	private Member bean = null ;
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request ;
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
		
		String url = "";
		if(this.checkValidate() == false){
			url="/meView/meJoinForm.jsp";
			this.request.setAttribute("bean", bean);
		}else{
			MemberDao mDao = new MemberDao();
			url="main.jsp";
			int cnt = -99999;
			cnt = mDao.InsertData(bean);
		}
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(this.request, response);		
	}
	

	@Override
	public boolean checkValidate() {
		boolean isCheck = true;
		
		if(bean.getGender() == null){
			this.request.setAttribute("errgender", "������ �ݵ�� üũ �Ͻ��� ���Դϴ�.");
			isCheck = false;
		}
		
		if(bean.getZipcode().equals("")){
			this.request.setAttribute("errzip", "�����ȣ�� �ʼ��� ���Դϴ�.");
			isCheck = false;
		}
		
		if(bean.getAddress2().equals("")){
			this.request.setAttribute("erraddress", "�ּҴ� �ʼ��� ���Դϴ�.");
			isCheck = false;
		}
		return isCheck;
	}

}
