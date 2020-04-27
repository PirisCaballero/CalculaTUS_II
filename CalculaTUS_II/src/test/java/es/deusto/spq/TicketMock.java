package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TicketMock {

	@Mock
	Ticket t;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test
	public void testGetFechaEmision() {
		when(t.getFecha_emision()).thenReturn("12/2/20");
		assertEquals(t.getFecha_emision(), "12/2/20");
	}

	@Test
	public void testGetNombreUsuario() {
		when(t.getNombreUsuario()).thenReturn("Mikel");
		assertEquals(t.getNombreUsuario(), "Mikel");
	}

	@Test
	public void testGetIDLugarCompra() {
		when(t.getID_Lugar_Compra()).thenReturn(4);
		assertEquals(t.getID_Lugar_Compra(), 4);
	}

	@Test
	public void testGetID() {
		when(t.getID()).thenReturn(5);
		assertEquals(t.getID(), 5);
	}

	@Test
	public void testGetImporte() {
		when(t.getImporte()).thenReturn(12.0);
		assertEquals(t.getImporte(), 12.0, 0);
	}

	@Test
	public void testGetLista() {
		when(t.getLista()).thenReturn(null);
		assertEquals(t.getLista(), null);
	}

}
