package mypkg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SuperDao {
//Instance
	protected Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "comics";
	private String password = "oracle";

//Method	
	protected Connection getConn(){
		try {
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void closeConn(){
		//conn = null;
		//if (conn != null) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	//}

//Constructor
	public SuperDao(){
		try {
			Class.forName(driver);
			this.conn = getConn();
			if(conn != null){
				//System.out.println("db立加肯丰~~");
			}else{
				//System.out.println("db立加角菩ばば");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
