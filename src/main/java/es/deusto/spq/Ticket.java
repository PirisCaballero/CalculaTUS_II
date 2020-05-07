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

	public String getFecha_emision() {
		return Fecha_emision;
	}

	public void setFecha_emision(String fecha_emision) {
		Fecha_emision = fecha_emision;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public int getID_Lugar_Compra() {
		return ID_Lugar_Compra;
	}

	public void setID_Lugar_Compra(int iD_Lugar_Compra) {
		ID_Lugar_Compra = iD_Lugar_Compra;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD_Tipo) {
		ID = iD_Tipo;
	}
	
	public Double getImporte() {
		return this.importe;
	}
	public void setImporte(Double imp) {
		this.importe = imp;
	}

	public ArrayList<Producto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Producto> lista) {
		this.lista = lista;
	}

	public Ticket() {
	}
	public Ticket(String fecha , String us_email , Double importe , int loc_id) {
		this.Fecha_emision = fecha;
		this.NombreUsuario = us_email;
		this.importe = importe;
		this.ID_Lugar_Compra = loc_id;
	}
}
