package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PanelPreguntasTest {

	public PanelPreguntas pg;
	
	@Test
	public void testPanelPreguntas() {
		pg = new PanelPreguntas();
		assertFalse(pg.equals(null));
	}
}
