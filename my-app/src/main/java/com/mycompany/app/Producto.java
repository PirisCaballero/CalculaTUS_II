package com.mycompany.app;
public class Producto {
	private float precio;
	private String nombre;
	private int cantidad;
	public Producto(int precio, String nombre, int cantidad) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
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
	

}
