package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import java.awt.Choice;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.ShowTickets;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

public class PanelTicketTest {

	static Users u;
	static PanelDatos pd;
	static PanelTicket pt;
	static ShowTickets st;
	static VentanaCalculaTUSII vt;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		pd = new PanelDatos();
		vt = new VentanaCalculaTUSII(u);
	}
	
	@Test
	public void testPanelTicket() {
		pt = new PanelTicket(u, pd);
		assertFalse(pt.equals(null));
	}
	
	@Test
	public void testGetFrameTickets() {
		ShowTickets s = pt.getFrameTickets();
		assertFalse(s.equals(null));
	}
	
}