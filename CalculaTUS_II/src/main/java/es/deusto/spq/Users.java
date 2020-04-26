package es.deusto.spq;

import java.util.ArrayList;

public class Users {
	// tipos de attributos que van a componer el proyecto
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private String pass;
	private int admin;
	private String email_admin;
	private Type type;
	private ArrayList<Users> trabajadores;// este atributo solo se usara si el usurio es de tipo Admin ya que aqui
											// almacenara todos sus trabajadores

	public enum Type {
		Admin, trabajador
	}// definimos el tipo de Usuario que va a ser

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apell) {
		this.apellidos = apell;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", pass=" + pass
				+ ", admin=" + admin + ", adminemail=" + email_admin;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getAdmin() {
		return this.admin;
	}

	public void setAdmin(int ad) {
		this.admin = ad;
	}

	public String getAdminEmail() {
		return this.email_admin;
	}

	public void setAdminEmail(String email) {
		this.email_admin = email;
	}

//por defecto va a ser la clase trabajador 
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

//este constructor se declara para la creación de un administrados añadiendo el parametro de la lista de usuarios que va a tener a su nombre
//public Users(String nombre, String direccion, String email, String pass,ArrayList<Users>trabajadores) {
//	super();
//	this.nombre = nombre;
//	this.direccion = direccion;
//	this.email = email;
//	this.pass = pass;
//	this.type = Type.Admin;
//	this.trabajadores=trabajadores;
//	
//}


}
