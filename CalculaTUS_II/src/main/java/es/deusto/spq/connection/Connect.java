package es.deusto.spq.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;

import es.deusto.spq.Local;
import es.deusto.spq.Opinion;
import es.deusto.spq.Producto;
import es.deusto.spq.Ticket;
import es.deusto.spq.Users;

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

	public boolean say_hello(Connection cn) {
		try {
			if( cn != null ) {
				if (cn.isValid(50000)) {
					return true;
				} else {
					return false;
				}
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean good_by(Connection cn) {
		try {
			if(cn != null) {
				if(cn.isValid(50000)) {
					cn.close();
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return false;
		}
	}

	public boolean buscar_usuario(String email) {
		String sql = "Select * from users where email = ?";
		Connection cn = Open_connection();
		if( email != null && email != "" ) {
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setString(1, email);
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
		}else {
			return false;
		}
		
	}

	public boolean buscar_local(Users user, Local loc) {
		String sql = "Select * from locales where Nombre = ? and email_duenio = ?";
		Connection cn = Open_connection();
		if( user != null && loc != null) {
			if( buscar_usuario(user.getEmail()) ) {
				try {
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setString(1, loc.getNombre());
					stmt.setString(2, user.getEmail());
					ResultSet rs = stmt.executeQuery();
					int cont = 0;
					while (rs.next()) {
						cont += 1;
					}
					if (cont == 1) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException sqlE) {
					System.out.println(sqlE);
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	public Local getLocal_by_Id(Users user , int ID) {
		String sql = "Select * from locales where  idLocales = ? and email_duenio = ?";
		Connection cn = Open_connection();
		if( user != null ) {
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, ID);
				stmt.setString(2, user.getEmail());
				ResultSet rs = stmt.executeQuery();
				Local loc = new Local();
				int cont = 0;
				while (rs.next()) {
					loc.setId(ID);
					loc.setNombre(rs.getString(2));
					loc.setDireccion(rs.getString(3));
					loc.setCp(rs.getInt(4));
					loc.setDescripcion(rs.getString(5));
					cont += 1;
				}
				if(cont == 1) {
					return loc;
				}else {
					return null;
				}
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				return null;
			}
		}else {
			return null;
		}
		
	}

	public Users Verificar_usuario(String email, String pass) {
		Users us = null;
		String sql = "Select * from users where email = ?";
		Connection cn = Open_connection();
		if( email != "" && pass !="" && email != null && pass != null) {
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
		}else {
			return null;
		}
		
	}

	public Users Recuperar_usuario(String user_email) {
		Users us = new Users();
		String sql = "Select * from users where email = ?";
		Connection cn = Open_connection();
		if( user_email != "" && user_email != null ) {
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setString(1, user_email);
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
					JOptionPane.showMessageDialog(null, "Usuario no encontrado" + "-->"+cont);
					System.out.println("Usuario no recuperado");
					return null;
				}
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
	}

	public boolean isAdmin(Users user) {
		if( user != null ) {
			if( buscar_usuario(user.getEmail()) && user.getAdmin() == 1) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
					
	}
	public boolean RegisLocal(Users user, Local loc) {
		if( user != null && loc != null ) {
			if (!buscar_local(user, loc)) {
				if(buscar_usuario(user.getEmail())) {
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
				}else {
					return false;
				}			
			} else {
				JOptionPane.showMessageDialog(null, "Ese local ya esta registrado");
				return false;
			}
		}else {
			return false;
		}
		
	}

	public boolean RegisUser(Users us) {
		if( us != null ) {
			if (!buscar_usuario(us.getEmail())) {
				System.out.println("Usuario no registrado");
				Users usa = Recuperar_usuario(us.getAdminEmail());
				if (isAdmin(usa)) {
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
		}else {
			return false;
		}
	}
	public ArrayList<Producto> getProducts_by_ticket(Users user , int ticketID){
		ArrayList<Producto> pL = new ArrayList<Producto>();
		String sql = "Select * from elementoscompra where idTicket = ?";
		Connection cn = Open_connection();
		if( user != null ) {
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, ticketID);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Producto p = new Producto((String)rs.getString(2), Double.parseDouble( (String)rs.getString(3) ) , Integer.parseInt((String)rs.getString(4)));
					pL.add(p);
				}
				good_by(cn);
				return pL;
			}catch(SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
	}
	public Ticket getTicket_by_ticketID(int ID) {
		Ticket t = new Ticket();
		String sql = "Select * from tickets where idTickets = ?";
		Connection cn = Open_connection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				t.setID( rs.getInt(1) );
				t.setNombreUsuario(rs.getString(2));
				t.setImporte(rs.getDouble(3));
				t.setID_Lugar_Compra(rs.getInt(4));
				t.setFecha_emision(rs.getString(5));
			}
			good_by(cn);
			return t;
		}catch(SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return null;
		}
	}
	public ArrayList<Users> getUsers() {
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
		if( us != null && locName != null && locName != "" ) {
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
		}else {
			return null;
		}
		
	}
	public ArrayList<Producto> getProducts_byLocal(Users us , int loc_ID) {
		if( us != null ) {
			if( !buscar_usuario(us.getEmail()) ) {
				return null;
			}
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
		}else{
			return null;
		}
	}
	public boolean anadirProducto(Users usAd , Producto pr , int loc_ID) {
		if( usAd != null && pr != null && buscar_usuario(usAd.getEmail())) {
			Local l = getLocal_by_Id(usAd, loc_ID);
			if( l == null ) { 
				return false; 
			}
			if( getProduct_by_Name(usAd, pr.getNombre()) != null ) {
				return false;
			}
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
		}else {
			return false;
		}
	}
	public boolean cambio_de__tipo_de_usuario(Users log_user, String user_to_change, int cambio) {
		if( log_user != null && user_to_change != null && user_to_change != "") {
			Users userChanged = Recuperar_usuario(user_to_change);
			//System.out.println(userChanged.toString());
			if( userChanged == null ) {
				return false;
			}
			if (log_user.getAdmin() == 1) {
				//System.out.println("El usuario es admin, OK");
				//System.out.println(log_user.getEmail() + "||" + userChanged.getAdminEmail());
				if (log_user.getEmail().equals(userChanged.getAdminEmail())) {
					//System.out.println("El usuario a cambiar es del usuario administrador");
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
						//System.out.println(stmt.executeUpdate());
						good_by(cn);
						return true;
					} catch (SQLException sqlE) {
						//System.out.println(sqlE);
						return false;
					}
				} else {
					//System.out.println("El usuario a cambiar no pertenece al usuario administrador");
					return false;
				}
			} else {
				//System.out.println("El usuario " + log_user.getNombre() + "no es administrador");
				return false;
			}
		}else {
			return false;
		}
	}

	public ArrayList<Local> getLocales(Users us) {
		if( us != null && buscar_usuario(us.getEmail()) ) {
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
		}else {
			return null;
		}
	}
	
	public ArrayList<Users> getUsers_byAdmin(Users usAd){
		if( usAd != null && buscar_usuario(usAd.getEmail()) ) {
			if( isAdmin(usAd) ) {
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
					return null;
				}
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	public Producto getProduct_by_Name(Users user , String Nombre) {
		if( user != null && Nombre != "" ) {
			Producto p = null;
			String sql = "Select * from productos where Nombre = ? and email_comprador = ?";
			Connection cn = Open_connection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setString(1, Nombre);
				stmt.setString(2, user.getEmail());
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					p = new Producto(rs.getDouble(3), rs.getString(2), 1, rs.getInt(4), rs.getString(5));
					p.setID(rs.getInt(1));
				}
				//System.out.println("producto: "+p.getNombre()+p.getID());
				good_by(cn);
				return p;
			}catch(SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return p;
			}
		}else {
			return null;
		}
	}
	/*
	 * Funcion para crear un ticket
	 */
	public Ticket crearTicket(Users user , Ticket ti) {
		if( user != null && ti != null ) {
			if( buscar_usuario(user.getEmail()) ) {
				Ticket t = null;
				String sql = "INSERT INTO tickets VALUES ( ? , ? , ? , ? , ? )";
				Connection cn = Open_connection();
				try {
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setInt(1, 0);
					stmt.setString(2, user.getEmail());
					stmt.setDouble(3, ti.getImporte());
					stmt.setInt(4, ti.getID_Lugar_Compra());
					stmt.setString(5, ti.getFecha_emision());
					int rs = stmt.executeUpdate();
					if(rs == 1) {
						//JOptionPane.showMessageDialog(null, "Ticket generado satisfactoriamente");
						System.out.println("Ticket generado satisfactoriamente");
					}
					try {
						String sql2 = "Select * from tickets where email_comprador = ? and Importe = ? and idLocal = ? and fecha = ?";
						PreparedStatement stmt2 = cn.prepareStatement(sql2);
						stmt2.setString(1, user.getEmail());
						stmt2.setDouble(2, ti.getImporte());
						stmt2.setInt(3, ti.getID_Lugar_Compra());
						stmt2.setString(4, ti.getFecha_emision());
						ResultSet rs2 = stmt2.executeQuery();
						while(rs2.next()) {
							t = new Ticket((String)rs2.getString(5), rs2.getString(2), (Double)rs2.getDouble(3), rs2.getInt(4));
							t.setID(rs2.getInt(1));
						}
						good_by(cn);
						return t;
					}catch(SQLException sqlE2) {
						System.out.println(sqlE2);
						sqlE2.printStackTrace();
					}
				}catch(SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
				}
				return t;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	/*
	 * Funcion para añadir productos a la tabla de elementos de compra
	 */
	public boolean introducirProductosComprador(Users user , ArrayList<Producto> prL , Ticket t) {
		//TODO
		if( user != null && prL != null && t != null ) {
			int tam = prL.size();
			for(int i = 0 ; i<tam ; i++) {
				String sql = "Insert into elementoscompra VALUES ( ? , ? , ? , ?)";
				Connection cn = Open_connection();
				try {
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setInt(1, t.getID());
					stmt.setString(2, prL.get(i).getNombre());
					stmt.setDouble(3, prL.get(i).getPrecio());
					stmt.setInt(4, prL.get(i).getCantidad());
					int rs = stmt.executeUpdate();
					if(rs == 1) { System.out.println("YAS"); };
					}catch(SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
					return false;
					}
				}
			return true;
		}else {
			return false;
		}
	}
	public ArrayList<Ticket> getTickets_by_user(Users user){
		if( user != null ) {
			if( buscar_usuario(user.getEmail()) ) {
				ArrayList<Ticket> tL = new ArrayList<Ticket>();
				String sql = "Select * from tickets where email_comprador = ?";
				Connection cn = Open_connection();
				try {
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setString(1, user.getEmail());
					ResultSet rs = stmt.executeQuery();
					while(rs.next()) {
						Ticket ti = new Ticket((String)rs.getString(5), rs.getString(2), (Double)rs.getDouble(3), rs.getInt(4));
						ti.setID(rs.getInt(1));
						tL.add(ti);
					}
					return tL;
				}catch(SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
					return null;
				}
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	public boolean SaveOpinion(Opinion op) {
		if(op != null) {
			String sql = "Insert into opiniones values (? , ? , ? , ?)";
			Connection cn = Open_connection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, 0);
				stmt.setInt(2, op.getValoracion());
				stmt.setString(3, op.getComentario());
				stmt.setString(4, op.getEmail());
				int r = stmt.executeUpdate();
				if(r==1) {
					return true;
				}else {
					return false;
				}
			}catch(SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
}
