package com.mycompany.app;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {
	private String Fecha_emision;
	private String NombreUsuario;
	private String ID_Lugar_Compra;
	private String ID_Tipo;
	private ArrayList<Producto>lista;
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
	public String getID_Lugar_Compra() {
		return ID_Lugar_Compra;
	}
	public void setID_Lugar_Compra(String iD_Lugar_Compra) {
		ID_Lugar_Compra = iD_Lugar_Compra;
	}
	public String getID_Tipo() {
		return ID_Tipo;
	}
	public void setID_Tipo(String iD_Tipo) {
		ID_Tipo = iD_Tipo;
	}
	public ArrayList<Producto> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Producto> lista) {
		this.lista = lista;
	}
	public Ticket () {}
	//si lo creamos desde cero y queremos una lista vacia
	public Ticket( String nombre , String id_lugar , String id_ti ) {
		Date fecha = new Date();
		SimpleDateFormat dt = new SimpleDateFormat( "hh:mm:ss at dd/mm/yyy" );
		this.Fecha_emision = dt.format(fecha);
		this.NombreUsuario = nombre;
		this.ID_Lugar_Compra = id_lugar;
		this.ID_Tipo = id_ti;
		this.lista=new ArrayList<Producto>();
	}
	//si queremos crear el objeto con ujna lista predefinida
	public Ticket( String nombre , String id_lugar , String id_ti,ArrayList<Producto>list ) {
		Date fecha = new Date();
		SimpleDateFormat dt = new SimpleDateFormat( "hh:mm:ss at dd/mm/yyy" );
		this.Fecha_emision = dt.format(fecha);
		this.NombreUsuario = nombre;
		this.ID_Lugar_Compra = id_lugar;
		this.ID_Tipo = id_ti;
		this.lista=list;
	}
	//calculamos el precio total del producto 
	public float totalPrecio() {
		float total=0;
		if(this.lista!=null) {
			for (Producto producto : lista) {
				total+=producto.getPrecio();
			}
			return total;
		}
		
		return 0;
		
	}

}
