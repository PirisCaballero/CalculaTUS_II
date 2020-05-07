package es.deusto.spq.ventanas;

import javax.swing.*;

import es.deusto.spq.Users;
import es.deusto.spq.paneles.Panel_Central;
import es.deusto.spq.paneles.Panel_Datos;
import es.deusto.spq.paneles.Panel_Ticket;
import es.deusto.spq.paneles.Panel_norte;
import es.deusto.spq.paneles.Panel_sur;

public class Ventana_CalculaTUS_II{

	/**
	 * Betha 1.1 
	 */

	private Users main_user;
	private static JFrame main_frame;
	public static Panel_Central pc; private Panel_Datos pd;private Panel_sur ps;private Panel_norte pn;
	public Ventana_CalculaTUS_II(Users user) {
		this.main_user = user;
		Ventana_CalculaTUS_II.main_frame = new JFrame();
		main_frame.setTitle("CalculaTUS_II");
		main_frame.setLayout(null);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1024, 720);
		main_frame.setResizable(false);
		main_frame.setLocationRelativeTo(null);
		String [] users = { "Aitor" , "Iratxe" , "Erik" , "Eneko" };
		ps = new Panel_sur(main_user , main_frame , users);
		pd = new Panel_Datos();
		pc = new Panel_Central(main_user , pd);
		pn = new Panel_norte(main_user , this.main_frame , pc.getPanel_Ticket());
		
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
		Ventana_CalculaTUS_II VenCal = new Ventana_CalculaTUS_II(us);
	}
}
