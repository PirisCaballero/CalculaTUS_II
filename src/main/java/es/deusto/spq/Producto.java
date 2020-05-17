package es.deusto.spq;

public class Producto {
	private double precio;
	private String nombre;
	private int cantidad;
	private int localAsociado;
	private String userAsociado;
	private int id;
	private String Categoria;

	/**
	 * Construye un tipo de Producto (hay dos tipos)
	 * 
	 * @param precio
	 * @param nombre
	 * @param cantidad
	 * @param loc
	 * @param user
	 * @param c
	 */
	public Producto(double precio, String nombre, int cantidad, int loc, String user, String c) {
		this.precio = precio;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.userAsociado = user;
		this.localAsociado = loc;
		this.Categoria = c;
	}

	/**
	 * Devuelve la cateogria del producto
	 * 
	 * @return categoria
	 */
	public String getCategoria() {
		return Categoria;
	}

	/**
	 * Modifica la cateogria del producto
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	/**
	 * Construye un tipo de Producto (hay dos tipos)
	 * 
	 * @param Nombre
	 * @param prec
	 * @param Cantidad
	 */
	public Producto(String Nombre, Double prec, int Cantidad) {
		this.nombre = Nombre;
		this.precio = prec;
		this.cantidad = Cantidad;
	}

	/**
	 * Devuelve el id del producto
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		this.id = ID;
	}

	/**
	 * Modifica el id del producto
	 * 
	 * @return id
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * Devuelve el local asociado al producto
	 * 
	 * @return localAsociado
	 */
	public int getLocalAsociado() {
		return localAsociado;
	}

	/**
	 * Modifca el local asociado al producto
	 * 
	 * @param localAsociado
	 */
	public void setLocalAsociado(int localAsociado) {
		this.localAsociado = localAsociado;
	}

	/**
	 * Devuelve el precio del producto
	 * 
	 * @return precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio del producto
	 * 
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Devuelve el nombre del producto
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del producto
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la cantidad del producto
	 * 
	 * @return cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Modifica la cantidad del producto
	 * 
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return String del objeto Opinion
	 */
	@Override
	public String toString() {
		String pr = "Nombre: " + this.nombre + " Precio: " + this.precio + " idLocal: " + this.localAsociado
				+ "Usuario: " + this.userAsociado;
		return pr;
	}

	/**
	 * Devuelve el usuario asociado del producto
	 * 
	 * @return userAsociado
	 */
	public String getUserAsociado() {
		return userAsociado;
	}

	/**
	 * Modifca el usuario asociado del producto
	 * 
	 * @param userAsociado
	 */
	public void setUserAsociado(String userAsociado) {
		this.userAsociado = userAsociado;
	}
}
