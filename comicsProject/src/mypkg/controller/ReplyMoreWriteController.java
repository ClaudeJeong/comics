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
		int groupno = Integer.parseInt(request.getParameter("groupno")); //�׷�ѹ�
		int no = Integer.parseInt(request.getParameter("no")); //�����ѹ� �ش� ����� �޸� �Խù�
		int orderno = Integer.parseInt(request.getParameter("orderno")); // �Խù� ����
		int depth = Integer.parseInt(request.getParameter("depth")); // ��ۿ� ���
		String morere = request.getParameter("morere"); //����
		String writer = request.getParameter("writer"); //�ۼ���
		
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
