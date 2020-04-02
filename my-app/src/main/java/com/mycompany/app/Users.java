package com.mycompany.app;

public class Users {
	//tipos de attributos que van a componer el proyecto
private  String nombre;
private  String direccion;
private  String email;
private  String pass;
private   Type type;

private enum Type { Admin,trabajador}//definimos el tipo de Usuario que va a ser

public String getNombre() {
	return nombre;
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

@Override
public String toString() {
	return "Users [nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + ", pass=" + pass + ", type="
			+ type + "]";
}
//por defecto va a ser la clase trabajador 
public Users(String nombre, String direccion, String email, String pass, Type type) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.email = email;
	this.pass = pass;
	this.type = type.trabajador;
}






}
