package es.deusto.spq;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.Producto;

public class ProductoTest {

	@Test
	public void test() {
		// Producto p=new Producto(10, "pollo", 4);
		Producto p = new Producto(10, "pollo", 4, 0, "Alfonso");
		
		Producto p2 = new Producto("huevos", 3.0, 12);
		// comprobacion getters
		Boolean resultado;
		resultado = (p.getCantidad() == 4);
		assertTrue(resultado);
		resultado = (p.getNombre().equals("pollo"));
		assertTrue(resultado);
		resultado = (p.getPrecio() == 10);
		assertTrue(resultado);
		// comprobacion de setters
		p.setCantidad(5);
		p.setPrecio(5);
		p.setNombre("nada");
		p.setID(3);
		p.setLocalAsociado(9);
		p.setUserAsociado("Alfonso");
		
		resultado = (p.getCantidad() == 5);
		assertTrue(resultado);
		resultado = (p.getNombre().equals("nada"));
		assertTrue(resultado);
		resultado = (p.getPrecio() == 5);
		assertTrue(resultado);
		
		resultado = p.getID()==3;
		assertTrue(resultado);
		
		resultado = p.getLocalAsociado() == 9;
		assertTrue(resultado);
		
		
		String actual = p.getUserAsociado();
		String expected = "Alfonso";	
		assertEquals(expected, actual);
		
		String expected2 = p.toString();
		String actual2 = "Nombre: nada Precio: 5.0 idLocal: 9Usuario: Alfonso";
		assertEquals(expected2, actual2);
	}

}
