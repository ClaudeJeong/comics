package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberDeleteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//�߰� ��λ���
			//å �뿩���̸� ������ �ȵǴ� ���
			//���̵� ����� ������ ������ Ż�������� ��ü
		
		HttpSession session = request.getSession();
		//Membersession.getAttribute("loginfo");
		
			
	}

}
