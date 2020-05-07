package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import java.awt.Choice;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.Show_Tickets;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class Panel_TicketTest {

	static Users u;
	static Panel_Datos pd;
	static Panel_Ticket pt;
	static Show_Tickets st;
	static Ventana_CalculaTUS_II vt;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		pd = new Panel_Datos();
		vt = new Ventana_CalculaTUS_II(u);
	}
	
	@Test
	public void testPanel_Ticket() {
		pt = new Panel_Ticket(u, pd);
		assertFalse(pt.equals(null));
	}
	
	@Test
	public void testGetFrameTickets() {
		Show_Tickets s = pt.getFrameTickets();
		assertFalse(s.equals(null));
	}
	
}
