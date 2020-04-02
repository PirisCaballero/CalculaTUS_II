package com.mycompany.app.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mycompany.app.Users;

public class Connect {
	
	Connection conn;
	public Connection Open_connection () {
		conn = null;
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		    System.out.println("Error al registrar el driver de MySQL: " + ex);
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://83.213.204.144:3306/calculatus_root","calculaTUS_root", "Nevera98!");
			boolean ok = say_hello(conn);
			System.out.println(ok);
			return conn;
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return conn;
		}
	}
	public boolean say_hello(Connection cn) {
		try {
			if(cn.isValid(50000)) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}
	public void good_by(Connection cn) {
		try {
			cn.close();
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
		}
	}
	public boolean RegisUser(Users us) {
		String sql = "Insert Into users Values (? , ? , ? , ? , ? , ?)";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, us.getNombre());
			stmt.setString(2, us.getApellidos());
			stmt.setString(3, us.getEmail());
			stmt.setString(4, us.getPass());
			stmt.setInt(5, us.getAdmin());
			stmt.setString(6, us.getAdminEmail());
			/////
			System.out.println(stmt.executeUpdate());
			good_by(cn);
			return true;
		}catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {
		Connect c = new Connect();
		Users Nekane = new Users("Nekane" , "Garcia" , "nekane.garcia@deusto.es" , "mesa123" , 1 , "null");
		Users Luis = new Users("Luis", "Gomez", "luis.gomez@deusto.es", "lavadora", 0 , "nekane.garcia@deusto.es");
		c.RegisUser(Nekane);
		c.RegisUser(Luis);
	}
}
