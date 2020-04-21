package com.mycompany.app.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import com.mycompany.app.Users;

public class PanelPreguntas extends JPanel{

	private Users main_user;
	
	public PanelPreguntas(Users us) {

		this.setBounds(0 , 0 , 574 , 470);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.white);
		this.setLayout(null);
		this.main_user = us;
		this.setPreferredSize(new Dimension(500, 800));
		
		JLabel lblPreguntas = new JLabel("Preguntas frecuentes");
		lblPreguntas.setBounds(50, 11, 433, 56);
		lblPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		Font auxFont = lblPreguntas.getFont();
		lblPreguntas.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		add(lblPreguntas);
		
		JLabel lblP1 = new JLabel("¿Qué es Calculatus II?");
		lblP1.setBounds(25, 50, 250, 56);
		Font auxFont1 = lblP1.getFont();
		lblP1.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
		add(lblP1);
		
		Font fuente = new Font("Arial", 2, 12);
		JLabel lblR1 = new JLabel("<html><p>Calculatus II es una aplicación que te permitirá realizar"
				+ " un seguimiento de tus compras. De esta manera, serás capaz de analizar tus gastos,"
				+ " generar estadísticas y mucho más.</p></html>");
		lblR1.setBounds(25, lblP1.getY()+40, this.getWidth()-100, 56);
		lblR1.setFont(fuente);
		add(lblR1);
		
		JLabel lblP2 = new JLabel("¿Cómo puedo registrar un local?");
		lblP2.setBounds(25, lblR1.getY()+70, 250, 56);
		lblP2.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
		add(lblP2);
		
		JLabel lblR2 = new JLabel("<html><p>Para registrar un nuevo local debes hacer click"
				+ " sobre el símbolo del panel arriba a la izquierda que se asemeja a una casa."
				+ " Después, simplemente debes introducir los datos correspondientes en los campos.</p></html>");
		lblR2.setBounds(25, lblP2.getY()+40, this.getWidth()-100, 56);
		lblR2.setFont(fuente);
		add(lblR2);
		
		JLabel lblP3 = new JLabel("¿Cómo puedo añadir un ticket nuevo?");
		lblP3.setBounds(25, lblR2.getY()+70, 250, 56);
		lblP3.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
		add(lblP3);
		
		JLabel lblR3 = new JLabel("<html><p>Para añadir un ticket nuevo solo hay que hacer click"
				+ " en el símbolo que contiene un papel y un lápiz y rellenar los campos"
				+ " con los datos de nuestro ticket de compra.</p></html>");
		lblR3.setBounds(25, lblP3.getY()+40, this.getWidth()-100, 56);
		lblR3.setFont(fuente);
		add(lblR3);
		
		JLabel lblP4 = new JLabel("¿Cómo puedo añadir un producto?");
		lblP4.setBounds(25, lblR3.getY()+70, 250, 56);
		lblP4.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
		add(lblP4);
		
		JLabel lblR4 = new JLabel("<html><p>Para añadir un producto hay que hacer click sobre el "
				+ "icono que contiene una espiga de trigo y rellenar los campos pertinentes."
				+ " Necesitarás registrar un producto antes de intentar ponerlo en un ticket.</p></html>");
		lblR4.setBounds(25, lblP4.getY()+40, this.getWidth()-100, 56);
		lblR4.setFont(fuente);
		add(lblR4);
		
		JLabel lblP5 = new JLabel("¿Por qué no me aparecen productos cuando voy a crear un ticket?");
		lblP5.setBounds(25, lblR4.getY()+70, 450, 56);
		lblP5.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
		add(lblP5);
		
		JLabel lblR5 = new JLabel("<html><p>Es posible que a la hora de generar un ticket no aparezca el"
				+ " producto que se quiere añadir a la lista de los productos adquiridos. Para ello se debe "
				+ "haber añadido un producto previamente como se explica en la pregunta ¿Cómo puedo añadir un"
				+ " producto?</p></html>");
		lblR5.setBounds(25, lblP5.getY()+40, this.getWidth()-100, 56);
		lblR5.setFont(fuente);
		add(lblR5);
		
		JLabel lblP6 = new JLabel("¿Por qué no me aparece el local que quiero seleccionar?");
		lblP6.setBounds(25, lblR5.getY()+70, 450, 56);
		lblP6.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
		add(lblP6);
		
		JLabel lblR6 = new JLabel("<html><p>Tener un local registrado es importante para poder crear tickets"
				+ " en relación a ese establecimiento. Es posible que el local no haya sido guardado anteriormente "
				+ "para saber cómo hacerlo sigue los pasos definidos en la pregunta ¿Cómo puedo registrar un local?</p></html>");
		lblR6.setBounds(25, lblP6.getY()+40, this.getWidth()-100, 56);
		lblR6.setFont(fuente);
		add(lblR6);
		
//		JLabel lblP7 = new JLabel("¿Qué es Calculatus II?");
//		lblP7.setBounds(25, lblR6.getY()+70, 450, 56);
//		lblP7.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
//		add(lblP7);
//		
//		JLabel lblR7 = new JLabel("<html><p>Calculatus II es una aplicación que te permitirá realizar\"\r\n" + 
//				"				+ \" un seguimiento de tus compras. De esta manera, serás capaz de analizar tus gastos,\"\r\n" + 
//				"				+ \" generar estadísticas y mucho más.</p></html>");
//		lblR7.setBounds(25, lblP7.getY()+40, this.getWidth()-100, 56);
//		lblR7.setFont(fuente);
//		add(lblR7);
//		
//		JLabel lblP8 = new JLabel("¿Qué es Calculatus II?");
//		lblP8.setBounds(25, lblR7.getY()+70, 450, 56);
//		lblP8.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
//		add(lblP8);
//		
//		JLabel lblR8 = new JLabel("<html><p>Calculatus II es una aplicación que te permitirá realizar\"\r\n" + 
//				"				+ \" un seguimiento de tus compras. De esta manera, serás capaz de analizar tus gastos,\"\r\n" + 
//				"				+ \" generar estadísticas y mucho más.</p></html>");
//		lblR8.setBounds(25, lblP8.getY()+40, this.getWidth()-100, 56);
//		lblR8.setFont(fuente);
//		add(lblR8);
	}
}
