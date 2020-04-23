package com.mycompany.app;

public class Local {

	private String nombre;
	private String direccion;
	private int cp;
	private String descripcion;
	private int IdLocal;

	public Local() {
	}

	public Local(String nom, String dir, int codPost, String desc) {
		this.nombre = nom;
		this.direccion = dir;
		this.cp = codPost;
		this.descripcion = desc;
	}

	@Override
	public String toString() {
		String local = "Nombre: " + this.getNombre() + " Direccion: " + this.getDireccion() + " codigo postal: "
				+ this.getCp();
		return local;
	}
	public void setId(int id) {
		this.IdLocal = id;
	}
	public int getId() {
		return this.IdLocal;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

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

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

}
