package es.deusto.spq;

public class Opinion {

	private int id_opinion;
	private String email;
	private int valoracion;
	private String comentario;

	public Opinion() {
		
	}
	public int getId_opinion() {
		return id_opinion;
	}

	public void setId_opinion(int id_opinion) {
		this.id_opinion = id_opinion;
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
		return "Opinion [id_opinion=" + id_opinion + ", email=" + email + ", valoracion=" + valoracion + ", comentario="
				+ comentario + "]";
	}

}
