package com.mycompany.app.paneles;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mycompany.app.Connection.Connect;

public class PanelCrearTicket extends JPanel{
	JLabel lblFechaEmisionTicket, lblLocalTicket, lblProductosTicket, lblUnidades;
	JTextField txtFechaEmisionTicket, txtTienda, txtUnidades;
	JButton btnGuardarTicket, btnAgregarProducto;
	JTable tablaProductos;
	Choice choiceProducto;
	String columnas []= {"Producto", "Precio", "Unidades"};
	Object data[][]= {};
	
	public PanelCrearTicket() {
		
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(240, 100, 530, 360);
		this.setVisible(false);
		
		lblFechaEmisionTicket = new JLabel();
		lblFechaEmisionTicket.setText("Fecha de emision:");
		lblFechaEmisionTicket.setBounds(90, 30, 140, 30);
		this.add(lblFechaEmisionTicket);

		txtFechaEmisionTicket = new JTextField();
		txtFechaEmisionTicket.setText("");
		txtFechaEmisionTicket.setBounds(260, 30, 170, 30);
		this.add(txtFechaEmisionTicket);

		lblLocalTicket = new JLabel();
		lblLocalTicket.setText("Introduce la tienda de compra:");
		lblLocalTicket.setBounds(51, 80, 180, 30);
		this.add(lblLocalTicket);

		txtTienda = new JTextField();
		txtTienda.setText("");
		txtTienda.setBounds(260, 80, 170, 30);
		this.add(txtTienda);

		lblProductosTicket = new JLabel();
		lblProductosTicket.setText("Introduce los productos:");
		lblProductosTicket.setBounds(70, 135, 180, 30);
		this.add(lblProductosTicket);

		choiceProducto = new Choice();
		Connect cn = new Connect();
		choiceProducto.setBounds(260, 140, 170, 50);
		this.add(choiceProducto);
		
		btnAgregarProducto = new JButton();
		btnAgregarProducto.setText("Agregar");
		btnAgregarProducto.setBounds(440, 135, 50, 10);
		btnAgregarProducto.setSize(80, 30);
		this.add(btnAgregarProducto);
		
		btnGuardarTicket = new JButton();
		btnGuardarTicket.setText("Guardar");
		btnGuardarTicket.setBounds(this.getWidth() / 2 - 50, 320, 50, 10);
		btnGuardarTicket.setSize(80, 30);
		this.add(btnGuardarTicket);
		
		lblUnidades = new JLabel();
		lblUnidades.setText("Introduce las unidades:");
		lblUnidades.setBounds(70, 185, 180, 30);
		this.add(lblUnidades);
		
		txtUnidades = new JTextField();
		txtUnidades.setText("");
		txtUnidades.setBounds(260, 185, 170, 30);
		this.add(txtUnidades);
		
		DefaultTableModel dtm = new DefaultTableModel(data, columnas);
		tablaProductos = new JTable(dtm);
		tablaProductos.setBounds(20, 240, 500, 180);
		tablaProductos.setSize(490, 100);
		tablaProductos.setPreferredScrollableViewportSize(new Dimension(490, 100));
		JScrollPane scrollPane = new JScrollPane(tablaProductos);
		this.add(scrollPane, BorderLayout.CENTER);

	}
}
