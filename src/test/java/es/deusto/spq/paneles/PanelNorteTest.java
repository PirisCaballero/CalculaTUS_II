package es.deusto.spq.paneles;

import javax.swing.JFrame;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.Show_Tickets;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

public class PanelNorteTest {

	static Connect c = new Connect();
	static Users u;
	static PanelNorte pn;
	static JFrame main_frame;
	static Show_Tickets st;
	static PanelCentral pc;
	static PanelDatos pd;
	static VentanaCalculaTUSII vt;
	
	@BeforeClass
	public static void initialize() {
		
		u = c.RecuperarUsuario("admin@root.es");
		vt = new VentanaCalculaTUSII(u);
		main_frame = new JFrame();
		main_frame.setTitle("CalculaTUS_II");
		main_frame.setLayout(null);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1024, 720);
		main_frame.setResizable(false);
		main_frame.setLocationRelativeTo(null);
		
		pd = new PanelDatos();
		
		pc = new PanelCentral(u, pd);
		
		
	}
	
	@Test
	public void testPanelNorte() {
		pn = new PanelNorte(u, main_frame, pc.getPanel_Ticket());
	}
	
}
