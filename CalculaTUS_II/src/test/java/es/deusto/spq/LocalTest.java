package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.Local;

public class LocalTest {
	// comprobamos la funcionalidad de la clase Local
	static Local local;
	static Local l2;
	
	@BeforeClass
	public static void initialize() {
		local = new Local("casa", "ninguna", 48190, "es un local");
		l2 = new Local();
	}
	
	@Test
	public void testGetNombre() {
		assertTrue(local.getNombre().equals("casa"));
	}
	
	@Test
	public void testGetDireccion() {
		assertTrue(local.getDireccion().equals("ninguna"));		
	}
	
	@Test
	public void testGetDescripcion() {
		assertTrue(local.getDescripcion().equals("es un local"));		
	}
	
	@Test
	public void testGetCp() {
		assertEquals(48190, local.getCp());		
	}
	
	@Test
	public void testSetCp() {
		l2.setCp(0);
		assertEquals(0, l2.getCp());
	}
	
	@Test
	public void testSetDescripcion() {
		l2.setDescripcion("nada");
		assertEquals("nada", l2.getDescripcion());
	}
	
	@Test
	public void testSetNombre() {
		l2.setNombre("sopuerta");
		assertEquals("sopuerta", l2.getNombre());
	}
	
	@Test
	public void testSetDireccion() {
		l2.setDireccion("alguna");
		assertEquals("alguna", l2.getDireccion());
	}
	
	@Test
	public void testSetID() {
		l2.setId(3);
		assertEquals(3, l2.getId());
	}
	
	@Test
	public void testToString() {
		String expected = "Nombre: casa Direccion: ninguna codigo postal: 48190";
		String actual = local.toString();
		assertEquals(expected, actual);
	}
	
}
