package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;

public class PanelEstadisticasTest {
	static PanelEstadisticas pe;
	static Users us;
	static PanelDatos pdts;
	
	@BeforeClass
	public static void initialize() {
		us = new Users("ADMIN", "ROOT", "admin@root.es", "root", 1, "null");
		pdts = new PanelDatos();
		pe = new PanelEstadisticas(us, pdts);
	}
	@Test
	public void buscarTest() {
		pe.buscar();
	}
	@Test
	public void refreshTest() {
		pe.refresh();
	}
}
