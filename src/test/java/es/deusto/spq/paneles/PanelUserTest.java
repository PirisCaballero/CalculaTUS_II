package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.Show_Descuentos;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

public class PanelUserTest {

	static Users u;
	static PanelDatos pd;
	static PanelUser pu;
	static Show_Descuentos sd;
	static PanelControl pc;
	static VentanaCalculaTUSII vt;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		vt = new VentanaCalculaTUSII(u);
		pd = new PanelDatos();
		sd = new Show_Descuentos(u);
		pc = new PanelControl(u, pd);
	}
	
	@Test
	public void testPanelUser() {
		pu = new PanelUser(u, pd);
	}
	
}
