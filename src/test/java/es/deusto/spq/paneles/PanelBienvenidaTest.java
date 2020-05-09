package es.deusto.spq.paneles;

import static org.junit.Assert.*;

import org.junit.*;

import es.deusto.spq.Users;

public class PanelBienvenidaTest {
	
	static Users u;
	
	@BeforeClass
	public static void initialize() {
		u = new Users();
	}

	@Test
	public void testPanelBienvenida() {
		PanelBienvenida pbvn = new PanelBienvenida(u);
		assertFalse(pbvn.equals(null));
	}
}
