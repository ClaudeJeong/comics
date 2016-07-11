package mypkg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDao {
//Instance
	private String driver = "oracle.jdbc.driver.OracleDriver";
	protected Connection conn = null;
	private String url = "jdbc:oracle:thin:@localhost:1522:xe" ;
	private String id = "comics";
	private String password = "oracle";
//Constructor	
	public SuperDao(){
		try {
			Class.forName(driver);
			this.conn=getConnection();
			if(conn != null){
				System.out.println("立加己傍");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("立加角菩");
			e.printStackTrace();
		}
	}
	protected Connection getConnection() {
		try {
			return conn=DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
		public void closeConnection(){
			if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
