package com.mycompany.app.paneles;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.*;

import com.mycompany.app.Connection.Connect;

public class PanelCrearTicket extends JPanel{
	JLabel lblFechaEmisionTicket, lblLocalTicket, lblProductosTicket;
	JTextField txtFechaEmisionTicket, txtTienda;
	JButton btnGuardarTicket, btnAgregarProducto;
	Choice choiceProducto;
	
	public PanelCrearTicket() {
		
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(240, 100, 530, 360);
		this.setVisible(false);
		
		lblFechaEmisionTicket = new JLabel();
		lblFechaEmisionTicket.setText("Fecha de emision:");
		lblFechaEmisionTicket.setBounds(90, 70, 140, 30);
		this.add(lblFechaEmisionTicket);

		txtFechaEmisionTicket = new JTextField();
		txtFechaEmisionTicket.setText("");
		txtFechaEmisionTicket.setBounds(260, 70, 170, 30);
		this.add(txtFechaEmisionTicket);

		lblLocalTicket = new JLabel();
		lblLocalTicket.setText("Introduce la tienda de compra:");
		lblLocalTicket.setBounds(51, 120, 180, 30);
		this.add(lblLocalTicket);

		txtTienda = new JTextField();
		txtTienda.setText("");
		txtTienda.setBounds(260, 120, 170, 30);
		this.add(txtTienda);

		lblProductosTicket = new JLabel();
		lblProductosTicket.setText("Introduce los productos:");
		lblProductosTicket.setBounds(70, 175, 180, 30);
		this.add(lblProductosTicket);

		choiceProducto = new Choice();
		Connect cn = new Connect();
		choiceProducto.setBounds(260, 180, 170, 50);
		this.add(choiceProducto);
		
		btnAgregarProducto = new JButton();
		btnAgregarProducto.setText("Agregar");
		btnAgregarProducto.setBounds(440, 180, 50, 10);
		btnAgregarProducto.setSize(80, 30);
		this.add(btnAgregarProducto);
		
		btnGuardarTicket = new JButton();
		btnGuardarTicket.setText("Guardar");
		btnGuardarTicket.setBounds(this.getWidth() / 2 - 50, 320, 50, 10);
		btnGuardarTicket.setSize(80, 30);
		this.add(btnGuardarTicket);

	}
}
