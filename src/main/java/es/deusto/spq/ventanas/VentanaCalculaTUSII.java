package es.deusto.spq.ventanas;

import javax.swing.*;

import es.deusto.spq.Users;
import es.deusto.spq.paneles.*;

/**
 * Ventana principal de la aplicacion, aqui se superposicionan todos los paneles
 * del programa.
 */

public class VentanaCalculaTUSII{

	/**
	 * Betha 1.1 
	 */

	private Users main_user;
	private static JFrame main_frame;
	public static PanelCentral pc; private PanelDatos pd;private PanelSur ps;private PanelNorte pn;
	public VentanaCalculaTUSII(Users user) {
		this.main_user = user;
		VentanaCalculaTUSII.main_frame = new JFrame();
		main_frame.setTitle("CalculaTUS_II");
		main_frame.setLayout(null);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1024, 720);
		main_frame.setResizable(false);
		main_frame.setLocationRelativeTo(null);
		String [] users = { "Aitor" , "Iratxe" , "Erik" , "Eneko" };
		ps = new PanelSur(main_user , main_frame , users);
		pd = new PanelDatos();
		pc = new PanelCentral(main_user , pd);
		pn = new PanelNorte(main_user , this.main_frame , pc.getPanelTicket());
		
		main_frame.add(pn);
		main_frame.add(pc);
		main_frame.add(ps);
		main_frame.add(pd);
		main_frame.setVisible(true);
	}
	public static JFrame getFrame() {
		return main_frame;
	}
	public static void main(String[] args) {
		Users us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		VentanaCalculaTUSII VenCal = new VentanaCalculaTUSII(us);
	}
}
