package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

public class PanelLocalTest {

	static Connect c = new Connect();
	static Users u;
	static PanelLocal pl;
	static VentanaCalculaTUSII vt;
	
	@BeforeClass
	public static void initialize() {
		u = c.RecuperarUsuario("admin@root.es");
		vt = new VentanaCalculaTUSII(u);
	}
	
	@Test
	public void testPanelLocal() {
		pl = new PanelLocal(u);
		assertFalse(pl.equals(null));
	}
}
