package es.deusto.spq;

import java.util.ArrayList;

public class Users {
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private String pass;
	private int admin;
	private String email_admin;
	private Type type;

	/**
	 * este atributo solo se usara si el usurio es de tipo Admin ya que aqui
	 * almacenara todos sus trabajadores
	 */
	private ArrayList<Users> trabajadores;

	/**
	 * 
	 * Definimos el tipo de Usuario que va a ser
	 */
	public enum Type {
		Admin, trabajador
	}

	/**
	 * Devuelve el nombre del usuario
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve los apellidos del usuario
	 * 
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Modifica los apellidos del usuario
	 * 
	 * @param apell
	 */
	public void setApellidos(String apell) {
		this.apellidos = apell;
	}

	/**
	 * Modifica el nombre del usuario
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la direccion del usuario
	 * 
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Modifica la direccion del usuario
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el email del usuario
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Modifica el email del usuario
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return String del objeto User
	 */
	@Override
	public String toString() {
		return "Users [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", pass=" + pass
				+ ", admin=" + admin + ", adminemail=" + email_admin;
	}

	/**
	 * Devuelve la contraseña del usuario
	 * 
	 * @return pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Modifica la contraseña del usuario
	 * 
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Devuelve el tipo de usuario
	 * 
	 * @return type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Modifica el tipo de usuario
	 * 
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Devuelve el valor para saber si el usuario es admin o no
	 * 
	 * @return admin
	 */
	public int getAdmin() {
		return this.admin;
	}

	/**
	 * Modifica el valor para saber si el usuario es admin o no
	 * 
	 * @param ad
	 */
	public void setAdmin(int ad) {
		this.admin = ad;
	}

	/**
	 * Devuelve el email del administrador de un usuario
	 * 
	 * @return email_admin
	 */
	public String getAdminEmail() {
		return this.email_admin;
	}

	/**
	 * Modifica el email del administrador de un usuario
	 * 
	 * @param email
	 */
	public void setAdminEmail(String email) {
		this.email_admin = email;
	}

	/**
	 * Construye un Usuario, por defecto va a ser la clase trabajador
	 * 
	 * @param nombre
	 * @param apel
	 * @param email
	 * @param pass
	 * @param isAdmin
	 * @param A_email
	 */
	public Users(String nombre, String apel, String email, String pass, int isAdmin, String A_email) {
		super();
		this.nombre = nombre;
		this.apellidos = apel;
		this.email = email;
		this.pass = pass;
		this.admin = isAdmin;
		this.email_admin = A_email;

	}

	public Users() {
	}

}
