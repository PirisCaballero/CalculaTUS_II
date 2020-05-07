package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class Panel_LocalTest {

	static Connect c = new Connect();
	static Users u;
	static Panel_Local pl;
	static Ventana_CalculaTUS_II vt;
	
	@BeforeClass
	public static void initialize() {
		u = c.Recuperar_usuario("admin@root.es");
		vt = new Ventana_CalculaTUS_II(u);
	}
	
	@Test
	public void testPanelLocal() {
		pl = new Panel_Local(u);
		assertFalse(pl.equals(null));
	}
}
