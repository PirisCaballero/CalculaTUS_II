package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Ticket;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class Show_Tickets extends JFrame{
	
	/**
	 * Betha 1.2
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Ticket> tL;
	private Users main_user;
	private JTable tabla;
	private Show_ticket st;
	private Connect cn;
	public Show_Tickets(Users user) {
		this.setTitle("Tickets");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds( Ventana_CalculaTUS_II.getFrame().getLocation().x+Ventana_CalculaTUS_II.getFrame().getWidth() , Ventana_CalculaTUS_II.getFrame().getLocation().y , 350 , Ventana_CalculaTUS_II.getFrame().getHeight()  );
		this.setResizable(false);
		this.setLayout(null);
		this.main_user = user;
		cn = new Connect();
		tL = cn.getTickets_by_user(main_user);
		String[] nomCol = { "ID_Ticket" };
		
		//Contenido
		Model modelo = new Model();
		modelo.setColumnIdentifiers(nomCol);
		modelo.setColumnCount(1);
		modelo.setRowCount(tL.size());
		for(int i = 0; i<tL.size() ; i++) {
			modelo.setValueAt(tL.get(i).getNombreUsuario()+"TICKET"+tL.get(i).getID(), i, 0);
			modelo.isCellEditable(i, 0);
		}
			
		tabla = new JTable(modelo);
		tabla.setEnabled(true);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane( tabla );
		scroll.setBounds(0 , 0 , 350 , Ventana_CalculaTUS_II.getFrame().getHeight()-80 );
		//scroll.setBorder(BorderFactory.createLineBorder(Color.red));
		
		JButton btnEnviar = new JButton("Ver Ticket");
		btnEnviar.setBounds(0 , Ventana_CalculaTUS_II.getFrame().getHeight()-80 , 175 , 50);
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(175 , Ventana_CalculaTUS_II.getFrame().getHeight()-80 , 175 , 50);
		this.add(scroll);
		this.add(btnEnviar);
		this.add(btnRefresh , BorderLayout.SOUTH);
		
		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				st = new Show_ticket(main_user, (String)tabla.getValueAt(tabla.getSelectedRow(), 0));
				st.setVisible(true);
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tL.clear();
				tL = cn.getTickets_by_user(main_user);
				String[] nomCol = { "ID_Ticket" };
				Model modelo = new Model();
				modelo.setColumnIdentifiers(nomCol);
				modelo.setColumnCount(1);
				modelo.setRowCount(tL.size());
				for(int i = 0; i<tL.size() ; i++) {
					modelo.setValueAt(tL.get(i).getNombreUsuario()+"TICKET"+tL.get(i).getID(), i, 0);
					modelo.isCellEditable(i, 0);
				}
				tabla.setModel(modelo);
			}
		});
		
	}

}
class Model extends DefaultTableModel{
	/**
	 * Betha 1.2
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isCellEditable(int row , int column) {
		return false;
	}
	
}
