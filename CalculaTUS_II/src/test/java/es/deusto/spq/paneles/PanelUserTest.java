package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.Show_Descuentos;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class PanelUserTest {

	static Users u;
	static Panel_Datos pd;
	static PanelUser pu;
	static Show_Descuentos sd;
	static PanelControl pc;
	static Ventana_CalculaTUS_II vt;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		vt = new Ventana_CalculaTUS_II(u);
		pd = new Panel_Datos();
		sd = new Show_Descuentos(u);
		pc = new PanelControl(u, pd);
	}
	
	@Test
	public void testPanelUser() {
		pu = new PanelUser(u, pd);
	}
	
}
