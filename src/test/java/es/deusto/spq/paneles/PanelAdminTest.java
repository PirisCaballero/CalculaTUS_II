package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.*;

import es.deusto.spq.Users;

public class PanelAdminTest {

	static Users u;
	static PanelDatos pd;
	static PanelAdmin pa;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		pd = new PanelDatos();
	}
	
	@Test
	public void testPanelAdmin() {
		pa = new PanelAdmin(u, pd);
		assertFalse(pa.equals(null));
	}
	
}
