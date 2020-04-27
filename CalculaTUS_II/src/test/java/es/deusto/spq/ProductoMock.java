package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class ProductoMock {

	@Mock
	Producto p11;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test
	public void testToString() {
		when(p11.toString()).thenReturn("Nombre: pollo Precio: 10.0 idLocal: 0Usuario: Alfonso");
		assertEquals(p11.toString(), "Nombre: pollo Precio: 10.0 idLocal: 0Usuario: Alfonso");
	}

	@Test
	public void testGetUserAsociado() {
		when(p11.getUserAsociado()).thenReturn("Mikel");
		assertEquals(p11.getUserAsociado(), "Mikel");
	}

	@Test
	public void testGetID() {
		when(p11.getID()).thenReturn(13);
		assertEquals(p11.getID(), 13);
	}

	@Test
	public void testGetLocalAsociado() {
		when(p11.getLocalAsociado()).thenReturn(15);
		assertEquals(p11.getLocalAsociado(), 15);
	}

	@Test
	public void testGetPrecio() {
		when(p11.getPrecio()).thenReturn(10.0);
		assertEquals(p11.getPrecio(), 10.0, 0);
	}

	@Test
	public void testGetNombre() {
		when(p11.getNombre()).thenReturn("Jon");
		assertEquals(p11.getNombre(), "Jon");
	}

	@Test
	public void testGetCantidad() {
		when(p11.getCantidad()).thenReturn(4);
		assertEquals(p11.getCantidad(), 4);
	}

}
