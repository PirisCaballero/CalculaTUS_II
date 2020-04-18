package com.mycompany.app.paneles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mycompany.app.Local;
import com.mycompany.app.Producto;
import com.mycompany.app.Ticket;
import com.mycompany.app.Users;
import com.mycompany.app.Connection.Connect;
import com.toedter.calendar.JCalendar;

import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Panel_Ticket extends JPanel {
	
	/**
	 * Betha 1.2
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private Panel_Datos pd;
	private JCalendar calendario;
	private ArrayList<Local> ul;
	private ArrayList<Producto> pL;
	private Choice choice , producto;
	private Connect cn;
	private DefaultTableModel modelo;
	private int row = 0; private int col =0;
	private JTextField textField;
	private ArrayList<Producto> prTicket;
	private String date;
	
	public Panel_Ticket(Users us , Panel_Datos pdat) {
		this.setBounds(0 , 0 , 574 , 470);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.white);
		this.setLayout(null);
		this.main_user = us;
		this.pd = pdat;
		String[] nomCol = { "Producto" , "Precio" , "Cantidad" };
		String[][] data = { {} };
 		modelo = new DefaultTableModel( data , nomCol );
 		prTicket = new ArrayList<Producto>();
		
		JLabel lblAadirTicket = new JLabel("Añadir Ticket");
		Font f = new Font(lblAadirTicket.getFont().getName() , Font.BOLD , 17);
		lblAadirTicket.setFont(f);
		//lblAadirTicket.setBorder(BorderFactory.createLineBorder(Color.red));
		lblAadirTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirTicket.setBounds(139, 23, 250, 50);
		add(lblAadirTicket);
		
		calendario = new JCalendar();
		calendario.setBounds(300 , 140 , 200 , 150);
		calendario.setTodayButtonVisible(true);
		add(calendario);
		
		cn = new Connect();
		ul = cn.getLocales(main_user);
		choice = new Choice();
		choice.add("-------------------");
		choice.setBounds(300, 99, 200, 20);
		for(Local u : ul) {
			choice.add(u.getNombre());
		}
		add(choice);
		
		JLabel lblNewLabel = new JLabel("Local");
		lblNewLabel.setBounds(100, 99, 150, 30);
		add(lblNewLabel);
		
		JLabel lblFecha = new JLabel("Fecha  ");
		lblFecha.setBounds(100, 141, 150, 30);
		add(lblFecha);
		
		JButton button = new JButton("Agregar");
		button.setBounds(200, 400, 150, 30);
		add(button);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(100, 321, 150, 30);
		add(lblProducto);
		
		producto = new Choice();
		if(choice.getSelectedItem() != "-------------------") {
			Local locID = cn.getLocal_byName(main_user, choice.getSelectedItem());
			pL = cn.getProducts_byLocal(main_user, locID.getId());
			for(Producto p : pL) {
				producto.add(p.getNombre());
			}
		}else {
			System.out.println("No hay seleccion");
		}
		
		JLabel lblCantidadDeProducto = new JLabel("Cantidad de Producto");
		lblCantidadDeProducto.setBounds(100, 362, 150, 30);
		add(lblCantidadDeProducto);
		
		textField = new JTextField();//textField de cantidad
		textField.setBounds(300, 362, 200, 27);
		add(textField);
		textField.setColumns(10);
		
		JButton btn_grabar = new JButton("Grabar");
		btn_grabar.setBounds(360, 400, 150, 30);
		add(btn_grabar);
		
		
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Funciona el listener");
				if(choice.getSelectedItem() != "-------------------") {
					producto.removeAll();
					Local locID = cn.getLocal_byName(main_user, choice.getSelectedItem());
					pL = cn.getProducts_byLocal(main_user, locID.getId());
					for(Producto p : pL) {
						producto.add(p.getNombre());
					}
					producto.repaint();
					choice.disable();
				}else {
					producto.removeAll();
					System.out.println("No hay seleccion");
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( choice.getSelectedItem() != "-------------------" && textField.getText()!="" && Integer.parseInt(textField.getText())>0 ) {
					String pattern = "dd-MM-yyyy";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					date = simpleDateFormat.format(calendario.getDate());
					System.out.println(date + producto.getSelectedItem());
					Producto pr = cn.getProduct_by_Name(main_user, producto.getSelectedItem());
					modelo.setRowCount(modelo.getRowCount()+1);
					modelo.setValueAt(pr.getNombre() , row, col);
					modelo.setValueAt(pr.getPrecio(), row, col+1);
					modelo.setValueAt(textField.getText(), row, col+2);
					pd.setData(modelo);
					row+=1;
					prTicket.add(pr);
				}else {
					JOptionPane.showMessageDialog(null, "No hay cantidad seleccionada o no hay local seleccionado");
				}
			}
		});
		btn_grabar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String lista = "¿Desea hacer un ticket con los siguientes productos? : \n";
				Double prec = 0.0;
				for(int i = 0; i<prTicket.size() ; i++) {
					lista += prTicket.get(i).getNombre() + "\n";
					System.out.println( modelo.getValueAt(i, 2) );
					Double var2 = prTicket.get(i).getPrecio() * Integer.parseInt((String) modelo.getValueAt(i, 2)); 
					prec += var2;
				}
				//prTicket es el array con los productos del ticket
				lista += "Por un precio de: "+prec+" €";
				int opcion = JOptionPane.showConfirmDialog(null, lista);
				if( opcion == JOptionPane.YES_OPTION ) {
					Local loc = cn.getLocal_byName(main_user, choice.getSelectedItem());
					Ticket ti = new Ticket( date , main_user.getEmail() , prec , loc.getId() );
					Ticket TI = cn.crearTicket(main_user,ti);
					System.out.println("El id del ticket es: " + TI.getID());
					/*
					 * El ticket esta hecho, falta grabar los elementos relacionados a ese ticket en otra tabla.
					 */
					cn.introducirProductosComprador(main_user, prTicket, TI);
				}else {
					System.out.println("Has seleccionado no hacer el ticket");
				}
			}
		});
		
		producto.setBounds(300, 321, 200, 20);
		add(producto);		
		
		
	}
}
