package es.deusto.spq;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.Producto;
import es.deusto.spq.Ticket;

public class TicketTest {

	static Ticket t1, t2;
	static Producto p1, p2;
	
	@BeforeClass
	public static void initialize() {
		t1 = new Ticket("12/2/20", "alguno@gmail.com", 23.4, 1);
		t1.setID(43);
		t2 = new Ticket();
		p1 = new Producto("pan", 2.0, 1);
		p2 = new Producto(12.3, "detergente", 2, 0, "Pepito" , "Ropa");
		ArrayList<Producto> pr = new ArrayList<Producto>();
		pr.add(p1);
		pr.add(p2);
		t1.setLista(pr);
	}
	
	@Test
	public void testSetFechaEmision() {
		t2.setFecha_emision("23/4/19");
		assertEquals("23/4/19", t2.getFecha_emision());
	}
	
	@Test
	public void testSetNombreUsuario() {
		t2.setNombreUsuario("Dorian");
		assertEquals("Dorian", t2.getNombreUsuario());
	}
	
	@Test
	public void testSetIDLugarCompra() {
		t2.setID_Lugar_Compra(3);
		assertEquals(3, t2.getID_Lugar_Compra());
	}
	
	@Test
	public void testSetID() {
		t2.setID(53);
		assertEquals(53, t2.getID());
	}
	
	@Test
	public void testSetImporte() {
		t2.setImporte(86.2);
		assertEquals(86.2, t2.getImporte(), 0);
	}
	
	@Test
	public void testSetLista() {
		ArrayList<Producto> ap2= new ArrayList<Producto>();
		ap2.add(p1);
		ap2.add(p2);		
		t2.setLista(ap2);
		assertFalse(t2.getLista().equals(null));
	}
	
	@Test
	public void testGetFechaEmision() {
		assertEquals("12/2/20", t1.getFecha_emision());
	}
	
	@Test
	public void testGetNombreUsuario() {
		assertEquals("alguno@gmail.com", t1.getNombreUsuario());
	}
	
	@Test
	public void testGetIDLugarCompra() {
		assertEquals(1, t1.getID_Lugar_Compra());
	}
	
	@Test
	public void testGetID() {
		assertEquals(43, t1.getID());
	}
	
	@Test
	public void testGetImporte() {
		assertEquals(23.4, t1.getImporte(), 0);
	}
	
	@Test
	public void testGetLista() {
		assertFalse(t1.getLista().equals(null));
	}
	
}
