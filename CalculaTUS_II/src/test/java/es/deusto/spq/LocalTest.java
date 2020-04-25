package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.deusto.spq.Local;

public class LocalTest {
	// comprobamos la funcionalidad de la clase Local
	@Test
	public void Funcionaltest() {
		Local local = new Local("casa", "ninguna", 48190, "es un local");
		// comprobación de los diferentes getters y setters funcionan correctamente
		// getters
		Boolean resultado;
		resultado = local.getNombre().equals("casa");
		assertTrue(resultado);
		resultado = local.getDireccion().equals("ninguna");
		assertTrue(resultado);
		resultado = local.getDescripcion().equals("es un local");
		assertTrue(resultado);
		resultado = (local.getCp() == 48190);
		assertTrue(resultado);
		// setters
		local.setCp(0);
		local.setDescripcion("nada");
		local.setDireccion("santana");
		local.setNombre("sopuerta");
		local.setId(3);
		resultado = local.getNombre().equals("sopuerta");
		assertTrue(resultado);
		resultado = local.getDireccion().equals("santana");
		assertTrue(resultado);
		resultado = local.getDescripcion().equals("nada");
		assertTrue(resultado);
		resultado = (local.getCp() == 0);
		assertTrue(resultado);
		resultado = (local.getId() == 3);
		assertTrue(resultado);
		
		String expected = local.toString();
		String actual = "Nombre: sopuerta Direccion: santana codigo postal: 0";
		assertEquals(expected, actual);
	}

}
