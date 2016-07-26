package mypkg.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordDao extends SuperDao {
	
	
	//한건의 대여 현황이 들어감
	public int InsertData( String mid, int bcode ){ 
		PreparedStatement pstmt1 = null, pstmt2 = null ;
		
		int cnt = -99999 ;

		try {
			if( conn == null ){ super.conn = super.getConn() ; }
			conn.setAutoCommit( false );
			
			// 1. 대여 현황이 추가 된다.
			String sql1 = " insert into records(recordnum, mid, bcode, lenddate, period, returndate) ";
			sql1 += " values(recordseq.nextval, ?, ?, default, default, null)";
			
			pstmt1 = super.conn.prepareStatement(sql1) ;
			pstmt1.setString(1, mid);
			pstmt1.setInt(2, bcode);
			
			cnt = pstmt1.executeUpdate() ; 
			
			// 2. 책의 대여 상태가 대여 중 으로 바뀐다.
			String sql2 = " update books set " ;
			sql2 += " bookstat = '대출 중' " ; 
			sql2 += " where bookcode = ? " ;
						
			pstmt2 = super.conn.prepareStatement(sql2) ;
			pstmt2.setInt(1, bcode);
						
			cnt = pstmt2.executeUpdate() ;
			
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
				if( pstmt1 != null ){ pstmt1.close(); }
				if( pstmt2 != null ){ pstmt2.close(); }
				super.closeConn(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}
	
	//아직 안함
	//대여 상황이 변할 때, 반납 같은 경우. 
	public int UpdateData( int bcode ){
		System.out.println( "반납 책 코드 : " + bcode ); 
		PreparedStatement pstmt1 = null, pstmt2 = null ;
		
		int cnt = -99999 ;
		
		try {
			if( conn == null ){ super.conn = super.getConn() ; }
			conn.setAutoCommit( false );
			
			// 1. 반납 일자가 업데이트 된다.
			String sql1 = " update records set " ;
			sql1 += " returndate = sysdate " ; 
			sql1 += " where bcode = ? " ;
			
			pstmt1 = super.conn.prepareStatement(sql1) ;
			pstmt1.setInt(1, bcode);
			
			cnt = pstmt1.executeUpdate() ;
			
			// 2. 책의 대여 상태가 대여 가능 으로 바뀐다.
			String sql2 = " update books set " ;
			sql2 += " bookstat = '대출 가능' " ; 
			sql2 += " where bookcode = ? " ;
			
			pstmt2 = super.conn.prepareStatement(sql2) ;
			pstmt2.setInt(1, bcode);
			
			cnt = pstmt2.executeUpdate() ;
			
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
				if( pstmt1 != null ){ pstmt1.close(); }
				if( pstmt2 != null ){ pstmt2.close(); }
				super.closeConn(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
	}
		
	public RecordDao() {}
	
	//한사람의 정보를 보여주기 위함
	public Member selectMeByMid(String mid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member bean = new Member();
		String sql = " select id, name, nickname, to_char(birth,'yyyy/MM/dd')as birth, gender, phone1, phone2, phone3 from members ";	   
				sql += " where id = ? ";
			
		try {
			//if(this.conn == null){
				this.conn = getConn();
			//}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean.setBirth(rs.getString("birth"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setNickname(rs.getString("nickname"));
				bean.setPhone1(rs.getString("phone1"));
				bean.setPhone2(rs.getString("phone2"));
				bean.setPhone3(rs.getString("phone3"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				super.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 		
		return bean  ;
	}
		
	//한사람의 대여 현황을 보여주기 위함
	public List<JoinRecord01> selectRcByMid(String mid) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = " select rc.recordnum, rc.bcode, bk.name, bk.volume, bk.writer, ";
		sql += " to_char(rc.lenddate,'yyyy/MM/dd') as lenddate, to_char(rc.lenddate + rc.period,'yyyy/MM/dd') as duedate, ";
		sql += " trunc(sysdate) - trunc(rc.lenddate) - rc.period as overdue ";
		sql += " from records rc inner join books bk ";
		sql += " on rc.bcode=bk.bookcode ";
		sql += " where rc.mid = ? and rc.returndate is null ";

		List<JoinRecord01> lists = new ArrayList<JoinRecord01>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConn() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setString(1, mid);
			
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) {
				JoinRecord01 bean = new JoinRecord01() ; 
				bean.setRecordnum(rs.getInt("recordnum"));
				bean.setBcode(rs.getInt("bcode"));
				bean.setBname(rs.getString("name"));
				bean.setVolume(rs.getInt("volume"));
				bean.setWriter(rs.getString("writer"));
				bean.setLenddate(rs.getString("lenddate"));
				bean.setDuedate(rs.getString("duedate"));
				int overdue = rs.getInt("overdue");
				if(overdue < 0){
					overdue = 0;
				}
				bean.setOverdue(overdue);
				lists.add( bean ) ; 
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
				this.closeConn() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return lists  ;
	}
	
	//아직 안함
	//총 대여 현황을 보여주기 위함
	public List<JoinRecord02> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		//랭킹을 이용하여 모든 데이터를 조회한다.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
			
		String sql = " select recordnum, bcode, name, volume, writer, nickname, mid, ";
		sql += " lenddate, returndate, imsiOD, overdue, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select rc.recordnum, rc.bcode, bk.name, bk.volume, bk.writer, me.nickname, rc.mid, " ;
		sql += " to_char(rc.lenddate,'yyyy/MM/dd') as lenddate, to_char(rc.returndate,'yyyy/MM/dd') as returndate, ";
		sql += " trunc(sysdate) - trunc(rc.lenddate) - rc.period as imsiOD, ";
		sql += " trunc(rc.returndate) - trunc(rc.lenddate) - rc.period as overdue, ";
		sql += " rank() over( order by rc.recordnum desc) as ranking ";
		sql += " from(records rc inner join books bk ";
		sql += " on rc.bcode=bk.bookcode) inner join members me ";
		sql += " on rc.mid=me.id ";
		if( mode.equals("all") == false ){
			sql += " where lower(" + mode + ") like lower('" + keyword + "')"; 
		}
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		
		List<JoinRecord02> lists = new ArrayList<JoinRecord02>() ;
		try {
			//if( this.conn == null ){ 
				this.conn = this.getConn() ; 
			//}			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow); 
				
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) {
				JoinRecord02 bean = new JoinRecord02() ; 
				bean.setRecordnum( rs.getInt("recordnum") );
				bean.setBcode(rs.getInt("bcode"));
				bean.setName( rs.getString("name"));
				bean.setVolume(rs.getInt("volume"));
				bean.setWriter( rs.getString("writer"));
				bean.setNickname( rs.getString("nickname"));
				bean.setMid( rs.getString("mid"));
				bean.setLenddate( rs.getString("lenddate"));
				bean.setReturndate( rs.getString("returndate"));
				
				int overdue = rs.getInt("overdue");
				if(rs.getString("returndate") == null || rs.getString("returndate").equals("null") || rs.getString("returndate").equals("")){
					overdue = rs.getInt("imsiOD");
				}
				if(overdue < 0){
					overdue = 0;
				}
				bean.setOverdue( overdue );
				
				lists.add( bean ) ; 
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
				this.closeConn() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return lists  ;
	}

	
	//토탈 카운트
	public int selectTotalCount(String tableName, String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select count(*) as cnt from " + tableName ;
		if( mode.equals("all") == false ){
			sql+= " where " + mode + " like '" + keyword + "'";
		}
		int cnt = 0;
		try {
			//if (this.conn == null) {
				this.conn = this.getConn();
			//}
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
				this.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}
	
	//한건의 사용자를 찻기 위한 리스트
	public List<Member> SelectMemberDataList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select id, name, nickname, email1, email2, birth, gender, phone1, phone2, phone3, address1, address2, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select id, name, nickname, email1, email2, to_char(birth,'yyyy/MM/dd')as birth, gender, phone1, phone2, phone3, address1, address2, rank() over( order by id asc ) as ranking ";
		sql += " from members ";
		
		if( mode.equals("all") == false ){
			sql += " where lower(" + mode + ") like lower('" + keyword + "')"; 
		}
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		List<Member> lists = new ArrayList<Member>();
		try {
			//if (this.conn == null) {
				this.conn = this.getConn();
			//}
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member bean = new Member();
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(rs.getString("birth"));
				bean.setEmail1(rs.getString("email1"));
				bean.setEmail2(rs.getString("email2"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setNickname(rs.getString("nickname"));
				bean.setPhone1(rs.getString("phone1"));
				bean.setPhone2(rs.getString("phone2"));
				bean.setPhone3(rs.getString("phone3"));
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
	
	//대여를 하기위한 책 검색 리스트
	public List<Book> selectBookList(String name) {
		//랭킹을 이용하여 모든 데이터를 조회한다.
				PreparedStatement pstmt = null ;
				ResultSet rs = null ;
				
				String sql = " select bookcode, name, volume, writer, bookstat"; 
				sql += " from books " ;
				sql += " where lower(name) like lower('%" + name + "%') "; //작성자 필터링 조건
				sql += " order by bookstat asc ,name asc, volume asc ";

				List<Book> lists = new ArrayList<Book>() ;
				try {
					//if( this.conn == null ){ 
						this.conn = this.getConn() ; 
					//}			
					pstmt = this.conn.prepareStatement(sql) ;
					
					rs = pstmt.executeQuery() ; 
					while ( rs.next() ) {
						Book bean = new Book() ; 
						bean.setBookcode( rs.getInt("bookcode") );
						bean.setName( rs.getString("name") ); 
						bean.setVolume( rs.getInt("volume") );
						bean.setWriter( rs.getString("writer") );
						bean.setBookstat( rs.getString("bookstat") );
						
						lists.add( bean ) ; 
					}
					
				} catch (SQLException e) {			
					e.printStackTrace();
				} finally{
					try {
						if( rs != null){ rs.close(); } 
						if( pstmt != null){ pstmt.close(); } 
						this.closeConn() ;
					} catch (Exception e2) {
						e2.printStackTrace(); 
					}
				} 		
				return lists  ;
	}

	//개인의 대여 히스토리
	public List<JoinRecord02> SelectDataHistory(String mid, int beginRow, int endRow,
			String mode, String keyword) {
		System.out.println(mid + "/"+beginRow+ "/"+endRow + "/"+mode+ "/"+ keyword+"/");
		//랭킹을 이용하여 모든 데이터를 조회한다.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
			
		String sql = " select recordnum, bcode, name, volume, writer, nickname, mid, ";
		sql += " lenddate, returndate, imsiOD, overdue, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select rc.recordnum, rc.bcode, bk.name, bk.volume, bk.writer, me.nickname, rc.mid, " ;
		sql += " to_char(rc.lenddate,'yyyy/MM/dd') as lenddate, to_char(rc.returndate,'yyyy/MM/dd') as returndate, ";
		sql += " trunc(sysdate) - trunc(rc.lenddate) - rc.period as imsiOD, ";
		sql += " trunc(rc.returndate) - trunc(rc.lenddate) - rc.period as overdue, ";
		sql += " rank() over( order by rc.recordnum desc) as ranking ";
		sql += " from(records rc inner join books bk ";
		sql += " on rc.bcode=bk.bookcode) inner join members me ";
		sql += " on rc.mid=me.id ";
		sql += " where mid=? ";
		if( mode.equals("all") == false ){
			sql += " and lower(" + mode + ") like lower('" + keyword + "') "; 
		}
		
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		
		List<JoinRecord02> lists = new ArrayList<JoinRecord02>() ;
		try {
			//if( this.conn == null ){ 
				this.conn = this.getConn() ; 
			//}			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setString(1, mid);
			pstmt.setInt(2, beginRow);
			pstmt.setInt(3, endRow); 
				
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) {
				JoinRecord02 bean = new JoinRecord02() ; 
				bean.setRecordnum( rs.getInt("recordnum") );
				bean.setBcode(rs.getInt("bcode"));
				bean.setName( rs.getString("name"));
				bean.setVolume(rs.getInt("volume"));
				bean.setWriter( rs.getString("writer"));
				bean.setNickname( rs.getString("nickname"));
				bean.setMid( rs.getString("mid"));
				bean.setLenddate( rs.getString("lenddate"));
				bean.setReturndate( rs.getString("returndate"));
				
				int overdue = rs.getInt("overdue");
				if(rs.getString("returndate") == null || rs.getString("returndate").equals("null") || rs.getString("returndate").equals("")){
					overdue = rs.getInt("imsiOD");
				}
				if(overdue < 0){
					overdue = 0;
				}
				bean.setOverdue( overdue );
				
				lists.add( bean ) ; 
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
				this.closeConn() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return lists;
	}
	//개인 히스토리 토탈 카운트
	public int selectTotalCount(String tableName, String mid, String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select count(*) as cnt from " + tableName ;
		sql += " where mid=? ";
		if( mode.equals("all") == false ){
			sql += " and " + mode + " like '" + keyword + "'";
		}
		int cnt = 0;
		try {
			//if (this.conn == null) {
				this.conn = this.getConn();
			//}
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, mid);
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
				this.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace();
			}	
		}
		return cnt;
	}
}
