package es.deusto.spq.paneles;

import javax.swing.JFrame;

import org.junit.*;

import es.deusto.spq.Users;

public class Panel_surTest {

	static Users u;
	static JFrame main_frame;
	static Panel_sur ps;
	static String[] us = { "Aitor" , "Iratxe" , "Erik" , "Eneko" };
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Ben", "Bon", "benbon@gmail.com", "eo", 0, "admin@root.es");
		main_frame = new JFrame();
		main_frame.setTitle("CalculaTUS_II");
		main_frame.setLayout(null);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1024, 720);
		main_frame.setResizable(false);
		main_frame.setLocationRelativeTo(null);
		
	}
	
	@Test
	public void testPanel_sur() {
		ps = new Panel_sur(u, main_frame, us);
	}
}
