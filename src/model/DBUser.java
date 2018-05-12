package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBConn;

public class DBUser {
	public static List<UserInfo> findAllUsers() throws SQLException {
		Connection conn = DBConn.getConn();
		String sql = "select * from users";
		PreparedStatement stmt;
		List<UserInfo> userList = new ArrayList<UserInfo>();
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			UserInfo uBean = new UserInfo(rs.getInt("id"), rs.getString("name"), rs.getString("password"),
					rs.getString("major"));
			userList.add(uBean);
		}
		DBConn.closeAll(conn, stmt, rs);
		return userList;
	}

	public static void AddUser(UserInfo u) throws SQLException {
		Connection conn = DBConn.getConn();
		String sql = "INSERT INTO users(id, name, password, major)" + "values(?,?,?,?)";
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, u.id);
		stmt.setString(2, u.name);
		stmt.setString(3, u.password);
		stmt.setString(4, u.major);
		stmt.executeUpdate();
	}
}
