package mypkg.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.functors.NullIsTruePredicate;

public class MemberDao extends SuperDao {

	public Member selectByPk(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select id, password, nickname from members where id = ? ";
		Member bean = new Member();
		this.conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean.setId(rs.getString("id"));
				bean.setPassword(rs.getString("password"));
				bean.setNickname(rs.getString("nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
			if(pstmt != null){ pstmt.close(); }
			if(rs != null){rs.close();}
			super.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			 }
		}
		
		
		return bean;
	}

	public List<Zipcode> SelectZipcode(String dong) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Zipcode> lists = new ArrayList<Zipcode>();
		String sql=" select * ";
			   sql+=" from zipcodes where dong like '%" + dong + "%'" ;
			   sql+=" order by sido asc, gugun asc, dong asc ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Zipcode zip = new Zipcode();
				zip.setBunji(rs.getString("bunji"));
				zip.setDong(rs.getString("dong"));
				zip.setGugun(rs.getString("gugun"));
				zip.setSido(rs.getString("sido"));
				zip.setZipcode(rs.getString("zipcode"));
				zip.setSeqnum(Integer.parseInt(rs.getString("seqnum")));
				//System.out.println(zip.toString());
				
				lists.add(zip);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 try {
				 if(pstmt != null){ pstmt.close(); }
				 if(rs != null){ rs.close(); }
				 super.closeConn();
			 } catch (SQLException e) {
				 e.printStackTrace();
			}
		}
		return lists;
	}

	public int InsertData(Member bean) {
		PreparedStatement pstmt = null;
		String sql = " insert into members(id, password, name, nickname, email1, email2, birth, gender,";
		sql += " phone1, phone2, phone3, zipcode, address1, address2)";
		sql += " values(?, ?, ?, ?, ?, ?, to_date(?, 'yyyy/MM/dd'), ?, ?, ?, ?, ?, ?, ?)";
		int cnt = -99999;
		try {
			if (conn == null) {
				super.conn = super.getConn();
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
			pstmt.setString(12, bean.getZipcode());
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
					super.closeConn();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public boolean checkId(String id) {
		boolean check = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select id from members where id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
				if(rs.next()){
					check = false;
				}else{
					check = true;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e){
		}finally {
			try {
				if (pstmt != null) {pstmt.close();}
				if (rs != null) {rs.close();}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
}
