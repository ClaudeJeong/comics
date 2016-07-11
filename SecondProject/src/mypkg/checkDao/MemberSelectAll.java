package mypkg.checkDao;

import java.util.List;

import mypkg.model.Member;
import mypkg.model.MemberDao;

public class MemberSelectAll {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		List<Member> lists = dao.SelectDataList();
		if(lists.size() == 0){
			System.out.println("찾는 데이터 없음");
		}else{
			for( Member member : lists){
				System.out.println(member.toString());
			}
		}
		
	}

}
