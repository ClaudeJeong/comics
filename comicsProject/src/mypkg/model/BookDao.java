package mypkg.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends SuperDao {
	//���� ����
	public int InsertData( Book bean ){
		System.out.println( bean.toString() ); 
		String sql = "insert into books(bookcode, name, volume, writer, publisher, pubdate, genre, image, bookstat, bookstory) " ;
		sql += " values(seqprod.nextval, ?, ?, ?, ?, to_date(?, 'yyyy/MM/dd'), ?, ?, ?, ?) " ;
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConn() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getVolume());
			pstmt.setString(3, bean.getWriter());
			pstmt.setString(4, bean.getPublisher());
			pstmt.setString(5, bean.getPubdate());
			pstmt.setString(6, bean.getGenre());
			pstmt.setString(7, bean.getImage());
			pstmt.setString(8, bean.getBookstat());
			pstmt.setString(9, bean.getBookstory());
			
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
	
	//���� ����
	public int UpdateData( Book bean ){
		System.out.println( bean.toString() ); 
		String sql = "update books set " ;
		sql += " name=?, volume=?, writer=?, publisher=?, pubdate=to_date(?, 'yyyy/MM/dd'), " ;
		sql += " genre=?, image=?, bookstat=?, bookstory=?  " ; 
		sql += " where bookcode = ? " ;

		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConn() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getVolume());
			pstmt.setString(3, bean.getWriter());
			pstmt.setString(4, bean.getPublisher());
			pstmt.setString(5, bean.getPubdate());
			pstmt.setString(6, bean.getGenre());
			pstmt.setString(7, bean.getImage());
			pstmt.setString(8, bean.getBookstat());
			pstmt.setString(9, bean.getBookstory());			
			pstmt.setInt(10, bean.getBookcode() );
			
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
	
	//���� ����
	public int DeleteData( int pmkey ){
		String sql = " delete from books where bookcode = ? " ;
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConn() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			pstmt.setInt(1, pmkey);
			
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
	public BookDao() {
	
	}
	
	//å ����� �����ֱ� ����
	public List<Book> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		//��ŷ�� �̿��Ͽ� ��� �����͸� ��ȸ�Ѵ�.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select bookcode, name, volume, writer, publisher, pubdate, genre, image, bookstat, bookstory, ranking "; 
		sql += " from " ; 
		sql += " ( " ;
		sql += " select bookcode, name, volume, writer, publisher, pubdate, genre, image, bookstat, bookstory, rank() over( order by name asc ) as ranking " ;
		sql += " from books " ;
		if( mode.equals("all") == false ){
			sql += " where lower(" + mode + ") like lower('" + keyword + "') "; //�ۼ��� ���͸� ����
		}
		sql += " ) " ;
		sql += " where ranking between ? and ? " ; 

		List<Book> lists = new ArrayList<Book>() ;
		try {
			if( this.conn == null ){ this.conn = this.getConn() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow); 
			
			rs = pstmt.executeQuery() ; 
			while ( rs.next() ) {
				Book bean = new Book() ; 
				bean.setBookcode( rs.getInt("bookcode") );
				bean.setName( rs.getString("name") ); 
				bean.setVolume( rs.getInt("volume") );
				bean.setWriter( rs.getString("writer") );				
				bean.setPublisher( rs.getString("publisher") );		
				bean.setPubdate( String.valueOf( rs.getDate("pubdate"))) ;
				bean.setGenre( rs.getString("genre") );
				bean.setImage( rs.getString("image") );
				bean.setBookstat( rs.getString("bookstat") );
				bean.setBookstory( rs.getString("bookstory") );
				
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
	
	
	//å 1�ǿ� ���� �� ���� ����
	public Book SelectDataByPk( int bookcode  ){
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		String sql = "select * " ;
		sql += " from books " ; 
		sql += " where bookcode = ? " ;
		Book bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConn() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			//placehodelr ġȯ�� �ݵ�� execute �޼ҵ� ���� �ٷ� ������ �ϼ���. 
			pstmt.setInt( 1, bookcode ); 
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) {
				bean = new Book() ;
				bean.setBookcode( rs.getInt("bookcode") );
				bean.setName( rs.getString("name") ); 
				bean.setVolume( rs.getInt("volume") );
				bean.setWriter( rs.getString("writer") );				
				bean.setPublisher( rs.getString("publisher") );		
				bean.setPubdate( String.valueOf( rs.getDate("pubdate"))) ;
				bean.setGenre( rs.getString("genre") );
				bean.setImage( rs.getString("image") );
				bean.setBookstat( rs.getString("bookstat") );
				bean.setBookstory( rs.getString("bookstory") );
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
		return bean  ;
	}
	
	//��Ż ī��Ʈ
	public int SelectTotalCount(String mode, String keyword) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select count(*) as cnt from books";
		if( mode.equals("all") == false ){
			sql += " where lower(" + mode + ") like lower('" + keyword + "') ";
		}
		
		int cnt = 0; //���� ����� �⺻��
		
		try {
			if( this.conn == null ){ this.conn = this.getConn() ; }
			pstmt = this.conn.prepareStatement( sql ) ;
			rs = pstmt.executeQuery() ; 
			if ( rs.next() ) { 
				cnt = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null ){ rs.close(); }
				if( pstmt != null ){ pstmt.close(); }
				this.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return cnt ;
	}

}
