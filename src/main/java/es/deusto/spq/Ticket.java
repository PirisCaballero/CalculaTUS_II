package es.deusto.spq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {
	private String Fecha_emision;
	private String NombreUsuario;
	private int ID_Lugar_Compra;
	private int ID;
	private ArrayList<Producto> lista;
	private Double importe = 0.0;

	/**
	 * Devuelve la fecha de emision del ticket
	 * 
	 * @return fecha_emision
	 */
	public String getFecha_emision() {
		return Fecha_emision;
	}

	/**
	 * Modifica la fecha de emision del ticket
	 * 
	 * @param fecha_emision
	 */
	public void setFecha_emision(String fecha_emision) {
		Fecha_emision = fecha_emision;
	}

	/**
	 * Devuelve el nombre del usuario del ticket
	 * 
	 * @return NombreUsuario
	 */
	public String getNombreUsuario() {
		return NombreUsuario;
	}

	/**
	 * Modifica el nombre del usuario del ticket
	 * 
	 * @param nombreUsuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	/**
	 * Devuelve la id del lugar de compra del ticket
	 * 
	 * @return id_lugar_compra
	 */
	public int getID_Lugar_Compra() {
		return ID_Lugar_Compra;
	}

	/**
	 * Modifica la id del lugar de compra del ticket
	 * 
	 * @param iD_Lugar_Compra
	 */
	public void setID_Lugar_Compra(int iD_Lugar_Compra) {
		ID_Lugar_Compra = iD_Lugar_Compra;
	}

	/**
	 * Devuelve el id del ticket
	 * 
	 * @return id
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Modifica el tipo de id del ticket
	 * 
	 * @param iD_Tipo
	 */
	public void setID(int iD_Tipo) {
		ID = iD_Tipo;
	}

	/**
	 * Devuelve el importe del ticket
	 * 
	 * @return importe
	 */
	public Double getImporte() {
		return this.importe;
	}

	/**
	 * Modifica el importe del ticket
	 * 
	 * @param imp
	 */
	public void setImporte(Double imp) {
		this.importe = imp;
	}

	/**
	 * Devuelve una lista de productos
	 * 
	 * @return ArrayList de Productos
	 */
	public ArrayList<Producto> getLista() {
		return lista;
	}

	/**
	 * Modifica una lista de productos
	 * 
	 * @param lista
	 */
	public void setLista(ArrayList<Producto> lista) {
		this.lista = lista;
	}

	public Ticket() {
	}

	/**
	 * Construye un Ticket
	 * 
	 * @param fecha
	 * @param us_email
	 * @param importe
	 * @param loc_id
	 */
	public Ticket(String fecha, String us_email, Double importe, int loc_id) {
		this.Fecha_emision = fecha;
		this.NombreUsuario = us_email;
		this.importe = importe;
		this.ID_Lugar_Compra = loc_id;
	}
}
