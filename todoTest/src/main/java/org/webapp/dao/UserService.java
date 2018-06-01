package org.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {
	private static final String URL = "jdbc:mysql://192.168.0.203/test_db?useSSL=no&characterEncoding=utf8";
	private static final String USER = "mingyun";
	private static final String PW = "alsrbs3193!";

	Connection conn; // sql 접속할 수 있게 설정하는 객체
	PreparedStatement ps; // sql 쿼리를 실행시켜주는 객체
	ResultSet rs; // sql select 쿼리 결과를 리턴받아 저장하는 객체

	// sql 접소 메소드
	public void getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PW);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원가입 메소드
	public boolean saveUser(User user) {
		int status = 0;
		try {
			getConn();
			String sql = "insert into todo01_user(id, password, name) values(?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());

			status = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status != 0 ? true : false;
	}
}
