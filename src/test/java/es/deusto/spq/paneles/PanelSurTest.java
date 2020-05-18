package es.deusto.spq.paneles;

import javax.swing.JFrame;

import org.junit.*;

import es.deusto.spq.Users;

public class PanelSurTest {

	static Users u;
	static JFrame main_frame;
	static PanelSur ps;
	static String[] us = { "Aitor" , "Iratxe" , "Erik" , "Eneko" };
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Ben", "Bon", "benbon@gmail.com", "eo", 0, "admin@root.es");
		
	}
	
	@Test
	public void testPanelSur() {
		ps = new PanelSur(u, us);
	}
}
