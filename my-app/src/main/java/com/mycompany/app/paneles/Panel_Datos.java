package com.mycompany.app.paneles;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Panel_Datos extends JPanel{

	/**
	 * Betha1.1
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo;private JTable tabla;
	public Panel_Datos() {
		this.setBounds( 0 , 50 , 500 , 470 );
		this.setVisible(true);
		//this.setBorder(BorderFactory.createLineBorder(Color.green));
		//this.setBackground(Color.green);
		
		///Contenido
		String nombres_col[] = {"Columna 1" , "Columna 2" , "Columna 3"};
		String Data[][] = {
				{ "" , "" , "" }
				
		};
		modelo = new DefaultTableModel(Data, nombres_col);
		tabla = new JTable(modelo);
		tabla.setSize(380 , 470);
		tabla.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds( 0 , 0 , 400 , 470 );
		
		add(scrollPane);
	}
	public void setData(DefaultTableModel mod) {
		this.modelo = mod;
		tabla.setModel(modelo);
		tabla.repaint();
	}
}
