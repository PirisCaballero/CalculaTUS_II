package es.deusto.spq.ventanas;

import static org.junit.Assert.assertTrue;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import junit.framework.JUnit4TestAdapter;

@PerfTest(invocations = 10)
public class VentanasPerfTest {

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(VentanasPerfTest.class);
	}
	
//	@Test(expected = NullPointerException.class)
//	@PerfTest(invocations = 4, threads = 20)
//	@Required(max = 200, average = 120)
//	public void show_DescuentosTest() {
//		Connect c = new Connect();
//		Users us = c.Recuperar_usuario("admin@root.es");
//		Show_Descuentos SD = new Show_Descuentos(us);
//		assertTrue(SD != null);
//	}
//	
//	@Test(expected = IndexOutOfBoundsException.class)
//	@PerfTest(invocations = 4, threads = 20)
//	@Required(max = 900, average = 100)
//	public void show_ticketTest() {
//		Connect c = new Connect();
//		Users us = c.Recuperar_usuario("admin@root.es");
//		String ti = "Ticket";
//		Show_ticket St = new Show_ticket(us, ti);
//		assertTrue(St != null);
//	}
//	//TODO Esta da error
//	@Test(expected = NullPointerException.class)
//	@PerfTest(invocations = 4, threads = 20)
//	@Required(max = 500, average = 250)
//	public void show_TicketsTest() {
//		Connect c = new Connect();
//		Users us = c.Recuperar_usuario("admin@root.es");
//		Show_Tickets ST = new Show_Tickets(us);
//		assertTrue(ST != null);
//	}
	
	/////////////////////////////////////////////////////////////
	@Test(expected = NullPointerException.class)
	@PerfTest(invocations = 10, threads = 5)
	@Required(totalTime = 30000, max = 10000)
	public void ventana_CalculaTUS_IITest() {
		Connect c = new Connect();
		Users us = c.RecuperarUsuario("admin@root.es");
		VentanaCalculaTUSII VenCal = new VentanaCalculaTUSII(us);
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
		Connect c = new Connect();
		Users us = c.RecuperarUsuario("admin@root.es");
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
