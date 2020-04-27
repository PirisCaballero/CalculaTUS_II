package es.deusto.spq;

import static org.junit.Assert.*;

import org.junit.*;

import es.deusto.spq.Producto;

public class ProductoTest {

	static Producto p1, p2;
	
	@BeforeClass
	public static void initialize() {
		p1 = new Producto(10, "pollo", 4, 0, "Alfonso");
		p1.setID(23);
		p2 = new Producto("huevos", 3.0, 12);
		p2.setUserAsociado("Javier");
	}
	
	@Test
	public void testSetID() {
		p2.setID(1);
		assertEquals(1, p2.getID());
	}
	
	@Test
	public void testSetLocalAsociado() {
		p2.setLocalAsociado(3);
		assertEquals(3, p2.getLocalAsociado());
	}
	
	@Test
	public void testSetPrecio() {
		p2.setPrecio(3.3);
		assertEquals(3.3, p2.getPrecio(), 0);
	}
	
	@Test
	public void testSetNombre() {
		p2.setNombre("cordero");
		assertEquals("cordero", p2.getNombre());
	}
	
	@Test
	public void testSetCantidad() {
		p2.setCantidad(3);
		assertEquals(3, p2.getCantidad());
	}
	
	@Test
	public void testToString() {
		String expected = "Nombre: pollo Precio: 10.0 idLocal: 0Usuario: Alfonso";
		assertEquals(expected, p1.toString());
	}
	
	@Test
	public void testSetUserAsociado() {
		p2.setUserAsociado("Manolo");
		assertEquals("Manolo", p2.getUserAsociado());
	}
	
	@Test
	public void testGetUserAsociado() {
		assertEquals("Javier", p2.getUserAsociado());
	}
	
	@Test
	public void testGetID() {
		assertEquals(23, p1.getID());
	}
	
	@Test
	public void testGetLocalAsociado() {
		assertEquals(0, p1.getLocalAsociado());
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(10.0, p1.getPrecio(), 0);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("pollo", p1.getNombre());
	}
	
	@Test
	public void testGetCantidad() {
		assertEquals(4, p1.getCantidad());
	}
	
}
