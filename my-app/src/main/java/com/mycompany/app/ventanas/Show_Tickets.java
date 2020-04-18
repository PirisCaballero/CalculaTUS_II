package com.mycompany.app.ventanas;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mycompany.app.Ticket;
import com.mycompany.app.Users;
import com.mycompany.app.Connection.Connect;

public class Show_Tickets{
	
	/**
	 * Betha 1.2
	 */
	private static final long serialVersionUID = 1L;
	private JFrame ven;
	private ArrayList<Ticket> tL;
	private Users main_user;
	public Show_Tickets(Users user) {
		ven = new JFrame();
		ven.setTitle("Tickets");
		ven.setVisible(true);
		ven.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ven.setBounds( Ventana_CalculaTUS_II.getFrame().getLocation().x+Ventana_CalculaTUS_II.getFrame().getWidth() , Ventana_CalculaTUS_II.getFrame().getLocation().y ,
				350 , Ventana_CalculaTUS_II.getFrame().getHeight()  );
		ven.setResizable(false);
		this.main_user = user;
		Connect cn = new Connect();
		tL = cn.getTickets_by_user(main_user);
		String[] nomCol = { "ID_Ticket" };
		
		//Contenido
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(nomCol);
		modelo.setColumnCount(1);
		modelo.setRowCount(tL.size());
		for(int i = 0; i<tL.size() ; i++) {
			modelo.setValueAt(tL.get(i).getNombreUsuario()+"TICKET"+tL.get(i).getID(), i, 0);
		}
			
		JTable tabla = new JTable(modelo);
		tabla.setEnabled(false);
		JScrollPane scroll = new JScrollPane( tabla );
		
		ven.add(scroll);
		
	}

}
