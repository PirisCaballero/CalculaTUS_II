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

public class ShowTickets extends JFrame{
	
	/**
	 * Betha 1.2
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Ticket> tL;
	private Users main_user;
	private JTable tabla;
	private ShowTicket st;
	private Connect cn;
	public ShowTickets(Users user) {
		this.setTitle("Tickets");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		if( VentanaCalculaTUSII.getFrame() != null ) {
			this.setBounds( VentanaCalculaTUSII.getFrame().getLocation().x+VentanaCalculaTUSII.getFrame().getWidth() , VentanaCalculaTUSII.getFrame().getLocation().y , 350 , VentanaCalculaTUSII.getFrame().getHeight()  );
		}else {
			this.setBounds(200 , 200 , 350 , 500);
		}
		
		this.setResizable(false);
		this.setLayout(null);
		this.main_user = user;
		cn = new Connect();
		tL = cn.getTicketsByUser(main_user);
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
		JButton btnEnviar = new JButton("Ver Ticket");
		JButton btnRefresh = new JButton("Refresh");
		if( VentanaCalculaTUSII.getFrame() != null ) {
			btnEnviar.setBounds(0 , VentanaCalculaTUSII.getFrame().getHeight()-80 , 175 , 50);
			btnRefresh.setBounds(175 , VentanaCalculaTUSII.getFrame().getHeight()-80 , 175 , 50);
			scroll.setBounds(0 , 0 , 350 , VentanaCalculaTUSII.getFrame().getHeight()-80 );
		}else {
			btnEnviar.setBounds(0 , 250 , 175 , 50);
			btnRefresh.setBounds(175 , 250 , 175 , 50);
			scroll.setBounds(0 , 0 , 350 , 450 );
		}
		
		//scroll.setBorder(BorderFactory.createLineBorder(Color.red));
		
		this.add(scroll);
		this.add(btnEnviar);
		this.add(btnRefresh , BorderLayout.SOUTH);
		
		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				st = new ShowTicket(main_user, (String)tabla.getValueAt(tabla.getSelectedRow(), 0));
				st.setVisible(true);
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tL.clear();
				tL = cn.getTicketsByUser(main_user);
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
