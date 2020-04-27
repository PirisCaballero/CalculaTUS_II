package es.deusto.spq.paneles;

import static org.junit.Assert.*;

import org.junit.*;

import es.deusto.spq.Users;

public class Panel_BienvenidaTest {
	
	static Users u;
	
	@BeforeClass
	public static void initialize() {
		u = new Users();
	}

	@Test
	public void testPanelBienvenida() {
		Panel_Bienvenida pbvn = new Panel_Bienvenida(u);
		assertFalse(pbvn.equals(null));
	}
}
