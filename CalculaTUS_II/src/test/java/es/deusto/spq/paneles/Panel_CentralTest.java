package es.deusto.spq.paneles;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class Panel_CentralTest {

	static Users u;
	static Panel_Datos pd;
	static Panel_FTP pftp;
	static Panel_Local pl;
	static Panel_producto pprod;
	static Panel_Bienvenida pb;
	static PanelAdmin pa;
	static PanelUser pu;
	static Panel_Ticket pt;
	static PanelPreguntas ppreg;
	static PanelControl pc;
	static Ventana_CalculaTUS_II vt;
	static Panel_Central pCent;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Ben", "Bon", "benbon@gmail.com", "eo", 0, "admin@root.es");
		vt = new Ventana_CalculaTUS_II(u);
		pd = new Panel_Datos();
		pftp = new Panel_FTP(u);
		pl = new Panel_Local(u);
		pprod = new Panel_producto(u, pd);
		pb = new Panel_Bienvenida(u);
		pa = new PanelAdmin(u, pd);
		pu = new PanelUser(u, pd);
		pt = new Panel_Ticket(u, pd);
		ppreg = new PanelPreguntas();
		pc = new PanelControl(u, pd);
	}
	
	@Test
	public void testSetPanel() {
		pCent = new Panel_Central(u, pd);
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
