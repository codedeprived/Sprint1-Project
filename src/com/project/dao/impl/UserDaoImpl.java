package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.UserDao;
import com.project.dto.User;
import com.project.utility.DbConnection;

public class UserDaoImpl implements UserDao {

	private Connection con = null;
	private PreparedStatement ps = null;

	@Override
	public boolean addUser(User user) {

		con = DbConnection.getConnection();
		try {
			ps = con.prepareStatement(
					"insert into tbl_user(first_name , last_name , email , password) values(?,?,?,?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());

			int row = ps.executeUpdate();
			if (row > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean updateUser(User user) {
		con = DbConnection.getConnection();
		try {
			ps = con.prepareStatement("update  tbl_user set first_name = ? , last_name = ? , email = ?, password = ?");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());

			int row = ps.executeUpdate();
			if (row > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean deleteUser(String email) {
		con = DbConnection.getConnection();
		try {
			ps = con.prepareStatement("delete from tbl_user where email = ?");
			ps.setString(1, email);

			int row = ps.executeUpdate();
			if (row > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<User> showAllUser() {
		con = DbConnection.getConnection();
		ResultSet rs = null;
		List<User> allUsers = new ArrayList<>();
		try {
			ps = con.prepareStatement("select * from tbl_user");

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String LastName = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);

				allUsers.add(new User(id, firstName, LastName, email, password));
			}

			return allUsers;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public User searchUser(String email) {

		con = DbConnection.getConnection();
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("Select * from tbl_user where email = ?");
			ps.setString(1, email);
			rs = ps.executeQuery();
//			if (rs.equals(null)) {
//				return null;
//			}
			int id = 0;
			String firstName = null;
			String lastName = null;
			String password = null;
			String Email = null;
			while (rs.next()) {
				id = rs.getInt(1);
				firstName = rs.getString(2);
				lastName = rs.getString(3);
				Email = rs.getString(4);
				password = rs.getString(5);
			}
			if (id == 0) {
				return null;
			}
			User user = new User(id, firstName, lastName, Email, password);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
