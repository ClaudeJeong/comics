package member_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common_controller.SuperController;
import model.MemberDao;
import model.Zipcode;

public class MemberZipCheckController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String dong = request.getParameter("dong");
		List<Zipcode> lists = null;
		MemberDao mDao = new MemberDao();
		if(dong != null){
			lists = mDao.SelectZipcode(dong);
		}
		
		request.setAttribute("lists", lists);
		
		String url = "/meView/zipCheck.jsp";
		RequestDispatcher dispat = request.getRequestDispatcher(url);
		dispat.forward(request, response);
		
	}

}
