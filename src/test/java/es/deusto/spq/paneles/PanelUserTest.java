package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.ShowDescuentos;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

public class PanelUserTest {

	static Users u;
	static PanelDatos pd;
	static PanelUser pu;
	//static ShowDescuentos sd;
	static PanelControl pc;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		pd = new PanelDatos();
		//sd = new ShowDescuentos(u);
		pc = new PanelControl(u, pd);
	}
	
	@Test
	public void testPanelUser() {
		pu = new PanelUser(u, pd);
	}
	
}
