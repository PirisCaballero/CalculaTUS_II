package com.mycompany.app.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mycompany.app.Users;

public class Panel_consola extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	JTextArea consola;
	JCheckBox checkConsola;

	// JScrollPane sp;

	private Users main_user;
	public Panel_consola(Users user) {
		main_user = user;
		this.setBounds(300 , 0 , 724 , 200);
		this.setLayout(null);
		
		
		
		//////Contenido
		consola = new JTextArea();
		// consola.setText("Inserte texto aqui...");
		consola.setBounds(0, 0, 724, 200);
		consola.setForeground(Color.green);
		consola.setBackground(Color.BLACK);
		consola.setCaretColor(Color.green);
		Font f = new Font("Serif", Font.BOLD, 15);
		consola.setFont(f);
		consola.setLineWrap(true);
		consola.setWrapStyleWord(true);
		consola.setMargin(new Insets(10, 10, 10, 10));
		consola.setCaretPosition(0);
		addText(main_user.getNombre() + " >> BIENVENIDO A CALCULATUS II ");
		this.add(consola);

	}
	public void addText(String text) {
		consola.setText(text );
	}
}