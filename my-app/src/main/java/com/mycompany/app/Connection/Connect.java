package com.mycompany.app.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	Connection conn;
	public Connect () {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		    System.out.println("Error al registrar el driver de MySQL: " + ex);
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://83.213.204.144:3306/calculatus_root","calculaTUS_root", "Nevera98!");
			boolean ok = say_hello(conn);
			System.out.println(ok);
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
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
	
	
	
	public static void main(String[] args) {
		Connect c = new Connect();
	}
}
