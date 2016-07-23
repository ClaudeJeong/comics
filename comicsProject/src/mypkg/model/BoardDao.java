package mypkg.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao extends SuperDao {

	public int selectTotalCount(String mode, String keyword) {
			// 게시물의 전체 건수를 보여주는 것
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = " select count(*) as cnt from boards ";
			if( mode.equals("all") == false ){
				sql+= " where " + mode + " like '" + keyword + "'";
			}
			int cnt = 0;
			try {
				if (this.conn == null) {
					this.conn = this.getConn();
				}
				pstmt = this.conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				if (rs.next()) {

					cnt = rs.getInt("cnt");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if (pstmt != null) {pstmt.close();}
					if ( rs != null) { rs.close();}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return cnt;

		}

	
	public List<Board> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		// 랭킹을 이용하여 조회하되 writer이 작성한 항목만 조회한다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select no, subject, writer, password, content, readhit, to_char(regdate, 'yyyy/MM/dd')as regdate, boardtype, to_char(updatedate, 'yyyy/MM/dd')as updatedate, image, remark, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select no, subject, writer, password, content, readhit, regdate, boardtype, updatedate, image, remark, rank() over( order by no desc ) as ranking ";
		sql += " from boards ";
		
		if( mode.equals("all") == false ){
			sql += " where lower(" + mode + ") like lower('" + keyword + "')"; // 작성자 필터링 조건
		}
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		List<Board> lists = new ArrayList<Board>();
		try {
			if (this.conn == null) {
				this.conn = this.getConn();
			}
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board bean = new Board();
				bean.setNo(rs.getInt("no"));
				bean.setSubject(rs.getString("subject"));
				bean.setWriter(rs.getString("writer"));
				bean.setPassword(rs.getString("password"));
				bean.setContent(rs.getString("content"));
				bean.setReadHit(rs.getInt("readhit"));
				bean.setBoardType(rs.getString("boardtype"));
				bean.setImage(rs.getString("image"));
				bean.setRemark(rs.getString("remark"));
				bean.setUpdateDate(rs.getString("updatedate"));
				bean.setRegDate(rs.getString("regdate"));
				lists.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
}
}
