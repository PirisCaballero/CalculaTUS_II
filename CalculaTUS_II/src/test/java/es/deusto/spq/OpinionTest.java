package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.Opinion;

public class OpinionTest {

	@Test
	public void test() {
		Opinion o1 = new Opinion();
		o1.setId_opinion(1);
		o1.setEmail("eneko.perez@opendeusto.es");
		o1.setValoracion(5);
		o1.setComentario("Buena aplicacion");
		Boolean resultado;

		assertEquals(1, o1.getId_opinion());
		
		assertFalse(o1.equals(null));

		String a = o1.getEmail();
		resultado = a.equals("eneko.perez@opendeusto.es");
		assertTrue(resultado);

		assertEquals(5, o1.getValoracion());;

		String c = o1.getComentario();
		resultado = c.equals("Buena aplicacion");
		assertTrue(resultado);
		// ---------setters-------
		o1.setId_opinion(2);
		o1.setEmail("abc@opendeusto.es");
		o1.setValoracion(4);
		o1.setComentario("Estupenda");

		o1.setId_opinion(2);;
		assertEquals(2, o1.getId_opinion());;

		String a2 = o1.getEmail();
		resultado = a2.equals("abc@opendeusto.es");
		assertTrue(resultado);

		o1.setValoracion(4);
		assertEquals(4, o1.getValoracion());;

		String c2 = o1.getComentario();
		resultado = c2.equals("Estupenda");
		assertTrue(resultado);
				
		String expected = o1.toString();
		String actual = "Opinion [id_opinion=2, email=abc@opendeusto.es, valoracion=4, comentario=Estupenda]";
		assertEquals(expected, actual);
		
	}
}
