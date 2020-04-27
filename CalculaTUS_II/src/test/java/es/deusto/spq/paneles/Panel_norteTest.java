package es.deusto.spq.paneles;

import javax.swing.JFrame;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.Show_Tickets;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class Panel_norteTest {

	static Users u;
	static Panel_norte pn;
	static JFrame main_frame;
	static Show_Tickets st;
	static Panel_Central pc;
	static Panel_Datos pd;
	static Ventana_CalculaTUS_II vt;
	
	@BeforeClass
	public static void initialize() {
		
		u = new Users("Ben", "Bon", "benbon@gmail.com", "eo", 0, "admin@root.es");
		vt = new Ventana_CalculaTUS_II(u);
		main_frame = new JFrame();
		main_frame.setTitle("CalculaTUS_II");
		main_frame.setLayout(null);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1024, 720);
		main_frame.setResizable(false);
		main_frame.setLocationRelativeTo(null);
		
		pd = new Panel_Datos();
		
		pc = new Panel_Central(u, pd);
		
		
	}
	
	@Test
	public void testPanel_norte() {
		pn = new Panel_norte(u, main_frame, pc.getPanel_Ticket());
	}
	
}
