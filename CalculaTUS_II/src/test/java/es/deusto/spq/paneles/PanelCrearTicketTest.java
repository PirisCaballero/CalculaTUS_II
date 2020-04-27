package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PanelCrearTicketTest {

	public PanelCrearTicket pct;
	
	@Test
	public void testPanelCrearTicket() {
		pct = new PanelCrearTicket();
		assertFalse(pct.equals(null));
	}
	
}
