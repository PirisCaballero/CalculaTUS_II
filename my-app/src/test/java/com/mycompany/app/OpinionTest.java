package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mycompany.app.Opinion;

public class OpinionTest {

	@Test
	void test() {
		Opinion o1 = new Opinion("eneko.perez@opendeusto.es", 5, "Buena aplicacion");
		Boolean resultado;

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
		o1.setEmail("abc@opendeusto.es");
		o1.setValoracion(4);
		o1.setComentario("Estupenda");

		String a2 = o1.getEmail();
		resultado = a2.equals("abc@opendeusto.es");
		assertTrue(resultado);

		int b2 = o1.getValoracion();
		resultado = (b2 == 4);
		assertTrue(resultado);

		String c2 = o1.getComentario();
		resultado = c2.equals("Estupenda");
		assertTrue(resultado);
	}

}
