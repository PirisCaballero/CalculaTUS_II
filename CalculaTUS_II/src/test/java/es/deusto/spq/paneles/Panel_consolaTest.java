package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class Panel_consolaTest {

	static Users u;
	static Panel_consola pc;
	static Ventana_CalculaTUS_II vt;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Ben", "Bon", "benbon@gmail.com", "eo", 0, "admin@root.es");
		vt = new Ventana_CalculaTUS_II(u);
	}
	
	@Test
	public void testPanel_consola() {
		pc = new Panel_consola(u);
	}
}
