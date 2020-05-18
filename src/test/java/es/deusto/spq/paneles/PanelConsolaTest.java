package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

public class PanelConsolaTest {

	static Connect c = new Connect();
	static Users u;
	static PanelConsola pc;
	
	@BeforeClass
	public static void initialize() {
		u = c.RecuperarUsuario("admin@root.es");
	}
	
	@Test
	public void testPanelConsola() {
		pc = new PanelConsola(u);
	}
}
