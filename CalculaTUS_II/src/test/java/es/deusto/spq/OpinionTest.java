package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.Opinion;

public class OpinionTest {

	@Test
	public void test() {
		Opinion o1 = new Opinion(1, "eneko.perez@opendeusto.es", 5, "Buena aplicacion");
		Boolean resultado;

		int d = o1.getId_opinion();
		resultado = (d == 1);
		assertTrue(resultado);

		String a = o1.getEmail();
		resultado = a.equals("eneko.perez@opendeusto.es");
		assertTrue(resultado);

		int b = o1.getValoracion();
		resultado = (b == 5);
		assertTrue(resultado);

		String c = o1.getComentario();
		resultado = c.equals("Buena aplicacion");
		assertTrue(resultado);
		// ---------setters-------
		o1.setId_opinion(2);
		o1.setEmail("abc@opendeusto.es");
		o1.setValoracion(4);
		o1.setComentario("Estupenda");

		int d2 = o1.getId_opinion();
		resultado = (d2 == 2);
		assertTrue(resultado);

		String a2 = o1.getEmail();
		resultado = a2.equals("abc@opendeusto.es");
		assertTrue(resultado);

		int b2 = o1.getValoracion();
		resultado = (b2 == 4);
		assertTrue(resultado);

		String c2 = o1.getComentario();
		resultado = c2.equals("Estupenda");
		assertTrue(resultado);
				
		String expected = o1.toString();
		String actual = "Opinion [id_opinion=2, email=abc@opendeusto.es, valoracion=4, comentario=Estupenda]";
		assertEquals(expected, actual);
		
	}
}
