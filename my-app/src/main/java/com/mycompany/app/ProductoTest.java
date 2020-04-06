package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductoTest {

	@Test
	public void test() {
		Producto p=new Producto(10, "pollo", 4);
		//comprobacion getters 
		Boolean resultado;
		resultado=(p.getCantidad()==4);
		assertTrue(resultado);
		resultado=(p.getNombre().equals("pollo"));
		assertTrue(resultado);
		resultado=(p.getPrecio()==10);
		assertTrue(resultado);
		//comprobacion de setters
		p.setCantidad(5);
		p.setPrecio(5);
		p.setNombre("nada");
		resultado=(p.getCantidad()==5);
		assertTrue(resultado);
		resultado=(p.getNombre().equals("nada"));
		assertTrue(resultado);
		resultado=(p.getPrecio()==5);
		assertTrue(resultado);
		
	}

}
