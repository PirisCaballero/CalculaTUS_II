package es.deusto.spq.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Local;
import es.deusto.spq.Producto;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

import java.awt.Choice;

/**
 * Panel en el que se pueden añadir los productos introducendi los datos
 * local del producto, precio, nombre y categoria.
 */

public class PanelProducto extends JPanel {

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
	private String[] column_names = { "Nombre" , "Precio" , "Local" };
	private String localSel = "";
	private PanelDatos pd;Choice choice_cat;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Este Panel permite la creacion y adición de productos
	 * @param us
	 * @param pdts
	 */
	public PanelProducto(Users us , PanelDatos pdts) {
		this.setLayout(null);
		String[] colnames = {"Nombre" , "Precio" , "Categoria"};
		modelo.setColumnIdentifiers(colnames);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.white);
		this.setBounds(0, 0, 524, 470);
		this.user = us;
		this.pd = pdts;

		JLabel lblLocal = new JLabel("Local: ");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(50, 112, 150, 30);
		add(lblLocal);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(412, 74, 89, 23);
		add(btnRefresh);

		choice = new Choice();
		Connect cn = new Connect();
		locList = cn.getLocales(user);
		for (Local l : locList) {
			choice.add(l.getNombre());
		}
		choice.setBounds(250, 112, 150, 30);
		add(choice);

		JLabel lblPrecio = new JLabel("Nombre: ");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(50, 168, 150, 30);
		add(lblPrecio);

		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_1.setBounds(50, 223, 150, 30);
		add(lblPrecio_1);

		textField = new JTextField();
		textField.setBounds(250, 168, 150, 30);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(250, 223, 150, 30);
		add(textField_1);
		this.setVisible(false);
		
		////Array con los datos de la tabla
		Object[][] datos = {};
		
		/*
		 * Choice para elegir el local de los productos a mostrar en la tabla
		 */
		choice_1 = new Choice();
		ArrayList<Local> locListTable = cn.getLocales(user);
		for(Local l : locListTable) {
			choice_1.add(l.getNombre());
		}
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 349, 89, 23);
		add(btnAgregar);
		
		JLabel lblAadirProducto = new JLabel("Añadir Producto");
		lblAadirProducto.setBounds(50, 11, 433, 56);
		lblAadirProducto.setHorizontalAlignment(SwingConstants.CENTER);
		Font auxFont = lblAadirProducto.getFont();
		lblAadirProducto.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		add(lblAadirProducto);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setBounds(50, 264, 150, 30);
		add(lblCategoria);
		
		choice_cat = new Choice();
		choice_cat.setBounds(250, 274, 150, 20);
		for( String s : cn.getCategorias() ) {
			choice_cat.add(s);
		}
		add(choice_cat);
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
			}
		});

	}
	/**
	 * Este metodo inserta el modelo que se le pasan como parametro en la  tabla del PanelDatos
	 * @param locID
	 * @param tabla
	 * @return
	 */
	public DefaultTableModel dataToTable(int locID , JTable tabla) {
		Connect cn = new Connect();
		ArrayList<Producto> prList = cn.getProductsByLocal(user, locID);
		modelo.setRowCount(prList.size());
		modelo.setColumnCount(3);
		modelo.setColumnIdentifiers(column_names);
		Local loc = cn.getLocalById(user, locID);
		for( int i = 0 ; i<prList.size() ; i++ ) {
			System.out.println(prList.get(i).toString());
			modelo.setValueAt(prList.get(i).getNombre(),i , 0);
			modelo.setValueAt(prList.get(i).getPrecio(),i , 1);
			modelo.setValueAt(loc.getNombre(),i , 2);
		}
		tabla.setModel(modelo);
		this.pd.setData(modelo);
		return modelo;
	}
	/**
	 * Este metodo recarga los elementos del panel
	 */
	public void refresh() {
		localSel = choice.getSelectedItem();
		choice.removeAll();
		Connect cn = new Connect();
		locList.clear();
		locList = cn.getLocales(user);
		for (Local l : locList) {
			choice.add(l.getNombre());
		}
		Local local = cn.getLocalByName(user, localSel);
		cn.getProductsByLocal(user, local.getId());
	}
	/**
	 * Este metodo añade el producto a la BBDD
	 */
	public void agregarProducto() {
		Connect cn = new Connect();
		Local local = cn.getLocalByName(user, choice.getSelectedItem());
		Producto prod = new Producto( Double.parseDouble(textField_1.getText()), textField.getText() , 0 , local.getId() ,user.getEmail() , choice_cat.getSelectedItem());
		cn.anadirProducto(user, prod, local.getId());
		textField.setText("");textField_1.setText("");
		String[] rowData = { prod.getNombre() , ""+prod.getPrecio() , prod.getCategoria() };
		modelo.addRow(rowData);
		pd.setData(modelo);
	}
}
