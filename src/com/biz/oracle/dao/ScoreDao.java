package com.biz.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDao {
	
	Connection conn;
	
	public void dbConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "myMem";
			String password = "1234";
			
			conn = DriverManager.getConnection(url, user, password);
		
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectScore() {
		
		String sql = "SELECT * FROM tbl_score";
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(true) {
				if(rs.next() == false)
					break;
				
				String strID = rs.getString("g_id");
				String strSub = rs.getString("g_subject");
				int intScore = rs.getInt("g_score");
				String strNum = rs.getString("g_stnum");
				
				System.out.print(strID + "\t");
				System.out.print(strSub + "\t");
				System.out.print(strNum + "\t");
				System.out.print(intScore + "\n");
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
