package mypkg.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyDao extends SuperDao{

	public int InsertData(Reply bean) {
		PreparedStatement pstmt = null ;
		String sql = " insert into replies(renum, bonum, writer, content, groupno, orderno, depth)";
			   sql += " values(replynumseq.nextval, ?, ?, ?,replynumseq.currval, 0, 0)";
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
				super.closeConn(); 
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
				String sql = " select renum, WRITER, CONTENT, regdate, UPDATEDATE, groupno, ORDERNO, DEPTH, ranking";  
					   sql += " from (";
					   sql += " select r.renum, r.WRITER, r.CONTENT, r.regdate, r.UPDATEDATE, r.groupno, r.ORDERNO, r.DEPTH,"; 
					   sql += " rank() over(order by groupno desc, orderno asc) as ranking";
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
						bean.setGroupNo(rs.getInt("groupno"));
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

	public int DeleteData(int reNum) {
		PreparedStatement pstmt = null ;
		String sql = " update replies set writer = null, content = '삭제된 댓글입니다',";
			   sql += " regdate=null, updatedate=null where reNum = ? ";
		int cnt = -99999;
		try {
			if( conn == null ){ super.conn = super.getConn(); }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setInt(1, reNum);
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
				super.closeConn(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}

	public int updateReply(int groupno ,int orderno, int bnum) {
		PreparedStatement pstmt = null ;
		String sql = " update replies set orderno = orderno + 1 " ;
		sql += " where bonum = ? and groupno = ? and orderno > ?" ;
		
		int cnt = -99999 ; //부정의 의미
		try {
			if( this.conn == null ){ this.conn = this.getConn(); }
			conn.setAutoCommit( false ); 
			pstmt = this.conn.prepareStatement( sql ) ;
			pstmt.setInt(1, bnum) ; 
			pstmt.setInt(2, groupno) ; 
			pstmt.setInt(3, orderno) ;
			
			cnt = pstmt.executeUpdate() ;
			conn.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			cnt = -99999 ;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				this.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return cnt ; 
	}

	public int InsertMoreData(Reply bean) {
		PreparedStatement pstmt = null ;
		String sql = " insert into replies(renum, bonum, writer, content, groupno, orderno, depth)";
			   sql += " values(replynumseq.nextval, ?, ?, ?, ?, ?, ?)";
		int cnt = -99999;
		try {
			//if( conn == null ){
				super.conn = super.getConn();
				//}
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setInt(1, bean.getBoNum());
			pstmt.setString(2, bean.getWriter()) ;
			pstmt.setString(3, bean.getContent()) ;
			pstmt.setInt(4, bean.getGroupNo());
			pstmt.setInt(5, bean.getOrderNo());
			pstmt.setInt(6, bean.getDepth());
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
				super.closeConn(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}
	
}
