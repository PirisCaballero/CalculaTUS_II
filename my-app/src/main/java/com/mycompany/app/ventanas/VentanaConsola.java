package com.mycompany.app.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class VentanaConsola {

	JButton botonAtras, botonEjecutar;
	JTextArea consola;
	JCheckBox checkConsola;

	// JScrollPane sp;

	public VentanaConsola() {

		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(720, 480);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// frame.setTitle("TITULO");

		JPanel ventanaConsola = new JPanel();
		ventanaConsola.setLayout(null);
		frame.getContentPane().add(ventanaConsola);
		ventanaConsola.setVisible(true);

		consola = new JTextArea();
		// consola.setText("Inserte texto aqui...");
		consola.setBounds(10, 10, 690, 300);
		consola.setForeground(Color.BLACK);
		consola.setBackground(Color.WHITE);
		consola.setCaretColor(Color.BLACK);
		Font f = new Font("Serif", Font.BOLD, 15);
		consola.setFont(f);
		consola.setLineWrap(true);
		consola.setWrapStyleWord(true);
		consola.setMargin(new Insets(10, 10, 10, 10));
		consola.setCaretPosition(0);

		checkConsola = new JCheckBox();
		checkConsola.setText("Modo oscuro");
		checkConsola.setBounds(10, 390, 100, 30);
		checkConsola.setSelected(false);

		botonAtras = new JButton();
		botonAtras.setText("Atras");
		botonAtras.setBounds(10, 340, 200, 30);

		botonEjecutar = new JButton();
		botonEjecutar.setText("Ejecutar?");
		botonEjecutar.setBounds(500, 340, 200, 30);

		ventanaConsola.add(consola);
		ventanaConsola.add(botonAtras);
		ventanaConsola.add(botonEjecutar);
		ventanaConsola.add(checkConsola);

		checkConsola.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkConsola.isSelected() == true) {
					consola.setForeground(Color.WHITE);
					consola.setBackground(Color.BLACK);
					consola.setCaretColor(Color.WHITE);
				} else if (checkConsola.isSelected() == false) {
					consola.setForeground(Color.BLACK);
					consola.setBackground(Color.WHITE);
					consola.setCaretColor(Color.BLACK);
				}

			}
		});

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BOTON ATRAS actionListener");
				consola.setText("");
				checkConsola.setSelected(false);
				consola.setForeground(Color.BLACK);
				consola.setBackground(Color.WHITE);
				consola.setCaretColor(Color.BLACK);
				consola.setCaretPosition(0);
			}
		});

		botonEjecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BOTON EJECUTAR");
			}
		});
	}

	// deberiamos quitarlo y decidir en que clase ponemos el main, lo dejo para
	// probar ESTA ventana
/*	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaConsola();
			}
		});
	}*/

}