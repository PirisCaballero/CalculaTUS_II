package com.mycompany.app.ventanas;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaOpinion extends JFrame {

	JRadioButton estrella1, estrella2, estrella3, estrella4, estrella5;
	JButton botonSiguiente, botonAtras;
	ButtonGroup radioButtonsEstrellas;
	JTextArea texto;
	JLabel comentario, valoracion, error;
	JScrollPane scroll;

	public VentanaOpinion() {
		super("Opinion");
		this.setSize(720, 480);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel ventanaOpinion = new JPanel();
		ventanaOpinion.setLayout(null);
		getContentPane().add(ventanaOpinion);
		ventanaOpinion.setVisible(true);

		estrella1 = new JRadioButton("⭐");
		estrella1.setActionCommand("1");
		estrella1.setBounds(100, 50, 90, 50);
		estrella2 = new JRadioButton("⭐ ⭐");
		estrella2.setActionCommand("2");
		estrella2.setBounds(227, 50, 90, 50);
		estrella3 = new JRadioButton("⭐ ⭐ ⭐");
		estrella3.setActionCommand("3");
		estrella3.setBounds(335, 50, 90, 50);
		estrella4 = new JRadioButton("⭐ ⭐ ⭐ ⭐");
		estrella4.setActionCommand("4");
		estrella4.setBounds(452, 50, 90, 50);
		estrella5 = new JRadioButton("⭐ ⭐ ⭐ ⭐ ⭐"/* , true */);
		estrella5.setActionCommand("5");
		estrella5.setBounds(570, 50, 90, 50);

		radioButtonsEstrellas = new ButtonGroup();
		radioButtonsEstrellas.add(estrella1);
		radioButtonsEstrellas.add(estrella2);
		radioButtonsEstrellas.add(estrella3);
		radioButtonsEstrellas.add(estrella4);
		radioButtonsEstrellas.add(estrella5);

		botonAtras = new JButton();
		botonAtras.setText("Atras");
		botonAtras.setBounds(10, 340, 200, 30);

		botonSiguiente = new JButton();
		botonSiguiente.setText("Siguiente");
		botonSiguiente.setBounds(500, 340, 200, 30);

		valoracion = new JLabel();
		valoracion.setText("Valoracion:");
		valoracion.setBounds(10, 10, 100, 20);

		comentario = new JLabel();
		comentario.setText("Comentario:");
		comentario.setBounds(10, 130, 100, 20);

		texto = new JTextArea();
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		texto.setMargin(new Insets(10, 10, 10, 10));
		texto.setCaretPosition(0);
		scroll = new JScrollPane(texto);
		scroll.setBounds(10, 150, 690, 150);
		add(scroll);

		error = new JLabel();
		error.setText("Falta valoracion o comentario.");
		error.setForeground(Color.red);
		error.setVisible(false);
		error.setBounds(500, 320, 200, 20);

		add(estrella1);
		add(estrella2);
		add(estrella3);
		add(estrella4);
		add(estrella5);
		add(botonSiguiente);
		add(botonAtras);
		add(comentario);
		add(valoracion);
		add(scroll);
		add(error);

		botonSiguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BOTON SIUGIENTE");
				// System.out.println("Valoracion: " +
				// radioButtonsEstrellas.getSelection().getActionCommand());
				System.out.println("Comentario: " + texto.getText());

				if (!radioButtonsEstrellas.isSelected(null) && !texto.getText().equals("")) {
					System.out.println("TODO OK");
					error.setVisible(false);
					// CODIGO DE CONTINUAR, AQUI
				} else if (radioButtonsEstrellas.isSelected(null) || texto.getText().equals("")) {
					System.out.println("FALTA ALGO");
					error.setVisible(true);
					// NO TIENE VALORACION U OPINION, NO DEBERIAMOS SEGUIR
				}

			}
		});

		botonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BOTON ATRAS");

			}
		});
	}

	// Dejo el main, habria que quitarlo
	public static void main(String[] args) {
		VentanaOpinion VO = new VentanaOpinion();
		VO.setVisible(true);
	}

}
