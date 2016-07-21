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
		Member bean = new Member();
		String sql = " select id, password, name, nickname, email1, email2, to_char(birth,'yyyy/MM/dd')as birth, gender, phone1, phone2, phone3, zipcode, address1, address2, to_char(regdate,'yyyy/MM/dd')as regdate from members ";
			   
				sql += " where id = ? ";
		this.conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean.setAddress1(rs.getString("address1"));
				bean.setAddress2(rs.getString("address2"));
				bean.setBirth(rs.getString("birth"));
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
				bean.setRegDate(rs.getString("regdate"));
				bean.setZipcode(rs.getString("zipcode"));
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

		return bean;
	}

	public List<Zipcode> SelectZipcode(String dong) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Zipcode> lists = new ArrayList<Zipcode>();
		String sql = " select * ";
		sql += " from zipcodes where dong like '%" + dong + "%'";
		sql += " order by sido asc, gugun asc, dong asc ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Zipcode zip = new Zipcode();
				zip.setBunji(rs.getString("bunji"));
				zip.setDong(rs.getString("dong"));
				zip.setGugun(rs.getString("gugun"));
				zip.setSido(rs.getString("sido"));
				zip.setZipcode(rs.getString("zipcode"));
				zip.setSeqnum(Integer.parseInt(rs.getString("seqnum")));
				// System.out.println(zip.toString());

				lists.add(zip);
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
			if (rs.next()) {
				check = false;
			} else {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	public boolean checkNickname(String nickname) {
		boolean check = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select nickname from members where nickname = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = false;
			} else {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	public int selectTotalCount(String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select count(*) as cnt from members ";
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
				this.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;

	}

	public List<Member> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select id, password, name, nickname, email1, email2, birth, gender, phone1, phone2, phone3, zipcode, address1, address2, regdate, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select id, password, name, nickname, email1, email2, birth, gender, phone1, phone2, phone3, zipcode, address1, address2, regdate, rank() over( order by id asc ) as ranking ";
		sql += " from members ";
		
		if( mode.equals("all") == false ){
			sql += " where lower(" + mode + ") like lower('" + keyword + "')"; 
		}
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		List<Member> lists = new ArrayList<Member>();
		try {
			if (this.conn == null) {
				this.conn = this.getConn();
			}
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
				bean.setPassword(rs.getString("password"));
				bean.setPhone1(rs.getString("phone1"));
				bean.setPhone2(rs.getString("phone2"));
				bean.setPhone3(rs.getString("phone3"));
				bean.setRegDate(rs.getString("regDate"));
				bean.setZipcode(rs.getString("zipcode"));
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
				this.closeConn();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public int DeleteDate(String id) {
		String sql = " delete from members where id = ? " ;
		PreparedStatement pstmt = null ;
		int cnt = -99999 ;
		try {
			if( conn == null ){ super.conn = super.getConn() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setString(1, id);			
			cnt = pstmt.executeUpdate(); 
			conn.commit(); 
		} catch (Exception e) {
			SQLException err = (SQLException)e;			
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