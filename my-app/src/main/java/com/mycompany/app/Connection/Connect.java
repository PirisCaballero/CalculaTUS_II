package com.mycompany.app.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;

import com.mycompany.app.Local;
import com.mycompany.app.Producto;
import com.mycompany.app.Users;

public class Connect {

	Connection conn;

	public Connection Open_connection() {
		conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de MySQL: " + ex);
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://83.213.204.144:3306/calculatus_root", "calculaTUS_root",
					"Nevera98!");
			boolean ok = say_hello(conn);
			System.out.println(ok);
			return conn;
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return conn;
		}
	}

	private boolean say_hello(Connection cn) {
		try {
			if (cn.isValid(50000)) {
				return true;
			} else {
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
		} catch (SQLException sqlE) {
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
			while (rs.next()) {
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
				cont += 1;
			}
			if (cont == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			return false;
		}
	}

	private boolean buscar_local(Users user, Local loc) {
		String sql = "Select * from locales where Nombre = ? and email_duenio = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, loc.getNombre());
			stmt.setString(2, user.getEmail());
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont += 1;
			}
			if (cont == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			return false;
		}
	}

	public Users Verificar_usuario(String email, String pass) {
		Users us = null;
		String sql = "Select * from users where email = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			us = new Users();
			int cont = 0;
			while (rs.next()) {
				us.setNombre(rs.getString(1));
				us.setApellidos(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPass(rs.getString(4));
				us.setAdmin(rs.getInt(5));
				us.setAdminEmail(rs.getString(6));
				cont += 1;
			}
			System.out.println(cont);
			if (cont > 0) {
				if (us.getPass().equals(pass)) {
					System.out.println("Usuario verificado");
					return us;
				} else {
					System.out.println("Usuario no verificado");
					Users user = null;
					return user;
				}
			} else {
				Users user = null;
				return user;
			}
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			Users user = null;
			return user;
		}
	}

	private Users Recuperar_usuario(String user_Adminemail) {
		Users us = new Users();
		String sql = "Select * from users where email = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, user_Adminemail);
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				us.setNombre(rs.getString(1));
				us.setApellidos(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPass(rs.getString(4));
				us.setAdmin(rs.getInt(5));
				us.setAdminEmail(rs.getString(6));
				cont += 1;
			}
			if (cont == 1) {
				System.out.println("Usuario recuperado");
				return us;
			} else {
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
				System.out.println("Usuario no recuperado");
				return null;
			}
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return null;
		}
	}

	private boolean isAdmin(Users user) {
		if (user.getAdminEmail() == "null") {
			System.out.println("Este usuario es admin");
			return true;
		} else {
			Users us = Recuperar_usuario(user.getAdminEmail());
			System.out.println(us.toString());
			if (us != null && us.getAdmin() == 1) {
				System.out.println("El usuario al que hace referencia es admin");
				return true;
			} else {
				// JOptionPane.showMessageDialog(null, "El usuario al que hace referencia no es
				// admin");
				System.out.println("El usuario al que hace referencia no es admin");
				return false;
			}
		}
	}

	public boolean RegisLocal(Users user, Local loc) {
		if (!buscar_local(user, loc)) {
			System.out.println("El local no esta registrado");
			String sql = "Insert into locales Values ( ? , ? , ? , ? , ? , ? )";
			Connection cn = Open_connection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, 0);
				stmt.setString(2, loc.getNombre());
				stmt.setString(3, loc.getDireccion());
				stmt.setInt(4, loc.getCp());
				stmt.setString(5, loc.getDescripcion());
				stmt.setString(6, user.getEmail());
				////////
				System.out.println(stmt.executeUpdate());
				good_by(cn);
				return true;
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ese local ya esta registrado");
			return false;
		}
	}

	public boolean RegisUser(Users us) {
		if (!buscar_usuario(us.getEmail())) {
			System.out.println("Usuario no registrado");
			if (isAdmin(us)) {
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
				} catch (SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
					return false;
				}
			} else {
				// JOptionPane.showMessageDialog(null, "Ese administrador no existe");
				System.out.println("Ese administrador no existe");
				return false;
			}
		} else {
			// JOptionPane.showMessageDialog(null, "Usuario ya registrado");
			System.out.println("Usuario ya registrado");
			return false;
		}
	}

	private ArrayList<Users> getUsers() {
		ArrayList<Users> usersList = new ArrayList<Users>();
		String sql = "Select * from users";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
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
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			ArrayList<Users> r = new ArrayList<Users>();
			return r;
		}
	}

	public void list_users() {
		ArrayList<Users> ul = getUsers();
		for (Users u : ul) {
			System.out.println(u.toString());
		}
	}
	public Local getLocal_byName(Users us , String locName) {
		//TODO
		Local loc = null;
		String sql = "Select * from locales where email_duenio = ? and Nombre = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, us.getEmail());
			stmt.setString(2, locName);
			ResultSet rs = stmt.executeQuery();
			//TODO
			while(rs.next()) {
				loc = new Local(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				loc.setId(rs.getInt(1));
				System.out.println(rs.getInt(1));
			}
			good_by(cn);
			return loc;
		}catch(SQLException sqle) {
			System.out.println(sqle);
			sqle.printStackTrace();
			return null;
		}
	}
	public ArrayList<Producto> getProducts_byLocal(Users us , int loc_ID) {
		ArrayList<Producto> prList = null;
		String sql = "Select * from productos where idLocal = ? and email_comprador = ?";
		Connection cn = Open_connection();
		prList = new ArrayList<Producto>();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, loc_ID);
			stmt.setString(2, us.getEmail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Producto pr = new Producto(rs.getDouble(3), rs.getString(2), 1 , rs.getInt(4) , us.getEmail());
				prList.add(pr);
				//System.out.println(pr.toString());
			}
			good_by(cn);
			return prList;
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return null;
		}
	}
	public boolean anadirProducto(Users usAd , Producto pr , int loc_ID) {
		String sql = "Insert Into productos Values( ? , ? , ? , ? , ? )";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2, pr.getNombre());
			stmt.setDouble(3, pr.getPrecio());
			stmt.setInt(4, loc_ID);
			stmt.setString(5, usAd.getEmail());
			int aniadido = stmt.executeUpdate();
			good_by(cn);
			if( aniadido == 1 ) {
				JOptionPane.showMessageDialog(null, "Producto Añadido");
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "El producto no ha podido ser añadido");
				return false;
			}
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return false;
		}
	}
	public boolean cambio_de__tipo_de_usuario(Users log_user, String user_to_change, int cambio) {
		Users userChanged = Recuperar_usuario(user_to_change);
		System.out.println(userChanged.toString());
		if (log_user.getAdmin() == 1) {
			System.out.println("El usuario es admin, OK");
			System.out.println(log_user.getEmail() + "||" + userChanged.getAdminEmail());
			if (log_user.getEmail().equals(userChanged.getAdminEmail())) {
				System.out.println("El usuario a cambiar es del usuario administrador");
				String sql = "Update users set admin = ? , admin_email = ? where email = ?";
				Connection cn = Open_connection();
				try {
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setInt(1, cambio);
					if( cambio == 1 ) {
						stmt.setString(2, "null");
					}else {
						stmt.setString(2, log_user.getEmail());
					}
					stmt.setString(3, user_to_change);
					System.out.println(stmt.executeUpdate());
					good_by(cn);
					return true;
				} catch (SQLException sqlE) {
					System.out.println(sqlE);
					return false;
				}
			} else {
				System.out.println("El usuario a cambiar no pertenece al usuario administrador");
				return false;
			}
		} else {
			System.out.println("El usuario " + log_user.getNombre() + "no es administrador");
			return false;
		}
	}

	public ArrayList<Local> getLocales(Users us) {
		ArrayList<Local> localesList = new ArrayList<Local>();
		String sql = "Select * from locales where email_duenio = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, us.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Local loc = new Local(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				localesList.add(loc);
				//System.out.println(loc.toString());
			}
			return localesList;
		} catch (SQLException sqlE) {
			localesList = null;
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return localesList;
		}
	}
	
	public ArrayList<Users> getUsers_byAdmin(Users usAd){
		ArrayList<Users> userList = null;
		String sql = "Select * from users where admin_email = ?";
		Connection cn = Open_connection();
		try {
			userList = new ArrayList<Users>();
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, usAd.getEmail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Users us = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
				System.out.println(us.toString());
				userList.add(us);
			}
			good_by(cn);
			return userList;
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return userList;
		}
	}

	public static void main(String[] args) {
		Connect c = new Connect();
		Local loc = new Local("Prueba", "C/Pr", 48920, "Esta good");
		Producto pr = new Producto(2.1 , "EroskiPR", 1 , 18 , "admin@root.es");
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		c.anadirProducto(us, pr, 18);

	}
}
