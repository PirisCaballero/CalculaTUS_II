package es.deusto.spq.paneles;

import javax.swing.JFrame;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.ShowTickets;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

public class PanelNorteTest {

	static Connect c = new Connect();
	static Users u;
	static PanelNorte pn;
	static ShowTickets st;
	static PanelCentral pc;
	static PanelDatos pd;
	
	@BeforeClass
	public static void initialize() {
		
		u = c.RecuperarUsuario("admin@root.es");
		pd = new PanelDatos();
		pc = new PanelCentral(u, pd);
		
		
	}
	
	@Test
	public void testPanelNorte() {
		pn = new PanelNorte(u, pc.getPanelTicket());
	}
	
}
