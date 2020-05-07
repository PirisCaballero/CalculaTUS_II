package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class Panel_consolaTest {

	static Connect c = new Connect();
	static Users u;
	static Panel_consola pc;
	static Ventana_CalculaTUS_II vt;
	
	@BeforeClass
	public static void initialize() {
		u = c.Recuperar_usuario("admin@root.es");
		vt = new Ventana_CalculaTUS_II(u);
	}
	
	@Test
	public void testPanel_consola() {
		pc = new Panel_consola(u);
	}
}
