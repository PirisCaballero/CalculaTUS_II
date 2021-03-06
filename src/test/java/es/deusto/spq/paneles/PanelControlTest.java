package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.*;

import es.deusto.spq.Users;

public class PanelControlTest {
	
	static Users u;
	static PanelDatos pd;
	static PanelControl pc;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		pd = new PanelDatos();
	}

	@Test
	public void testPanelControl() {
		pc = new PanelControl(u, pd);
		assertFalse(pc.equals(null));
	}
}
