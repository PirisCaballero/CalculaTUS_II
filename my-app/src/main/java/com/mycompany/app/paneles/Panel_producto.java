package com.mycompany.app.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mycompany.app.Local;
import com.mycompany.app.Producto;
import com.mycompany.app.Users;
import com.mycompany.app.Connection.Connect;

import java.awt.Choice;

public class Panel_producto extends JPanel {

	/**
	 * CalculaTUS_II
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Local> locList = new ArrayList<Local>();
	private Choice choice, choice_1;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnRefresh;
	private Users user;
	private JTable tabla_productos;
	private String[] column_names = { "Nombre" , "Producto" , "Local" };
	private JScrollPane scrollpane;
	private String localSel = "";

	public Panel_producto(Users us) {
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.white);
		this.setBounds(240, 100, 530, 360);
		this.user = us;

		JLabel lblLocal = new JLabel("Local: ");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(50, 50, 150, 30);
		add(lblLocal);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(431, 11, 89, 23);
		add(btnRefresh);

		choice = new Choice();
		Connect cn = new Connect();
		locList = cn.getLocales(user);
		for (Local l : locList) {
			choice.add(l.getNombre());
		}
		choice.setBounds(250, 50, 150, 30);
		add(choice);

		JLabel lblPrecio = new JLabel("Nombre: ");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(50, 100, 150, 30);
		add(lblPrecio);

		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_1.setBounds(50, 150, 150, 30);
		add(lblPrecio_1);

		textField = new JTextField();
		textField.setBounds(250, 100, 150, 30);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(250, 150, 150, 30);
		add(textField_1);
		this.setVisible(false);
		
		////Array con los datos de la tabla
		Object[][] datos = {};
		
		//Crear la tabla de con los producto ya registrados
		tabla_productos = new JTable( datos , column_names );
		
		//Creamos un scrollpanel y se lo agregamos a la tabla
		scrollpane = new JScrollPane(tabla_productos);
		scrollpane.setBounds( 15 , 200 , 500 , 150 );
		scrollpane.setBorder(BorderFactory.createLineBorder(Color.black));
		add(scrollpane);
		
		/*
		 * Choice para elegir el local de los productos a mostrar en la tabla
		 */
		choice_1 = new Choice();
		ArrayList<Local> locListTable = cn.getLocales(user);
		for(Local l : locListTable) {
			choice_1.add(l.getNombre());
		}
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(15, 154, 89, 23);
		add(btnAgregar);
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Refreshing...");
				localSel = choice.getSelectedItem();
				choice.removeAll();
				Connect cn = new Connect();
				locList.clear();
				locList = cn.getLocales(user);
				for (Local l : locList) {
					choice.add(l.getNombre());
				}
				Local local = cn.getLocal_byName(user, localSel);
				cn.getProducts_byLocal(user, local.getId());
				//scrollpane.removeAll();
				//System.out.println("Local seleccionado: " + local.getId());
				dataToTable(local.getId(), tabla_productos);
			}
		});
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connect cn = new Connect();
				Local local = cn.getLocal_byName(user, choice.getSelectedItem());
				//System.out.println("El nombre del local es: "+local.getNombre();
				Producto prod = new Producto( Double.parseDouble(textField_1.getText()), textField.getText() , 0 , local.getId() ,user.getEmail());
				cn.anadirProducto(user, prod, local.getId());
				textField.setText("");textField_1.setText("");
			}
		});

	}
	public void dataToTable(int locID , JTable tabla) {
		Connect cn = new Connect();
		ArrayList<Producto> prList = cn.getProducts_byLocal(user, locID);
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setRowCount(prList.size());
		modelo.setColumnCount(3);
		modelo.setColumnIdentifiers(column_names);
		for( int i = 0 ; i<prList.size() ; i++ ) {
			System.out.println(prList.get(i).toString());
			modelo.setValueAt(prList.get(i).getNombre(),i , 0);
			modelo.setValueAt(prList.get(i).getPrecio(),i , 1);
			modelo.setValueAt(prList.get(i).getLocalAsociado(),i , 2);
		}
		tabla.setModel(modelo);
	}
}
