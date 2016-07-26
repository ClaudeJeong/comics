package mypkg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.model.Reply;
import mypkg.model.ReplyDao;

public class ReplyMoreWriteController implements SuperController {

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*renum=${lists.reNum}&no=${bean.no}&orderno=${bean.orderNo}
		morere*/
		int groupno = Integer.parseInt(request.getParameter("groupno")); //그룹넘버
		int no = Integer.parseInt(request.getParameter("no")); //보더넘버 해당 댓글이 달린 게시물
		int orderno = Integer.parseInt(request.getParameter("orderno")); // 게시물 순서
		int depth = Integer.parseInt(request.getParameter("depth")); // 댓글에 댓글
		String morere = request.getParameter("morere"); //내용
		String writer = request.getParameter("writer"); //작성자
		
		System.out.println(groupno);
		System.out.println(no);
		System.out.println(orderno);
		System.out.println(morere);
		System.out.println(writer);
		System.out.println(depth);
		
		Reply bean = new Reply();
		bean.setContent(morere);
		bean.setGroupNo(groupno);
		bean.setDepth(depth + 1);
		bean.setOrderNo(orderno + 1);
		bean.setWriter(writer);
		bean.setBoNum(no);
		ReplyDao rDao = new ReplyDao();
		int cnt = -99999;
		cnt = rDao.updateReply(groupno, orderno, no);
		cnt = rDao.InsertMoreData(bean);
		
		boolean upReadHit = false;
		request.setAttribute("upReadHit", upReadHit);
		
		new BoardNoticeDetailController().doProcess(request, response);
		
	}

}
