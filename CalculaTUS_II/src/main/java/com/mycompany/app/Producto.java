package com.mycompany.app;

public class Producto {
	private double precio;
	private String nombre;
	private int cantidad;
	private int localAsociado;
	private String userAsociado;
	private int id;

	public Producto(double precio, String nombre, int cantidad , int loc , String user) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.userAsociado = user;
		this.localAsociado = loc;
	}
	public Producto(String Nombre , Double prec , int Cantidad) {
		this.nombre = Nombre;
		this.precio = prec;
		this.cantidad = Cantidad;
	}

	public void setID(int ID) {
		this.id = ID;
	}
	public int getID() {
		return this.id;
	}
	public int getLocalAsociado() {
		return localAsociado;
	}

	public void setLocalAsociado(int localAsociado) {
		this.localAsociado = localAsociado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		String pr = "Nombre: " + this.nombre + " Precio: "+this.precio + " idLocal: "+this.localAsociado + "Usuario: "+this.userAsociado;
		return pr;
	}

	public String getUserAsociado() {
		return userAsociado;
	}

	public void setUserAsociado(String userAsociado) {
		this.userAsociado = userAsociado;
	}
}
