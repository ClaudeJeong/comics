package mypkg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import mypkg.model.MemberDao;

public class MemberIdCheckController implements SuperController {

	@SuppressWarnings("unchecked")
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		MemberDao mDao = new MemberDao();
		boolean check = false;
		String id = request.getParameter("id1");
		
		if( id != null){
			check = mDao.checkId(id);
			json.put("check", check);
			out.println(json);
			out.flush();
			out.close();
			
		}
		
	}

}
