package es.deusto.spq.paneles;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

import es.deusto.spq.Users;

public class PanelAdminTest {

	static Users u;
	static PanelDatos pdts;

	PanelAdmin pa2 = mock(PanelAdmin.class);
	
	@BeforeClass
	public static void initialize() {
		u = new Users();
		pdts = new PanelDatos();
	}

	@Test
	public void testPanelBienvenida() {
		PanelAdmin pa = new PanelAdmin(u, pdts);
		assertFalse(pa.equals(null));
	}
	
	@Test
	public void testSetLocalesyPorductos() {
		when(pa2.save()).thenReturn(true);
		assertTrue(pa2.save());
	}

}
