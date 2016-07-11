package mypkg.model;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao extends SuperDao {

// Method
	public int InsertData(Member bean) {
		//회원 가입
		PreparedStatement pstmt = null;
		String sql = " insert into members(id, password, name, nickname, email1, email2, birth, gender,";
		sql += " phone1, phone2, phone3, zipcode, address1, address2)";
		sql += " values(?, ?, ?, ?, ?, ?, to_date(?, 'yyyy/MM/dd'), ?, ?, ?, ?, ?, ?, ?)";
		int cnt = -99999;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getNickname());
			pstmt.setString(5, bean.getEmail1());
			pstmt.setString(6, bean.getEmail2());
			pstmt.setString(7, bean.getBirth());
			pstmt.setString(8, bean.getGender());
			pstmt.setString(9, bean.getPhone1());
			pstmt.setString(10, bean.getPhone2());
			pstmt.setString(11, bean.getPhone3());
			pstmt.setString(12, bean.getZipCode());
			pstmt.setString(13, bean.getAddress1());
			pstmt.setString(14, bean.getAddress2());
			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException) e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					super.closeConnection();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public int DeleteData(String id){
		//해당 회원이 탈퇴
		PreparedStatement pstmt = null;
		String sql = " delete from members where id = ?";
		int cnt = - 99999;
		try {
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			SQLException err = (SQLException) e;
			cnt = -err.getErrorCode();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
			if( pstmt != null ) {pstmt.close();}
				super.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public List<Member> SelectDataList() {
		// 모든 회원 데이터 조회
		List<Member> lists = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from members order by name";
		if (conn == null) {
			super.conn = super.getConnection();
		}
		try {
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member bean = new Member();
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setEmail1(rs.getString("email1"));
				bean.setEmail2(rs.getString("email2"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setNickname(rs.getString("nickname"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone1(rs.getString("phone1"));
				bean.setPhone2(rs.getString("phone2"));
				bean.setPhone3(rs.getString("phone3"));
				bean.setRegDate(String.valueOf(rs.getDate("registedate")));
				bean.setZipCode(rs.getString("zipcode"));

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
				super.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lists;
	}
	public Member SelectDataByPk( String id ){
		//primary key로 해당 회원의 정보 한 건을 조회한다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from members where id = ?";
		Member bean = null;
		if( this.conn == null ){ this.conn = this.getConnection(); }
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean = new Member();
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setEmail1(rs.getString("email1"));
				bean.setEmail2(rs.getString("email2"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setNickname(rs.getString("nickname"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone1(rs.getString("phone1"));
				bean.setPhone2(rs.getString("phone2"));
				bean.setPhone3(rs.getString("phone3"));
				bean.setRegDate(String.valueOf(rs.getDate("registedate")));
				bean.setZipCode(rs.getString("zipcode"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
			if( pstmt != null ) { pstmt.close(); }	
			if( rs != null ) { rs.close(); }
			this.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return bean;
	}
	public Member SelectDataByEmail( String email1, String email2 ){
		//primary key로 해당 회원의 정보 한 건을 조회한다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from members where email1 = ? and email2 = ?";
		Member bean = null;
		if( this.conn == null ){ this.conn = this.getConnection(); }
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email1);
			pstmt.setString(2, email2);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean = new Member();
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(String.valueOf(rs.getDate("birth")));
				bean.setEmail1(rs.getString("email1"));
				bean.setEmail2(rs.getString("email2"));
				bean.setGender(rs.getString("gender"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setNickname(rs.getString("nickname"));
				bean.setPassword(rs.getString("password"));
				bean.setPhone1(rs.getString("phone1"));
				bean.setPhone2(rs.getString("phone2"));
				bean.setPhone3(rs.getString("phone3"));
				bean.setRegDate(String.valueOf(rs.getDate("registedate")));
				bean.setZipCode(rs.getString("zipcode"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
			if( pstmt != null ) { pstmt.close(); }	
			if( rs != null ) { rs.close(); }
			this.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return bean;
	}
}
