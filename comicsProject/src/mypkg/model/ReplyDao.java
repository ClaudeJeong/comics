package mypkg.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyDao extends SuperDao{

	public int InsertData(Reply bean) {
		PreparedStatement pstmt = null ;
		String sql = " insert into replies(renum, bonum, writer, content, orderno, depth)";
			   sql += " values(replynumseq.nextval, ?, ?, ?, 0, 0)";
		int cnt = -99999;
		try {
			if( conn == null ){ super.conn = super.getConn(); }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setInt(1, bean.getBoNum());
			pstmt.setString(2, bean.getWriter()) ;
			pstmt.setString(3, bean.getContent()) ;
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 
		} catch (Exception e) {
			SQLException err = (SQLException)e ;			
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				//super.closeConn(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}

	public int selectTotalCount(int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select count(*) as cnt from replies where bonum = ? ";
		int cnt = 0;
		try {
			if (this.conn == null) {
				this.conn = this.getConn();
			}
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
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
				//super.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public List<Reply> SelectDataList(int beginRow, int endRow, int no) {
		// 랭킹을 이용하여 조회하되 writer이 작성한 항목만 조회한다.
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<Reply> lists = new ArrayList<Reply>();
				String sql = " select renum, WRITER, CONTENT, regdate, UPDATEDATE, ORDERNO, DEPTH, ranking";  
					   sql += " from (";
					   sql += " select r.renum, r.WRITER, r.CONTENT, r.regdate, r.UPDATEDATE, r.ORDERNO, r.DEPTH,"; 
					   sql += " rank() over(order by renum desc) as ranking";
					   sql += " from boards b inner join replies r";	
					   sql += " on b.no = r.bonum";	
					   sql += " where r.bonum = ?)";
					   sql += " where ranking between ? and ?";
						
				try {
					if (this.conn == null) {
						this.conn = this.getConn();
					}
					pstmt = this.conn.prepareStatement(sql);
					pstmt.setInt(1, no);
					pstmt.setInt(2, beginRow);
					pstmt.setInt(3, endRow);

					rs = pstmt.executeQuery();
					while (rs.next()) {
						Reply bean = new Reply();
						bean.setContent(rs.getString("content"));
						bean.setDepth(rs.getInt("depth"));
						bean.setOrderNo(rs.getInt("orderNo"));
						bean.setRegDate(rs.getString("regDate"));
						bean.setReNum(rs.getInt("reNum"));
						bean.setUpdateDate(rs.getString("updateDate"));
						bean.setWriter(rs.getString("writer"));
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
