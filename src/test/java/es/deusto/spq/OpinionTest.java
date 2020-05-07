package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.Opinion;

public class OpinionTest {

	static Opinion o1, o2;
	
	@BeforeClass
	public static void initialize() {
		o1 = new Opinion();
		o1.setId_opinion(1);
		o1.setEmail("eneko.perez@opendeusto.es");
		o1.setValoracion(5);
		o1.setComentario("Buena aplicacion");
		o2 = new Opinion();
	}
	
	@Test
	public void testGetID_Opinion() {
		assertEquals(1, o1.getId_opinion());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("eneko.perez@opendeusto.es", o1.getEmail());
	}
	
	@Test
	public void testGetValoracion() {
		assertEquals(5, o1.getValoracion());
	}
	
	@Test
	public void testGetComentario() {
		assertEquals("Buena aplicacion", o1.getComentario());
	}
	
	@Test
	public void testSetComentario() {
		o2.setComentario("Buenisima aplicacion");
		assertEquals("Buenisima aplicacion", o2.getComentario());
	}
	
	@Test
	public void testSetValoracion() {
		o2.setValoracion(4);
		assertEquals(4, o2.getValoracion());
	}
	
	@Test
	public void testSetEmail() {
		o2.setEmail("alguno@gmail.com");
		assertEquals("alguno@gmail.com", o2.getEmail());
	}
	
	@Test
	public void testSetId_Opinion() {
		o2.setId_opinion(64);
		assertEquals(64, o2.getId_opinion());
	}
	
	@Test
	public void testToString() {
		String expected = "Opinion [id_opinion=1, email=eneko.perez@opendeusto.es, valoracion=5, comentario=Buena aplicacion]";
		assertEquals(expected, o1.toString());
	}
	
	
}
