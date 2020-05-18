package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

public class PanelCentralTest {

	static PanelDatos pd;
	static PanelFTP pftp;
	static PanelLocal pl;
	static PanelProducto pprod;
	static PanelBienvenida pb;
	static PanelAdmin pa;
	static PanelUser pu;
	static PanelTicket pt;
	static PanelPreguntas ppreg;
	static PanelControl pc;
	static PanelCentral pCent;
	static Connect c;
	static Users u;
	@BeforeClass
	public static void initialize() {
		//u = new Users("Ben", "Bon", "benbon@gmail.com", "eo", 0, "admin@root.es");
		c = new Connect();
		u = c.RecuperarUsuario("admin@root.es");
		pd = new PanelDatos();
	}
	
	@Test
	public void testSetPanel() {
		pCent = new PanelCentral(u, pd);
		pCent.setPanel(0);
	}
}
