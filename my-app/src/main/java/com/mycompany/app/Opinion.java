package com.mycompany.app;

public class Opinion {

	private String email;
	private int valoracion;
	private String comentario;

	public Opinion(String email, int valoracion, String comentario) {
		super();
		this.email = email;
		this.valoracion = valoracion;
		this.comentario = comentario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Opinion [email=" + email + ", valoracion=" + valoracion + ", comentario=" + comentario + "]";
	}

}
