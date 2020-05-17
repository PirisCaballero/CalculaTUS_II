package es.deusto.spq;

public class Opinion {

	private int id_opinion;
	private String email;
	private int valoracion;
	private String comentario;

	public Opinion() {

	}

	/**
	 * Devuelve la id de la opinion
	 * 
	 * @return id_opinion
	 */
	public int getId_opinion() {
		return id_opinion;
	}

	/**
	 * Modifica la id de la opinion
	 * 
	 * @param id_opinion
	 */
	public void setId_opinion(int id_opinion) {
		this.id_opinion = id_opinion;
	}

	/**
	 * Devuelve el email del autor de la opinion
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Modifica el email del autor de la opinion
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve el valor de la valoracion
	 * 
	 * @return valoracion
	 */
	public int getValoracion() {
		return valoracion;
	}

	/**
	 * Modifica el valor de la valoracion
	 * 
	 * @param valoracion
	 */
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	/**
	 * Devuelve el comentario de la opinion
	 * 
	 * @return comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Modifica el comentario de la opinion
	 * 
	 * @param comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return String del objeto Opinion
	 */
	@Override
	public String toString() {
		return "Opinion [id_opinion=" + id_opinion + ", email=" + email + ", valoracion=" + valoracion + ", comentario="
				+ comentario + "]";
	}

}
