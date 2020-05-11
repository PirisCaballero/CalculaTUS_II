package es.deusto.spq.ventanas;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Local;
import es.deusto.spq.Producto;
import es.deusto.spq.Ticket;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
public class ShowTicket extends JFrame{
	private JTable table;
	private int ID;
	private Users main_user;
	private ArrayList<Producto> prList;
	public ShowTicket(Users user , String ti) {
		setTitle(ti);
		setSize(500 , 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		this.main_user = user;
		String[] l = ti.split("TICKET");
		ID = Integer.parseInt(l[1]);
		System.out.println("ID-->"+ID);
		Connect cn = new Connect();
		prList = cn.getProductsByTicket(main_user, this.ID);
		Ticket ticket = cn.getTicketByTicketID(ID);
		Local loc = cn.getLocalById(main_user, ticket.getID_Lugar_Compra());
		
		JLabel lblNewLabel = new JLabel(ti);
		lblNewLabel.setBounds(175, 20, 150, 30);
		getContentPane().add(lblNewLabel);
		
		String[] nomCol = { "Nombre" , "Precio" , "Cantidad" };
		String[][] data = {{}};
		DefaultTableModel modelo = new DefaultTableModel(data , nomCol);
		modelo.setRowCount(prList.size());
		for(int i = 0 ; i<prList.size() ; i++) {
			modelo.setValueAt(prList.get(i).getNombre(), i, 0);
			modelo.setValueAt(prList.get(i).getPrecio(), i, 1);
			modelo.setValueAt(prList.get(i).getCantidad(), i, 2);
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 237, 150);
		getContentPane().add(scrollPane);
		
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setBounds(257, 61, 107, 30);
		getContentPane().add(lblImporte);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(257, 114, 107, 30);
		getContentPane().add(lblFecha);
		
		JLabel label = new JLabel(""+ticket.getImporte());
		label.setBounds(374, 61, 107, 30);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel(""+ticket.getFecha_emision());
		label_1.setBounds(374, 114, 107, 30);
		getContentPane().add(label_1);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(257, 160, 107, 30);
		getContentPane().add(lblLocal);
		
		JLabel label_2 = new JLabel(""+loc.getNombre());
		label_2.setBounds(374, 160, 107, 30);
		getContentPane().add(label_2);
	}
}
