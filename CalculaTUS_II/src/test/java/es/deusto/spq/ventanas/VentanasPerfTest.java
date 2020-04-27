package es.deusto.spq.ventanas;

import static org.junit.Assert.assertTrue;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.Users;
import junit.framework.JUnit4TestAdapter;

@PerfTest(invocations = 10)
public class VentanasPerfTest {

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(VentanasPerfTest.class);
	}
	/*
	@Test
	@PerfTest(invocations = 4, threads = 20)
	// @Required(max = 120, average = 30)
	public void show_DescuentosTest() {
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		Show_Descuentos SD = new Show_Descuentos(us);
		assertTrue(SD != null);
	}
	
	@Test
	@PerfTest(invocations = 4, threads = 20)
	// @Required(max = 120, average = 30)
	public void show_ticketTest() {
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		String ti = "Ticket";
		Show_ticket St = new Show_ticket(us, ti);
		assertTrue(St != null);
	}
	
	@Test
	@PerfTest(invocations = 4, threads = 20)
	// @Required(max = 120, average = 30)
	public void show_TicketsTest() {
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		Show_Tickets ST = new Show_Tickets(us);
		assertTrue(ST != null);
	}
	*/
	
	@Test
	@PerfTest(invocations = 10, threads = 5)
	@Required(totalTime = 15000, max = 10000)
	public void ventana_CalculaTUS_IITest() {
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		Ventana_CalculaTUS_II VenCal = new Ventana_CalculaTUS_II(us);
		assertTrue(VenCal != null);
	}

	@Test
	@PerfTest(invocations = 20, threads = 10)
	@Required(totalTime = 150, max = 100)
	public void ventanaLoginTest() {
		VentanaLogin VL = new VentanaLogin();
		assertTrue(VL != null);
	}
	
	@Test
	@PerfTest(invocations = 20, threads = 10)
	@Required(totalTime = 1000, max = 1000)
	public void ventanaOpinionTest() {
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		VentanaOpinion VO = new VentanaOpinion(us);
		assertTrue(VO != null);
	}
	
	@Test
	@PerfTest(invocations = 10, threads = 5)
	@Required(totalTime = 1500, max = 1000)
	public void ventanaRegistroTest() {
		VentanaRegistro VR = new VentanaRegistro();
		assertTrue(VR != null);
	}
	
}
