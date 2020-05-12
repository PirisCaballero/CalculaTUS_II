package es.deusto.spq.paneles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import es.deusto.spq.Local;
import es.deusto.spq.Producto;
import es.deusto.spq.Ticket;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.ShowTickets;

import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelTicket extends JPanel {
	
	/**
	 * Betha 1.2
	 */
	
	private final String nombres_col[] = {"Columna 1" , "Columna 2" , "Columna 3"};
	private final String Data[][] = {
			{ "" , "" , "" }
	};
	
	
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private PanelDatos pd;
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
	private static ShowTickets st;
	
	public PanelTicket(Users us , PanelDatos pdat) {
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
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(200, 400, 150, 30);
		add(btnAgregar);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(100, 321, 150, 30);
		add(lblProducto);
		
		producto = new Choice();
		if(choice.getSelectedItem() != "-------------------") {
			Local locID = cn.getLocalByName(main_user, choice.getSelectedItem());
			pL = cn.getProductsByLocal(main_user, locID.getId());
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
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(360, 400, 150, 30);
		add(btnGrabar);
		
		JButton show_Ti = new JButton("Ver Tickets");
		show_Ti.setBounds(40, 400, 150, 30);
		add(show_Ti);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(71, 23, 89, 23);
		add(btnRefresh);
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				refresh();
			}
		});
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Funciona el listener");
				if(choice.getSelectedItem() != "-------------------") {
					producto.removeAll();
					Local locID = cn.getLocalByName(main_user, choice.getSelectedItem());
					pL = cn.getProductsByLocal(main_user, locID.getId());
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
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		btnGrabar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				grabar();
			}
		});
		st = new ShowTickets(main_user);
		st.setVisible(false);
		show_Ti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				st.setVisible(true);
			}
		});
		
		producto.setBounds(300, 321, 200, 20);
		add(producto);		
		
		
	}
	
	public static ShowTickets getFrameTickets() {
		return st;
	}
	
	public void refresh() {
		choice.removeAll();
		ul.clear();
		ul = cn.getLocales(main_user);
		choice.add("-------------------");
		for(Local u : ul) {
			choice.add(u.getNombre());
		}
		choice.setEnabled(true);
		producto.removeAll();
		pL.clear();
		if(choice.getSelectedItem() != "-------------------") {
			Local locID = cn.getLocalByName(main_user, choice.getSelectedItem());
			pL = cn.getProductsByLocal(main_user, locID.getId());
			for(Producto p : pL) {
				producto.add(p.getNombre());
			}
		}else {
			System.out.println("No hay seleccion");
		}
		
		for(int i = 0; i<modelo.getRowCount()-1;i++) {
			modelo.removeRow(i);
		}
		
	}
	
	public void agregar() {
		if( choice.getSelectedItem() != "-------------------" && textField.getText()!="" && Integer.parseInt(textField.getText())>0 ) {
			String pattern = "dd-MM-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			date = simpleDateFormat.format(calendario.getDate());
			System.out.println(date + producto.getSelectedItem());
			Producto pr = cn.getProductByName(main_user, producto.getSelectedItem());
			pr.setCantidad(Integer.parseInt(textField.getText()));
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
	
	public void grabar() {
		String lista = "¿Desea hacer un ticket con los siguientes productos? : \n";
		Double prec = 0.0;
		for(int i = 0; i<prTicket.size() ; i++) {
			lista += prTicket.get(i).getNombre() + "\n";
			System.out.println( modelo.getValueAt(i, 2) );
			Double var2 = prTicket.get(i).getPrecio() * Double.parseDouble((String) modelo.getValueAt(i, 2)); 
			prec += var2;
		}
		//prTicket es el array con los productos del ticket
		lista += "Por un precio de: "+prec+" €";
		int opcion = JOptionPane.showConfirmDialog(null, lista);
		if( opcion == JOptionPane.YES_OPTION ) {
			Local loc = cn.getLocalByName(main_user, choice.getSelectedItem());
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
}
