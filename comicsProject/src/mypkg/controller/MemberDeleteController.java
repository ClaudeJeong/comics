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
			//추가 고민사항
			//책 대여중이면 삭제가 안되는 방법
			//아이디만 남기고 나머지 정보가 탈퇴함으로 교체
		
		HttpSession session = request.getSession();
		//Membersession.getAttribute("loginfo");
		
			
	}

}
