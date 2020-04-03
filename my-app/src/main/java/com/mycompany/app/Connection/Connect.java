package com.mycompany.app.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
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
	private boolean say_hello(Connection cn) {
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
	private void good_by(Connection cn) {
		try {
			cn.close();
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
		}
	}
	
	private boolean buscar_usuario(String email) {
		String sql = "Select * from users where email = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while ( rs.next() ) {
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
				cont +=1;
			}
			if(cont == 0) {
				return false;
			}else {
				return true;
			}
		}catch (SQLException sqlE) {
			System.out.println(sqlE);
			return false;
		}
	}
	public Users Verificar_usuario(String email , String pass) {
		Users us = null;
		String sql = "Select * from users where email = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			us = new Users();
			int cont =0;
			while(rs.next()) {
				us.setNombre(rs.getString(1));
				us.setApellidos(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPass(rs.getString(4));
				us.setAdmin(rs.getInt(5));
				us.setAdminEmail(rs.getString(6));
				cont+=1;
			}
			System.out.println(cont);
			if(cont >0) {
				if( us.getPass().equals(pass) ) {
					System.out.println("Usuario verificado");
					return us;
				}else {
					System.out.println("Usuario no verificado");
					Users user = null;
					return user; 
				}
			}
			else { 
				Users user = null;
				return user; 
			}  
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			Users user = null;
			return user; 
		}
	}
	private Users Recuperar_usuario(Users user) {
		Users us = new Users();
		String sql = "Select * from users where email = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, user.getAdminEmail());
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while(rs.next()) {
				us.setNombre(rs.getString(1));
				us.setApellidos(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPass(rs.getString(4));
				us.setAdmin(rs.getInt(5));
				us.setAdminEmail(rs.getString(6));
				cont += 1;
			}
			if(cont == 1 ) {
				System.out.println("Usuario recuperado");
				return us;
			}else {
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
				System.out.println("Usuario no recuperado");
				return null;
			}
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return null;
		}
	}
	private boolean isAdmin(Users user) {
		if( user.getAdminEmail()=="null" ) {
			System.out.println("Este usuario es admin");
			return true;
		}else {
			Users us = Recuperar_usuario(user);
			System.out.println(us.toString());
			if(us != null && us.getAdmin()==1 ) {
				System.out.println("El usuario al que hace referencia es admin");
				return true;
			}else {
				//JOptionPane.showMessageDialog(null, "El usuario al que hace referencia no es admin");
				System.out.println("El usuario al que hace referencia no es admin");
				return false;
			}
		}
	}
	public boolean RegisUser(Users us) {
		if( !buscar_usuario(us.getEmail()) ) {
			System.out.println("Usuario no registrado");
			if( isAdmin(us) ) {
				System.out.println("Administrador registrado");
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
					JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
					return true;
				}catch (SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
					return false;
				}
			}else {
				//JOptionPane.showMessageDialog(null, "Ese administrador no existe");
				System.out.println("Ese administrador no existe");
				return false;
			}
		}else {
			//JOptionPane.showMessageDialog(null, "Usuario ya registrado");
			System.out.println("Usuario ya registrado");
			return false;
		}
	}
	private ArrayList<Users> getUsers(){
		ArrayList<Users> usersList = new ArrayList<Users>();
		String sql = "Select * from users";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while( rs.next() ) {
				Users us = new Users();
				us.setNombre(rs.getString(1));
				us.setApellidos(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPass(rs.getString(4));
				us.setAdmin(rs.getInt(5));
				us.setAdminEmail(rs.getString(6));
				usersList.add(us);
			}
			return usersList;
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			ArrayList<Users> r = new ArrayList<Users>();
			return r;
		}
	}
	public void list_users() {
		ArrayList<Users> ul = getUsers();
		for(Users u : ul) {
			System.out.println( u.toString() );
		}
	}
	
	
	
	public static void main(String[] args) {
		Connect c = new Connect();
		Users Aitor = new Users("Eneko" , "Valero Cuenca" , "eneko.valero@deusto.es" , "mesa555" , 0 , "Iratxe.campo@deusto.es" );
		c.RegisUser(Aitor);
	}
}
