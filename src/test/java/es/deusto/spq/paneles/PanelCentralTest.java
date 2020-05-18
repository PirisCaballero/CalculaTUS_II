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
		pftp = new PanelFTP(u);
		pl = new PanelLocal(u);
		pprod = new PanelProducto(u, pd);
		pb = new PanelBienvenida(u);
		pa = new PanelAdmin(u, pd);
		pu = new PanelUser(u, pd);
		pt = new PanelTicket(u, pd);
		ppreg = new PanelPreguntas();
		pc = new PanelControl(u, pd);
	}
	
	@Test
	public void testSetPanel() {
		pCent = new PanelCentral(u, pd);
		pCent.setPanel(0);
		pCent.setPanel(1);
		pCent.setPanel(2);
		pCent.setPanel(3);
		pCent.setPanel(4);
		pCent.setPanel(5);
		pCent.setPanel(6);
		pCent.setPanel(7);
		pCent.setPanel(8);
		pCent.getPanelProd();
	}
}
