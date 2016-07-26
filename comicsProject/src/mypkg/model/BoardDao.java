package mypkg.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao extends SuperDao {

	public int selectTotalCount(String mode, String keyword, String boardType) {
			// 게시물의 전체 건수를 보여주는 것
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = " select count(*) as cnt from boards where boardtype = ? ";
			if( mode.equals("all") == false ){
				sql+= " and " + mode + " like '" + keyword + "'";
			}
			int cnt = 0;
			try {
				if (this.conn == null) {
					this.conn = this.getConn();
				}
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, boardType);
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
					super.closeConn();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return cnt;

		}

	
	public List<Board> SelectDataList(int beginRow, int endRow, String mode, String keyword, String boardType) {
		// 랭킹을 이용하여 조회하되 writer이 작성한 항목만 조회한다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select no, subject, writer, password, content, readhit, to_char(regdate, 'yyyy/MM/dd')as regdate, boardtype, to_char(updatedate, 'yyyy/MM/dd')as updatedate, image, remark, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select no, subject, writer, password, content, readhit, regdate, boardtype, updatedate, image, remark, rank() over( order by no desc ) as ranking ";
		sql += " from boards ";
		sql += " where boardtype = ? ";
		if( mode.equals("all") == false ){
			sql += " and lower(" + mode + ") like lower('" + keyword + "')"; // 작성자 필터링 조건
		}
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		List<Board> lists = new ArrayList<Board>();
		try {
			//if (this.conn == null) {
				this.conn = this.getConn();
			//}
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, boardType);
			pstmt.setInt(2, beginRow);
			pstmt.setInt(3, endRow);
			
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


	public int insertData(Board bean) {
		PreparedStatement pstmt = null ;
		String sql = " insert into boards(no, boardtype, writer, subject, content, password, image, regdate, updatedate, readhit, remark)";
			   sql += " values(boardnumseq.nextval, ?, ?, ?, ?, ?, ?, default, default, default, null)"; 

		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConn(); }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, bean.getBoardType());
			pstmt.setString(2, bean.getWriter()) ;
			pstmt.setString(3, bean.getSubject()) ;
			pstmt.setString(4, bean.getContent()) ;
			pstmt.setString(5, bean.getPassword()) ;
			pstmt.setString(6, bean.getImage());
			
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


	public Board selectDataByPk(int no) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		String sql = "select * " ;
		sql += " from boards " ; 
		sql += " where no = ? " ;
		Board bean = null ;
		try {
			if( this.conn == null ){
			 this.conn = this.getConn(); 
			 }
		
			pstmt = this.conn.prepareStatement(sql) ;			
			pstmt.setInt( 1, no ); 
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				bean = new Board() ;
				bean.setNo( rs.getInt("no") );				
				bean.setSubject( rs.getString("subject") );
				bean.setWriter( rs.getString("writer") );
				bean.setPassword( rs.getString("password") );
				bean.setContent( rs.getString("content") );
				bean.setReadHit( rs.getInt("readhit") );				
				bean.setRegDate( String.valueOf( rs.getDate("regdate"))) ;
				bean.setBoardType(rs.getString("boardtype"));
				bean.setRemark(rs.getString("remark"));
				bean.setUpdateDate(String.valueOf( rs.getDate("updatedate")));
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
				super.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return bean  ;
	}


	public int UpdateReadhit(int no) {
		PreparedStatement pstmt = null ;
		String sql = " update boards set readhit = readhit + 1 " ;
		sql += " where no=? " ;
		
		int cnt = -99999 ; //부정의 의미
		try {
			//if( this.conn == null ){ 
				this.conn = this.getConn() ; 
				//}
			conn.setAutoCommit( false ); 
			pstmt = this.conn.prepareStatement( sql ) ;
			pstmt.setInt(1, no) ; 
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
				super.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return cnt ; 
		
	}


	public int deleteData(int no) {
		PreparedStatement pstmt = null ;
		String sql = " delete from boards";
		sql += " where no=? " ;
		
		int cnt = -99999 ; //부정의 의미
		try {
			if( this.conn == null ){ 
				this.conn = this.getConn() ; 
				}
			conn.setAutoCommit( false ); 
			pstmt = this.conn.prepareStatement( sql ) ;
			pstmt.setInt(1, no) ; 
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
				//super.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return cnt ; 
	}


	public int UpdateData(Board bean) {
		PreparedStatement pstmt = null ;
		String sql = " update boards set subject = ?, content = ?, updatedate = default where no = ?";

		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConn(); }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, bean.getSubject()) ;
			pstmt.setString(2, bean.getContent()) ;
			pstmt.setInt(3, bean.getNo()) ;
			
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
