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

	/**
	 * Crea la conexion a la Base de Datos
	 * 
	 * @return conn
	 */
	public Connection OpenConnection() {
		conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de MySQL: " + ex);
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://83.213.204.144:3306/calculatus_root", "calculaTUS_root",
					"Nevera98!");
			return conn;
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return conn;
		}
	}

	/**
	 * 
	 * @param cn
	 * @return boolean
	 */
	public boolean sayHello(Connection cn) {
		try {
			if (cn != null) {
				if (cn.isValid(50000)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Cierra la conexion con la BD
	 * 
	 * @param cn
	 * @return boolean
	 */
	public boolean goodBy(Connection cn) {
		try {
			if (cn != null) {
				if (cn.isValid(50000)) {
					cn.close();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return false;
		}
	}

	/**
	 * Busca un usuario en la BD
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean buscarUsuario(String email) {
		String sql = "Select * from users where email = ?";
		Connection cn = OpenConnection();
		if (email != null && email != "") {
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
		} else {
			return false;
		}

	}

	/**
	 * Busca un local en la BD
	 * 
	 * @param user
	 * @param loc
	 * @return boolean
	 */
	public boolean buscarLocal(Users user, Local loc) {
		String sql = "Select * from locales where Nombre = ? and email_duenio = ?";
		Connection cn = OpenConnection();
		if (user != null && loc != null) {
			if (buscarUsuario(user.getEmail())) {
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
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * Recibe Local buscado en la BD
	 * 
	 * @param user
	 * @param ID
	 * @return Local
	 */
	public Local getLocalById(Users user, int ID) {
		String sql = "Select * from locales where  idLocales = ? and email_duenio = ?";
		Connection cn = OpenConnection();
		if (user != null) {
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
				if (cont == 1) {
					return loc;
				} else {
					return null;
				}
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				return null;
			}
		} else {
			return null;
		}

	}

	/**
	 * Comprueba si existe un Usuario
	 * 
	 * @param email
	 * @param pass
	 * @return User
	 */
	public Users VerificarUsuario(String email, String pass) {
		Users us = null;
		String sql = "Select * from users where email = ?";
		Connection cn = OpenConnection();
		if (email != "" && pass != "" && email != null && pass != null) {
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
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @param user_email
	 * @return User
	 */
	public Users RecuperarUsuario(String user_email) {
		Users us = new Users();
		String sql = "Select * from users where email = ?";
		Connection cn = OpenConnection();
		if (user_email != "" && user_email != null) {
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
					// JOptionPane.showMessageDialog(null, "Usuario no encontrado" + "-->"+cont);
					System.out.println("Usuario no recuperado");
					return null;
				}
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Registra un Local en la BD
	 * 
	 * @param user
	 * @param loc
	 * @return boolean
	 */
	public boolean RegisLocal(Users user, Local loc) {
		if (user != null && loc != null) {
			if (!buscarLocal(user, loc)) {
				if (buscarUsuario(user.getEmail())) {
					String sql = "Insert into locales Values ( ? , ? , ? , ? , ? , ? )";
					Connection cn = OpenConnection();
					try {
						PreparedStatement stmt = cn.prepareStatement(sql);
						stmt.setInt(1, 0);
						stmt.setString(2, loc.getNombre());
						stmt.setString(3, loc.getDireccion());
						stmt.setInt(4, loc.getCp());
						stmt.setString(5, loc.getDescripcion());
						stmt.setString(6, user.getEmail());
						////////
						goodBy(cn);
						return true;
					} catch (SQLException sqlE) {
						System.out.println(sqlE);
						sqlE.printStackTrace();
						return false;
					}
				} else {
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ese local ya esta registrado");
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * Comprueba si un Usuario es Admin
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean isAdmin(Users user) {
		if (user != null) {
			if (buscarUsuario(user.getEmail()) && user.getAdmin() == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * Registra un Usuario en la BD
	 * 
	 * @param us
	 * @return boolean
	 */
	public boolean RegisUser(Users us) {
		if (us != null) {
			if (!buscarUsuario(us.getEmail())) {
				if (us.getAdminEmail() == "null") {
					String sql = "Insert Into users Values (? , ? , ? , ? , ? , ?)";
					Connection cn = OpenConnection();
					try {
						PreparedStatement stmt = cn.prepareStatement(sql);
						stmt.setString(1, us.getNombre());
						stmt.setString(2, us.getApellidos());
						stmt.setString(3, us.getEmail());
						stmt.setString(4, us.getPass());
						stmt.setInt(5, us.getAdmin());
						stmt.setString(6, us.getAdminEmail());
						/////
						goodBy(cn);
						JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
						return true;
					} catch (SQLException sqlE) {
						System.out.println(sqlE);
						sqlE.printStackTrace();
						return false;
					}
				} else {
					Users usa = RecuperarUsuario(us.getAdminEmail());
					if (isAdmin(usa)) {
						System.out.println("Administrador registrado");
						String sql = "Insert Into users Values (? , ? , ? , ? , ? , ?)";
						Connection cn = OpenConnection();
						try {
							PreparedStatement stmt = cn.prepareStatement(sql);
							stmt.setString(1, us.getNombre());
							stmt.setString(2, us.getApellidos());
							stmt.setString(3, us.getEmail());
							stmt.setString(4, us.getPass());
							stmt.setInt(5, us.getAdmin());
							stmt.setString(6, us.getAdminEmail());
							/////
							goodBy(cn);
							JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
							return true;
						} catch (SQLException sqlE) {
							System.out.println(sqlE);
							sqlE.printStackTrace();
							return false;
						}
					} else {
						return false;
					}
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

	/**
	 * Busca los Productos de un Ticket y un Usuario
	 * 
	 * @param user
	 * @param ticketID
	 * @return ArrayList de Productos de un Ticket
	 */
	public ArrayList<Producto> getProductsByTicket(Users user, int ticketID) {
		ArrayList<Producto> pL = new ArrayList<Producto>();
		String sql = "Select * from elementoscompra where idTicket = ?";
		Connection cn = OpenConnection();
		if (user != null) {
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, ticketID);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Producto p = new Producto((String) rs.getString(2), Double.parseDouble((String) rs.getString(3)),
							Integer.parseInt((String) rs.getString(4)));
					pL.add(p);
				}
				goodBy(cn);
				return pL;
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Busca un Ticket por su ID en la BD
	 * 
	 * @param ID
	 * @return Ticket
	 */
	public Ticket getTicketByTicketID(int ID) {
		Ticket t = new Ticket();
		String sql = "Select * from tickets where idTickets = ?";
		Connection cn = OpenConnection();
		try {
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				t.setID(rs.getInt(1));
				t.setNombreUsuario(rs.getString(2));
				t.setImporte(rs.getDouble(3));
				t.setID_Lugar_Compra(rs.getInt(4));
				t.setFecha_emision(rs.getString(5));
			}
			goodBy(cn);
			return t;
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return null;
		}
	}

	/**
	 * Busca todos los Usuarios en la BD
	 * 
	 * @return ArrayList de Usuarios
	 */
	public ArrayList<Users> getUsers() {
		ArrayList<Users> usersList = new ArrayList<Users>();
		String sql = "Select * from users";
		Connection cn = OpenConnection();
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

	/**
	 * Mete todos los Usuarios en un ArrayList
	 */
	public void listUsers() {
		ArrayList<Users> ul = getUsers();
		for (Users u : ul) {
			System.out.println(u.toString());
		}
	}

	/**
	 * Busca un Local por su nombre en la BD
	 * 
	 * @param us
	 * @param locName
	 * @return Local
	 */
	public Local getLocalByName(Users us, String locName) {
		// TODO
		if (us != null && locName != null && locName != "") {
			Local loc = null;
			String sql = "Select * from locales where email_duenio = ? and Nombre = ?";
			Connection cn = OpenConnection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setString(1, us.getEmail());
				stmt.setString(2, locName);
				ResultSet rs = stmt.executeQuery();
				// TODO
				while (rs.next()) {
					loc = new Local(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
					loc.setId(rs.getInt(1));
				}
				goodBy(cn);
				return loc;
			} catch (SQLException sqle) {
				System.out.println(sqle);
				sqle.printStackTrace();
				return null;
			}
		} else {
			return null;
		}

	}

	/**
	 * Busca una Categoria por su nombre en la BD
	 * 
	 * @param id
	 * @return String
	 */
	public String getCategoriaByID(int id) {
		if (id > 0) {
			String sql = "Select Nombre from categoria where ID_Categoria = ?";
			Connection c = OpenConnection();
			try {
				PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				int cont = 0;
				String cat = "";
				while (rs.next()) {
					cont += 1;
					cat = rs.getString(1);
				}
				if (cont == 1) {
					return cat;
				} else {
					goodBy(c);
					return null;
				}
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Devuelve una lista de Categorias
	 * 
	 * @return ArrayList de Categorias
	 */
	public ArrayList<String> getCategorias() {
		ArrayList<String> categorias = new ArrayList<String>();
		String sql = "Select Nombre from categoria";
		Connection c = OpenConnection();
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				categorias.add(rs.getString(1));
			}
			goodBy(c);
			return categorias;
		} catch (SQLException sqlE) {
			System.out.println(sqlE);
			sqlE.printStackTrace();
			return null;
		}
	}

	/**
	 * Busca una lista de Productos de un Local y un Usuario en concreto
	 * 
	 * @param us
	 * @param loc_ID
	 * @return ArrayList de Productos
	 */
	public ArrayList<Producto> getProductsByLocal(Users us, int loc_ID) {
		if (us != null) {
			if (!buscarUsuario(us.getEmail())) {
				return null;
			}
			ArrayList<Producto> prList = null;
			String sql = "Select * from productos where idLocal = ? and email_comprador = ?";
			Connection cn = OpenConnection();
			prList = new ArrayList<Producto>();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, loc_ID);
				stmt.setString(2, us.getEmail());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Producto pr = new Producto(rs.getDouble(3), rs.getString(2), 1, rs.getInt(4), us.getEmail(),
							rs.getString(6));
					prList.add(pr);
					// System.out.println(pr.toString());
				}
				goodBy(cn);
				return prList;
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Añade productos a la BD
	 * 
	 * @param usAd
	 * @param pr
	 * @param loc_ID
	 * @return boolean
	 */
	public boolean anadirProducto(Users usAd, Producto pr, int loc_ID) {
		if (usAd != null && pr != null && buscarUsuario(usAd.getEmail())) {
			Local l = getLocalById(usAd, loc_ID);
			if (l == null) {
				return false;
			}
			if (getProductByName(usAd, pr.getNombre()) != null) {
				return false;
			}
			String sql = "Insert Into productos Values( ? , ? , ? , ? , ? , ? )";
			Connection cn = OpenConnection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, 0);
				stmt.setString(2, pr.getNombre());
				stmt.setDouble(3, pr.getPrecio());
				stmt.setInt(4, loc_ID);
				stmt.setString(5, usAd.getEmail());
				stmt.setString(6, pr.getCategoria());
				int aniadido = stmt.executeUpdate();
				goodBy(cn);
				if (aniadido == 1) {
					JOptionPane.showMessageDialog(null, "Producto Añadido");
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "El producto no ha podido ser añadido");
					return false;
				}
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Cambia un Usuario normal a Admin o viceversa
	 * 
	 * @param log_user
	 * @param user_to_change
	 * @param cambio
	 * @return boolean
	 */
	public boolean cambioDeTipoDeUsuario(Users log_user, String user_to_change, int cambio) {
		if (log_user != null && user_to_change != null && user_to_change != "") {
			Users userChanged = RecuperarUsuario(user_to_change);
			// System.out.println(userChanged.toString());
			if (userChanged == null) {
				return false;
			}
			if (log_user.getAdmin() == 1) {
				// System.out.println("El usuario es admin, OK");
				// System.out.println(log_user.getEmail() + "||" + userChanged.getAdminEmail());
				if (log_user.getEmail().equals(userChanged.getAdminEmail())) {
					// System.out.println("El usuario a cambiar es del usuario administrador");
					String sql = "Update users set admin = ? , admin_email = ? where email = ?";
					Connection cn = OpenConnection();
					try {
						PreparedStatement stmt = cn.prepareStatement(sql);
						stmt.setInt(1, cambio);
						if (cambio == 1) {
							stmt.setString(2, "null");
						} else {
							stmt.setString(2, log_user.getEmail());
						}
						stmt.setString(3, user_to_change);
						// System.out.println(stmt.executeUpdate());
						goodBy(cn);
						return true;
					} catch (SQLException sqlE) {
						// System.out.println(sqlE);
						return false;
					}
				} else {
					// System.out.println("El usuario a cambiar no pertenece al usuario
					// administrador");
					return false;
				}
			} else {
				// System.out.println("El usuario " + log_user.getNombre() + "no es
				// administrador");
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Busca los Locales de un Usuario en la BD
	 * 
	 * @param us
	 * @return ArrayList de Locales
	 */
	public ArrayList<Local> getLocales(Users us) {
		if (us != null && buscarUsuario(us.getEmail())) {
			ArrayList<Local> localesList = new ArrayList<Local>();
			String sql = "Select * from locales where email_duenio = ?";
			Connection cn = OpenConnection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setString(1, us.getEmail());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Local loc = new Local(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
					localesList.add(loc);
					// System.out.println(loc.toString());
				}
				return localesList;
			} catch (SQLException sqlE) {
				localesList = null;
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return localesList;
			}
		} else {
			return null;
		}
	}

	/**
	 * Busca Usuarios cuyo email del admin es el mismo
	 * 
	 * @param usAd
	 * @return ArrayList de Usuarios
	 */
	public ArrayList<Users> getUsersByAdmin(Users usAd) {
		if (usAd != null && buscarUsuario(usAd.getEmail())) {
			if (isAdmin(usAd)) {
				ArrayList<Users> userList = null;
				String sql = "Select * from users where admin_email = ?";
				Connection cn = OpenConnection();
				try {
					userList = new ArrayList<Users>();
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setString(1, usAd.getEmail());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						Users us = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getInt(5), rs.getString(6));
						userList.add(us);
					}
					goodBy(cn);
					return userList;
				} catch (SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public ArrayList<Producto> getProductsByUser(Users u){
		if(u!=null) {
			ArrayList<Producto> prodArr = new ArrayList<Producto>();
			String sql = "Select * from productos where email_comprador = ?";
			Connection cn = OpenConnection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setString(1, u.getEmail());
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Producto p = new Producto(rs.getDouble(3), rs.getString(2), 1, rs.getInt(4), rs.getString(5), rs.getString(6));
					p.setID(rs.getInt(1));
					prodArr.add(p);
				}
				goodBy(cn);
				return prodArr;
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
				return null;
			}
		}
		else return null;
	}
	
	/**
	 * Busca un Producto con un Nombre y un Usuario (comprador) especifico
	 * 
	 * @param user
	 * @param Nombre
	 * @return Producto
	 */
	public Producto getProductByName(Users user, String Nombre) {
		if (user != null && Nombre != "") {
			Producto p = null;
			String sql = "Select * from productos where Nombre = ? and email_comprador = ?";
			Connection cn = OpenConnection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setString(1, Nombre);
				stmt.setString(2, user.getEmail());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					p = new Producto(rs.getDouble(3), rs.getString(2), 1, rs.getInt(4), rs.getString(5),
							rs.getString(6));
					p.setID(rs.getInt(1));
				}
				// System.out.println("producto: "+p.getNombre()+p.getID());
				goodBy(cn);
				return p;
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return p;
			}
		} else {
			return null;
		}
	}

	/**
	 * Funcion para crear un ticket
	 * 
	 * @param user
	 * @param ti
	 * @return Ticket
	 */
	public Ticket crearTicket(Users user, Ticket ti) {
		if (user != null && ti != null) {
			if (buscarUsuario(user.getEmail())) {
				Ticket t = null;
				String sql = "INSERT INTO tickets VALUES ( ? , ? , ? , ? , ? )";
				Connection cn = OpenConnection();
				try {
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setInt(1, 0);
					stmt.setString(2, user.getEmail());
					stmt.setDouble(3, ti.getImporte());
					stmt.setInt(4, ti.getID_Lugar_Compra());
					stmt.setString(5, ti.getFecha_emision());
					int rs = stmt.executeUpdate();
					if (rs == 1) {
						// JOptionPane.showMessageDialog(null, "Ticket generado satisfactoriamente");
					}
					try {
						String sql2 = "Select * from tickets where email_comprador = ? and Importe = ? and idLocal = ? and fecha = ?";
						PreparedStatement stmt2 = cn.prepareStatement(sql2);
						stmt2.setString(1, user.getEmail());
						stmt2.setDouble(2, ti.getImporte());
						stmt2.setInt(3, ti.getID_Lugar_Compra());
						stmt2.setString(4, ti.getFecha_emision());
						ResultSet rs2 = stmt2.executeQuery();
						while (rs2.next()) {
							t = new Ticket((String) rs2.getString(5), rs2.getString(2), (Double) rs2.getDouble(3),
									rs2.getInt(4));
							t.setID(rs2.getInt(1));
						}
						goodBy(cn);
						return t;
					} catch (SQLException sqlE2) {
						System.out.println(sqlE2);
						sqlE2.printStackTrace();
					}
				} catch (SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
				}
				return t;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Funcion para añadir productos a la tabla de elementos de compra
	 * 
	 * @param user
	 * @param prL
	 * @param t
	 * @return boolean
	 */
	public boolean introducirProductosComprador(Users user, ArrayList<Producto> prL, Ticket t) {
		// TODO
		if (user != null && prL != null && t != null) {
			int tam = prL.size();
			for (int i = 0; i < tam; i++) {
				String sql = "Insert into elementoscompra VALUES ( ? , ? , ? , ?)";
				Connection cn = OpenConnection();
				try {
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setInt(1, t.getID());
					stmt.setString(2, prL.get(i).getNombre());
					stmt.setDouble(3, prL.get(i).getPrecio());
					stmt.setInt(4, prL.get(i).getCantidad());
					int rs = stmt.executeUpdate();
					if (rs == 1) {
					}
					;
				} catch (SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Busca todos los tickets de un Usuario (comprador) en la BD
	 * 
	 * @param user
	 * @return ArrayList de Tickets
	 */
	public ArrayList<Ticket> getTicketsByUser(Users user) {
		if (user != null) {
			if (buscarUsuario(user.getEmail())) {
				ArrayList<Ticket> tL = new ArrayList<Ticket>();
				String sql = "Select * from tickets where email_comprador = ?";
				Connection cn = OpenConnection();
				try {
					PreparedStatement stmt = cn.prepareStatement(sql);
					stmt.setString(1, user.getEmail());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						Ticket ti = new Ticket((String) rs.getString(5), rs.getString(2), (Double) rs.getDouble(3),
								rs.getInt(4));
						ti.setID(rs.getInt(1));
						tL.add(ti);
					}
					return tL;
				} catch (SQLException sqlE) {
					System.out.println(sqlE);
					sqlE.printStackTrace();
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Guarda una Opinion en la BD
	 * 
	 * @param op
	 * @return boolean
	 */
	public boolean SaveOpinion(Opinion op) {
		if (op != null) {
			String sql = "Insert into opiniones values (? , ? , ? , ?)";
			Connection cn = OpenConnection();
			try {
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, 0);
				stmt.setInt(2, op.getValoracion());
				stmt.setString(3, op.getComentario());
				stmt.setString(4, op.getEmail());
				int r = stmt.executeUpdate();
				if (r == 1) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException sqlE) {
				System.out.println(sqlE);
				sqlE.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Actualiza el Nombre o la Contraseña de un Usuario en la BD
	 * 
	 * @param us
	 * @param nombre
	 * @param pass
	 * @return boolean
	 */
	public boolean updateData(Users us, String nombre, String pass) {
		if (us != null && nombre != "" && pass != null && nombre != null && pass != null
				&& buscarUsuario(us.getEmail())) {
			String sql = "update users set name = ? where email = ?";
			String sql2 = "update users set password = ? where email = ?";
			Connection cn = OpenConnection();
			try {
				PreparedStatement stmt1 = cn.prepareStatement(sql);
				PreparedStatement stmt2 = cn.prepareStatement(sql2);
				stmt1.setString(1, nombre);
				stmt1.setString(2, us.getEmail());

				stmt2.setString(1, pass);
				stmt2.setString(2, us.getEmail());
				int R1 = stmt1.executeUpdate();
				int R2 = stmt2.executeUpdate();
				if (R1 == 1 && R2 == 1) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				System.out.println(e);
				return false;
			}
		} else {
			return false;
		}
	}
}
