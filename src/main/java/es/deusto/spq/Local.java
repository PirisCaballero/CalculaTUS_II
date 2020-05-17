package es.deusto.spq;

public class Local {

	private String nombre;
	private String direccion;
	private int cp;
	private String descripcion;
	private int IdLocal;
	private String emailDuenio;

	/**
	 * Construye un Local
	 * 
	 * @param nom
	 * @param dir
	 * @param codPost
	 * @param desc
	 */
	public Local(String nom, String dir, int codPost, String desc) {
		this.nombre = nom;
		this.direccion = dir;
		this.cp = codPost;
		this.descripcion = desc;
		this.emailDuenio = "";
	}

	/*
	 * Construye un local vacio, sin parametros
	 */
	public Local() {
	}

	/**
	 * 
	 * @return String del objeto Local
	 */
	@Override
	public String toString() {
		String local = "Nombre: " + this.getNombre() + " Direccion: " + this.getDireccion() + " codigo postal: "
				+ this.getCp();
		return local;
	}

	/**
	 * Modifica id del local
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.IdLocal = id;
	}

	/**
	 * Devuelve id del local
	 * 
	 * @return id
	 */
	public int getId() {
		return this.IdLocal;
	}

	/**
	 * Devuelve descripcion del local
	 * 
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Modifica descripcion del local
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el nombre del local
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del local
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la direccion del local
	 * 
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Modifica la direccion del local
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el cp del local
	 * 
	 * @return cp
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Modifica el cp del local
	 * 
	 * @param cp
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

	/**
	 * Devuelve el email del dueño
	 * 
	 * @return emailduenio
	 */
	public String getEmailduenio() {
		return this.emailDuenio;
	}

	/**
	 * Modifica el email del dueño
	 * 
	 * @param email
	 */
	public void setEmailDuenio(String email) {
		this.emailDuenio = email;
	}

}
