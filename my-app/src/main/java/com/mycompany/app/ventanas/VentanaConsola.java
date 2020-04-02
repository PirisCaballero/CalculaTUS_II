package com.mycompany.app.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class VentanaConsola {

	JButton botonAtras, botonSiguiente;
	JTextField consola;

	public VentanaConsola() {

		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(720, 480);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// frame.setTitle("TITULO");

		JPanel ventanaRegistro = new JPanel();
		ventanaRegistro.setLayout(null);
		frame.getContentPane().add(ventanaRegistro);
		ventanaRegistro.setVisible(true);

		consola = new JTextField();
		consola.setText("texto de prueba para la consola");
		consola.setBounds(10, 10, 690, 200);

		botonAtras = new JButton();
		botonAtras.setText("Atras");
		botonAtras.setBounds(10, 340, 200, 30);

		botonSiguiente = new JButton();
		botonSiguiente.setText("Siguiente");
		botonSiguiente.setBounds(500, 340, 200, 30);

		ventanaRegistro.add(consola);
		ventanaRegistro.add(botonAtras);
		ventanaRegistro.add(botonSiguiente);

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BOTON ATRAS actionListener");
			}
		});

		botonSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	// deberiamos quitarlo y decidir en que clase ponemos el main, lo dejo para
	// probar ESTA ventana
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaConsola();
			}
		});
	}

}